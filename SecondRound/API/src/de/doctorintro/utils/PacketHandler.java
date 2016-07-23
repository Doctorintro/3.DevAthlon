package de.doctorintro.utils;

import de.doctorintro.codec.Packet;
import io.netty.channel.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public abstract class PacketHandler extends SimpleChannelInboundHandler<Packet> {

    private Channel channel;
    private BlockingQueue<Packet> waiting;

    public PacketHandler() {
        this.waiting = new LinkedBlockingQueue<Packet>();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Activate Channel");
        this.channel = ctx.channel();
        System.out.println(waiting.isEmpty());
        waiting.forEach(packet -> send(packet));
        waiting.clear();
        System.out.println("Finish with Activation");
    }

    public void send(Packet packet) {
        if (channel == null) {
            System.out.println("Handler Adding Sending " + packet.getClass().getSimpleName());
            waiting.add(packet);
        } else {
            System.out.println("Handler Start Sending " + packet.getClass().getSimpleName());
            ChannelFuture f = channel.writeAndFlush(packet);
            f.addListener((ChannelFutureListener) future -> {
                System.out.println(" Cancelld:" + f.isCancelled() + " Done: " + f.isDone() + " Sucess: " + f.isSuccess() + " Name: " + packet.getClass().getSimpleName());
                System.out.println("End Start Sending " + packet.getClass().getSimpleName());
            });
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Logger log = Logger.getGlobal();
        log.log(Level.SEVERE, null, cause);
    }

    public Channel getChannel() {
        return channel;
    }
}