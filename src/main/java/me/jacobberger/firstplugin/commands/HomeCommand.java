package me.jacobberger.firstplugin.commands;

import me.jacobberger.firstplugin.FirstPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    private final FirstPlugin plugin;

    public HomeCommand(FirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player p = (Player) sender;
            String uuid = p.getUniqueId().toString();
            Location location = plugin.getConfig().getLocation(uuid + " home");

            p.teleport(location);

            p.sendMessage("You have teleported home.");

        }

        return true;

    }

}
