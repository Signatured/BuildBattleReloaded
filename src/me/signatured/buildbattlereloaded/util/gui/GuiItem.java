package me.signatured.buildbattlereloaded.util.gui;

import java.util.function.BiConsumer;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import me.signatured.buildbattlereloaded.util.ItemBuilder;

@Getter
public class GuiItem {
	
	private ItemStack item;
	private GuiClickEvent listener;
	
	public GuiItem(ItemStack item) {
		this.item = item;
	}
	
	public GuiItem(ItemBuilder builder) {
		this.item = builder.build();
	}
	
	public void setListener(BiConsumer<InventoryClickEvent, Player> consumer) {
		this.listener = new GuiClickEvent() {
			@Override
			public void onClick(InventoryClickEvent event, Player player) {
				consumer.accept(event, player);
			}
		};
	}
}
