package de.doctorintro.codec;

import io.netty.buffer.ByteBuf;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public abstract class Packet {

    public Packet() {
    }

    public void readBytes(ByteBuf buf) {
    }

    public void writeBytes(ByteBuf buf) {
    }
}
