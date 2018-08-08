package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

import elemental2.core.Function;
import elemental2.dom.HTMLElement;
import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.JsPropertyMap;

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

    /** @see #queryRenderedFeatures(Object, QueryRenderedFeaturesOptions) */
    public native QueryRenderedFeaturesResult[] queryRenderedFeatures(@Nullable Object geometry);

    /**
     * Returns an array of GeoJSON Feature objects representing visible features that satisfy the query parameters.
     *
     * @param geometry (PointLike|Array<PointLike>) The geometry of the query region: either a single point or southwest
     * and northeast points describing a bounding box. Omitting this parameter (i.e. calling Map#queryRenderedFeatures
     * with zero arguments, or with only a options argument) is equivalent to passing a bounding box encompassing the
     * entire map viewport.
     * @see <a href="https://www.mapbox.com/mapbox-gl-js/api/#map#queryrenderedfeatures">API #queryRenderedFeatures</a>
     */
    public native QueryRenderedFeaturesResult[] queryRenderedFeatures(@Nullable Object geometry,
            @Nullable QueryRenderedFeaturesOptions options);

    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class QueryRenderedFeaturesOptions {
        /**
         * (Array<string>?) An array of style layer IDs for the query to inspect. Only features within these layers will
         * be returned. If this parameter is undefined, all layers will be checked.
         */
        public String[] layers;
        public final @JsOverlay QueryRenderedFeaturesOptions layers(String... layers) {
            this.layers = layers; return this;
        }

        /** (Array?) A filter to limit query results. */
        public Object[] filter;
        public final @JsOverlay QueryRenderedFeaturesOptions filter(Object... filter) {
            this.filter = filter; return this;
        }

        public static @JsOverlay QueryRenderedFeaturesOptions queryRenderedFeaturesOptions() {
            return new QueryRenderedFeaturesOptions();
        }
    }

    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class QueryRenderedFeaturesResult {
        public Object id;
        public String type;
        public JsPropertyMap<Object> properties;

        public Object layer;
        public String source;
        public String sourceLayer;

        public JsPropertyMap<Object> state;

        public Object geometry;
    }

    /**
     * Returns an array of GeoJSON Feature objects representing features within the specified vector tile or GeoJSON
     * source that satisfy the query parameters.
     *
     * @see <a href="https://www.mapbox.com/mapbox-gl-js/api/#map#querysourcefeatures">API #querySourceFeatures</a>
     */
    public native Object[] querySourceFeatures(String sourceId, @Nullable QuerySourceFeaturesOptions options);

    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class QuerySourceFeaturesOptions {
        /**
         * The name of the vector tile layer to query. For vector tile sources, this parameter is required. For GeoJSON
         * sources, it is ignored.
         */
        public @Nullable String sourceLayer;
        public final @JsOverlay QuerySourceFeaturesOptions sourceLayer(String sourceLayer) {
            this.sourceLayer = sourceLayer; return this;
        }

        /** (Array?) A filter to limit query results. */
        public Object[] filter;
        public final @JsOverlay QuerySourceFeaturesOptions filter(Object... filter) {
            this.filter = filter; return this;
        }

        public static @JsOverlay QuerySourceFeaturesOptions querySourceFeaturesOptions() {
            return new QuerySourceFeaturesOptions();
        }
    }

    /** Adds a source to the map's style. */
    public native Map addSource(String id, Object source);

    /** Returns a Boolean indicating whether the source is loaded. */
    public native boolean isSourceLoaded(String sourceId);

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

    /** Sets the value of a paint property in the specified style layer. */
    public native Map setPaintProperty(String layer, String name, @DoNotAutobox Object value);

    /** Returns the value of a paint property in the specified style layer. */
    public native Any getPaintProperty(String layer, String name);

    /** Sets the value of a layout property in the specified style layer. */
    public native Map setLayoutProperty(String layer, String name, @DoNotAutobox Object value);

    /** Returns the value of a layout property in the specified style layer. */
    public native Any getLayoutProperty(String layer, String name);

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

    /** Returns the map's current zoom level. */
    public native double getZoom();

    /** Sets the map's zoom level. Equivalent to {@code jumpTo({zoom: zoom})}. */
    public native Map setZoom(double zoom);

    /** Zooms the map to the specified zoom level, with an animated transition. */
    public native Map zoomTo(double zoom);

    /** Increases the map's zoom level by 1. */
    public native Map zoomIn();

    /** Increases the map's zoom level by 1. */
    public native Map zoomIn(Object options, Object eventData);

    /** Decreases the map's zoom level by 1. */
    public native Map zoomOut();

    /** Decreases the map's zoom level by 1. */
    public native Map zoomOut(Object options, Object eventData);

    /** Zooms the map to the specified zoom level, with an animated transition. */
    public native Map zoomTo(double zoom, Object options, Object eventData);

    /** Pans the map to the specified location, with an animated transition. */
    public native Map panTo(double[] lngLat);

    /** Pans the map to the specified location, with an animated transition. */
    public native Map panTo(LngLat lngLat);

    /** Pans the map to the specified location, with an animated transition. */
    public native Map panTo(double[] lngLat, @Nullable AnimationOptions options, @Nullable Object eventData);

    /** Pans the map to the specified location, with an animated transition. */
    public native Map panTo(LngLat lngLat, @Nullable AnimationOptions options, @Nullable Object eventData);

    /**
     * Pans and zooms the map to contain its visible area within the specified geographical bounds. This function will
     * also reset the map's bearing to 0 if bearing is nonzero.
     */
    public native Map fitBounds(double[] westSouthEastNorth, @Nullable FitBoundsOptions options,
            @Nullable Object eventData);

    /**
     * Pans and zooms the map to contain its visible area within the specified geographical bounds. This function will
     * also reset the map's bearing to 0 if bearing is nonzero.
     */
    public native Map fitBounds(LngLatBounds westSouthEastNorth, @Nullable FitBoundsOptions options,
            @Nullable Object eventData);

    /**
     * Changes any combination of center, zoom, bearing, and pitch, without an animated transition. The map will retain
     * its current values for any details not specified in options.
     */
    public native Map jumpTo(CameraOptions options);

    /**
     * Changes any combination of center, zoom, bearing, and pitch, without an animated transition. The map will retain
     * its current values for any details not specified in options.
     */
    public native Map jumpTo(CameraOptions options, @Nullable Object eventData);

    /**
     * Changes any combination of center, zoom, bearing, and pitch, with an animated transition between old and new
     * values. The map will retain its current values for any details not specified in options.
     */
    public native Map easeTo(CameraOptions options);

    /**
     * Changes any combination of center, zoom, bearing, and pitch, with an animated transition between old and new
     * values. The map will retain its current values for any details not specified in options.
     */
    public native Map easeTo(CameraOptions options, @Nullable Object eventData);

    /**
     * Changes any combination of center, zoom, bearing, and pitch, animating the transition along a curve that evokes
     * flight. The animation seamlessly incorporates zooming and panning to help the user maintain her bearings even
     * after traversing a great distance.
     */
    public native Map flyTo(CameraOptions options);

    /**
     * Changes any combination of center, zoom, bearing, and pitch, animating the transition along a curve that evokes
     * flight. The animation seamlessly incorporates zooming and panning to help the user maintain her bearings even
     * after traversing a great distance.
     */
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

    /**
     * If map is able to fit to provided bounds, returns  CameraOptions with at least  center,  zoom,  bearing, offset,
     * padding, and  maxZoom, as well as any other options provided in arguments. If map is unable to fit, method will
     * warn and return undefined.
     */
    public native @Nullable CameraOptions cameraForBounds(LngLatBounds bounds);

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

        /**
         * If false, no mouse, touch, or keyboard listeners will be attached to the map, so it will not respond to
         * interaction.
         */
        public boolean interactive;
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
        public final @JsOverlay CameraOptions center(double[] center) { this.center = center; return this; }

        /** (number): The desired zoom level. */
        public double zoom;
        public final @JsOverlay CameraOptions zoom(double zoom) { this.zoom = zoom; return this; }

        /**
         * (number): The desired bearing, in degrees. The bearing is the compass direction that is "up"; for example, a
         * bearing of 90° orients the map so that east is up.
         */
        public double bearing;
        public final @JsOverlay CameraOptions bearing(double bearing) { this.bearing = bearing; return this; }

        /** (number): The desired pitch, in degrees. */
        public double pitch;
        public final @JsOverlay CameraOptions pitch(double pitch) { this.pitch = pitch; return this; }

        /** (LngLatLike): If  zoom is specified,  around determines the point around which the zoom is centered. */
        public double[] around;
        public final @JsOverlay CameraOptions around(double[] around) { this.around = around; return this; }

        public static @JsOverlay CameraOptions cameraOptions() { return new CameraOptions(); }
    }

    @FunctionalInterface @JsFunction
    public interface Listener {
        void apply(Event e);
    }

    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class FitBoundsOptions {
        /** (number | PaddingOptions) The amount of padding in pixels to add to the given bounds. */
        public Object padding;
        public final @JsOverlay FitBoundsOptions padding(double padding) { this.padding = padding; return this; }
        public final @JsOverlay FitBoundsOptions padding(double top, double right, double bottom, double left) {
            PaddingOptions out = new PaddingOptions();
            out.top = top; out.right = right; out.bottom = bottom; out.left = left;
            padding = out;
            return this;
        }

        /**
         * If true, the map transitions using Map#easeTo. If false, the map transitions using Map#flyTo. See those
         * functions and AnimationOptions for information about options available.
         */
        public boolean linear;
        public final @JsOverlay FitBoundsOptions linear(boolean linear) { this.linear = linear; return this; }

        /** The maximum zoom level to allow when the map view transitions to the specified bounds. */
        public double maxZoom;
        public final @JsOverlay FitBoundsOptions maxZoom(double maxZoom) { this.maxZoom = maxZoom; return this; }

        public static @JsOverlay FitBoundsOptions fitBoundsOptions() { return new FitBoundsOptions(); }
    }

    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class PaddingOptions {
        public double top;
        public double bottom;
        public double left;
        public double right;
    }

    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class AnimationOptions {
        public double duration;
        public Function easing;
        public Object offset;
        public boolean animate;
    }
}
