package me.signatured.buildbattlereloaded.gamedata;

import lombok.Getter;
import me.signatured.buildbattlereloaded.BuildGame;
import me.signatured.buildbattlereloaded.BuildPlayer;

@Getter
public class BuildPlot {
	
	private BuildGame game;
	private BuildPlayer player;
	
	public BuildPlot(BuildGame game) {
		this.game = game;
	}
}
