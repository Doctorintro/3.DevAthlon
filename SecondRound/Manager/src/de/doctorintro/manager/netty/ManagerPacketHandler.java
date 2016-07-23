package de.doctorintro.manager.netty;

import de.doctorintro.codec.Packet;
import de.doctorintro.manager.ProxyManager;
import de.doctorintro.packets.ClientRegisterPacket;
import de.doctorintro.packets.ClientRegisterResultPacket;
import de.doctorintro.utils.PacketHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public class ManagerPacketHandler extends PacketHandler {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet msg) throws Exception {
        if (msg instanceof ClientRegisterPacket) {
            ClientRegisterPacket packet = (ClientRegisterPacket) msg;
            if (packet.getType().equals(ClientRegisterPacket.Type.PROXY)) {
                send(new ClientRegisterResultPacket(ProxyManager.newProxy(getChannel())));
            }
        }
    }
}
