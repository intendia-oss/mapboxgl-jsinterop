package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

import elemental2.dom.MouseEvent;
import jsinterop.annotations.JsType;

/** MapMouseEvent is the event type for mouse-related map events. */
@JsType(namespace = GLOBAL, name = "Object", isNative = true)
public class MapMouseEvent {

    /** type(string): The event type. */
    public String type;

    /** The Map object that fired the event. */
    public Map target;

    /** The DOM event which caused the map event. */
    public MouseEvent originalEvent;

    /** The pixel coordinates of the mouse cursor, relative to the map and measured from the top left corner. */
    public Point point;

    /** The geographic location on the map of the mouse cursor. */
    public LngLat lngLat;

    /**
     * Prevents subsequent default processing of the event by the map.
     *
     * Calling this method will prevent the following default map behaviors:
     * <ul>
     * <li>On mousedown events, the behavior of DragPanHandler</li>
     * <li>On mousedown events, the behavior of DragRotateHandler</li>
     * <li>On mousedown events, the behavior of BoxZoomHandler</li>
     * <li>On dblclick events, the behavior of DoubleClickZoomHandler</li>
     * </ul>
     */
    public native void preventDefault();

    /** {@code true} if preventDefault has been called. */
    public boolean defaultPrevented;
}
