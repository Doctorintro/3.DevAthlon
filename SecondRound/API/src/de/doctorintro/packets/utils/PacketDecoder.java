package de.doctorintro.packets.utils;

import de.doctorintro.codec.CodecEnum;
import de.doctorintro.codec.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by Doctorintro on 05.05.2016.
 */
public class PacketDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext chc, ByteBuf buf, List<Object> list) throws Exception {
        if (buf instanceof EmptyByteBuf) {
            return;
        }
        int packetID = buf.readInt();
        Class<? extends Packet> packetClass = CodecEnum.getCodec(packetID).getClazz();
        System.out.println("Decoding " + packetID + " - Class: " + packetClass.getSimpleName());
        if (packetClass != null) {
            Packet packet = packetClass.newInstance();
            packet.readBytes(buf);
            list.add(packet);
        }
    }
}
