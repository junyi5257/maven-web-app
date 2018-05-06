package com.junyi.elasticsearch.conf;

//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 *
 * @author goujy
 * @date 5/6/18
 */
public class TestClient {
    public static void main(String[] args) {

        TransportClient client = null;
        try {
           /* Settings settings = Settings.builder()
                    .put("cluster.name", "elasticsearch").build();*/

            /*client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(
                            new InetSocketTransportAddress(
                                    InetAddress.getByName("localhost"), Integer.parseInt("9300")));
        */
            InetAddress address = InetAddress.getByName("localhost"); // ip
            InetSocketAddress socketAddress=new InetSocketAddress(address, 9300);  //socket address = ip + port

            TransportAddress transportAddress = new InetSocketTransportAddress(socketAddress);
            System.out.println(transportAddress+"===");
             client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(transportAddress);



        } catch (Exception e) {
            System.out.println("====");
        }
        System.out.println(client);
        client.close();
    /*
        RestHighLevelClient client2 = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200, "http")));

        System.out.println(client2);*/
    }
}
