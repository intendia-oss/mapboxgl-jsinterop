package com.intendia.mapboxgl.map;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsType;

/** A ScaleControl control displays the ratio of a distance on the map to the corresponding distance on the ground. */
@JsType(isNative = true)
public class ScaleControl implements IControl {

    @Override public native String getDefaultPosition();

    @Override public native HTMLElement onAdd(Map map);

    @Override public native void onRemove(Map map);
}
