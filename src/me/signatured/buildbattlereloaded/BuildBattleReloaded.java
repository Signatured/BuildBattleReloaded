package me.signatured.buildbattlereloaded;

import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;

public class BuildBattleReloaded extends JavaPlugin {
	
	@Getter
	private static BuildBattleReloaded instance;
	
	@Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
	}
}
