package me.signatured.buildbattlereloaded.delays;

import org.bukkit.entity.Player;

public class BuildExpiration {

	private long expiration = 0;
	private long timeToAdd;
	private String message;
	
	public BuildExpiration(long milliseconds, String message) {
		timeToAdd = milliseconds;
		this.message = message;
	}
	
	public BuildExpiration expireIn() {
		expiration = System.currentTimeMillis() + timeToAdd;
		return this;
	}

	public boolean isExpired() {
		return System.currentTimeMillis() >= expiration;
	}

	public void expireNow() {
		expiration = 0;
	}

	public long getExpiration() {
		return expiration;
	}
	
	public void sendMessage(Player player) {
		player.sendMessage(message);
	}
}
