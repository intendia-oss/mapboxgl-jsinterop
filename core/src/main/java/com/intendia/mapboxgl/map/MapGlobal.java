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

    MapEventType<Event> resize = new MapEventType<>("resize");
    MapEventType<Event> remove = new MapEventType<>("remove");
    MapEventType<Event> mousedown = new MapEventType<>("mousedown");
    MapEventType<Event> mouseup = new MapEventType<>("mouseup");
    MapEventType<Event> mouseover = new MapEventType<>("mouseover");
    MapEventType<Event> mousemove = new MapEventType<>("mousemove");
    MapEventType<Event> click = new MapEventType<>("click");
    MapEventType<Event> dblclick = new MapEventType<>("dblclick");
    MapEventType<Event> mouseenter = new MapEventType<>("mouseenter");
    MapEventType<Event> mouseleave = new MapEventType<>("mouseleave");
    MapEventType<Event> mouseout = new MapEventType<>("mouseout");
    MapEventType<Event> contextmenu = new MapEventType<>("contextmenu");
    MapEventType<Event> wheel = new MapEventType<>("wheel");
    MapEventType<Event> touchstart = new MapEventType<>("touchstart");
    MapEventType<Event> touchend = new MapEventType<>("touchend");
    MapEventType<Event> touchmove = new MapEventType<>("touchmove");
    MapEventType<Event> touchcancel = new MapEventType<>("touchcancel");
    MapEventType<Event> movestart = new MapEventType<>("movestart");
    MapEventType<Event> move = new MapEventType<>("move");
    MapEventType<Event> moveend = new MapEventType<>("moveend");
    MapEventType<Event> dragstart = new MapEventType<>("dragstart");
    MapEventType<Event> drag = new MapEventType<>("drag");
    MapEventType<Event> dragend = new MapEventType<>("dragend");
    MapEventType<Event> zoomstart = new MapEventType<>("zoomstart");
    MapEventType<Event> zoom = new MapEventType<>("zoom");
    MapEventType<Event> zoomend = new MapEventType<>("zoomend");
    MapEventType<Event> rotatestart = new MapEventType<>("rotatestart");
    MapEventType<Event> rotate = new MapEventType<>("rotate");
    MapEventType<Event> rotateend = new MapEventType<>("rotateend");
    MapEventType<Event> pitchstart = new MapEventType<>("pitchstart");
    MapEventType<Event> pitch = new MapEventType<>("pitch");
    MapEventType<Event> pitchend = new MapEventType<>("pitchend");
    MapEventType<Event> boxzoomstart = new MapEventType<>("boxzoomstart");
    MapEventType<Event> boxzoomend = new MapEventType<>("boxzoomend");
    MapEventType<Event> boxzoomcancel = new MapEventType<>("boxzoomcancel");
    MapEventType<Event> webglcontextlost = new MapEventType<>("webglcontextlost");
    MapEventType<Event> webglcontextrestored = new MapEventType<>("webglcontextrestored");
    MapEventType<Event> load = new MapEventType<>("load");
    MapEventType<Event> render = new MapEventType<>("render");
    MapEventType<Event> error = new MapEventType<>("error");
    MapEventType<Event> data = new MapEventType<>("data");
    MapEventType<Event> styledata = new MapEventType<>("styledata");
    MapEventType<Event> sourcedata = new MapEventType<>("sourcedata");
    MapEventType<Event> dataloading = new MapEventType<>("dataloading");
    MapEventType<Event> styledataloading = new MapEventType<>("styledataloading");
    MapEventType<Event> sourcedataloading = new MapEventType<>("sourcedataloading");
}
