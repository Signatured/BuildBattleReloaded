package me.signatured.buildbattlereloaded.countdown;

import me.signatured.buildbattlereloaded.BuildGame;

public class CelebrateCountdown extends BuildCountdown {

	public CelebrateCountdown(BuildGame game, int timeLeft) {
		super(game, timeLeft);
		game.setCelebrateCountdown(this);
	}

	@Override
	public void onStop() {
		onCancel();
		getGame().reset();
	}

	@Override
	public void onCancel() {
		this.cancel();
		getGame().setCelebrateCountdown(null);
	}

}
