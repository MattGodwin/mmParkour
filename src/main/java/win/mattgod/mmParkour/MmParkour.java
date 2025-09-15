package win.mattgod.mmParkour;

import org.bukkit.plugin.java.JavaPlugin;
import win.mattgod.mmcore.pkSetStart;

public final class MmParkour extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        registerCommand("pkSetStart", new pkSetStart(this));
        registerCommand("pkSetCheckpoint", new pkSetCheckpoint(this));
        registerCommand("pkSetEnd", new pkSetEnd(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
