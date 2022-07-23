package com.github.sintcraft.easytxtcommands;

import com.github.sintcraft.easytxtcommands.commands.EasyTxtCommandsCmd;
import org.bukkit.plugin.java.JavaPlugin;

public final class EasyTxtCommands extends JavaPlugin {
  private CommandsManager commandsManager;
  private EasyTxtCommandsCmd easyTxtCommandsCmd;

  @Override
  public void onEnable() {
    // Plugin startup logic
    saveDefaultConfig();
    commandsManager = new CommandsManager(this);
    easyTxtCommandsCmd = new EasyTxtCommandsCmd(this);
    getLogger().info("Plugin ready!");
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
    getLogger().info("Bye world únú.");
  }

  public CommandsManager getCommandsManager() {
    return commandsManager;
  }
}
