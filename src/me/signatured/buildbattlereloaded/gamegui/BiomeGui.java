package me.signatured.buildbattlereloaded.gamegui;

import lombok.Getter;
import me.signatured.buildbattlereloaded.gamedata.BuildPlot;
import me.signatured.buildbattlereloaded.util.gui.Gui;

public class BiomeGui extends Gui {
	
	@Getter
	private BuildPlot plot;

	public BiomeGui(BuildPlot plot) {
		super("Choose Plot Biome", 3);
		this.plot = plot;
	}
	
	public void initItems() {
		
	}

}
