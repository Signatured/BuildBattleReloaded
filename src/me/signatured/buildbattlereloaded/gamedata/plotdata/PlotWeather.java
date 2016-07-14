package me.signatured.buildbattlereloaded.gamedata.plotdata;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import me.signatured.buildbattlereloaded.BuildGame;
import me.signatured.buildbattlereloaded.BuildPlayer;
import me.signatured.buildbattlereloaded.gamedata.BuildPlot;
import me.signatured.buildbattlereloaded.util.ItemBuilder;

public enum PlotWeather {
	
	SUNNY("Sunny", new ItemStack(Material.DOUBLE_PLANT)),
	RAINY("Rainy", new ItemStack(Material.WATER_BUCKET)),
	STORMY("Stormy",  new ItemStack(Material.BLAZE_ROD)),
	SNOWY("Snowy",  new ItemStack(Material.SNOW_BALL));
	
	@Getter
	private String name;
	private ItemStack item;
	
	PlotWeather(String name, ItemStack item) {
		this.name = name;
		this.item = item;
	}
	
	public ItemStack getItem(boolean selected) {
		ItemBuilder builder = ItemBuilder.of(item);
		
		builder.name(ChatColor.YELLOW + name);
		
		if (selected)
			builder.lore("", ChatColor.GREEN + "Selected");
		else
			builder.lore("", ChatColor.GRAY + "Click to select");
		
		return builder.build();
	}
	
	public void apply(BuildPlot plot) {
		BuildPlayer buildPlayer = plot.getPlayer();
		Player player = buildPlayer.getPlayer();
		
		if (player == null)
			return;
		
		switch (this) {
		
		case SUNNY:
			player.setPlayerWeather(WeatherType.CLEAR);
			break;
		case RAINY:
			if (plot.getBiome() == PlotBiome.ICE_PLAINS)
				plot.setBiome(PlotBiome.PLAINS);
			player.setPlayerWeather(WeatherType.DOWNFALL);
			break;
		case SNOWY:
			plot.setBiome(PlotBiome.ICE_PLAINS);
			player.setPlayerWeather(WeatherType.DOWNFALL);
			break;
		default:
			break;
		}
	}
	
	public void apply(BuildGame game, BuildPlot plot) {
		List<Player> players = game.getParticipants().stream().filter(p -> p.getPlayer() != null)
				.map(p -> p.getPlayer()).collect(Collectors.toList());
		
		switch (this) {
		
		case SUNNY:
			if (plot.getBiome() == PlotBiome.ICE_PLAINS)
				plot.setBiome(PlotBiome.PLAINS);
			players.forEach(p -> p.setPlayerWeather(WeatherType.CLEAR));
			break;
		case RAINY:
			if (plot.getBiome() == PlotBiome.ICE_PLAINS)
				plot.setBiome(PlotBiome.PLAINS);
			players.forEach(p -> p.setPlayerWeather(WeatherType.DOWNFALL));
			break;
		case SNOWY:
			plot.setBiome(PlotBiome.ICE_PLAINS);
			players.forEach(p -> p.setPlayerWeather(WeatherType.DOWNFALL));
			break;
		default:
			break;
		}
	}
}
