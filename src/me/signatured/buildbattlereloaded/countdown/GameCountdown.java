package me.signatured.buildbattlereloaded.countdown;

import me.signatured.buildbattlereloaded.BuildGame;

public class GameCountdown extends BuildCountdown {

	public GameCountdown(BuildGame game, int timeLeft) {
		super(game, timeLeft);
		game.setGameCountdown(this);
	}

	@Override
	public void onStop() {
		onCancel();
		new VoteCountdown(getGame(), 0, 10);
	}

	@Override
	public void onCancel() {
		this.cancel();
		getGame().setGameCountdown(null);
	}

}
