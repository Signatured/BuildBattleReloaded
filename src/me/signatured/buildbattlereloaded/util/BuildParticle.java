package me.signatured.buildbattlereloaded.util;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import me.signatured.buildbattlereloaded.BuildBattleReloaded;
import me.signatured.buildbattlereloaded.BuildPlayer;

public class BuildParticle extends BukkitRunnable {
	
	private BuildPlayer player;
	private Location loc;
	private Effect particle;
	
	public BuildParticle(BuildPlayer player, Location loc, Effect particle) {
		this.player = player;
		this.loc = loc;
		this.particle = particle;
		
		this.runTaskTimer(BuildBattleReloaded.getInstance(), 0, 10);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		if (player.getPlayer() == null)
			return;
		
		player.getPlayer().playEffect(loc, particle, 0);
	}
}
