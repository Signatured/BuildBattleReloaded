package me.signatured.buildbattlereloaded.countdown;

import org.bukkit.scheduler.BukkitRunnable;

import lombok.Getter;
import me.signatured.buildbattlereloaded.BuildBattleReloaded;
import me.signatured.buildbattlereloaded.BuildGame;

@Getter
public abstract class BuildCountdown extends BukkitRunnable {
	
	private BuildGame game;
	private int timeLeft;
	
	public BuildCountdown(BuildGame game, int timeLeft) {
		this.game = game;
		this.timeLeft = timeLeft;
		
		this.runTaskTimer(BuildBattleReloaded.getInstance(), 0, 20);
	}

	@Override
	public void run() {
		if (timeLeft <= 0)
			onStop();
		
		timeLeft--;
	}
	
	public abstract void onStop();
	public abstract void onCancel();
}
