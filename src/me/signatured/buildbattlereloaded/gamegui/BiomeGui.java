package me.signatured.buildbattlereloaded.gamegui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import lombok.Getter;
import me.signatured.buildbattlereloaded.gamedata.BuildPlot;
import me.signatured.buildbattlereloaded.gamedata.plotdata.PlotBiome;
import me.signatured.buildbattlereloaded.util.gui.Gui;
import me.signatured.buildbattlereloaded.util.gui.GuiItem;

public class BiomeGui extends Gui {
	
	@Getter
	private BuildPlot plot;
	private List<GuiItem> items = new ArrayList<>();

	public BiomeGui(BuildPlot plot) {
		super("Choose Plot Biome", 3);
		this.plot = plot;
		
		initItems();
	}
	
	public void show(Player player) {
		int index = 9;
		
		for (GuiItem item : items)
			addItem(index++, item);
		
		super.show(player);
	}
	
	private void initItems() {
		PlotBiome selected = plot.getBiome();
		
		for (PlotBiome biome : PlotBiome.values()) {
			GuiItem item = new GuiItem(biome.getItem(selected == biome));
			items.add(item);
		}
	}

}
