package me.signatured.buildbattlereloaded.gamegui;

import lombok.Getter;
import me.signatured.buildbattlereloaded.gamedata.BuildPlot;
import me.signatured.buildbattlereloaded.util.gui.Gui;

public class TimeGui extends Gui {
	
	@Getter
	private BuildPlot plot;

	public TimeGui(BuildPlot plot) {
		super("Choose Plot Time", 3);
		this.plot = plot;
	}
	
	public void initItems() {
		
	}

}
