package com.intendia.mapboxgl.tools;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import elemental2.core.Global;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;

public final class ToolsGlobal {
    private ToolsGlobal() {}

    /** Given any valid GeoJSON, return bounds in the form [WSEN]. Invalid objects returns null. */
    @JsMethod(namespace = JsPackage.GLOBAL, name = "geojsonExtent")
    public static native double[] extent(/*GeoJSON*/Object value);

    public static void ensureInjected() {
        Resources resources = GWT.create(Resources.class);
        Global.eval(resources.geojsonExtent().getText());
        Global.eval(resources.mapboxGlLanguage().getText());
    }

    interface Resources extends ClientBundle {
        @Source("geojson-extent.js") TextResource geojsonExtent();
        @Source("mapbox-gl-language.js") TextResource mapboxGlLanguage();
    }
}
