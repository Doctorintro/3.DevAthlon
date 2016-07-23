package de.doctorintro.manager.netty;

import de.doctorintro.packets.utils.PacketDecoder;
import de.doctorintro.packets.utils.PacketEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public class Server {

    private String ip;
    private int port;
    private EventLoopGroup parentGroup, childGroup;

    public Server(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void run() {

        parentGroup = new NioEventLoopGroup();
        childGroup = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(parentGroup, childGroup);
        b.channel(NioServerSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.childHandler(new ChannelInitializer() {
            @Override
            protected void initChannel(Channel c) throws Exception {
                c.pipeline()
                        .addLast("PacketEncoder", new PacketEncoder())
                        .addLast("PacketDecoder", new PacketDecoder())
                        .addLast("Handler", new ManagerPacketHandler());
                System.out.println("[init] new Channel");
            }
        });
        b.bind(getIp(), getPort());
    }

    public synchronized void cancel() {
        parentGroup.shutdownGracefully();
        childGroup.shutdownGracefully();
    }

    public int getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }

}