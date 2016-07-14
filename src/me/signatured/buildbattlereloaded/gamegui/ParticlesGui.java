package me.signatured.buildbattlereloaded.gamegui;

import lombok.Getter;
import me.signatured.buildbattlereloaded.gamedata.BuildPlot;
import me.signatured.buildbattlereloaded.util.gui.Gui;

public class ParticlesGui extends Gui {
	
	@Getter
	private BuildPlot plot;

	public ParticlesGui(BuildPlot plot) {
		super("Choose Plot Particles", 3);
		this.plot = plot;
	}
	
	public void initItems() {
		
	}

}
