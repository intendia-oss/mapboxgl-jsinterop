package com.intendia.mapboxgl.map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.TextResource;
import elemental2.core.Global;

public interface MapGlobal {

    static void ensureInjected() {
        Resources resources = GWT.create(Resources.class);
        resources.style().ensureInjected();
        Global.eval(resources.script().getText());
    }

    interface Resources extends ClientBundle {
        @Source("mapbox-gl.js") TextResource script();
        @Source("mapbox-gl.gss") @NotStrict CssResource style();
    }

    EventType<Event> resize = new EventType<>("resize");
    EventType<Event> remove = new EventType<>("remove");
    EventType<Event> mousedown = new EventType<>("mousedown");
    EventType<Event> mouseup = new EventType<>("mouseup");
    EventType<Event> mouseover = new EventType<>("mouseover");
    EventType<Event> mousemove = new EventType<>("mousemove");
    EventType<Event> click = new EventType<>("click");
    EventType<Event> dblclick = new EventType<>("dblclick");
    EventType<Event> mouseenter = new EventType<>("mouseenter");
    EventType<Event> mouseleave = new EventType<>("mouseleave");
    EventType<Event> mouseout = new EventType<>("mouseout");
    EventType<Event> contextmenu = new EventType<>("contextmenu");
    EventType<Event> wheel = new EventType<>("wheel");
    EventType<Event> touchstart = new EventType<>("touchstart");
    EventType<Event> touchend = new EventType<>("touchend");
    EventType<Event> touchmove = new EventType<>("touchmove");
    EventType<Event> touchcancel = new EventType<>("touchcancel");
    EventType<Event> movestart = new EventType<>("movestart");
    EventType<Event> move = new EventType<>("move");
    EventType<Event> moveend = new EventType<>("moveend");
    EventType<Event> dragstart = new EventType<>("dragstart");
    EventType<Event> drag = new EventType<>("drag");
    EventType<Event> dragend = new EventType<>("dragend");
    EventType<Event> zoomstart = new EventType<>("zoomstart");
    EventType<Event> zoom = new EventType<>("zoom");
    EventType<Event> zoomend = new EventType<>("zoomend");
    EventType<Event> rotatestart = new EventType<>("rotatestart");
    EventType<Event> rotate = new EventType<>("rotate");
    EventType<Event> rotateend = new EventType<>("rotateend");
    EventType<Event> pitchstart = new EventType<>("pitchstart");
    EventType<Event> pitch = new EventType<>("pitch");
    EventType<Event> pitchend = new EventType<>("pitchend");
    EventType<Event> boxzoomstart = new EventType<>("boxzoomstart");
    EventType<Event> boxzoomend = new EventType<>("boxzoomend");
    EventType<Event> boxzoomcancel = new EventType<>("boxzoomcancel");
    EventType<Event> webglcontextlost = new EventType<>("webglcontextlost");
    EventType<Event> webglcontextrestored = new EventType<>("webglcontextrestored");
    EventType<Event> load = new EventType<>("load");
    EventType<Event> render = new EventType<>("render");
    EventType<Event> error = new EventType<>("error");
    EventType<Event> data = new EventType<>("data");
    EventType<Event> styledata = new EventType<>("styledata");
    EventType<Event> sourcedata = new EventType<>("sourcedata");
    EventType<Event> dataloading = new EventType<>("dataloading");
    EventType<Event> styledataloading = new EventType<>("styledataloading");
    EventType<Event> sourcedataloading = new EventType<>("sourcedataloading");
}
