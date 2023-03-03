package whiless.onlycolor_move.Listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import whiless.onlycolor_move.Onlycolor_move;
import whiless.onlycolor_move.config.TeamColorConfig;
import whiless.onlycolor_move.team.Team;

public class MoveSystem implements Listener {
    Location last_team_color_loc = null;
    TeamColorConfig config = Onlycolor_move.getconfig();

    @EventHandler
    public void playermove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        String player_team = null;

        //プレイヤーのチーム確認
        for (String team : config.getTeams()){
            if (new Team(team).hasPlayer(player)){
                player_team = team;
            }

        }

        //チームに所属してない
        if (player_team.equals(null)){return;}
        //チームブロックが Air
        if (config.getTeamMaterial(player_team).equals(Material.AIR)){return;}


        //プレイヤーの地面を取得
        Location loc = player.getLocation();
        loc.setY(loc.getY()-1);


        if (loc.getBlock().getType().equals(config.getTeamMaterial(player_team))){
            last_team_color_loc = loc;

        }else{

            if (loc.getBlock().getType().equals(Material.AIR))return;
            if (last_team_color_loc.equals(null))return;
            last_team_color_loc.setY(last_team_color_loc.getY()+1);
            player.teleport(last_team_color_loc);
        }


    }
}
