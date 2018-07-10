package com.intendia.mapboxgl.map;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public interface IControl {
    /**
     * Provide a default position for this control. If {@link Map#addControl} is called without the position parameter,
     * the value returned by getDefaultPosition will be used as the control's position.
     *
     * Valid values are 'top-left' ,  'top-right',  'bottom-left', and  'bottom-right' (javascript defaults to
     * 'top-right' but do not apply to java GWT as you are forced to implement this method).
     */
    String getDefaultPosition();

    /**
     * Register a control on the map and give it a chance to register event listeners and resources. This method is
     * called by Map#addControl internally.
     */
    HTMLElement onAdd(Map map);

    /**
     * Unregister a control on the map and give it a chance to detach event listeners and resources. This method is
     * called by Map#removeControl internally.
     */
    void onRemove(Map map);
}
