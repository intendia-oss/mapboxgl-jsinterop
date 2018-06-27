package com.intendia.mapboxgl.map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.TextResource;
import elemental2.core.Global;
import javax.annotation.Nullable;

public class MapGlobal {

    private static @Nullable Resources INSTANCE;

    public static void ensureInjected() {
        if (INSTANCE != null) throw new IllegalStateException("already injected");
        INSTANCE = GWT.create(Resources.class);
        INSTANCE.base().ensureInjected();
        Global.eval(INSTANCE.script().getText());
    }

    public interface Resources extends ClientBundle {
        @Source("mapbox-gl.js") TextResource script();
        @Source("mapbox-gl.gss") @NotStrict CssResource base();
    }
}
