package com.github.sintcraft.easytxtcommands.commands;

import com.github.sintcraft.easytxtcommands.EasyTxtCommands;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.executors.ExecutorType;
import org.bukkit.ChatColor;

public class EasyTxtCommandsCmd {
  private EasyTxtCommands plugin;
  private CommandAPICommand easytxtcommands = new CommandAPICommand("easytxtcommands")
          .withAliases("etcmds", "easytc")
          .withPermission("etcmds.reload")
          .executes((sender, args) -> {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aReloading config..."));
            // Reload system logic
            plugin.reloadConfig();
            plugin.getCommandsManager().registerCommands();

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aConfig Reloaded!"));
          }, ExecutorType.ALL);

  public EasyTxtCommandsCmd(EasyTxtCommands plugin) {
    this.plugin = plugin;
    easytxtcommands.register();
  }
}
