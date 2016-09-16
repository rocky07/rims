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
import com.sencha.gxt.core.shared.event.CancellableEvent;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.event.BeforeCheckChangeEvent.BeforeCheckChangeHandler;
import com.sencha.gxt.widget.core.client.tree.Tree.CheckState;

/**
 * Fires before a item's checked state is changed.
 */
public class BeforeCheckChangeEvent<T> extends GwtEvent<BeforeCheckChangeHandler<T>> implements CancellableEvent {

  /**
   * Handler type.
   */
  private static Type<BeforeCheckChangeHandler<?>> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<BeforeCheckChangeHandler<?>> getType() {
    if (TYPE == null) {
      TYPE = new Type<BeforeCheckChangeHandler<?>>();
    }
    return TYPE;
  }

  private boolean cancelled;
  private CheckState state;
  private T item;

  public BeforeCheckChangeEvent(T item, CheckState state) {
    this.item = item;
    this.state = state;
  }
  
  public T getItem() {
    return item;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Type<BeforeCheckChangeHandler<T>> getAssociatedType() {
    return (Type) TYPE;
  }

  public Component getSource() {
    return (Component) super.getSource();
  }

  @Override
  public boolean isCancelled() {
    return cancelled;
  }

  /**
   * Returns the item's checked state.
   * 
   * @return the checked state
   */
  public CheckState getChecked() {
    return state;
  }

  @Override
  public void setCancelled(boolean cancel) {
    this.cancelled = cancel;
  }

  @Override
  protected void dispatch(BeforeCheckChangeHandler<T> handler) {
    handler.onBeforeCheckChange(this);
  }
  
  /**
   * Handler class for {@link BeforeCheckChangeEvent} events.
   */
  public interface BeforeCheckChangeHandler<T> extends EventHandler {

    /**
     * Called before an item's check state changes. Listeners can cancel the
     * action by calling {@link BeforeCloseEvent#setCancelled(boolean)}.
     */
    void onBeforeCheckChange(BeforeCheckChangeEvent<T> event);
  }
  
  /**
   * A widget that implements this interface is a public source of
   * {@link BeforeCheckChangeEvent} events.
   */
  public interface HasBeforeCheckChangeHandlers<T> {

    /**
     * Adds a {@link BeforeCheckChangeHandler} handler for {@link BeforeCheckChangeEvent} events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    public HandlerRegistration addBeforeCheckChangeHandler(BeforeCheckChangeHandler<T> handler);

  }

}
