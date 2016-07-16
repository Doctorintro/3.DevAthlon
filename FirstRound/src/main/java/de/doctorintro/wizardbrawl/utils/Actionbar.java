package de.doctorintro.wizardbrawl.utils;

import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class Actionbar {

    public static void sendMessage(String message, Player p){
        try {
            Class<?> iChatBaseComp = Reflection.getNMS("IChatBaseComponent");
            Class<?> chatSerialiser = iChatBaseComp.getClasses()[0];
            Object packet = Reflection.getNMS("PacketPlayOutChat").getConstructor(iChatBaseComp, byte.class)
                    .newInstance(chatSerialiser.getMethod("a", String.class).invoke(chatSerialiser, "{\"text\": \"" + message + "\"}" ), (byte)2);
            Reflection.sendPacket(p, packet);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
