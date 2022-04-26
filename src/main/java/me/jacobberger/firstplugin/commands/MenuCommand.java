package me.jacobberger.firstplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Inventory inventory = Bukkit.createInventory(player, 9, ChatColor.BOLD + "Loser");

            ItemStack home_button = new ItemStack(Material.DARK_OAK_DOOR, 1);
            ItemStack place_holder = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);

            ItemMeta itemMeta = home_button.getItemMeta();
            itemMeta.setDisplayName("Do not click.");
            home_button.setItemMeta(itemMeta);

            inventory.setItem(1, place_holder);
            inventory.setItem(2, place_holder);
            inventory.setItem(3, place_holder);
            inventory.setItem(4, place_holder);
            inventory.setItem(5, place_holder);
            inventory.setItem(6, place_holder);
            inventory.setItem(7, place_holder);
            inventory.setItem(8, place_holder);


            inventory.setItem(0, home_button);
            player.openInventory(inventory);

        }
        return true;
    }

}