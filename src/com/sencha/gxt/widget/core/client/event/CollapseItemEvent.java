/**
 * Sencha GXT 4.0.0 - Sencha for GWT
 * Copyright (c) 2006-2015, Sencha Inc.
 *
 * licensing@sencha.com
 * http://www.sencha.com/products/gxt/license/
 *
 * ================================================================================
 * Open Source License
 * ================================================================================
 * This version of Sencha GXT is licensed under the terms of the Open Source GPL v3
 * license. You may use this license only if you are prepared to distribute and
 * share the source code of your application under the GPL v3 license:
 * http://www.gnu.org/licenses/gpl.html
 *
 * If you are NOT prepared to distribute and share the source code of your
 * application under the GPL v3 license, other commercial and oem licenses
 * are available for an alternate download of Sencha GXT.
 *
 * Please see the Sencha GXT Licensing page at:
 * http://www.sencha.com/products/gxt/license/
 *
 * For clarification or additional options, please contact:
 * licensing@sencha.com
 * ================================================================================
 *
 *
 * ================================================================================
 * Disclaimer
 * ================================================================================
 * THIS SOFTWARE IS DISTRIBUTED "AS-IS" WITHOUT ANY WARRANTIES, CONDITIONS AND
 * REPRESENTATIONS WHETHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION THE
 * IMPLIED WARRANTIES AND CONDITIONS OF MERCHANTABILITY, MERCHANTABLE QUALITY,
 * FITNESS FOR A PARTICULAR PURPOSE, DURABILITY, NON-INFRINGEMENT, PERFORMANCE AND
 * THOSE ARISING BY STATUTE OR FROM CUSTOM OR USAGE OF TRADE OR COURSE OF DEALING.
 * ================================================================================
 */
package com.sencha.gxt.widget.core.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.event.CollapseItemEvent.CollapseItemHandler;

/**
 * Fires after an item is collapsed.
 */
public class CollapseItemEvent<T> extends GwtEvent<CollapseItemHandler<T>> {

  /**
   * Handler class for {@link CollapseItemEvent} events.
   */
  public interface CollapseItemHandler<T> extends EventHandler {

    /**
     * Called after a panel is collapsed.
     */
    void onCollapse(CollapseItemEvent<T> event);
  }
  
  /**
   * A widget that implements this interface is a public source of
   * {@link CollapseItemEvent} events.
   */
  public interface HasCollapseItemHandlers<T> {

    /**
     * Adds a {@link CollapseItemHandler} handler for {@link CollapseItemEvent}
     * events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    HandlerRegistration addCollapseHandler(CollapseItemHandler<T> handler);
  }
  
  /**
   * Handler type.
   */
  private static Type<CollapseItemHandler<?>> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<CollapseItemHandler<?>> getType() {
    return TYPE != null ? TYPE : (TYPE = new Type<CollapseItemHandler<?>>());
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Type<CollapseItemHandler<T>> getAssociatedType() {
    return (Type) TYPE;
  }
  
  private T item;
  
  public CollapseItemEvent(T item) {
    this.item = item;
  }
  
  public T getItem() {
    return item;
  }

  @Override
  public Component getSource() {
    return (Component) super.getSource();
  }

  @Override
  protected void dispatch(CollapseItemHandler<T> handler) {
    handler.onCollapse(this);
  }

}
