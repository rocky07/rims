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
package com.sencha.gxt.chart.client.chart.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.sencha.gxt.chart.client.chart.event.SeriesItemOverEvent.SeriesItemOverHandler;
import com.sencha.gxt.chart.client.chart.series.Series;
import com.sencha.gxt.core.client.ValueProvider;

/**
 * Fired when an item in the {@link Series} is moused over.
 */
public class SeriesItemOverEvent<M> extends GwtEvent<SeriesItemOverHandler<M>> {

  /**
   * A widget that implements this interface is a public source of
   * {@link SeriesItemOverEvent} events.
   */
  public interface HasSeriesItemOverHandlers<M> {

    /**
     * Adds a {@link SeriesItemOverHandler} handler for
     * {@link SeriesItemOverEvent} events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    HandlerRegistration addSeriesItemOverHandler(SeriesItemOverHandler<M> handler);
  }

  /**
   * Handler class for {@link SeriesItemOverEvent} events.
   */
  public interface SeriesItemOverHandler<M> extends EventHandler {

    /**
     * Fired when an item in the {@link Series} is moused over.
     * 
     * @param event the fired event
     */
    void onSeriesOverItem(SeriesItemOverEvent<M> event);
  }

  /**
   * Handler type.
   */
  private static Type<SeriesItemOverHandler<?>> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<SeriesItemOverHandler<?>> getType() {
    if (TYPE == null) {
      TYPE = new Type<SeriesItemOverHandler<?>>();
    }
    return TYPE;
  }

  private final M item;
  private final ValueProvider<? super M, ? extends Number> valueProvider;
  private final int index;
  private final Event event;

  /**
   * Creates a new event.
   * 
   * @param item the store item
   * @param valueProvider the value provider
   * @param index the series index
   * @param event the source browser event
   */
  public SeriesItemOverEvent(M item, ValueProvider<? super M, ? extends Number> valueProvider, int index, Event event) {
    this.item = item;
    this.valueProvider = valueProvider;
    this.index = index;
    this.event = event;
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public Type<SeriesItemOverHandler<M>> getAssociatedType() {
    return (Type) getType();
  }

  /**
   * Returns the browser event that initiated the selection event.
   * 
   * @return the browser event that initiated the selection event
   */
  public Event getBrowserEvent() {
    return event;
  }

  /**
   * Returns the index of the series item.
   * 
   * @return the index of the series item
   */
  public int getIndex() {
    return index;
  }

  /**
   * Returns the store item associated with the event.
   * 
   * @return the store item associated with the event
   */
  public M getItem() {
    return item;
  }

  /**
   * Returns the value provider associated with the event.
   * 
   * @return the value provider associated with the event
   */
  public ValueProvider<? super M, ? extends Number> getValueProvider() {
    return valueProvider;
  }

  @Override
  protected void dispatch(SeriesItemOverHandler<M> handler) {
    handler.onSeriesOverItem(this);
  }

}
