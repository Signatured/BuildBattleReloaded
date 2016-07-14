package me.signatured.buildbattlereloaded.gamedata.plotdata;

import org.bukkit.block.Biome;

import lombok.Getter;

@Getter
public enum PlotBiome {
	
	PLAINS("Plains", Biome.PLAINS),
	MESA("Mesa", Biome.MESA),
	OCEAN("Ocean", Biome.OCEAN),
	DESERT("Desert", Biome.DESERT),
	FOREST("Forest", Biome.FOREST),
	JUNGLE("Jungle", Biome.JUNGLE),
	ICE_PLAINS("Ice Plains", Biome.ICE_PLAINS),
	SWAMP("Swamp", Biome.SWAMPLAND),
	SAVANNA("Savanna", Biome.SAVANNA);
	
	private String name;
	private Biome biome;
	
	PlotBiome(String name, Biome biome) {
		this.name = name;
		this.biome = biome;
	}
}
