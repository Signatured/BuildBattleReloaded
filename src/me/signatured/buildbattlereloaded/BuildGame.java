package me.signatured.buildbattlereloaded;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import me.signatured.buildbattlereloaded.countdown.CelebrateCountdown;
import me.signatured.buildbattlereloaded.countdown.GameCountdown;
import me.signatured.buildbattlereloaded.countdown.StartCountdown;
import me.signatured.buildbattlereloaded.countdown.VoteCountdown;
import me.signatured.buildbattlereloaded.gamedata.BuildPlot;

@Getter @Setter
public class BuildGame {
	
	@Getter
	private static List<BuildGame> games = new ArrayList<>();
	
	@NonNull
	private String name;
	private GameState state = GameState.BEFORE;
	private Location lobbyLoc;
	
	private int min;
	
	private List<BuildPlayer> participants = new ArrayList<>();
	private List<BuildPlot> plots = new ArrayList<>();
	
	private StartCountdown startCountdown;
	private GameCountdown gameCountdown;
	private VoteCountdown voteCountdown;
	private CelebrateCountdown celebrateCountdown;
	
	public BuildGame(String name) {
		this.name = name;
		
		games.add(this);
	}
	
	public void add(Player player) {
		BuildPlayer bp = new BuildPlayer(player, this);
		
		participants.add(bp);
		bp.handleInventory();
		bp.teleport(lobbyLoc);
		
		checkStartRequirements();
	}
	
	public void remove(BuildPlayer player) {
		player.returnInventory();
		participants.remove(player);
		
		if (!started() && getSize() < min && startCountdown != null)
			startCountdown.onCancel();
		else if (started() && isDefaultWinner())
			end();
	}
	
	public void start() {
		state = GameState.DURING;
		
		for (int i = 0; i < participants.size(); i++) {
			BuildPlayer player = participants.get(i);
			BuildPlot plot = plots.get(i);
			
			plot.setPlayer(player);
			player.teleport(plot.getTeleportLoc());
		}
	}
	
	public void end() {
		state = GameState.AFTER;
		BuildPlot winner = getWinner();
		
		teleport(winner.getTeleportLoc());
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
	
	public void teleport(Location loc) {
		participants.stream().forEach(p -> p.teleport(loc));
	}
	
	public BuildPlayer getParticipant(Player player) {
		return participants.stream().filter(p -> p.getUuid().equals(player.getUniqueId())).findAny().orElse(null);
	}
	
	public BuildPlot getPlot(BuildPlayer player) {
		return plots.stream().filter(p -> p.getPlayer().equals(player)).findAny().orElse(null);
	}
	
	public BuildPlot getWinner() {
		BuildPlot winner = getPlot(participants.get(0));
		for (BuildPlayer player : participants) {
			BuildPlot plot = getPlot(player);
			
			if (plot.getScore() > winner.getScore())
				winner = plot;	
		}
		
		return winner;
	}
	
	public void checkStartRequirements() {
		if (getSize() >= min && startCountdown == null)
			new StartCountdown(this, 60);
	}
	
	public boolean gameSetup() {
		return lobbyLoc != null && min >= 2 && getMax() >= 2;
	}
	
	public boolean started() {
		return state == GameState.DURING;
	}
	
	public boolean isDefaultWinner() {
		return getSize() == 1;
	}
	
	public boolean joinable() {
		return plots.size() > 0 && lobbyLoc != null;
	}
	
	public int getSize() {
		return participants.size();
	}
	
	public int getMax() {
		return plots.size();
	}
	
	public enum GameState {
		BEFORE,
		DURING,
		AFTER;
	}
}
