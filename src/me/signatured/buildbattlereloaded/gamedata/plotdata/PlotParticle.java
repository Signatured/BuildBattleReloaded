package me.signatured.buildbattlereloaded.gamedata.plotdata;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import me.signatured.buildbattlereloaded.util.ItemBuilder;

@Getter
public enum PlotParticle {
	
	SLIME("Slime", ItemBuilder.of(Material.SLIME_BALL).build(), Effect.SLIME),
	LAVA_DRIP("Lava Drip", ItemBuilder.of(Material.LAVA_BUCKET).build(), Effect.LAVADRIP),
	WATER_DRIP("Water Drip", ItemBuilder.of(Material.WATER_BUCKET).build(), Effect.WATERDRIP),
	NOTE("Note", ItemBuilder.of(Material.NOTE_BLOCK).build(), Effect.NOTE),
	HEART("Heart", ItemBuilder.of(Material.GOLD_NUGGET).build(), Effect.HEART),
	HAPPY_VILLAGER("Happy Villager", ItemBuilder.of(Material.EMERALD).build(), Effect.HAPPY_VILLAGER),
	ANGRY_VILLAGER("Angry Villager", ItemBuilder.of(Material.SLIME_BALL).build(), Effect.VILLAGER_THUNDERCLOUD),
	GLYPH("Glyph", ItemBuilder.of(Material.BOOK).build(), Effect.FLYING_GLYPH),
	MOBSPAWNER_FLAMES("Mobspawner Flames", ItemBuilder.of(Material.MOB_SPAWNER).build(), Effect.MOBSPAWNER_FLAMES),
	EXPLOSION("Explosion", ItemBuilder.of(Material.TNT).build(), Effect.EXPLOSION),
	MAGIC_CRIT("Magic Crit", ItemBuilder.of(Material.DIAMOND_SWORD).build(), Effect.MAGIC_CRIT),
	WITCH_MAGIC("Witch Magic", ItemBuilder.of(Material.SLIME_BALL).build(), Effect.WITCH_MAGIC),
	SPLASH("Splash", ItemBuilder.of(Material.GLASS_BOTTLE).build(), Effect.SPLASH),
	CLOUD("Cloud", ItemBuilder.of(Material.STAINED_GLASS).build(), Effect.CLOUD),
	PORTAL("Portal", ItemBuilder.of(Material.PORTAL).build(), Effect.PORTAL),
	FIREWORK_SPARK("Firework Spark", ItemBuilder.of(Material.FIREWORK).build(), Effect.FIREWORKS_SPARK),
	SMOKE("Smoke", ItemBuilder.of(Material.REDSTONE_BLOCK).build(), Effect.SMOKE),
	SNOWBALL("Snowball", ItemBuilder.of(Material.SNOW_BALL).build(), Effect.SNOWBALL_BREAK);
	
	private String name;
	private ItemStack item;
	private Effect effect;
	
	PlotParticle(String name, ItemStack item, Effect effect) {
		this.name = name;
		this.item = item;
		this.effect = effect;
	}
}
