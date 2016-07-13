package me.signatured.buildbattlereloaded.util.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import lombok.Getter;

public class Gui {

	@Getter
	private static List<Gui> guis = new ArrayList<>();
	
	@Getter
	private Inventory inv;
	private Map<Integer, GuiItem> items = new HashMap<>();
	
	public Gui(String name, int height) {
		this.inv = Bukkit.createInventory(null, height * 9, name);
		
		guis.add(this);
	}
	
	public static Gui getGui(Inventory inv) {
		return guis.stream().filter(g -> g.getInv().equals(inv)).findAny().orElse(null);
	}
	
	public void addItem(int index, GuiItem item) {
		items.put(index, item);
		updateItems();
	}
	
	public GuiItem getItem(int index) {
		return items.get(index);
	}
	
	public void show(Player player) {
		player.openInventory(inv);
	}
	
	private void updateItems() {
		inv.clear();
		
		items.entrySet().forEach(entry -> inv.setItem(entry.getKey(), entry.getValue().getItem()));
	}
}
