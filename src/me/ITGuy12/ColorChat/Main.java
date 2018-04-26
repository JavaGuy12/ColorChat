package me.ITGuy12.ColorChat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class Main extends JavaPlugin implements Listener{

	Permission colorChat = new Permission("chat.color");
	
	public void onEnable() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(this, this);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(p.hasPermission(colorChat)) {
			e.setFormat(p.getDisplayName() + ChatColor.WHITE + ": " + ChatColor.translateAlternateColorCodes('&', e.getMessage()));
		}
	}
}
