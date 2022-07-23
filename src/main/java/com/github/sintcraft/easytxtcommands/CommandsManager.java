package com.github.sintcraft.easytxtcommands;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.executors.ExecutorType;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class CommandsManager {
  private EasyTxtCommands plugin;
  private List<CommandAPICommand> cmds = new ArrayList<>();

  public CommandsManager(EasyTxtCommands plugin) {
    this.plugin = plugin;
    registerCommands();
  }

  public void registerCommands() {
    cmds.forEach((cmd) -> {
      CommandAPI.unregister(cmd.getName(), true);
    });

    cmds = new ArrayList<>();
    ConfigurationSection configCmds = plugin.getConfig().getConfigurationSection("commands");

    configCmds.getKeys(false).forEach((key) -> {
      List<String> aliases = configCmds.getStringList(key+".aliases");
      List<String> lines = configCmds.getStringList(key+".lines");
      CommandAPICommand cmd = new CommandAPICommand(key)
              .withPermission("etcmds.cmd."+key)
              .withAliases(aliases.toArray(new String[0]))
              .executes((sender, args) -> {
                lines.forEach(line -> {
                  sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                });
              }, ExecutorType.ALL);
      cmds.add(cmd);
      cmd.register();
    });
  }
}
