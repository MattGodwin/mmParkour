package win.mattgod.mmParkour;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import win.mattgod.mmParkour.utils.LocationUtil;

@NullMarked
public class pkSetEnd implements BasicCommand {

    private final MmParkour plugin;

    public pkSetEnd(MmParkour plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSourceStack source, String[] args) {

        Player p = (Player) source.getExecutor();

        if (args.length == 0) {
            source.getSender().sendRichMessage("<red>Correct format: /pkSetEnd course");
            return;
        }

        source.getExecutor().sendRichMessage("<green>Parkour end set: "  + args[0]);
        LocationUtil.saveLocation(plugin, "courses." + args[0] + ".end", p.getLocation());


    }

    @Override
    public @Nullable String permission() {
        return "mmParkour.pkSetEnd.use";
    }
}