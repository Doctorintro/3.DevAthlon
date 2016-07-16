package de.doctorintro.wizardbrawl.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class Actionbar {

    private static String VERSION;
    private static final String NMS;

    static {
        NMS = "net.minecraft.server.";
        VERSION = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
    }

    public static void sendMessage(String message, Player p){
        try {
            Class<?> iChatBaseComp = getNMS("IChatBaseComponent");
            Class<?> chatSerialiser = iChatBaseComp.getClasses()[0];
            Object packet = getNMS("PacketPlayOutChat").getConstructor(iChatBaseComp, byte.class)
                    .newInstance(chatSerialiser.getMethod("a", String.class).invoke(chatSerialiser, "{\"text\": \"" + message + "\"}" ), (byte)2);

            Object player = p.getClass().getMethod("getHandle").invoke(p);
            Object connection = player.getClass().getField("playerConnection").get(player);

            connection.getClass().getMethod("sendPacket", getNMS("Packet")).invoke(connection, packet);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Class getNMS(String name) throws ClassNotFoundException {
        return Class.forName(NMS+VERSION+"."+name);
    }

}
