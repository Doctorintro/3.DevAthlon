package de.doctorintro.proxy;

import de.doctorintro.codec.Packet;
import de.doctorintro.packets.ClientRegisterResultPacket;
import de.doctorintro.utils.PacketHandler;
import io.netty.channel.ChannelHandlerContext;
import net.md_5.bungee.BungeeCord;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public class ProxyPacketHandler extends PacketHandler {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet msg) throws Exception {
        if (msg instanceof ClientRegisterResultPacket) {
            ClientRegisterResultPacket packet = (ClientRegisterResultPacket) msg;
            if (!packet.isRegisterd()) BungeeCord.getInstance().stop("Es ist bereits ein andere Proxy regiistriert.");
        }
    }
}
