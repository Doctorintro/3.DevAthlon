package de.doctorintro.manager;


import de.doctorintro.manager.netty.Server;
import io.netty.channel.Channel;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public class ManagerMain {

    private static Server server;

    private static Channel proxy;

    public static void main(String[] args) {
        server = new Server("lcoalhost", 12546);
        server.run();
    }


    public static Channel getProxy() {
        return proxy;
    }

    public static void setProxy(Channel proxy) {
        ManagerMain.proxy = proxy;
    }

    public static Server getServer() {
        return server;
    }
}
