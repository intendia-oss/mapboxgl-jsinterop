package com.intendia.mapboxgl.map;

import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class LngLatBounds {

    public LngLatBounds(double[] westSouth, double[] EastNorth) {}

    /** Extend the bounds to include a given LngLat or LngLatBounds. */
    public native LngLatBounds extend(double[] lngLat);
    /** Extend the bounds to include a given LngLat or LngLatBounds. */
    public native LngLatBounds extend(LngLat lntLat);
    /** Extend the bounds to include a given LngLat or LngLatBounds. */
    public native LngLatBounds extend(LngLatBounds bounds);

    /** Returns the geographical coordinate equidistant from the bounding box's corners. */
    public native LngLat getCenter();

    public native double getWest();
    public native double getSouth();
    public native double getEast();
    public native double getNorth();

    /**
     * Returns the bounding box represented as an array, consisting of the southwest and northeast coordinates of the
     * bounding represented as arrays of numbers.
     */
    public native double[][] toArray();

    /** Check if the bounding box is an empty/null-type box. */
    public native boolean isEmpty();

    /**
     * Converts an array to a LngLatBounds object:
     * <ul>
     * <li>an array of LngLatLike objects in [sw, ne] order</li>
     * <li>an array of numbers in [west, south, east, north] order</li>
     * </ul>
     * If a LngLatBounds object is passed in, the function returns it unchanged.
     */
    public native static LngLatBounds convert(/*LngLatBoundsLike*/Object input);
}
