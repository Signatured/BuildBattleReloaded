package me.signatured.buildbattlereloaded.gamedata.plotdata;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import me.signatured.buildbattlereloaded.util.ItemBuilder;

public enum PlotBiome {
	
	PLAINS("Plains", Biome.PLAINS, new ItemStack(Material.GRASS)),
	MESA("Mesa", Biome.MESA, new ItemStack(Material.SAND, 1, (byte) 1)),
	OCEAN("Ocean", Biome.OCEAN, new ItemStack(Material.WATER_BUCKET)),
	DESERT("Desert", Biome.DESERT, new ItemStack(Material.SAND)),
	FOREST("Forest", Biome.FOREST, new ItemStack(Material.LOG)),
	JUNGLE("Jungle", Biome.JUNGLE, new ItemStack(Material.VINE)),
	ICE_PLAINS("Ice Plains", Biome.ICE_PLAINS, new ItemStack(Material.PACKED_ICE)),
	SWAMP("Swamp", Biome.SWAMPLAND, new ItemStack(Material.WATER_LILY)),
	SAVANNA("Savanna", Biome.SAVANNA, new ItemStack(Material.LOG_2));
	
	@Getter
	private String name;
	@Getter
	private Biome biome;
	private ItemStack item;
	
	PlotBiome(String name, Biome biome, ItemStack item) {
		this.name = name;
		this.biome = biome;
		this.item = item;
	}
	
	public ItemStack getItem(boolean selected) {
		ItemBuilder builder = ItemBuilder.of(item);
		
		builder.name(ChatColor.YELLOW + name);
		
		if (selected)
			builder.lore("", ChatColor.GREEN + "Selected");
		else
			builder.lore("", ChatColor.GRAY + "Click to select");
		
		return builder.build();
	}
}
