package me.signatured.buildbattlereloaded;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import lombok.Setter;
import me.signatured.buildbattlereloaded.delays.ChangeBiomeDelay;
import me.signatured.buildbattlereloaded.delays.ChangeFloorDelay;
import me.signatured.buildbattlereloaded.util.Util;

@Getter
public class BuildPlayer {
	
	private String name;
	private UUID uuid;
	private BuildGame game;
	private BuildRating currentRating;
	
	private ChangeBiomeDelay biomeDelay = new ChangeBiomeDelay();
	private ChangeFloorDelay floorDelay = new ChangeFloorDelay();
	
	@Setter
	private ItemStack[] inventory;
	@Setter
	private ItemStack[] armor;
	
	public BuildPlayer(Player player, BuildGame game) {
		this.name = player.getName();
		this.uuid = player.getUniqueId();
		this.game = game;
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
	
	public void handleInventory() {
		if (getPlayer() == null)
			return;
		inventory = getPlayer().getInventory().getContents();
		armor = getPlayer().getInventory().getArmorContents();
		
		Util.clearInventory(getPlayer());
	}
	
	public void returnInventory() {
		if (getPlayer() == null)
			return;
		Util.clearInventory(getPlayer());
		
		getPlayer().getInventory().setContents(inventory);
		getPlayer().getInventory().setArmorContents(armor);
	}
	
	public Player getPlayer() {
		return Bukkit.getPlayer(uuid);
	}
}
