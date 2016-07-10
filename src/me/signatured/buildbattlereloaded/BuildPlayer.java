package me.signatured.buildbattlereloaded;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import lombok.Getter;
import me.signatured.buildbattlereloaded.util.Util;

@Getter
public class BuildPlayer {
	
	private String name;
	private UUID uuid;
	private BuildGame game;
	
	public BuildPlayer(Player player) {
		this.name = player.getName();
		this.uuid = player.getUniqueId();
	}
	
	public void tell(String message) {
		if (getPlayer() == null)
			return;
		
		getPlayer().sendMessage(message);
	}
	
	public void actionbar(String message) {
		if (getPlayer() == null)
			return;
		
		Util.sendActionBar(getPlayer(), message);
	}
	
	public void title(String title) {
		if (getPlayer() == null)
			return;
		
		Util.sendTitle(getPlayer(), title);
	}
	
	public void subtitle(String subtitle) {
		if (getPlayer() == null)
			return;
		
		Util.sendSubtitle(getPlayer(), subtitle);
	}
	
	public void titleAndSubtitle(String title, String subtitle) {
		if (getPlayer() == null)
			return;
		
		Util.sendTitleAndSubtitle(getPlayer(), title, subtitle);
	}
	
	public void teleport(Location loc) {
		if (getPlayer() == null)
			return;
		
		getPlayer().teleport(loc);
	}
	
	public Player getPlayer() {
		return Bukkit.getPlayer(uuid);
	}
}
