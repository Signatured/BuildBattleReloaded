package me.signatured.buildbattlereloaded.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class Cuboid {
	
	private Location corner1;
	private Location corner2;
	
	public Cuboid(Location corner1, Location corner2) {
		if (!corner1.getWorld().equals(corner2.getWorld()))
			throw new IllegalArgumentException("Locations must be in same world!");
		
		this.corner1 = corner1;
		this.corner2 = corner2;
	}
	
	public List<Location> getLocations() {
		ArrayList<Location> locations = new ArrayList<>();
		double dist = corner1.distance(corner2);
		Location progress = corner1.clone();
		Vector dir = corner2.clone().subtract(corner1).multiply(1 / dist).toVector();
		
		while (dist > corner1.distance(progress)) {
			progress.add(dir);
			locations.add(progress.clone());
		}
		
		return locations;
	}
	
	public Location getRandomLocation() {
		List<Location> locs = getLocations();
		
		return locs.toArray(new Location[locs.size()])[Util.RANDOM.nextInt(locs.size())];
	}
	
	public Location getCenter() {
		double x = (corner1.getX() + corner2.getX()) / 2;
		double y = (corner1.getY() + corner2.getY()) / 2;
		double z = (corner1.getZ() + corner2.getZ()) / 2;
		
		return new Location(corner1.getWorld(), x, y, z);
	}
	
	public boolean contains(Location loc) {
		if (!isWithinCoords(corner1.getBlockX(), corner2.getBlockX(), loc.getBlockX()))
			return false;
		if (!isWithinCoords(corner1.getBlockY(), corner2.getBlockY(), loc.getBlockY()))
			return false;
		if (!isWithinCoords(corner1.getBlockZ(), corner2.getBlockZ(), loc.getBlockZ()))
			return false;
		
		return true;
	}
	
	private boolean isWithinCoords(double coord1, double coord2, double value) {
		if (coord1 > coord2)
			return (value <= coord1 && value >= coord2);
		return (value <= coord2 && value >= coord1);
	}
}
