package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsType;

/**
 * A source containing GeoJSON. (See the Style Specification for detailed documentation of options.)
 *
 * Extends Evented.
 *
 * Example
 * <pre>
 * map.addSource('some id', {
 *     type: 'geojson',
 *     data: 'https://d2ad6b4ur7yvpq.cloudfront.net/naturalearth-3.3.0/ne_10m_ports.geojson'
 * });
 * map.addSource('some id', {
 *    type: 'geojson',
 *    data: {
 *        "type": "FeatureCollection",
 *        "features": [{
 *            "type": "Feature",
 *            "properties": {},
 *            "geometry": {
 *                "type": "Point",
 *                "coordinates": [
 *                    -76.53063297271729,
 *                    39.18174077994108
 *                ]
 *            }
 *        }]
 *    }
 * });
 * map.getSource('some id').setData({
 *   "type": "FeatureCollection",
 *   "features": [{
 *       "type": "Feature",
 *       "properties": { "name": "Null Island" },
 *       "geometry": {
 *           "type": "Point",
 *           "coordinates": [ 0, 0 ]
 *       }
 *   }]
 * });
 * </pre>
 */
@JsType(namespace = GLOBAL, name = "Object", isNative = true)
public class GeoJSONSource implements Evented {

    /**
     * Sets the GeoJSON data and re-renders the map.
     *
     * @param data ((Object | string))A GeoJSON data object or a URL to one. The latter is preferable in the case of
     * large GeoJSON files.
     */
    public native GeoJSONSource setData(Object data);

    @Override public native Map on(String type, Map.Listener fn);

    @Override public native Map off(String type, Map.Listener fn);

    @Override public native Map once(String type, Map.Listener fn);

    /**
     * For clustered sources, fetches the zoom at which the given cluster expands.
     *
     * @param clusterId The value of the cluster's  cluster_id property.
     * @param callback A callback to be called when the zoom value is retrieved {@code (error, zoom) => { ... }}.
     */
    public native GeoJSONSource getClusterExpansionZoom(int clusterId, Callback<Double> callback);

    /**
     * For clustered sources, fetches the children of the given cluster on the next zoom level (as an array of GeoJSON
     * features).
     *
     * @param clusterId The value of the cluster's  cluster_id property.
     * @param callback A callback to be called when the features are retrieved {@code (error, features) => { ... }}.
     */
    public native GeoJSONSource getClusterChildren(int clusterId, Callback</*GeoJSONFeature*/Object[]> callback);

    /**
     * For clustered sources, fetches the original points that belong to the cluster (as an array of GeoJSON features).
     *
     * @param clusterId The value of the cluster's  cluster_id property.
     * @param limit The maximum number of features to return.
     * @param offset The number of features to skip (e.g. for pagination).
     * @param callback A callback to be called when the features are retrieved {@code (error, features) => { ... }}.
     */
    public native GeoJSONSource getClusterLeaves(int clusterId, int limit, int offset,
            Callback</*GeoJSONFeature*/Object[]> callback);

    @FunctionalInterface @JsFunction public interface Callback<T> {
        void onInvoke(Object error, T result);
    }
}
