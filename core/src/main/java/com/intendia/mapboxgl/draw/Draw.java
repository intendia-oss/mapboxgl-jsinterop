package com.intendia.mapboxgl.draw;

import static jsinterop.annotations.JsPackage.GLOBAL;

import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, name = "MapboxDraw", isNative = true)
public class Draw {

    /**
     * (Draw.modes.SIMPLE_SELECT === 'simple_select') Lets you select, delete, and drag features.
     *
     * In this mode, features can have their selected state changed by the user.
     *
     * Draw is in simple_select mode by default, and will automatically transition into simple_select mode again every
     * time the user finishes drawing a feature or exits direct_select mode.
     */
    public static final @JsOverlay String SIMPLE_SELECT = "simple_select";

    /**
     * (Draw.modes.DIRECT_SELECT === 'direct_select') Lets you select, delete, and drag vertices; and drag features.
     *
     * direct_select mode does not apply to point features, because they have no vertices.
     *
     * Draw enters direct_select mode when the user clicks a vertex of an selected line or polygon. So direct_select
     * mode typically follows simple_select mode.
     */
    public static final @JsOverlay String DIRECT_SELECT = "direct_select";

    /** (Draw.modes.DRAW_LINE_STRING === 'draw_line_string') Lets you draw a LineString feature. */
    public static final @JsOverlay String DRAW_LINE_STRING = "draw_line_string";

    /** (Draw.modes.DRAW_POLYGON === 'draw_polygon') Lets you draw a Polygon feature. */
    public static final @JsOverlay String DRAW_POLYGON = "draw_polygon";

    /** (Draw.modes.DRAW_POINT === 'draw_point') Lets you draw a Point feature. */
    public static final @JsOverlay String DRAW_POINT = "draw_point";

    public Draw(DrawOptions options) {}

    /**
     * add(geojson: Object) => Array<string>
     * This method takes either a GeoJSON Feature, FeatureCollection, or Geometry and adds it to Draw. It returns an
     * array of ids for interacting with the added features. If a feature does not have its own id, one is automatically
     * generated.
     *
     * The supported GeoJSON feature types are supported: Point, LineString, Polygon, MultiPoint, MultiLineString, and
     * MultiPolygon.
     *
     * If you add() a feature with an id that is already in use, the existing feature will be updated and no new feature
     * will be added.
     */
    public native String[] add(Object geojson);

    /**
     * get(featureId: string): ?Feature
     * Returns the GeoJSON feature in Draw with the specified id, or undefined if the id matches no feature.
     */
    public native @Nullable /*Feature*/Object get(String featureId);

    /**
     * getFeatureIdsAt(point: { x: number, y: number }): Array<string>
     * Returns an array of feature ids for features currently rendered at the specified point.
     *
     * Notice that the point argument requires x, y coordinates from pixel space, rather than longitude, latitude
     * coordinates.
     *
     * With this function, you can use the coordinates provided by mouse events to get information out of Draw.
     */
    public native String[] getFeatureIdsAt(/*[x,y]*/double[] point);

    /**
     * getSelectedIds(): Array<string>
     * Returns an array of feature ids for features currently selected.
     **/
    public native String[] getSelectedIds();

    /**
     * getSelected(): FeatureCollection
     * Returns a FeatureCollection of all the features currently selected.
     **/
    public native /*FeatureCollection*/Object getSelected();

    /**
     * getSelectedPoints(): FeatureCollection
     * Returns a FeatureCollection of Points representing all the vertices currently selected.
     */
    public native /*FeatureCollection*/ Object getSelectedPoints();

    /**
     * getAll(): FeatureCollection
     * Returns a FeatureCollection of all features.
     */
    public native /*FeatureCollection*/ Object getAll();

    /**
     * delete(ids: string | Array<string>): draw
     * Removes features with the specified ids. Returns the draw instance for chaining.
     *
     * In direct_select mode, deleting the active feature will exit that mode and revert to the simple_select mode.
     */
    public native Draw delete(String... ids);

    /**
     * deleteAll(): draw
     * Removes all features. Returns the draw instance for chaining.
     */
    public native Draw deleteAll();

    /**
     * set(featureCollection: FeatureCollection): Array<string>
     * Sets Draw's features to those in the specified FeatureCollection.
     *
     * Performs whatever delete, create, and update actions are necessary to make Draw's features match the specified
     * FeatureCollection. Effectively, this is the same as Draw.deleteAll() followed by Draw.add(featureCollection)
     * except that it does not affect performance as much.
     */
    public native String[] set(/*FeatureCollection*/Object featureCollection);

    /**
     * trash(): draw
     * Invokes the current mode's trash action. Returns the draw instance for chaining.
     */
    public native Draw trash();

    /**
     * combineFeatures(): draw
     * Invokes the current mode's combineFeatures action. Returns the draw instance for chaining.
     */
    public native Draw combineFeatures();

    /**
     * uncombineFeatures(): draw
     * Invokes the current mode's uncombineFeatures action. Returns the draw instance for chaining.
     */
    public native Draw uncombineFeatures();

    /**
     * getMode(): string
     * Returns Draw's current mode. For more about the modes, see above.
     */
    public native String getMode();

    /**
     * changeMode(mode: string, options?: Object): draw
     * Changes Draw to another mode. Returns the draw instance for chaining.
     */
    public native Draw changeMode(String mode);

    /**
     * changeMode(mode: string, options?: Object): draw
     * Changes Draw to another mode. Returns the draw instance for chaining.
     */
    public native Draw changeMode(String mode, Object options);

    /**
     * setFeatureProperty(featureId: string, property: string, value: any): draw
     * Sets the value of a property on the feature with the specified id. Returns the draw instance for chaining.
     * This is helpful if you are using Draw's features as your primary data store in your application.
     */
    public native Draw setFeatureProperty(String featureId, String property, Object any);

    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class DrawOptions {
        /** (default true) Whether or not to enable keyboard interactions for drawing. */
        public boolean keybindings;

        /** (default true) Whether or not to enable touch interactions for drawing. */
        public boolean touchEnabled;

        /**
         * (default true) Whether or not to enable box selection of features with shift+click+drag. If false,
         * shift+click+drag zooms into an area.
         */
        public boolean boxSelect;

        /** (default 2) Number of pixels around any feature or vertex (in every direction) that will respond to a click. */
        public double clickBuffer;

        /**
         * (default 25) Number of pixels around any feature of vertex (in every direction) that will respond to a
         * touch.
         */
        public double touchBuffer;

        /**
         * : Hide or show individual controls. Each property's name is a control, and value is a boolean indicating
         * whether the control is on or off. Available control names are point, line_string, polygon, trash,
         * combine_features and uncombine_features. By default, all controls are on. To change that default, use
         * displayControlsDefault.
         */
        public Controls controls;

        /**
         * (default true) The default value for controls. For example, if you would like all controls to be off by
         * default, and specify a whitelist with controls, use displayControlsDefault: false.
         */
        public boolean displayControlsDefault;

        /**
         * An array of map style objects. By default, Draw provides a map style for you. To learn about overriding
         * styles, see the Styling Draw section below.
         */
        public Object[] styles;

        /**
         * over ride the default modes with your own. MapboxDraw.modes can be used to see the default values. More
         * information on custom modes can be found here.
         */
        public Object modes;

        /** (default 'simple_select') the mode (from modes) that user will first land in. */
        public String defaultMode;
    }

    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class Controls {

        public boolean point, line_string, polygon, trash, combine_features, uncombine_features;

        public static @JsOverlay Controls create() {
            Controls out = new Controls();
            out.point = false;
            out.line_string = false;
            out.polygon = false;
            out.trash = false;
            out.combine_features = false;
            out.uncombine_features = false;
            return out;
        }
    }
}
