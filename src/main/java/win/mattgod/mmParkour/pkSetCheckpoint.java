package win.mattgod.mmParkour;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import win.mattgod.mmParkour.utils.LocationUtil;

@NullMarked
public class pkSetCheckpoint implements BasicCommand {

    private final MmParkour plugin;

    public pkSetCheckpoint(MmParkour plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSourceStack source, String[] args) {

        Player p = (Player) source.getExecutor();

        if (args.length == 0) {
            source.getSender().sendRichMessage("<red>Correct format: /pksetstart course checkpoint");
            return;
        }

        source.getExecutor().sendRichMessage("<green>Parkour checkpoint set: " + args[1]);
        LocationUtil.saveLocation(plugin, "courses." + args[0] + ".checkpoints." + args[1], p.getLocation());


    }

    @Override
    public @Nullable String permission() {
        return "mmParkour.setCheckpoint.use";
    }
}