package me.signatured.buildbattlereloaded.delays;

import org.bukkit.ChatColor;

public class ChangeWeatherDelay extends BuildExpiration {
	
	public ChangeWeatherDelay() {
		super(1000 * 5, ChatColor.RED + "You must wait " + ChatColor.YELLOW + "5s" + ChatColor.RED + " to do this!");
	}
}
