package me.signatured.buildbattlereloaded.util;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import lombok.Getter;
import me.signatured.buildbattlereloaded.BuildBattleReloaded;

public class ArenaFile {
	
	private BuildBattleReloaded plugin;
	private FileConfiguration config;
	@Getter
	private File file;

	public ArenaFile(BuildBattleReloaded plugin) {
		this.plugin = plugin;
		reloadConfig();
	}

	public void reloadConfig() {
		if (file == null)
			file = new File(plugin.getDataFolder(), "arenas.yml");
		config = YamlConfiguration.loadConfiguration(file);
	}

	public FileConfiguration getConfig() {
		if (config == null)
			reloadConfig();
		
		return config;
	}

	public void saveConfig() {
		if (config == null || file == null)
			return;
		
		try {
			getConfig().save(file);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}