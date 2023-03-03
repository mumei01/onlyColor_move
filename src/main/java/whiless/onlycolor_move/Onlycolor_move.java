package whiless.onlycolor_move;

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Team;
import whiless.onlycolor_move.Listener.MoveSystem;
import whiless.onlycolor_move.config.TeamColorConfig;

import java.awt.*;

public final class Onlycolor_move extends JavaPlugin {
    private static JavaPlugin plugin;
    public static MoveSystem moveSystem;
    public static Commands commands;

    public static TeamColorConfig config;




    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        config = new TeamColorConfig(this);
        commands = new Commands();

        moveSystem = new MoveSystem();


        for(Team team : getServer().getScoreboardManager().getMainScoreboard().getTeams()){
            Material  teamMaterial = config.getTeamMaterial(team.getName(),Material.AIR);

            ChatColor color;
            color = team.getColor();


            team.setPrefix(color+"["+team.getName()+"] "+ ChatColor.WHITE);
            if (teamMaterial.equals(Material.AIR)){
                config.setTeamMaterial(team.getName(),Material.AIR);
            }

        }




        getServer().getPluginManager().registerEvents(moveSystem,this);
        getLogger().info("onlyColor_move:が起動");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("onlyColor_move:が停止");
    }

    public static JavaPlugin getPlugin(){return plugin;}
    public static TeamColorConfig getconfig(){return config;}
}
