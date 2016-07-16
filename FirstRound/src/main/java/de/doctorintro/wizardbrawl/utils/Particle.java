package de.doctorintro.wizardbrawl.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Doctorintro on 17.07.2016.
 */
public class Particle {

    public static void sendParticle(Player p, Location location, String particle, int count){
        try {
            Class enumParticleClass = Reflection.getNMS("EnumParticle");

            Object packet = Reflection.getNMS("PacketPlayOutWorldParticles").getConstructor(
                    enumParticleClass, Boolean.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Integer.TYPE, int[].class)
                    .newInstance(getEnumValue(enumParticleClass, particle), true, (float)location.getX(), (float)location.getY(), (float)location.getZ(), (float)0.2, (float)0.2, (float)0.2, (float)0, count, new int[]{});

            Reflection.sendPacket(p, packet);

        } catch (ClassNotFoundException | NoSuchFieldException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static Object getEnumValue(Class clazz, String name){
        for (Object o : clazz.getEnumConstants()) {
            if(o.toString().equals(name)) return o;
        }
        return clazz.getEnumConstants()[0];
    }

}
