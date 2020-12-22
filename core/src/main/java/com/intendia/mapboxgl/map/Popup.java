package com.intendia.mapboxgl.map;

import static jsinterop.annotations.JsPackage.GLOBAL;

import elemental2.dom.Node;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class Popup {

    public Popup() {}
    public Popup(PopupOptions options) {}

    public native Popup addTo(Map map);
    public native Popup remove();
    public native Popup trackPointer();
    public native boolean isOpen();

    public native LngLat getLngLat();
    public native Popup setLngLat(LngLat lngLat);
    public native Popup setLngLat(double[] lngLat);

    public native int getMaxWidth();
    public native Popup setMaxWidth(int maxWidth);

    public native void addClassName(String className);
    public native void removeClassName(String className);
    public native void toggleClassName(String className);

    /**
     * Sets the popup's content to a string of text.
     *
     * This function creates a Text node in the DOM, so it cannot insert raw HTML. Use this method for security against
     * XSS if the popup content is user-provided.
     */
    public native Popup setText(String text);

    /**
     * Sets the popup's content to the HTML provided as a string.
     *
     * This method does not perform HTML filtering or sanitization, and must be used only with trusted content. Consider
     * Popup#setText if the content is an untrusted text string.
     */
    public native Popup setHTML(String html);

    /** Sets the popup's content to the element provided as a DOM node. */
    public native Popup setDOMContent(Node html);

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
