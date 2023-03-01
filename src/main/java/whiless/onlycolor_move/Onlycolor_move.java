package whiless.onlycolor_move;

import org.bukkit.plugin.java.JavaPlugin;
import whiless.onlycolor_move.Listener.MoveSystem;
import whiless.onlycolor_move.team.Team;

public final class Onlycolor_move extends JavaPlugin {
    private static JavaPlugin plugin;
    public static MoveSystem moveSystem;
    public static Commands commands;




    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        commands = new Commands();

        moveSystem = new MoveSystem();
        getServer().getPluginManager().registerEvents(moveSystem,this);
        getLogger().info("onlyColor_move:が起動");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("onlyColor_move:が停止");
    }

    public static JavaPlugin getPlugin(){return plugin;}
}
