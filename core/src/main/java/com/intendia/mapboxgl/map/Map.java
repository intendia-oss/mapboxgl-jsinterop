package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

import elemental2.dom.HTMLElement;
import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class Map implements Evented {

    public Map(MapOptions options) {}

    public native Map on(String type, Listener fn);

    public native Map off(String type, Listener fn);

    public native Map once(String type, Listener fn);

    public native Map on(String type, String layer, Listener fn);

    public native Map off(String type, String layer, Listener fn);

    public native void addControl(Object control);

    /**
     * Adds a {@code IControl} to the map, calling {@code control.onAdd(this)}.
     *
     * @param control The IControl to add.
     * @param position position on the map to which the control will be added. Valid values are 'top-left', 'top-right',
     * 'bottom-left', and 'bottom-right'. Defaults to 'top-right'.
     */
    public native void addControl(Object control, String position);

    public native void removeControl(Object control);

    public native Map resize();

    public native LngLatBounds getBounds();

    public native int getZoom();

    public native Map setZoom(int zoom);

    public native Map panTo(double[] lngLat, @Nullable Object options, @Nullable Object eventData);

    public native Map panTo(LngLat lngLat, @Nullable Object options, @Nullable Object eventData);

    public native Map fitBounds(double[] westSouthEastNorth, @Nullable FitBoundsOptions options, @Nullable Object eventData);

    public native Map fitBounds(LngLatBounds westSouthEastNorth, @Nullable FitBoundsOptions options, @Nullable Object eventData);

    public native Map jumpTo(CameraOptions options, @Nullable Object eventData);

    public native Map easeTo(CameraOptions options, @Nullable Object eventData);

    public native Map flyTo(CameraOptions options, @Nullable Object eventData);

    public native Map setPitch(double pitch);

    public native HTMLElement getContainer();

    public native Map stop();

    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class MapOptions {
        public Object container;
        public String style;
        public boolean trackResize;
        public double[] center;
        public int zoom;
        public boolean attributionControl;
    }

    /**
     * Options common to Map#jumpTo, Map#easeTo, and Map#flyTo, controlling the desired location, zoom, bearing, and
     * pitch of the camera. All properties are optional, and when a property is omitted, the current camera value
     * for that property will remain unchanged.
     */
    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class CameraOptions {
        /** (LngLatLike): The desired center. */
        public double[] center;
        /** (number): The desired zoom level. */
        public double zoom;
        /** (number): The desired bearing, in degrees. The bearing is the compass direction that is "up"; for example, a bearing of 90° orients the map so that east is up. */
        public double bearing;
        /** (number): The desired pitch, in degrees. */
        public double pitch;
        /** (LngLatLike): If  zoom is specified,  around determines the point around which the zoom is centered. */
        public double[] around;
    }

    @FunctionalInterface @JsFunction
    public interface Listener {
        void apply(Event e);
    }

    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class FitBoundsOptions {
        public double padding;
    }
}
