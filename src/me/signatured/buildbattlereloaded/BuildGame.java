package me.signatured.buildbattlereloaded;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import me.signatured.buildbattlereloaded.countdown.GameCountdown;
import me.signatured.buildbattlereloaded.countdown.StartCountdown;
import me.signatured.buildbattlereloaded.gamedata.BuildPlot;

@Getter @Setter
public class BuildGame {
	
	@Getter
	private static List<BuildGame> games = new ArrayList<>();
	
	@NonNull
	private String name;
	private GameState state = GameState.BEFORE;
	private Location lobbyLoc;
	private int minimum = 3;
	
	private Set<BuildPlayer> participants = new HashSet<>();
	private Set<BuildPlot> plots = new HashSet<>();
	
	private StartCountdown startCountdown;
	private GameCountdown gameCountdown;
	
	public BuildGame(String name) {
		this.name = name;
		
		games.add(this);
	}
	
	public void start() {
		state = GameState.DURING;
		//TODO
	}
	
	public void update() {
		if (getSize() >= minimum && startCountdown == null)
			start();
		if (getSize() < minimum && startCountdown != null)
			startCountdown.stop();
	}
	
	public void addPlayer(Player player) {
		BuildPlayer bp = new BuildPlayer(player, this);
		
		participants.add(bp);
		bp.handleInventory();
		bp.teleport(lobbyLoc);
	}
	
	public void removePlayer(BuildPlayer player) {
		if (!started()) {
			participants.remove(player);
			update();
		} else {
			participants.remove(player);
			
			if (getSize() == 1) {
				//TODO: Delcare winner
			}
		}
		
		player.returnInventory();
	}
	
	public void tell(String message) {
		participants.stream().forEach(p -> p.tell(message));
	}
	
	public void actionbar(String message) {
		participants.stream().forEach(p -> p.actionbar(message));
	}
	
	public void title(String title) {
		participants.stream().forEach(p -> p.title(title));
	}
	
	public void subtitle(String subtitle) {
		participants.stream().forEach(p -> p.subtitle(subtitle));
	}
	
	public void titleAndSubtitle(String title, String subtitle) {
		participants.stream().forEach(p -> p.titleAndSubtitle(title, subtitle));
	}
	
	public BuildPlayer getParticipant(Player player) {
		return participants.stream().filter(p -> p.getUuid().equals(player.getUniqueId())).findAny().orElse(null);
	}
	
	public BuildPlot getPlot(BuildPlayer player) {
		return plots.stream().filter(p -> p.getPlayer().equals(player)).findAny().orElse(null);
	}
	
	public boolean started() {
		return state != GameState.BEFORE;
	}
	
	public boolean joinable() {
		return plots.size() > 0 && lobbyLoc != null;
	}
	
	public int getSize() {
		return participants.size();
	}
	
	public int getMaxSize() {
		return plots.size();
	}
	
	public enum GameState {
		BEFORE,
		DURING,
		AFTER;
	}
}
