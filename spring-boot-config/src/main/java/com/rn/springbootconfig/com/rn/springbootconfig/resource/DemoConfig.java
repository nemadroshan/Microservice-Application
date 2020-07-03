package com.rn.springbootconfig.com.rn.springbootconfig.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("db")
public class DemoConfig {

    private String connection;
    private String host;
    private int port;


    @Override
    public String toString() {
        return "DemoConfig{" +
                "connection='" + connection + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                '}';
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
