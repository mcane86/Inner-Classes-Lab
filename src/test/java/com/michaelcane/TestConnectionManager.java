package com.michaelcane;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestConnectionManager {

    @Test
    public void testGetIP() {
        ConnectionManager connectionManager = new ConnectionManager(10);
        Connection connected = connectionManager.makeManagedConnection("867.5309", "BOB", "HTTPS");
        String expectedValue = "867.5309";
        String actualValue = connected.getIP();
        assertEquals("Should get the IP for Tommy Tutone", expectedValue, actualValue);
    }

    @Test
    public void testGetProtocol() {
        ConnectionManager connectionManager = new ConnectionManager(10);
        Connection connected = connectionManager.makeManagedConnection("867.5309", "BOB", "HTTPS");
        String expectedValue = "HTTPS";
        String actualValue = connected.getProtocol();
        assertEquals("Should get the HTTPS protocol", expectedValue, actualValue);
    }

    @Test
    public void testGetPort() {
        ConnectionManager connectionManager = new ConnectionManager(10);
        Connection connected = connectionManager.makeManagedConnection("867.5309", "BOB", "HTTPS");
        String expectedValue = "BOB";
        String actualValue= connected.getPort();
        assertEquals("Should get the BOB port", expectedValue, actualValue);
    }

    @Test
    public void testMakeManagedConnectionToFail() {
        ConnectionManager connectionManager = new ConnectionManager(10);
        connectionManager.setCurrentConnections(10);
        assertNull("Should return null", connectionManager.makeManagedConnection("867.5309", "HTTPS"));
    }

    @Test
    public void testMakeManagedConnection() {
        ConnectionManager connectionManager = new ConnectionManager(10);
        assertNotNull("Should return not Null", connectionManager.makeManagedConnection("867.5309", "HTTPS"));
    }

    @Test
    public void testTooManyConnections() {
        ConnectionManager connectionManager = new ConnectionManager(10);
        Connection connected = connectionManager.makeManagedConnection("867.5309", "BOB", "HTTPS");
        connected.close();
        String expectedValue = "NOT GONNA HAPPEN";
        String actualValue = connected.getIP();
        assertEquals("Should not return Tommy Tutone's IP Address", expectedValue, actualValue);
    }

    @Test
    public void testConnect() {
        ConnectionManager connectionManager = new ConnectionManager(10);
        Connection connected = connectionManager.makeManagedConnection("867.5309", "BOB", "HTTPS");
        String expectedValue = "CONNECTION - CONNECTION IS STRONG";
        String actualValue = connected.connect();
        assertEquals("Should be CONNECTED", expectedValue, actualValue);
    }

}
