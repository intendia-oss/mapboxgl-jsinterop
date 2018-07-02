package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

import elemental2.dom.HTMLElement;
import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class Map implements Evented {

    public static @JsProperty(namespace = "mapboxgl") String accessToken;

    public static @JsProperty(namespace = "mapboxgl") String version;

    public static @JsMethod(namespace = "mapboxgl") native boolean supported();

    public Map(MapOptions options) {}

    public native Map on(String type, Listener fn);

    public native Map off(String type, Listener fn);

    public native Map once(String type, Listener fn);

    public native Map on(String type, String layer, Listener fn);

    public native Map off(String type, String layer, Listener fn);

    /** Adds a source to the map's style. */
    public native Map addSource(String id, Object source);

    /** Removes a source from the map's style. */
    public native Map removeSource(String id);

    /** Returns the source with the specified ID in the map's style. */
    public native @Nullable Object getSource(String id);

    /** Adds a Mapbox style layer to the map's style. */
    public native Map addLayer(Object layer);
    /** Adds a Mapbox style layer to the map's style. */
    public native Map addLayer(Object layer, @Nullable String before);

    /** Moves a layer to a different z-position. */
    public native Map moveLayer(String id);
    /** Moves a layer to a different z-position. */
    public native Map moveLayer(String id, String beforeId);

    /** Removes the layer with the given id from the map's style. */
    public native Map removeLayer(String id);

    /** Returns the layer with the specified ID in the map's style. */
    public native Object getLayer(String id);

    public native void addControl(IControl control);

    /**
     * Adds a {@code IControl} to the map, calling {@code control.onAdd(this)}.
     *
     * @param control The IControl to add.
     * @param position position on the map to which the control will be added. Valid values are 'top-left', 'top-right',
     * 'bottom-left', and 'bottom-right'. Defaults to 'top-right'.
     */
    public native void addControl(IControl control, String position);

    public native void removeControl(IControl control);

    /** Returns the map's Mapbox style object, which can be used to recreate the map's style. */
    public native Object getStyle();

    public native Map setStyle(String styleUrl);
    public native Map setStyle(Object styleSpec);
    /**
     * Updates the map's Mapbox style object with a new value. If the given value is style JSON object, compares it
     * against the the map's current state and perform only the changes necessary to make the map style match the
     * desired state.
     */
    public native Map setStyle(Object style, @Nullable StyleOptions options);

    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class StyleOptions {
        /**
         * (default true) If false, force a 'full' update, removing the current style and adding building the given one
         * instead of attempting a diff-based update.
         */
        public boolean diff;

        /**
         * (default null) If non-null, defines a css font-family for locally overriding generation of glyphs in the 'CJK
         * Unified Ideographs' and 'Hangul Syllables' ranges. Forces a full update.
         */
        public String localIdeographFontFamily;
    }

    /** Returns a Boolean indicating whether the map's style is fully loaded. */
    public native boolean isStyleLoaded();

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

    /**
     * Returns the map's current bearing. The bearing is the compass direction that is "up"; for example, a bearing of
     * 90° orients the map so that east is up.
     */
    public native double getBearing();
    public native double setBearing(double bearing);

    /** Returns the map's current pitch (tilt). */
    public native double getPitch();
    public native Map setPitch(double pitch);

    /** Returns a Boolean indicating whether the map is fully loaded. */
    public native boolean loaded();

    /** Clean up and release all internal resources associated with this map. */
    public native void remove();

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
        /** The amount of padding in pixels to add to the given bounds. */
        public double padding;

        /**
         * If true, the map transitions using Map#easeTo. If false, the map transitions using Map#flyTo. See those
         * functions and AnimationOptions for information about options available.
         */
        public boolean linear;

        /** The maximum zoom level to allow when the map view transitions to the specified bounds. */
        public double maxZoom;
    }
}
