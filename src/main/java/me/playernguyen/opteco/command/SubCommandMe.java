package me.playernguyen.opteco.command;

import me.playernguyen.opteco.OptEco;
import me.playernguyen.opteco.configuration.OptEcoConfiguration;
import me.playernguyen.opteco.language.OptEcoLanguage;
import me.playernguyen.opteco.account.OptEcoCacheAccount;
import me.playernguyen.opteco.permission.OptEcoPermission;
import org.bukkit.command.CommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SubCommandMe extends SubCommand {


    SubCommandMe(String command, OptEco plugin) {

        super(command, plugin.getLanguageLoader().getLanguage(OptEcoLanguage.COMMAND_DESCRIBE_SELFCHECK), plugin);

        addPermissions(OptEcoPermission.EVERYTHING);
        addPermissions(OptEcoPermission.ADMIN);
        addPermissions(OptEcoPermission.ME);
        addPermissions(OptEcoPermission.USER);
    }

    @Override
    public boolean onPlayerCommand(Player player, ArrayList<String> args) {
        // Player information
        OptEcoCacheAccount optEcoCacheAccount = getPlugin().getAccountManager().get(player.getUniqueId());
        player.sendMessage(
                getMessageFormat().format(
                        getPlugin().getLanguageLoader().getLanguage(OptEcoLanguage.CHECK_SELF)
                                .replace("%value%", getMessageFormat()
                                        .numberFormat(optEcoCacheAccount.getBalance())
                                ).replace("%currency%", getPlugin()
                                .getConfigurationLoader()
                                .getString(OptEcoConfiguration.CURRENCY_SYMBOL)
                        )
                )
        );
        return true;
    }

    @Override
    public boolean onConsoleCommand(CommandSender sender, ArrayList<String> args) {
        sender.sendMessage(
                getMessageFormat().format(getPlugin().getLanguageLoader().getLanguage(OptEcoLanguage.FOR_PLAYER_COMMAND))
        );
        return true;
    }

    @Override
    public boolean onRemoteConsoleCommand(RemoteConsoleCommandSender sender, ArrayList<String> args) {
        sender.sendMessage(
                getMessageFormat().format(getPlugin().getLanguageLoader().getLanguage(OptEcoLanguage.FOR_PLAYER_COMMAND))
        );
        return true;
    }

    @Override
    public List<String> onTab(CommandSender commandSender, ArrayList<String> args) {
        return null;
    }
}
