package com.intendia.mapboxgl.map;

import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class LngLat {

    public static native LngLat convert(double[] lngLat);

    public static native LngLat convert(double lng, double lat);

    public double lng;
    public double lat;

    public LngLat(double lng, double Lat) {}

    /** Returns a new LngLat object whose longitude is wrapped to the range (-180, 180). */
    public native LngLat wrap();

    public native double[] toArray();

    /** Returns a LngLatBounds from the coordinates extended by a given radius. */
    public native LngLatBounds toBounds(double radius);
}
