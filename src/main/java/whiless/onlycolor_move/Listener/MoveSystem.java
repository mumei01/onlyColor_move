package whiless.onlycolor_move.Listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveSystem implements Listener {
    Location last_team_color_loc = null;

    @EventHandler
    public void playermove(PlayerMoveEvent event){
        Player player = event.getPlayer();

        //プレイヤーの地面を取得
        Location loc = player.getLocation();
        loc.setY(loc.getY()-1);




        if (loc.getBlock().getType().equals(Material.PURPLE_WOOL)){
            last_team_color_loc = loc;

        }else{

            if (loc.getBlock().getType().equals(Material.AIR))return;
            if (last_team_color_loc.equals(null))return;
            last_team_color_loc.setY(last_team_color_loc.getY()+1);
            player.teleport(last_team_color_loc);
        }


    }
}
