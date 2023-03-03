package whiless.onlycolor_move;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import whiless.onlycolor_move.config.TeamColorConfig;
import whiless.onlycolor_move.utility.CommandUtil;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;


public class Commands {
    public static JavaPlugin plugin = Onlycolor_move.getPlugin();
    public Commands(){
        CommandUtil.register("Only_color",new SetBlock());

    }

    private final static class SetBlock extends Command {
        private final List<String> teams = new ArrayList<>();
        public SetBlock() {
            super("set_block");
        }

        @Override
        public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {

            if (!(sender.isOp())) {
                sender.sendMessage("権限ありません。");
                return true;
            }
            //senderのメインハンドのアイテムをチームカラーとして登録する。
            Player player = (Player) sender;
            Material item = player.getItemInHand().getType();
            TeamColorConfig config = Onlycolor_move.getconfig();

            config.setTeamMaterial(args[0].toString(),item);
            player.sendMessage(args[0]+"のブロックを"+item+"に設定しました。");




            return true;
        }
        @Override
        public @Nonnull List<String> tabComplete(@Nonnull CommandSender sender, @Nonnull String alias, @Nonnull String[] args) throws IllegalArgumentException {
            final List<String> teams = new ArrayList<>();
            for (String team : Onlycolor_move.getconfig().getTeams()) {
                teams.add(team);
            }
            if (args.length <= 1) return teams;
            return super.tabComplete(sender, alias, args);
        }
    }
}
