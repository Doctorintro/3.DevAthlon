package de.doctorintro.packets;

import de.doctorintro.codec.Packet;
import io.netty.buffer.ByteBuf;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public class ClientRegisterPacket extends Packet {

    private Type type;

    public ClientRegisterPacket(Type type) {
        this.type = type;
    }

    @Override
    public void readBytes(ByteBuf buf) {
        this.type = Type.getType(buf.readInt());
    }

    @Override
    public void writeBytes(ByteBuf buf) {
        buf.writeInt(Type.getID(type));
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        PROXY,
        SERVER;

        public static Type getType(int id) {
            return values()[id];
        }

        public static int getID(Type type) {
            if (type.equals(PROXY)) return 0;
            if (type.equals(SERVER)) return 1;
            return -1;
        }
    }

}
