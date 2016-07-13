package me.signatured.buildbattlereloaded;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.signatured.buildbattlereloaded.util.gui.GuiListener;

public class BuildBattleReloaded extends JavaPlugin {
	
	@Getter
	private static BuildBattleReloaded instance;
	
	@Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		
		Bukkit.getPluginManager().registerEvents(new GuiListener(), this);
		Bukkit.getPluginManager().registerEvents(new BuildListener(), this);
	}
}
