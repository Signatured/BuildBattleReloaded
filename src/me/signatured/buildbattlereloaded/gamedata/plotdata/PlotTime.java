package me.signatured.buildbattlereloaded.gamedata.plotdata;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import me.signatured.buildbattlereloaded.util.ItemBuilder;

public enum PlotTime {
	
	DAY("Day", 1000, new ItemStack(Material.STAINED_CLAY, 1, (byte) 4)),
	NIGHT("Night", 13000, new ItemStack(Material.STAINED_CLAY, 1, (byte) 15));
	
	@Getter
	private String name;
	@Getter
	private int time;
	private ItemStack item;
	
	PlotTime(String name, int time, ItemStack item) {
		this.name = name;
		this.time = time;
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
