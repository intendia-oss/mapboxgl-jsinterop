package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

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
}
