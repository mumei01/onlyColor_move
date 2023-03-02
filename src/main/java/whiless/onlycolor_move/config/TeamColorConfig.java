package whiless.onlycolor_move.config;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;
import java.util.Set;

public final class TeamColorConfig extends ConfigFile {
    public TeamColorConfig(Plugin plugin) {
        super(plugin, "team-color-config.yml");

        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();

        if (!checkConsistency()) plugin.getLogger().warning("team-color-config.yml is illegal format. Please check example of default config.");
    }

    public Material getTeamMaterial(@Nonnull String team) {
        return Material.valueOf(getConfig().getString(team));
    }

    public Material getTeamMaterial(@Nonnull String name, @Nonnull Material material) {
        return Material.valueOf(getConfig().getString(name, material.name()));
    }

    public void setTeamMaterial(@Nonnull String team, @Nonnull Material material) {
        getConfig().set(team, material.name());
        saveConfig();
    }

    public Set<String> getTeams() {
        return getConfig().getKeys(false);
    }

    private boolean checkConsistency() {
        for (String key : getTeams()) {
            try {
                Material.valueOf(getConfig().getString(key));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}