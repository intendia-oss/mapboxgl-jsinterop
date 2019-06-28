package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class Popup {
    public Popup() {}
    public Popup(PopupOptions options) {}
    public native Popup setLngLat(double[] lngLat);
    public native Popup addTo(Map map);
    public native Popup remove();

    /**
     * Sets the popup's content to a string of text.
     *
     * This function creates a Text node in the DOM, so it cannot insert raw HTML. Use this method for security against
     * XSS if the popup content is user-provided.
     */
    public native void setText(String text);

    @JsType(namespace = GLOBAL, name = "Object", isNative = true)
    public static class PopupOptions {
        public boolean closeButton;
        public boolean closeOnClick;
        public int offset;
        public String className;
        public final @JsOverlay PopupOptions closeButton(boolean closeButton) {
            this.closeButton = closeButton; return this;
        }
        public final @JsOverlay PopupOptions closeOnClick(boolean closeOnClick) {
            this.closeOnClick = closeOnClick; return this;
        }
        public final @JsOverlay PopupOptions offset(int offset) {
            this.offset = offset; return this;
        }
        public final @JsOverlay PopupOptions className(String className) {
            this.className = className; return this;
        }

    }
}
