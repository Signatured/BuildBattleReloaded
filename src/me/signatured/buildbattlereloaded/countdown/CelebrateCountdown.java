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
		//TODO: Reset everything, give everyone stuff back
	}

	@Override
	public void onCancel() {
		this.cancel();
		getGame().setCelebrateCountdown(null);
	}

}
