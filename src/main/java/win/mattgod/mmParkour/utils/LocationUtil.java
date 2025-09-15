package win.mattgod.mmParkour.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class LocationUtil {

    // A private constructor prevents anyone from creating an instance of this utility class.
    private LocationUtil() {}

    public static void saveLocation(JavaPlugin plugin, String path, Location loc) {
        FileConfiguration config = plugin.getConfig();
        // The path is the parent key, e.g., "spawn-location"
        config.set(path + ".world", loc.getWorld().getName());
        config.set(path + ".x", loc.getX());
        config.set(path + ".y", loc.getY());
        config.set(path + ".z", loc.getZ());
        config.set(path + ".yaw", loc.getYaw());
        config.set(path + ".pitch", loc.getPitch());
        plugin.saveConfig(); // Save the changes to the file
    }

    public static Location loadLocation(JavaPlugin plugin, String path) {
        FileConfiguration config = plugin.getConfig();

        if (!config.contains(path)) {
            return null; // Path doesn't exist
        }

        World world = Bukkit.getWorld(config.getString(path + ".world"));
        if (world == null) {
            plugin.getLogger().warning("Failed to load location '" + path + "': World not found!");
            return null; // World is not loaded or doesn't exist
        }

        double x = config.getDouble(path + ".x");
        double y = config.getDouble(path + ".y");
        double z = config.getDouble(path + ".z");
        float yaw = (float) config.getDouble(path + ".yaw");
        float pitch = (float) config.getDouble(path + ".pitch");

        return new Location(world, x, y, z, yaw, pitch);
    }
}