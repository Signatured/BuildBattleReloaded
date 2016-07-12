package me.signatured.buildbattlereloaded.gamedata;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import me.signatured.buildbattlereloaded.BuildGame;
import me.signatured.buildbattlereloaded.BuildPlayer;
import me.signatured.buildbattlereloaded.util.Util;

@Getter
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
		//TODO
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
	
	@Getter
	public enum PlotBiome {
		
		PLAINS(Biome.PLAINS),
		MESA(Biome.MESA),
		OCEAN(Biome.OCEAN),
		DESERT(Biome.DESERT),
		FOREST(Biome.FOREST),
		JUNGLE(Biome.JUNGLE),
		ICE_PLAINS(Biome.ICE_PLAINS),
		SWAMP(Biome.SWAMPLAND),
		SAVANNA(Biome.SAVANNA);
		
		private Biome biome;
		
		PlotBiome(Biome biome) {
			this.biome = biome;
		}
	}
}
