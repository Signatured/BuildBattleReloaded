package me.signatured.buildbattlereloaded.countdown;

import org.bukkit.scheduler.BukkitRunnable;

import lombok.Getter;
import me.signatured.buildbattlereloaded.BuildGame;

public class StartCountdown extends BukkitRunnable {
	
	@Getter
	private int timeLeft = 60;
	private BuildGame game;
	
	public StartCountdown(BuildGame game) {
		this.game = game;
		game.setStartCountdown(this);
	}

	@Override
	public void run() {
		if (timeLeft <= 0)
			game.start();
		
		timeLeft--;
	}

	public void stop() {
		game.setStartCountdown(null);
		this.cancel();
	}
}
