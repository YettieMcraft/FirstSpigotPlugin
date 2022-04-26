package me.jacobberger.firstplugin;

import me.jacobberger.firstplugin.commands.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class FirstPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("My first plugin has started.");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("loser").setExecutor(new MenuCommand());
        getCommand("sethome").setExecutor(new SetHomeCommand(this));
        getCommand("home").setExecutor(new HomeCommand(this));
        getCommand("fart").setExecutor(new FartCommand());

//        getServer().getPluginManager().registerEvents(new ClickEvent(this), this);
        getServer().getPluginManager().registerEvents(this,this);

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        event.setJoinMessage("A loser has joined, please leave idiot.");

    }

    @EventHandler
    public void onEnterPortal(PlayerPortalEvent event) {

        Player player = event.getPlayer();
        player.sendRawMessage("Fuck you piece of shit go back!");

    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        World end = event.getEntity().getWorld();

        if(end.getName().endsWith("_the_end")) {

            if (event.getEntity().getType() == EntityType.ENDERMAN) {

                    event.getDrops().clear();

            }

        }

    }

    @EventHandler
    public void onClickEvent(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.BOLD + "Loser")) {

            //make it so that players can't move items
            event.setCancelled(true);

            if (event.getCurrentItem() == null) {
                return;
            }

            if (event.getCurrentItem().getType() == Material.DARK_OAK_DOOR){

                player.performCommand("home");
                player.closeInventory();

            }


        }

    }

}