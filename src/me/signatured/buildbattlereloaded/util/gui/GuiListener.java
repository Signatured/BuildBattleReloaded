package me.signatured.buildbattlereloaded.util.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class GuiListener implements Listener {
	
	@EventHandler
	public void onGuiClick(InventoryClickEvent event) {
		InventoryView view = event.getView();
		Inventory topInv = view.getTopInventory();
		
		if (Gui.getGui(topInv) == null)
			return;
		Gui gui = Gui.getGui(topInv);
		GuiItem item = gui.getItem(event.getRawSlot());
		event.setCancelled(true);
		
		if (item == null || item.getListener() == null)
			return;
		item.getListener().onClick(event, (Player) event.getWhoClicked());
	}
}
