package com.intendia.mapboxgl.map;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class LngLatBounds {
    public LngLatBounds(double[] westSouth, double[] EastNorth) {}
    public native double getWest();
    public native double getSouth();
    public native double getEast();
    public native double getNorth();
    public native LngLatBounds extend(double[] lngLat);
    public native LngLatBounds extend(LngLat lntLat);
    public native LngLatBounds extend(LngLatBounds bounds);
    public native double[] toArray();

    /**
     * Converts an array to a LngLatBounds object:
     * <ul>
     * <li>an array of LngLatLike objects in [sw, ne] order</li>
     * <li>an array of numbers in [west, south, east, north] order</li>
     * </ul>
     * If a LngLatBounds object is passed in, the function returns it unchanged.
     */
    public native static LngLatBounds convert(/*LngLatBoundsLike*/Object input);

    public final @JsOverlay boolean contains(LngLat ll) {
        return ll.lng <= getEast() && ll.lng >= getWest()
                && ll.lat <= getNorth() && ll.lat >= getSouth();
    }
}
