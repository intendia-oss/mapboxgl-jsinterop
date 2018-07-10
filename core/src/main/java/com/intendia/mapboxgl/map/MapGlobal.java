package com.intendia.mapboxgl.map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.TextResource;
import elemental2.core.Global;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

public interface MapGlobal {

    static void ensureInjected() {
        Resources resources = GWT.create(Resources.class);
        resources.style().ensureInjected();
        Global.eval(resources.script().getText());
    }

    static GeoJsonSourceBuilder sourceGeojson(String srcUrl) { return new GeoJsonSourceBuilder(srcUrl); }

    static GeoJsonSourceBuilder sourceGeojson(Object geojson) { return new GeoJsonSourceBuilder(geojson); }

    class DictionaryBuilder {
        final JsPropertyMap<Object> out = JsPropertyMap.of();

        public Object build() { return out; }
    }

    class GeoJsonSourceBuilder extends DictionaryBuilder {
        private GeoJsonSourceBuilder(Object data) { out.set("type", "geojson"); out.set("data", data); }

        public GeoJsonSourceBuilder cluster() { out.set("cluster", true); return this; }

        public GeoJsonSourceBuilder clusterMaxZoom(int maxZoom) { out.set("clusterMaxZoom", maxZoom); return this; }

        public GeoJsonSourceBuilder clusterRadius(int radius) { out.set("clusterRadius", radius); return this; }

        @Override public GeoJSONSource build() { return Js.uncheckedCast(out); }
    }

    interface Resources extends ClientBundle {
        @Source("mapbox-gl.js") TextResource script();
        @Source("mapbox-gl.gss") @NotStrict CssResource style();
    }

    /** Fired immediately after the map has been resized. */
    MapEventType<Event> resize = new MapEventType<>("resize");
    /** Fired immediately after the map has been removed with Map.event:remove. */
    MapEventType<Event> remove = new MapEventType<>("remove");

    /** Fired when a pointing device (usually a mouse) is pressed within the map. */
    MapEventType<MapMouseEvent> mousedown = new MapEventType<>("mousedown");
    /** Fired when a pointing device (usually a mouse) is released within the map. */
    MapEventType<MapMouseEvent> mouseup = new MapEventType<>("mouseup");
    /** Synonym for mouseenter. */
    MapEventType<MapMouseEvent> mouseover = new MapEventType<>("mouseover");
    /** Fired when a pointing device (usually a mouse) is moved within the map. */
    MapEventType<MapMouseEvent> mousemove = new MapEventType<>("mousemove");
    /** Fired when a pointing device (usually a mouse) is pressed and released at the same point on the map. */
    MapEventType<MapMouseEvent> click = new MapEventType<>("click");
    /** Fired when a pointing device (usually a mouse) is pressed and released at the same point on the map. */
    MapEventType<MapMouseEvent> dblclick = new MapEventType<>("dblclick");
    /**
     * Fired when a pointing device (usually a mouse) enters a visible portion of a specified layer from outside that
     * layer or outside the map canvas. This event can only be listened for via the three-argument version of Map#on,
     * where the second argument specifies the desired layer.
     */
    MapEventType<MapMouseEvent> mouseenter = new MapEventType<>("mouseenter");
    /**
     * Fired when a pointing device (usually a mouse) leaves a visible portion of a specified layer, or leaves the map
     * canvas. This event can only be listened for via the three-argument version of Map#on, where the second argument
     * specifies the desired layer.
     */
    MapEventType<MapMouseEvent> mouseleave = new MapEventType<>("mouseleave");
    /** Fired when a point device (usually a mouse) leaves the map's canvas. */
    MapEventType<MapMouseEvent> mouseout = new MapEventType<>("mouseout");
    /** Fired when the right button of the mouse is clicked or the context menu key is pressed within the map. */
    MapEventType<MapMouseEvent> contextmenu = new MapEventType<>("contextmenu");
    /** Fired when a wheel event occurs within the map. */
    MapEventType<MapMouseEvent> wheel = new MapEventType<>("wheel");

    /** Fired when a touchstart event occurs within the map. */
    MapEventType<MapTouchEvent> touchstart = new MapEventType<>("touchstart");
    /** Fired when a touchend event occurs within the map. */
    MapEventType<MapTouchEvent> touchend = new MapEventType<>("touchend");
    /** Fired when a touchmove event occurs within the map. */
    MapEventType<MapTouchEvent> touchmove = new MapEventType<>("touchmove");
    /** Fired when a touchcancel event occurs within the map. */
    MapEventType<MapTouchEvent> touchcancel = new MapEventType<>("touchcancel");

    MapEventType<Event> movestart = new MapEventType<>("movestart");
    MapEventType<Event> move = new MapEventType<>("move");
    MapEventType<Event> moveend = new MapEventType<>("moveend");

    MapEventType<Event> dragstart = new MapEventType<>("dragstart");
    MapEventType<Event> drag = new MapEventType<>("drag");
    MapEventType<Event> dragend = new MapEventType<>("dragend");

    MapEventType<Event> zoomstart = new MapEventType<>("zoomstart");
    MapEventType<Event> zoom = new MapEventType<>("zoom");
    MapEventType<Event> zoomend = new MapEventType<>("zoomend");

    MapEventType<Event> rotatestart = new MapEventType<>("rotatestart");
    MapEventType<Event> rotate = new MapEventType<>("rotate");
    MapEventType<Event> rotateend = new MapEventType<>("rotateend");

    MapEventType<Event> pitchstart = new MapEventType<>("pitchstart");
    MapEventType<Event> pitch = new MapEventType<>("pitch");
    MapEventType<Event> pitchend = new MapEventType<>("pitchend");

    MapEventType<Event> boxzoomstart = new MapEventType<>("boxzoomstart");
    MapEventType<Event> boxzoomend = new MapEventType<>("boxzoomend");
    MapEventType<Event> boxzoomcancel = new MapEventType<>("boxzoomcancel");

    MapEventType<Event> webglcontextlost = new MapEventType<>("webglcontextlost");
    MapEventType<Event> webglcontextrestored = new MapEventType<>("webglcontextrestored");

    /**
     * Fired immediately after all necessary resources have been downloaded and the first visually complete rendering of
     * the map has occurred.
     */
    MapEventType<Event> load = new MapEventType<>("load");

    /**
     * Fired whenever the map is drawn to the screen, as the result of
     * <ul>
     * <li>a change to the map's position, zoom, pitch, or bearing
     * <li>a change to the map's style
     * <li>a change to a GeoJSON source
     * <li>the loading of a vector tile, GeoJSON file, glyph, or sprite
     * </ul>
     */
    MapEventType<Event> render = new MapEventType<>("render");

    /**
     * Fired when an error occurs. This is GL JS's primary error reporting mechanism. We use an event instead of throw
     * to better accommodate asyncronous operations. If no listeners are bound to the error event, the error will be
     * printed to the console.
     */
    MapEventType<Event> error = new MapEventType<>("error");

    /**
     * Fired when any map data (style, source, tile, etc) begins loading or changing asyncronously. All dataloading
     * events are followed by a data or error event. See MapDataEvent for more information.
     */
    MapEventType<MapDataEvent> dataloading = new MapEventType<>("dataloading");
    /** Fired when any map data loads or changes. See MapDataEvent for more information. */
    MapEventType<MapDataEvent> data = new MapEventType<>("data");

    /**
     * Fired when the map's style begins loading or changing asyncronously. All styledataloading events are followed by
     * a styledata or error event. See MapDataEvent for more information.
     */
    MapEventType<MapDataEvent> styledataloading = new MapEventType<>("styledataloading");
    /** Fired when the map's style loads or changes. See MapDataEvent for more information. */
    MapEventType<MapDataEvent> styledata = new MapEventType<>("styledata");

    /**
     * Fired when one of the map's sources begins loading or changing asyncronously. All sourcedataloading events are
     * followed by a sourcedata or error event. See MapDataEvent for more information.
     */
    MapEventType<MapDataEvent> sourcedataloading = new MapEventType<>("sourcedataloading");
    /**
     * Fired when one of the map's sources loads or changes, including if a tile belonging to a source loads or changes.
     * See MapDataEvent for more information.
     */
    MapEventType<MapDataEvent> sourcedata = new MapEventType<>("sourcedata");
}
