package de.doctorintro.proxy;

import de.doctorintro.packets.ClientRegisterPacket;
import de.doctorintro.utils.Client;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Created by Doctorintro on 23.07.2016.
 */
public class ProxyMain extends Plugin {

    private Client client;

    @Override
    public void onEnable() {
        client = new Client("localhost", 12546, new ProxyPacketHandler());
        client.run();
        client.send(new ClientRegisterPacket(ClientRegisterPacket.Type.PROXY));
    }
}
