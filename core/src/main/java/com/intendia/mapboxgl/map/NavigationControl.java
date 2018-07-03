package com.intendia.mapboxgl.map;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsType;

/** A NavigationControl control contains zoom buttons and a compass. */
@JsType(isNative = true)
public class NavigationControl implements IControl {

    @Override public native String getDefaultPosition();

    @Override public native HTMLElement onAdd(Map map);

    @Override public native void onRemove(Map map);
}
