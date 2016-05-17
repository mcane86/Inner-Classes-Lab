package com.michaelcane;

import java.util.regex.Pattern;

public class ConnectionManager {

    int connectionsLimit = 10;
    int currentConnections =0;

    public void setCurrentConnections(int currentConnections) {
        this.currentConnections = currentConnections;
    }

    public ConnectionManager(int connectionsLimit) {
        this.connectionsLimit =connectionsLimit;
    }

    public ManagedConnection makeManagedConnection (String IP, String protocol) {
        Pattern whatIsProtocol = Pattern.compile("(?i)(Bluetooth|HTTP|HTTPS)");
        if(whatIsProtocol.matcher(protocol).matches() && currentConnections < connectionsLimit) {
            currentConnections ++;
            return new ManagedConnection(IP, "909", protocol);
        } else {
            return null;
        }
    }

    public ManagedConnection makeManagedConnection (String IP, String port, String protocol) {
        Pattern whatIsProtocol = Pattern.compile("(?i)(Bluetooth|HTTP|HTTPS)");
        if(whatIsProtocol.matcher(protocol).matches() && currentConnections < connectionsLimit) {
            currentConnections ++;
            return new ManagedConnection(IP, port, protocol);
        } else {
            return null;
        }
    }


    private class ManagedConnection implements Connection {

        String IP;
        String port;
        String protocol;


        public ManagedConnection(String IP, String port, String protocol) {
            this.IP = IP;
            this.port = port;
            this.protocol = protocol;
        }

        public String getIP() {
            return IP;
        }

        public String getPort() {
            return port;
        }

        public String getProtocol() {
            return protocol;
        }

        public String connect() {
            return "CONNECTION - CONNECTION IS STRONG";
        }

        public void close(){
            currentConnections--;
            this.port = "CLOSED";
            this.protocol = "NOPE";
            this.IP = "NOT GONNA HAPPEN";
        }
    }

}
