package me.ITGuy12.ColorChat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{

	Permission colorChat = new Permission("chat.color");
	
	public void onEnable() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(this, this);
		pm.addPermission(colorChat);
		getLogger().info(" is Enabled");
	}
	public void onDisable() {
	getLogger().info(" is Disabled");
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(p.hasPermission(colorChat)) {
			e.setFormat(p.getDisplayName() + ChatColor.WHITE + ": " + ChatColor.translateAlternateColorCodes('&', e.getMessage()));
		}
	}
}
