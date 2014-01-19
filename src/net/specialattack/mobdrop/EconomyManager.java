
package net.specialattack.mobdrop;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

public final class EconomyManager {

    public static boolean giveMoney(String player, double amount) {
        if (economy != null) {
            EconomyResponse response = economy.depositPlayer(player, amount);

            return response.transactionSuccess();
        }

        return false;
    }

    public static String formatCurrency(double amount) {
        if (economy != null) {
            return economy.format(amount);
        }

        return "" + amount;
    }

    private static Economy economy;

    private static boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    static {
        if (!setupEconomy()) {
            throw new RuntimeException("You need Vault and a working economy plugin installed to use this mod!");
        }
    }

}
