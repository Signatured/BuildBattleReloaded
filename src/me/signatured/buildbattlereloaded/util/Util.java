package me.signatured.buildbattlereloaded.util;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;

public class Util {
	
	public static PacketPlayOutChat createActionBarPacket(String message) {
		String msg = "{\"text\":\"" + message + "\"}";
		return new PacketPlayOutChat(ChatSerializer.a(msg), (byte) 2);
	}
	
	public static void sendActionBar(Player player, String message) {
		CraftPlayer p = (CraftPlayer) player;
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(createActionBarPacket(message));
	}
	
	public static PacketPlayOutTitle createTitlePacket(String message, int fadeIn, int stay, int fadeOut) {
		String msg = "{\"text\":\"" + message + "\"}";
		return new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a(msg), fadeIn, stay, fadeOut);
	}
	
	public static PacketPlayOutTitle createTitlePacket(String message) {
		String msg = "{\"text\":\"" + message + "\"}";
		return new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a(msg));
	}
	
	public static void sendTitle(Player player, String message, int fadeIn, int stay, int fadeOut) {
		CraftPlayer p = (CraftPlayer) player;
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(createTitlePacket(colorText(message), fadeIn, stay, fadeOut));
	}
	
	public static void sendTitle(Player player, String message) {
		CraftPlayer p = (CraftPlayer) player;
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(createTitlePacket(colorText(message)));
	}
	
	public static PacketPlayOutTitle createSubtitlePacket(String message, int fadeIn, int stay, int fadeOut) {
		String msg = "{\"text\":\"" + message + "\"}";
		return new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a(msg), fadeIn, stay, fadeOut);
	}
	
	public static PacketPlayOutTitle createSubtitlePacket(String message) {
		String msg = "{\"text\":\"" + message + "\"}";
		return new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a(msg));
	}
	
	public static void sendSubtitle(Player player, String message, int fadeIn, int stay, int fadeOut) {
		CraftPlayer p = (CraftPlayer) player;
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(createSubtitlePacket(colorText(message), fadeIn, stay, fadeOut));
	}
	
	public static void sendSubtitle(Player player, String message) {
		CraftPlayer p = (CraftPlayer) player;
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(createSubtitlePacket(colorText(message)));
	}
	
	public static void sendTitleAndSubtitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
		CraftPlayer p = (CraftPlayer) player;
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(createTitlePacket(colorText(title), fadeIn, stay, fadeOut));
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(createSubtitlePacket(colorText(subtitle), fadeIn, stay, fadeOut));
	}
	
	public static void sendTitleAndSubtitle(Player player, String title, String subtitle) {
		CraftPlayer p = (CraftPlayer) player;
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(createTitlePacket(colorText(title)));
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(createSubtitlePacket(colorText(subtitle)));
	}
	
	public static String colorText(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
