package me.signatured.buildbattlereloaded.gamegui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import lombok.Getter;
import me.signatured.buildbattlereloaded.gamedata.BuildPlot;
import me.signatured.buildbattlereloaded.gamedata.plotdata.PlotTime;
import me.signatured.buildbattlereloaded.util.gui.Gui;
import me.signatured.buildbattlereloaded.util.gui.GuiItem;

public class TimeGui extends Gui {
	
	@Getter
	private BuildPlot plot;
	private List<GuiItem> items = new ArrayList<>();

	public TimeGui(BuildPlot plot) {
		super("Choose Plot Time", 3);
		this.plot = plot;
		
		initItems();
	}
	
	@Override
	public void show(Player player) {
		addItem(11, items.get(0));
		addItem(15, items.get(1));
		
		super.show(player);
	}
	
	private void initItems() {
		PlotTime selected = plot.getTime();
		
		for (PlotTime time : PlotTime.values()) {
			GuiItem item = new GuiItem(time.getItem(selected == time));
			items.add(item);
		}
	}
}
