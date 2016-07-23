package de.doctorintro.packets;

import de.doctorintro.codec.Packet;
import io.netty.buffer.ByteBuf;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public class ClientRegisterResultPacket extends Packet {

    private boolean registerd;

    public ClientRegisterResultPacket(boolean registerd) {
        this.registerd = registerd;
    }

    @Override
    public void writeBytes(ByteBuf buf) {
        buf.writeBoolean(registerd);
    }

    @Override
    public void readBytes(ByteBuf buf) {
        registerd = buf.readBoolean();
    }

    public boolean isRegisterd() {
        return registerd;
    }
}
