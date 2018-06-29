package com.intendia.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.intendia.mapboxgl.draw.Draw;
import com.intendia.mapboxgl.draw.Draw.DrawOptions;
import com.intendia.mapboxgl.draw.DrawGlobal;
import com.intendia.mapboxgl.map.Map;
import com.intendia.mapboxgl.map.Map.MapOptions;
import com.intendia.mapboxgl.map.MapEventType;
import com.intendia.mapboxgl.map.MapGlobal;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.Elements;

public class SampleEntryPoint implements EntryPoint {

    @Override public void onModuleLoad() {
        Resources.inject();
        MapGlobal.ensureInjected();
        DrawGlobal.ensureInjected();

        Scheduler.get().scheduleDeferred(() -> {
            HTMLElement container = Elements.div().style("flex: 1;").get();
            Elements.body().add(container);

            MapOptions mapOptions = new MapOptions();
            mapOptions.container = container;
            mapOptions.style = "https://tiles.intendia.com/styles/positron/style.json";
            mapOptions.center = new double[] { -3, 40 };/*Madrid*/
            mapOptions.zoom = 5;
            mapOptions.trackResize = true;
            mapOptions.attributionControl = false;
            Map map = new Map(mapOptions);

            DrawOptions drawOptions = new DrawOptions();
            Draw.Controls drawControls = drawOptions.controls = Draw.Controls.create();
            drawControls.point = true; drawControls.polygon = true; drawControls.trash = true;
            Draw draw = new Draw(drawOptions);
            map.addControl(draw);

            MapEventType.bind(map, MapGlobal.load, ev -> DomGlobal.console.log("load", ev));
            MapEventType.bind(map, MapGlobal.zoom, ev -> DomGlobal.console.log("zoom", ev));
            MapEventType.bind(map, DrawGlobal.modechange, ev -> DomGlobal.console.log("draw.modechange", ev));
            MapEventType.bind(map, DrawGlobal.create, ev -> DomGlobal.console.log("draw.create", ev));
            MapEventType.bind(map, DrawGlobal.update, ev -> DomGlobal.console.log("draw.update", ev));
            MapEventType.bind(map, DrawGlobal.delete, ev -> DomGlobal.console.log("draw.delete", ev));
        });
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
