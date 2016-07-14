package me.signatured.buildbattlereloaded.gamegui;

import lombok.Getter;
import me.signatured.buildbattlereloaded.gamedata.BuildPlot;
import me.signatured.buildbattlereloaded.util.gui.Gui;

public class WeatherGui extends Gui {
	
	@Getter
	private BuildPlot plot;

	public WeatherGui(BuildPlot plot) {
		super("Choose Plot Weather", 3);
		this.plot = plot;
	}
	
	public void initItems() {
		
	}
}
