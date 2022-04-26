package me.jacobberger.firstplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class FartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player p = (Player) sender;

            if (args.length == 0) {

                p.sendMessage("Why the fuck did you just fart idiot!");
                p.addPotionEffect(PotionEffectType.BLINDNESS.createEffect(30,2));
                p.playSound(p.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 5,5);
                p.spawnParticle(Particle.EXPLOSION_HUGE, p.getLocation(), 10);

            }else{

                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if (target == null){
                    p.sendMessage("Who the fuck is " + target.getDisplayName());
                }else{
                    p.sendMessage("You farted on " + target.getDisplayName() + " you ass hole.");
                    target.sendMessage("You have just been farted on by " + p.getDisplayName());
                    target.addPotionEffect(PotionEffectType.BLINDNESS.createEffect(30,2));
                    target.playSound(target.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 5,5);
                    target.spawnParticle(Particle.EXPLOSION_HUGE, target.getLocation(), 10);
                }

            }

        }

        return true;
    }
}
