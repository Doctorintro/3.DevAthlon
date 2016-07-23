package de.doctorintro.codec;

import de.doctorintro.packets.ClientRegisterPacket;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public enum CodecEnum {

    CLIENT_REGISTER(0, ClientRegisterPacket.class);
    private int id;
    private Class<? extends Packet> clazz;

    CodecEnum(int id, Class<? extends Packet> clazz) {
        this.id = id;
        this.clazz = clazz;
    }

    public int getId() {
        return id;
    }

    public Class<? extends Packet> getClazz() {
        return clazz;
    }

    public static CodecEnum getCodec(Class<? extends Packet> clazz) {
        for (CodecEnum codecEnum : values())
            if (codecEnum.getClazz().equals(clazz)) return codecEnum;
        return null;
    }

    public static CodecEnum getCodec(int id) {
        return values()[id];
    }
}
