package com.intendia.mapboxgl.draw;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.TextResource;
import com.intendia.mapboxgl.map.Event;
import com.intendia.mapboxgl.map.MapEventType;
import com.intendia.mapboxgl.tools.ToolsGlobal;
import elemental2.core.Global;

public interface DrawGlobal {

    static void ensureInjected() {
        Resources resources = GWT.create(Resources.class);
        resources.style().ensureInjected();
        Global.eval(resources.script().getText());
        ToolsGlobal.ensureInjected(); // not mandatory dependency, but really useful so included anyways
    }

    interface Resources extends ClientBundle {
        @Source("mapbox-gl-draw.js") TextResource script();
        @Source("mapbox-gl-draw.gss") @CssResource.NotStrict CssResource style();
    }

    MapEventType<Event> create = new MapEventType<>("draw.create");
    MapEventType<Event> delete = new MapEventType<>("draw.delete");
    MapEventType<Event> combine = new MapEventType<>("draw.combine");
    MapEventType<Event> uncombine = new MapEventType<>("draw.uncombine");
    MapEventType<Event> update = new MapEventType<>("draw.update");
    MapEventType<Event> selectionchange = new MapEventType<>("draw.selectionchange");
    MapEventType<Event> modechange = new MapEventType<>("draw.modechange");
    MapEventType<Event> render = new MapEventType<>("draw.render");
    MapEventType<Event> actionable = new MapEventType<>("draw.actionable");
}
