package com.michaelcane;

public interface Connection {

    String getIP();

    String getPort();

    String getProtocol();

    String connect();

    void close();
}
