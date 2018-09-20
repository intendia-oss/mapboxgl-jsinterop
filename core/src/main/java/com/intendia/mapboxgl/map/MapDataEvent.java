package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

import javax.annotation.Nullable;
import jsinterop.annotations.JsType;

@JsType(namespace = GLOBAL, name = "Object", isNative = true)
public class MapDataEvent {

    /** type(string): The event type. */
    public String type;

    public Object target;

    /**
     * dataType(string): The type of data that has changed. One of  {@code source}, {@code style}.
     * <ul>
     * <li>'source': The non-tile data associated with any source
     * <li>'style': The style used by the map
     * </ul>
     */
    public String dataType;

    /**
     * isSourceLoaded(boolean?): True if the event has a  dataType of  source and the source has no outstanding network
     * requests.
     */
    public @Nullable Boolean isSourceLoaded;

    /** source(Object?): The style spec representation of the source if the event has a  dataType of source . */
    public @Nullable Object source;

    /** sourceId(String?): The source id if the event has a  dataType of source . */
    public @Nullable String sourceId;

    /**
     * sourceDataType(string?): Included if the event has a dataType of source and the event signals that internal
     * data has been received or changed. Possible values are {@code metadata} and {@code content}.
     */
    public @Nullable String sourceDataType;

    /**
     * tile(Object?): The tile being loaded or changed, if the event has a dataType of  source and the event is related
     * to loading of a tile.
     */
    public @Nullable Object tile;

    /**
     * coord(Coordinate?): The coordinate of the tile if the event has a dataType of  source and the event is related
     * to loading of a tile.
     */
    public @Nullable Object coord;
}
