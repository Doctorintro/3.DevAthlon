package de.doctorintro.wizardbrawl.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Doctorintro on 17.07.2016.
 */
public class Reflection {

    private static String VERSION;
    private static final String NMS;

    static {
        NMS = "net.minecraft.server.";
        VERSION = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
    }

    public static void sendPacket(Player p, Object packet) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Object player = p.getClass().getMethod("getHandle").invoke(p);
        Object connection = player.getClass().getField("playerConnection").get(player);

        connection.getClass().getMethod("sendPacket", Reflection.getNMS("Packet")).invoke(connection, packet);
    }

    public static Class getNMS(String name) throws ClassNotFoundException {
        return Class.forName(NMS+VERSION+"."+name);
    }
}
