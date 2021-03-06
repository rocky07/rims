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
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.event.SubmitEvent.SubmitHandler;

/**
 * Fired when the form is submitted.
 */
public class SubmitEvent extends GwtEvent<SubmitHandler> {
  /**
   * A widget that implements this interface is a public source of
   * {@link SubmitEvent} events.
   */
  public interface HasSubmitHandlers {

    /**
     * Adds a {@link SubmitHandler} handler for {@link SubmitEvent} events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    public HandlerRegistration addSubmitHandler(SubmitHandler handler);

  }

  /**
   * Handler for {@link SubmitEvent} events.
   */
  public interface SubmitHandler extends EventHandler {
    /**
     * Fired when the form is submitted.
     * 
     * <p>
     * The FormPanel must <em>not</em> be detached (i.e. removed from its parent
     * or otherwise disconnected from a {@link RootPanel}) until the submission
     * is complete. Otherwise, notification of submission will fail.
     * </p>
     * 
     * @param event the event
     */
    void onSubmit(SubmitEvent event);
  }

  /**
   * The event type.
   */
  private static Type<SubmitHandler> TYPE = new Type<SubmitHandler>();

  /**
   * Handler hook.
   * 
   * @return the handler hook
   */
  public static Type<SubmitHandler> getType() {
    if (TYPE == null) {
      TYPE = new Type<SubmitHandler>();
    }
    return TYPE;
  }

  private boolean canceled = false;

  /**
   * Cancel the form submit. Firing this will prevent a subsequent
   * {@link SubmitCompleteEvent} from being fired.
   */
  public void cancel() {
    this.canceled = true;
  }

  @Override
  public final Type<SubmitHandler> getAssociatedType() {
    return TYPE;
  }

  /**
   * Gets whether this form submit will be canceled.
   * 
   * @return <code>true</code> if the form submit will be canceled
   */
  public boolean isCanceled() {
    return canceled;
  }

  @Override
  protected void dispatch(SubmitHandler handler) {
    handler.onSubmit(this);
  }

}
