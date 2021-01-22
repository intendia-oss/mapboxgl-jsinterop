package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;

@JsType(isNative = true) public class Marker {
    public Marker() {}
    public Marker(HTMLElement element) {}
    public Marker(HTMLElement element, MarkerOptions options) {}
    public native Marker setLngLat(double[] lngLat);
    public native Marker addTo(Map map);
    public native Marker remove();
    public native Element getElement();

    /** Returns the Popup instance that is bound to the Marker.*/
    public native Popup getPopup();

    /** Binds a Popup to the Marker.*/
    public native Marker setPopup(Popup popup);

    /** Opens or closes the Popup instance that is bound to the Marker, depending on the current state of the Popup.*/
     public native Marker togglePopup();

    @JsType(namespace = GLOBAL, name = "Object", isNative = true) public static class MarkerOptions {
        public double[] offset;
        public final @JsOverlay MarkerOptions offset(int x, int y) {
            offset = new double[] { x, y }; return this;
        }
    }
}
