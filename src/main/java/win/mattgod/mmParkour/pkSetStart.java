package win.mattgod.mmcore;

import org.bukkit.Location;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import win.mattgod.mmParkour.MmParkour;
import win.mattgod.mmParkour.utils.LocationUtil;

@NullMarked
public class pkSetStart implements BasicCommand {

    private final MmParkour plugin;

    public pkSetStart(MmParkour plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSourceStack source, String[] args) {

        Player p = (Player) source.getExecutor();

        if (args.length == 0) {
            source.getSender().sendRichMessage("<red>Correct format: /pkSetStart course");
            return;
        }

        source.getExecutor().sendRichMessage("<green>Parkour start set: " + args[0]);
        LocationUtil.saveLocation(plugin, "courses." + args[0] + ".start", p.getLocation());


    }

    @Override
    public @Nullable String permission() {
        return "mmParkour.setStart.use";
    }
}