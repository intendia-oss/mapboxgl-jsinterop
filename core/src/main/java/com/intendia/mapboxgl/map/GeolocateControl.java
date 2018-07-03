package com.intendia.mapboxgl.map;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsType;

/**
 * A GeolocateControl control provides a button that uses the browser's geolocation API to locate the user on the map.
 *
 * Not all browsers support geolocation, and some users may disable the feature. Geolocation support for modern browsers
 * including Chrome requires sites to be served over HTTPS. If geolocation support is not available, the
 * GeolocateControl will not be visible.
 *
 * The zoom level applied will depend on the accuracy of the geolocation provided by the device.
 *
 * The GeolocateControl has two modes. If trackUserLocation is false (default) the control acts as a button, which when
 * pressed will set the map's camera to target the user location. If the user moves, the map won't update. This is most
 * suited for the desktop. If trackUserLocation is true the control acts as a toggle button that when active the user's
 * location is actively monitored for changes. In this mode the GeolocateControl has three states:
 *
 * <li>active - the map's camera automatically updates as the user's location changes, keeping the location dot in the
 * center.
 * <li>passive - the user's location dot automatically updates, but the map's camera does not.
 * <li>disabled
 */
@JsType(isNative = true)
public class GeolocateControl implements IControl, Evented {

    @Override public native String getDefaultPosition();

    @Override public native HTMLElement onAdd(Map map);

    @Override public native void onRemove(Map map);

    @Override public native Map on(String type, Map.Listener fn);

    @Override public native Map off(String type, Map.Listener fn);

    @Override public native Map once(String type, Map.Listener fn);
}
