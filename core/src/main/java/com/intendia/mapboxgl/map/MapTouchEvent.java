package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

import elemental2.dom.TouchEvent;
import jsinterop.annotations.JsType;

/** MapTouchEvent is the event type for touch-related map events. */
@JsType(namespace = GLOBAL, name = "Object", isNative = true)
public class MapTouchEvent {

    /** type(string): The event type. */
    public String type;

    /** The Map object that fired the event. */
    public Map target;

    /** The DOM event which caused the map event. */
    public TouchEvent originalEvent;

    /**
     * The pixel coordinates of the center of the touch event points, relative to the map and measured from the top left
     * corner.
     */
    public Point point;

    /** The array of pixel coordinates corresponding to a touch event's touches property. */
    public Point[] points;

    /** The geographic location on the map of the center of the touch event points. */
    public LngLat lngLat;

    /** The geographical locations on the map corresponding to a touch event's touches property. */
    public LngLat[] lngLats;

    /**
     * Prevents subsequent default processing of the event by the map.
     *
     * Calling this method will prevent the following default map behaviors:
     * <ul>
     * <li>On touchstart events, the behavior of DragPanHandler</li>
     * <li>On touchstart events, the behavior of TouchZoomRotateHandler</li>
     * </ul>
     */
    public native void preventDefault();

    /** {@code true} if preventDefault has been called. */
    public boolean defaultPrevented;
}
