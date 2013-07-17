
package net.specialattack.mobdrop;

import me.heldplayer.SpAEconomy.SpAEconomy;
import net.specialattack.mobdrop.modifiers.IModifier;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class KillListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity().getKiller() instanceof Player) {
            Player player = (Player) event.getEntity().getKiller();

            double money = 0.0D;
            String mobName = "";

            for (int i = 0; i < 3; i++) {
                for (IModifier modifier : SpAMobDrop.instance.moneyModifiers) {
                    money = modifier.getModified(player, event.getEntity(), money, i);
                    mobName = modifier.modifyName(event.getEntity(), mobName, i);
                }
            }

            if (money < 0.0D) {
                if (money > -0.01D) {
                    return;
                }

                player.sendMessage(ChatColor.DARK_GREEN + "You have lost " + ChatColor.WHITE + SpAEconomy.formatMoney(money) + ChatColor.DARK_GREEN + " for killing a " + ChatColor.WHITE + mobName);

                String account = SpAEconomy.getAccountForWorld(player.getWorld());
                SpAEconomy.instance.accounts.giveMoney(player.getName(), account, money);
            }
            else {
                if (money < 0.01D) {
                    return;
                }

                player.sendMessage(ChatColor.DARK_GREEN + "You have been awarded " + ChatColor.WHITE + SpAEconomy.formatMoney(money) + ChatColor.DARK_GREEN + " for killing a " + ChatColor.WHITE + mobName);

                String account = SpAEconomy.getAccountForWorld(player.getWorld());
                SpAEconomy.instance.accounts.giveMoney(player.getName(), account, money);
            }
        }
    }

}
