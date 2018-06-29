package com.intendia.mapboxgl.map;

import com.google.web.bindery.event.shared.HandlerRegistration;
import jsinterop.annotations.JsFunction;
import jsinterop.base.Js;

public class MapEventType<T> {

    private final String name;

    public MapEventType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static <T> HandlerRegistration bind(Evented target, MapEventType<T> type, EventCallbackFn<T> listener) {
        return bind(target, type.name, e -> listener.onEvent(Js.cast(e)));
    }

    private static HandlerRegistration bind(Evented target, String type, Map.Listener fn) {
        target.on(type, fn);
        return () -> target.off(type, fn);
    }

    public static <T> HandlerRegistration bind(Map target, MapEventType<T> type, String layer, EventCallbackFn<T> fn) {
        return bind(target, type.name, layer, e -> fn.onEvent(Js.cast(e)));
    }

    private static HandlerRegistration bind(Map source, String type, String layer, Map.Listener fn) {
        source.on(type, layer, fn);
        return () -> source.off(type, layer, fn);
    }

    /** Event handler callback. */
    @JsFunction public interface EventCallbackFn<E> {
        void onEvent(E event);
    }
}
