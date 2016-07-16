package me.signatured.buildbattlereloaded.gamegui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import lombok.Getter;
import me.signatured.buildbattlereloaded.gamedata.BuildPlot;
import me.signatured.buildbattlereloaded.util.ItemBuilder;
import me.signatured.buildbattlereloaded.util.gui.Gui;
import me.signatured.buildbattlereloaded.util.gui.GuiItem;

public class OptionsGui extends Gui {
	
	@Getter
	private BuildPlot plot;
	private List<GuiItem> items = new ArrayList<>();

	public OptionsGui(BuildPlot plot) {
		super("Plot Options", 3);
		this.plot = plot;
		
		initItems();
	}
	
	@Override
	public void show(Player player) {
		int index = 10;
		
		for (GuiItem item : items) {
			addItem(index, item);
			
			index += 2;
		}
		
		super.show(player);
	}
	
	private void initItems() {
		GuiItem biomeItem = new GuiItem(ItemBuilder.of(Material.GRASS));
		biomeItem.setListener((e, p) -> {
			new BiomeGui(plot).show(p);
		});
		items.add(biomeItem);
		
		GuiItem timeItem = new GuiItem(ItemBuilder.of(Material.WATCH));
		biomeItem.setListener((e, p) -> {
			new TimeGui(plot).show(p);
		});
		items.add(timeItem);
		
		GuiItem weatherItem = new GuiItem(ItemBuilder.of(Material.BLAZE_ROD));
		biomeItem.setListener((e, p) -> {
			new WeatherGui(plot).show(p);
		});
		items.add(weatherItem);
		
		GuiItem particlesItem = new GuiItem(ItemBuilder.of(Material.ENDER_CHEST));
		biomeItem.setListener((e, p) -> {
			new ParticlesGui(plot).show(p);
		});
		items.add(particlesItem);
	}
}
