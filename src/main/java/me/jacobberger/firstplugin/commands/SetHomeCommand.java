package me.jacobberger.firstplugin.commands;

import me.jacobberger.firstplugin.FirstPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {

    private final FirstPlugin plugin;

    public SetHomeCommand(FirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (sender instanceof Player){

                Player p = (Player) sender;
                String uuid = p.getUniqueId().toString();
                Location location = p.getLocation();

                plugin.getConfig().set(uuid + " home", location);
                plugin.saveConfig();

                p.sendMessage("Home has been set at current location.");

            }

        return true;

    }

}