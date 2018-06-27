package com.intendia.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.intendia.mapboxgl.map.Map;
import com.intendia.mapboxgl.map.MapGlobal;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.Elements;

public class SampleEntryPoint implements EntryPoint {

    @Override public void onModuleLoad() {
        Resources.inject();
        MapGlobal.ensureInjected();

        HTMLElement container = Elements.div().style("flex: 1;").get();

        Map.MapOptions options = new Map.MapOptions();
        options.container = (container);
        options.style = "https://tiles.intendia.com/styles/positron/style.json";
        options.center = new double[] { -3, 40 };/*Madrid*/
        options.zoom = 5;
        options.trackResize = true;
        options.attributionControl = false;
        Map map = new Map(options);

        Elements.body().add(container);
        Scheduler.get().scheduleDeferred(map::resize);
    }

    public static Resources.Style css() { return Resources.RESOURCES.style(); }
    public interface Resources extends ClientBundle {
        Resources RESOURCES = GWT.create(Resources.class);
        static void inject() { RESOURCES.style().ensureInjected(); }
        @Source("style.gss") Style style();
        interface Style extends CssResource {
        }
    }
}
