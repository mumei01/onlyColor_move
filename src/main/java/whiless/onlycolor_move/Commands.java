package whiless.onlycolor_move;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import whiless.onlycolor_move.utility.CommandUtil;

public class Commands {
    public static JavaPlugin plugin = Onlycolor_move.getPlugin();
    public Commands(){
        CommandUtil.register("Only_color",new SetBlock());

    }

    private final static class SetBlock extends Command {
        public SetBlock() {
            super("stop_game");
        }

        @Override
        public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {

            if (!(sender.isOp())) {
                sender.sendMessage("権限ありません。");
                return true;
            }
            //senderのメインハンドのアイテムをチームカラーとして登録する。


            return true;
        }
    }
}
