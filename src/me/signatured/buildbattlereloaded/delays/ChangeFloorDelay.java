package me.signatured.buildbattlereloaded.delays;

import org.bukkit.ChatColor;

public class ChangeFloorDelay extends BuildExpiration {

	public ChangeFloorDelay() {
		super(1000 * 5, ChatColor.RED + "You must wait " + ChatColor.YELLOW + "5s" + ChatColor.RED + " to do this!");
	}

}
