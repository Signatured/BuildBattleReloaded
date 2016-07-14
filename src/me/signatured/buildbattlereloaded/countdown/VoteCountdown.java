package me.signatured.buildbattlereloaded.countdown;

import org.bukkit.ChatColor;

import me.signatured.buildbattlereloaded.BuildGame;
import me.signatured.buildbattlereloaded.gamedata.BuildPlot;

public class VoteCountdown extends BuildCountdown {
	
	private int vote;

	public VoteCountdown(BuildGame game, int vote, int timeLeft) {
		super(game, timeLeft);
		game.setVoteCountdown(this);
		
		this.vote = vote;
		sendPlotInfo();
	}

	@Override
	public void onStop() {
		onCancel();
		getGame().startVote(vote + 1);
	}

	@Override
	public void onCancel() {
		this.cancel();
	}

	private void sendPlotInfo() {
		getGame().getParticipants().forEach(p -> p.subtitle(ChatColor.GRAY + "Plot Owner: " + ChatColor.AQUA + getCurrentPlot().getPlayer().getName()));
	}
	
	private BuildPlot getCurrentPlot() {
		return getGame().getActivePlots().get(vote);
	}
}
