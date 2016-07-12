package me.signatured.buildbattlereloaded.util;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundEffect {
	
	private Sound sound;
	private float pitch;
	
	public SoundEffect(Sound sound, float pitch) {
		this.sound = sound;
		this.pitch = pitch;
	}
	
	public void play(Player player) {
		player.playSound(player.getLocation(), sound, 1, pitch);
	}
}
