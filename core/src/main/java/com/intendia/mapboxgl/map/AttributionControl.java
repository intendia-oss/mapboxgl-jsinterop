package com.intendia.mapboxgl.map;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class AttributionControl implements IControl {

    @Override public native String getDefaultPosition();

    @Override public native HTMLElement onAdd(Map map);

    @Override public native void onRemove(Map map);
}
