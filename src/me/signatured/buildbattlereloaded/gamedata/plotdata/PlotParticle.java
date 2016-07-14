package me.signatured.buildbattlereloaded.gamedata.plotdata;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.signatured.buildbattlereloaded.util.ItemBuilder;

public enum PlotParticle {
	
	SLIME(ItemBuilder.of(Material.SLIME_BALL).build()),
	DRIP_LAVA(ItemBuilder.of(Material.LAVA_BUCKET).build()),
	DRIP_WATER(ItemBuilder.of(Material.WATER_BUCKET).build()),
	NOTE(ItemBuilder.of(Material.NOTE_BLOCK).build()),
	HEART(ItemBuilder.of(Material.GOLD_NUGGET).build()),
	HAPPY_VILLAGER(ItemBuilder.of(Material.EMERALD).build()),
	ANGRY_VILLAGER(ItemBuilder.of(Material.SLIME_BALL).build()),
	GLYPH(ItemBuilder.of(Material.BOOK).build()),
	BUBBLE(ItemBuilder.of(Material.WATER).build()),
	MOBSPAWNER_FLAMES(ItemBuilder.of(Material.MOB_SPAWNER).build()),
	EXPLOSION(ItemBuilder.of(Material.TNT).build()),
	CRIT(ItemBuilder.of(Material.DIAMOND_SWORD).build()),
	WITCH(ItemBuilder.of(Material.SLIME_BALL).build()),
	SPLASH(ItemBuilder.of(Material.SLIME_BALL).build()),
	CLOUD(ItemBuilder.of(Material.STAINED_GLASS).build()),
	PORTAL(ItemBuilder.of(Material.PORTAL).build()),
	FIREWORK_SPARK(ItemBuilder.of(Material.FIREWORK).build()),
	REDSTONE(ItemBuilder.of(Material.REDSTONE_BLOCK).build()),
	SNOWBALL(ItemBuilder.of(Material.SNOW_BALL).build());
	
	private ItemStack item;
	
	PlotParticle(ItemStack item) {
		this.item = item;
	}
}
