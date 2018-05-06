package cn.msb.chap01;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * Created by goujy on 5/7/18.
 */
public class TestCli {
    public static void main(String[] args) {
        try {
            TransportClient client = null;
            try {
                client = new PreBuiltTransportClient(Settings.EMPTY)
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), Integer.parseInt("9300")));

            } catch (Exception e) {
                System.out.println("====");
            }
            System.out.println(client);
        } catch (Exception e) {

        }
    }
}
