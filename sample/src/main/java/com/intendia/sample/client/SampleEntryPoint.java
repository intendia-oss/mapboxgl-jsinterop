package com.intendia.sample.client;

import static elemental2.dom.DomGlobal.console;
import static org.jboss.gwt.elemento.core.Elements.button;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.intendia.mapboxgl.draw.Draw;
import com.intendia.mapboxgl.draw.Draw.DrawOptions;
import com.intendia.mapboxgl.draw.DrawGlobal;
import com.intendia.mapboxgl.map.FullscreenControl;
import com.intendia.mapboxgl.map.GeolocateControl;
import com.intendia.mapboxgl.map.IControl;
import com.intendia.mapboxgl.map.Map;
import com.intendia.mapboxgl.map.Map.MapOptions;
import com.intendia.mapboxgl.map.MapEventType;
import com.intendia.mapboxgl.map.MapGlobal;
import com.intendia.mapboxgl.map.NavigationControl;
import com.intendia.mapboxgl.map.ScaleControl;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;

public class SampleEntryPoint implements EntryPoint {
    static String[] styles = {
            "https://tiles.intendia.com/styles/simple/style.json",
            "https://tiles.intendia.com/styles/streets/style.json"
    };
    static int styleIdx = styles.length - 1;
    static String nextStyle() { return styles[++styleIdx % styles.length]; }

    @Override public void onModuleLoad() {
        Resources.inject();
        MapGlobal.ensureInjected();
        DrawGlobal.ensureInjected();

        Scheduler.get().scheduleDeferred(() -> {
            HTMLElement container = Elements.div().style("flex: 1;").get();
            Elements.body().add(container);

            MapOptions mapOptions = new MapOptions();
            mapOptions.container = container;
            mapOptions.style = nextStyle();
            mapOptions.center = new double[] { -3, 40 };/*Madrid*/
            mapOptions.zoom = 5;
            mapOptions.trackResize = true;
            mapOptions.attributionControl = false;
            Map map = new Map(mapOptions);

            map.addControl(new FullscreenControl());
            map.addControl(new GeolocateControl());
            map.addControl(new NavigationControl());
            map.addControl(new ScaleControl());

            DrawOptions drawOptions = new DrawOptions();
            Draw.Controls drawControls = drawOptions.controls = Draw.Controls.create();
            drawControls.point = true; drawControls.polygon = true; drawControls.trash = true;
            Draw draw = new Draw(drawOptions);
            map.addControl(draw);

            map.addControl(new IControl() {
                HTMLElement el = Elements.div().css("mapboxgl-ctrl-group mapboxgl-ctrl")
                        .add(button("·").on(EventType.click, ev -> {
                            console.log("anonymousControl.click", ev);
                            map.setStyle(nextStyle());
                        }))
                        .asElement();
                @Override public String getDefaultPosition() { return "top-right"; }
                @Override public HTMLElement onAdd(Map map) { console.log("anonymousControl.onAdd", map); return el; }
                @Override public void onRemove(Map map) { console.log("anonymous.onRemove", map); }
            });

            bindEvent(map, MapGlobal.load);
            // bindEvent(map, MapGlobal.dataloading); bindEvent(map, MapGlobal.data); //too many events!
            bindEvent(map, MapGlobal.sourcedataloading); bindEvent(map, MapGlobal.sourcedata);
            bindEvent(map, MapGlobal.styledataloading); bindEvent(map, MapGlobal.styledata);
            bindEvent(map, MapGlobal.error);

            bindEvent(map, MapGlobal.zoom);
            bindEvent(map, MapGlobal.move);

            bindEvent(map, DrawGlobal.modechange);
            bindEvent(map, DrawGlobal.create);
            bindEvent(map, DrawGlobal.update);
            bindEvent(map, DrawGlobal.delete);
        });
    }

    public void bindEvent(Map map, MapEventType<?> type) {
        MapEventType.bind(map, type, ev -> console.log(type.getName(), ev));
    }

    public interface Resources extends ClientBundle {
        Resources RESOURCES = GWT.create(Resources.class);
        static void inject() { RESOURCES.style().ensureInjected(); }
        @Source("style.gss") Style style();
        interface Style extends CssResource {
        }
    }
}
