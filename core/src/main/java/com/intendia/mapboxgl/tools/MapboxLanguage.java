package com.intendia.mapboxgl.tools;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, name = "MapboxLanguage", isNative = true)
public class MapboxLanguage {

    public MapboxLanguage() {
    }

    public MapboxLanguage(LanguageOptions options) {
    }

    @JsType(namespace = JsPackage.GLOBAL, name = "Object", isNative = true)
    public static class LanguageOptions {
        public String defaultLanguage;
    }
}
