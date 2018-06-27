package com.intendia.mapboxgl.map;

import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class Event {
    public String type;
    public Object target;
}
