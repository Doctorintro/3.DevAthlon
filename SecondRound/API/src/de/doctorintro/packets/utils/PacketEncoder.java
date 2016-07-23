package de.doctorintro.packets.utils;

import de.doctorintro.codec.CodecEnum;
import de.doctorintro.codec.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by Doctorintro on 05.05.2016.
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext chc, Packet packet, ByteBuf buf) throws Exception {
        int id = CodecEnum.getCodec(packet.getClass()).getId();
        if (id > -1) {
            buf.writeInt(id);
            packet.writeBytes(buf);
        }
        System.out.println("Ecoding " + id);
    }

}
