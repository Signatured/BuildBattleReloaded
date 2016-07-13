package me.signatured.buildbattlereloaded.util.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public abstract class GuiClickEvent {
	
	public abstract void onClick(InventoryClickEvent event, Player player);
}
