package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;

@JsType(namespace = "mapboxgl", isNative = true) public class Marker {
    public Marker() {}
    public Marker(HTMLElement element) {}
    public Marker(HTMLElement element, MarkerOptions options) {}
    public native Marker setLngLat(double[] lngLat);
    public native Marker addTo(Map map);
    public native Marker remove();
    public native Element getElement();

    @JsType(namespace = GLOBAL, name = "Object", isNative = true) public static class MarkerOptions {
        public double[] offset;
        public final @JsOverlay MarkerOptions offset(int x, int y) {
            offset = new double[] { x, y }; return this;
        }
    }
}
