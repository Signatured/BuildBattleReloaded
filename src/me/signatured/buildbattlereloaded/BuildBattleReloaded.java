package me.signatured.buildbattlereloaded;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.signatured.buildbattlereloaded.util.ArenaFile;
import me.signatured.buildbattlereloaded.util.gui.GuiListener;

@Getter
public class BuildBattleReloaded extends JavaPlugin {
	
	@Getter
	private static BuildBattleReloaded instance;
	
	private ArenaFile arenaFile;
	
	@Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		
		this.arenaFile = new ArenaFile(this);
		
		Bukkit.getPluginManager().registerEvents(new GuiListener(), this);
		Bukkit.getPluginManager().registerEvents(new BuildListener(), this);
	}
}
