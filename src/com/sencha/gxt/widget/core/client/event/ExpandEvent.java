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

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.sencha.gxt.widget.core.client.event.ExpandEvent.ExpandHandler;

/**
 * Fires after the source is expanded.
 */
public class ExpandEvent extends GwtEvent<ExpandHandler> {

  /**
   * Handler class for {@link ExpandEvent} events.
   */
  public interface ExpandHandler extends EventHandler {

    /**
     * Called after the source is expanded.
     */
    void onExpand(ExpandEvent event);
  }

  /**
   * A widget that implements this interface is a public source of
   * {@link ExpandEvent} events.
   */
  public interface HasExpandHandlers {

    /**
     * Adds a {@link ExpandHandler} handler for {@link ExpandEvent} events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    HandlerRegistration addExpandHandler(ExpandHandler handler);
  }

  /**
   * Handler type.
   */
  private static Type<ExpandHandler> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<ExpandHandler> getType() {
    return TYPE != null ? TYPE : (TYPE = new Type<ExpandHandler>());
  }
  
  private Context context;
  
  public ExpandEvent() {
    
  }
  
  public ExpandEvent(Context context) {
    this.context = context;
  }
  
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Type<ExpandHandler> getAssociatedType() {
    return (Type) TYPE;
  }

  /**
   * Returns the cell context.
   * 
   * @return the cell context or null if event not cell based
   */
  public Context getContext() {
    return context;
  }

  @Override
  protected void dispatch(ExpandHandler handler) {
    handler.onExpand(this);
  }

}
