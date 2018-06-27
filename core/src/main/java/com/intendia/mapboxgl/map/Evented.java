package com.intendia.mapboxgl.map;

import jsinterop.annotations.JsType;

@JsType(isNative = true)
public interface Evented {

    /** Adds a listener to a specified event type. */
    Map on(String type, Map.Listener fn);

    /** Removes a previously registered event listener. */
    Map off(String type, Map.Listener fn);

    /** Adds a listener that will be called only once to a specified event type. */
    Map once(String type, Map.Listener fn);
}
