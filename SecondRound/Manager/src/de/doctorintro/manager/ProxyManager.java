package de.doctorintro.manager;

import io.netty.channel.Channel;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public class ProxyManager {

    public static boolean newProxy(Channel channel) {
        boolean valid = ManagerMain.getProxy() == null;
        if (valid) ManagerMain.setProxy(channel);
        return valid;
    }

}
