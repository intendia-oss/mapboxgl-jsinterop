package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

import jsinterop.annotations.JsType;

@JsType(namespace = GLOBAL, name = "Object", isNative = true)
public class Event {
    public String type;
    public Object target;
}
