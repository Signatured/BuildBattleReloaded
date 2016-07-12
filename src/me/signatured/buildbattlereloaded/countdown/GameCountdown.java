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
		//TODO: Start voting period
	}

	@Override
	public void onCancel() {
		this.cancel();
		getGame().setGameCountdown(null);
	}

}
