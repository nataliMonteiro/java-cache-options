package org.example.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelConfig {


    @Bean
    @Qualifier("clientInstance")
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        config.setInstanceName("hazelcast-instance");

        // Configure network settings, etc.
        NetworkConfig network = config.getNetworkConfig();
        network.setPort(5701);
        network.setPortAutoIncrement(true);

        // Add additional configuration as needed
        return Hazelcast.newHazelcastInstance(config);
    }

}
