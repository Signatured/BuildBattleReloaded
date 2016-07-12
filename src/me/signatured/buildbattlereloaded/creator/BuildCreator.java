package me.signatured.buildbattlereloaded.creator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import me.signatured.buildbattlereloaded.BuildGame;
import me.signatured.buildbattlereloaded.gamedata.BuildPlot;

@Getter
public class BuildCreator {
	
	@Getter
	private static List<BuildCreator> creators = new ArrayList<>();
	
	private UUID uuid;
	private BuildGame game;
	private BuildPlot plot;
	
	public BuildCreator(UUID uuid, BuildGame game) {
		this.uuid = uuid;
		this.game = game;
		
		creators.add(this);
	}
	
	public static BuildCreator getCreator(UUID uuid) {
		return creators.stream().filter(c -> c.getUuid().equals(uuid)).findAny().orElse(null);
	}
	
	public void cancel() {
		BuildGame.getGames().remove(game);
		creators.remove(this);
	}
}
