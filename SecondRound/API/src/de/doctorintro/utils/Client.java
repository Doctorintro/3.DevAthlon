package de.doctorintro.utils;

import de.doctorintro.codec.Packet;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public class Client {

    private String ip;
    private int port;

    private EventLoopGroup workerGroup;
    private PacketHandler handler;

    public Client(String ip, int port, PacketHandler handler) {
        this.ip = ip;
        this.port = port;
        this.handler = handler;
    }

    public void run() {

        try {

            workerGroup = new NioEventLoopGroup();

            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer() {
                @Override
                protected void initChannel(Channel c) throws Exception {
                    c.pipeline()
                            .addLast("PacketEncoder", new PacketEncoder())
                            .addLast("PacketDecoder", new PacketDecoder())
                            .addLast("Handler", handler);
                    System.out.println("[init] new Channel");
                }
            });
            b.connect(getIp(), getPort()).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void send(Packet packet) {
        System.out.println("Start Sending");
        handler.send(packet);
        System.out.println("End Sending");
    }

    public synchronized void cancel() {
        workerGroup.shutdownGracefully();
    }

    public PacketHandler getHandler() {
        return handler;
    }

    public int getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }
}