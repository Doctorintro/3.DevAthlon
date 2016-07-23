package de.doctorintro.proxy;

import de.doctorintro.codec.Packet;
import de.doctorintro.utils.PacketHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public class ProxyPacketHandler extends PacketHandler {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet msg) throws Exception {

    }
}
