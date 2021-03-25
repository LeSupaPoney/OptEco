package me.playernguyen.opteco.api.placeholderapi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.playernguyen.opteco.OptEco;
import me.playernguyen.opteco.configuration.OptEcoConfiguration;
import me.playernguyen.opteco.account.OptEcoCacheAccount;
import org.bukkit.entity.Player;

public class OptEcoExpansion extends PlaceholderExpansion {

    private final OptEco plugin;

    public OptEcoExpansion(OptEco plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return this.plugin.getName();
    }

    @Override
    public String getAuthor() {
        return this.plugin.getDescription().getAuthors().toString();
    }

    @Override
    public String getVersion() {
        return this.plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player p, String params) {
        if (p == null) {
            return "";
        }
        // %opteco_points%
        if (params.equalsIgnoreCase("points")) {
            OptEcoCacheAccount optEcoCacheAccount = OptEco.getInstance().getAccountManager().get(p.getUniqueId());
            if (optEcoCacheAccount == null) {
                return "";
            }
            double balance = optEcoCacheAccount.getBalance();
            return this.plugin.getMessageFormat().numberFormat(balance);
        }
        // %opteco_points_rounded
        if (params.equalsIgnoreCase("points_rounded")) {
            OptEcoCacheAccount optEcoCacheAccount = OptEco.getInstance().getAccountManager().get(p.getUniqueId());
            if (optEcoCacheAccount == null) {
                return null;
            }

            double balance = optEcoCacheAccount.getBalance();
            return String.valueOf(Math.round(balance));
        }

        // %opteco_version%
        if (params.equalsIgnoreCase("version")) {
            return this.plugin.getDescription().getVersion();
        }
        // %opteco_currency%
        if (params.equalsIgnoreCase("currency")) {
            return this.plugin.getConfigurationLoader().getString(OptEcoConfiguration.CURRENCY_SYMBOL);
        }
        return null;
    }
}
