package com.intendia.mapboxgl.draw;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.TextResource;
import com.intendia.mapboxgl.map.Event;
import com.intendia.mapboxgl.map.EventType;
import elemental2.core.Global;

public interface DrawGlobal {

    static void ensureInjected() {
        Resources resources = GWT.create(Resources.class);
        resources.style().ensureInjected();
        Global.eval(resources.script().getText());
    }

    interface Resources extends ClientBundle {
        @Source("mapbox-gl-draw.js") TextResource script();
        @Source("mapbox-gl-draw.gss") @CssResource.NotStrict CssResource style();
    }

    EventType<Event> create = new EventType<>("draw.create");
    EventType<Event> delete = new EventType<>("draw.delete");
    EventType<Event> combine = new EventType<>("draw.combine");
    EventType<Event> uncombine = new EventType<>("draw.uncombine");
    EventType<Event> update = new EventType<>("draw.update");
    EventType<Event> selectionchange = new EventType<>("draw.selectionchange");
    EventType<Event> modechange = new EventType<>("draw.modechange");
    EventType<Event> render = new EventType<>("draw.render");
    EventType<Event> actionable = new EventType<>("draw.actionable");
}
