package me.signatured.buildbattlereloaded;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import me.signatured.buildbattlereloaded.util.ItemBuilder;
import me.signatured.buildbattlereloaded.util.SoundEffect;

@Getter
public enum BuildRating {
	
	SUPER_POOP(1, ChatColor.DARK_RED, (byte) 14, 1F),
	POOP(2, ChatColor.RED, (byte) 6, 1.5F),
	OKAY(3, ChatColor.GREEN, (byte) 5, 2F),
	GOOD(4, ChatColor.DARK_GREEN, (byte) 13, 2.5F),
	AMAZING(5, ChatColor.DARK_PURPLE, (byte) 11, 3.5F),
	LEGENDARY(6, ChatColor.GOLD, (byte) 4, 4F);
	
	private int score;
	private ChatColor color;
	private byte data;
	private float pitch;
	
	BuildRating(int score, ChatColor color, byte data, float pitch) {
		this.score = score;
		this.color = color;
		this.data = data;
		this.pitch = pitch;
	}
	
	public String getName() {
		return color + "" + ChatColor.BOLD + name() + ChatColor.GRAY + " (Right Click)";
	}
	
	public SoundEffect getSound() {
		return new SoundEffect(Sound.CAT_MEOW, pitch);
	}
	
	public ItemStack getItem() {
		return new ItemBuilder(Material.STAINED_CLAY, data).name(getName()).build();
	}
}
