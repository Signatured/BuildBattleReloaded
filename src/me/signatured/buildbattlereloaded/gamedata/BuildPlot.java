package me.signatured.buildbattlereloaded.gamedata;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import lombok.Setter;
import me.signatured.buildbattlereloaded.BuildGame;
import me.signatured.buildbattlereloaded.BuildPlayer;
import me.signatured.buildbattlereloaded.gamedata.plotdata.PlotBiome;
import me.signatured.buildbattlereloaded.util.Util;

@Getter @Setter
public class BuildPlot {
	
	private BuildGame game;
	private MapData data;
	private PlotBiome biome;
	private BuildPlayer player;
	
	private int score;
	
	public BuildPlot(BuildGame game) {
		this.game = game;
	}
	
	public void changeFloor(ItemStack item) {
		data.getFloorBounds().getLocations().forEach(l -> Util.setBlockData(l, item));
	}
	
	public void changeBiome(PlotBiome biome) {
		data.getFloorBounds().getLocations().forEach(l -> Util.setBlockBiome(l, biome.getBiome()));
	}
	
	public void resetPlot() {
		for (Location loc : data.getFloorBounds().getLocations()) {
			Location cloneLoc = loc.clone().add(0, 1, 0);
			
			while (cloneLoc.getBlockY() <= data.getFlyingBounds().getHeight()) {
				Block block = cloneLoc.getBlock();
				
				if (block.getType() != Material.AIR)
					block.setType(Material.AIR);
				
				cloneLoc.add(0, 1, 0);
			}
			
			loc.getBlock().setType(Material.STAINED_CLAY);
		}
	}
	
	public Location getTeleportLoc() {
		Location loc = data.getFlyingBounds().getCenter();
		
		if (loc.getBlock().getType() != Material.AIR) {
			for (int i = 0; i < 50; i++) {
				loc = data.getFlyingBounds().getRandomLocation();
				
				if (loc.getBlock().getType() == Material.AIR)
					break;
			}
		}
		return loc;
	}
	
}
