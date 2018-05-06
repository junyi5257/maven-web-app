package com.junyi.elasticsearch.conf;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.annotation.Resource;
import java.net.InetAddress;

/**
 * @author goujy
 * @date 5/6/18
 */
@Configuration
@PropertySource(value = "classpath:elasticsearch.properties")
@EnableElasticsearchRepositories(basePackages = "com.junyi.elasticsearch.repository")
public class EsConfig {
    @Resource
    private Environment environment;

    @Bean
    public Client client() {
        try {
            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
            TransportAddress address = new InetSocketTransportAddress(InetAddress.getByName(environment.getProperty("elasticsearch.host")), Integer.parseInt(environment.getProperty("elasticsearch.port")));
            client.addTransportAddress(address);
            return client;
        } catch (Exception e) {

        }
        return null;
    }


    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
}
