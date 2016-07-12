package me.signatured.buildbattlereloaded.countdown;

import me.signatured.buildbattlereloaded.BuildGame;

public class VoteCountdown extends BuildCountdown {
	
	private int vote;

	public VoteCountdown(BuildGame game, int vote, int timeLeft) {
		super(game, timeLeft);
		game.setVoteCountdown(this);
	}

	@Override
	public void onStop() {
		onCancel();
		//TODO: Start next vote or end game
	}

	@Override
	public void onCancel() {
		this.cancel();
		getGame().setVoteCountdown(null);
	}

	
}
