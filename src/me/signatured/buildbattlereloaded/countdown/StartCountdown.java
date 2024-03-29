package me.signatured.buildbattlereloaded.countdown;

import me.signatured.buildbattlereloaded.BuildGame;

public class StartCountdown extends BuildCountdown {
	
	public StartCountdown(BuildGame game, int timeLeft) {
		super(game, timeLeft);
		game.setStartCountdown(this);
	}

	@Override
	public void onStop() {
		onCancel();
		getGame().start();
	}

	@Override
	public void onCancel() {
		this.cancel();
		getGame().setStartCountdown(null);
	}
}
