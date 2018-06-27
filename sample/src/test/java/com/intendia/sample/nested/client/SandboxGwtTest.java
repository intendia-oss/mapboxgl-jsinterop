package com.intendia.sample.nested.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.intendia.mapboxgl.sample.Sample";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}
