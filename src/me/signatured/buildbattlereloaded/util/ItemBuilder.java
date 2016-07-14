package me.signatured.buildbattlereloaded.util;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	private Material material;
	private int amount;
	private byte data;
	
	private String name;
	private List<String> lore;
	
	public ItemBuilder(Material material) {
		this(material, 0);
	}
	
	public ItemBuilder(Material material, int data) {
		this(material, 1, data);
	}
	
	public ItemBuilder(Material material, int amount, int data) {
		this.material = material;
		this.amount = amount;
		this.data = (byte) data;
	}
	
	public static ItemBuilder of(Material material) {
		return of(material, 0);
	}
	
	public static ItemBuilder of(Material material, int data) {
		return new ItemBuilder(material, data);
	}
	
	@SuppressWarnings("deprecation")
	public static ItemBuilder of(ItemStack item) {
		ItemBuilder builder = new ItemBuilder(item.getType(), item.getAmount(), item.getData().getData());
		ItemMeta meta = item.getItemMeta();
		
		if (meta != null && meta.hasDisplayName())
			builder.name(meta.getDisplayName());
		if (meta != null && meta.hasLore())
			builder.lore(meta.getLore());
		
		return builder;
	}
	
	public ItemBuilder material(Material material) {
		this.material = material;
		return this;
	}
	
	public ItemBuilder data(int data) {
		this.data = (byte) data;
		return this;
	}
	
	public ItemBuilder amount(int amount) {
		this.amount = amount;
		return this;
	}
	
	public ItemBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public ItemBuilder lore(List<String> lore) {
		this.lore = lore;
		return this;
	}
	
	public ItemBuilder lore(String... lore) {
		this.lore = Arrays.asList(lore);
		return this;
	}
	
	public ItemStack build() {
		ItemStack item = new ItemStack(material, amount, data);
		ItemMeta meta = item.getItemMeta();
		
		if (name != null)
			meta.setDisplayName(name);
		if (lore != null)
			meta.setLore(lore);
		
		item.setItemMeta(meta);
		return item;
	}
}
