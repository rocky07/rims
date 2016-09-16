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
package com.sencha.gxt.theme.blue.client.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.theme.base.client.menu.MenuItemBaseAppearance;

public class BlueMenuItemAppearance extends MenuItemBaseAppearance {

  public interface BlueMenuItemResources extends MenuItemBaseAppearance.MenuItemResources, ClientBundle {

    ImageResource menuParent();

    @Override
    @Source({"com/sencha/gxt/theme/base/client/menu/Item.gss",
            "com/sencha/gxt/theme/blue/client/menu/BlueItem.gss",
            "com/sencha/gxt/theme/base/client/menu/MenuItem.gss",
            "BlueMenuItem.gss"})
    BlueMenuItemStyle style();

    ImageResource itemOver();
  }

  public interface BlueMenuItemStyle extends MenuItemBaseAppearance.MenuItemStyle {
  }

  public BlueMenuItemAppearance() {
    this(GWT.<BlueMenuItemResources> create(BlueMenuItemResources.class),
        GWT.<MenuItemTemplate> create(MenuItemTemplate.class));
  }

  public BlueMenuItemAppearance(BlueMenuItemResources resources, MenuItemTemplate template) {
    super(resources, template);
  }

}
