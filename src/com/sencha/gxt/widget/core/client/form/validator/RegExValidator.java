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
package com.sencha.gxt.widget.core.client.form.validator;

import java.util.List;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.regexp.shared.RegExp;
import com.sencha.gxt.core.client.util.Util;
import com.sencha.gxt.messages.client.DefaultMessages;
import com.sencha.gxt.widget.core.client.form.error.DefaultEditorError;

/**
 * Validates the target value using a regular expression.
 */
public class RegExValidator extends AbstractValidator<String> {

  public interface RegExMessages {
    public String regExMessage();
  }

  protected class DefaultRegExMessages implements RegExMessages {

    @Override
    public String regExMessage() {
      return DefaultMessages.getMessages().textField_regexText();
    }

  }

  private RegExp compiledRegExp;
  private String regex;
  private RegExMessages messages;

  /**
   * Creates a new regex validator.
   * 
   * @param regex the regular expression
   */
  public RegExValidator(String regex) {
    this.regex = regex;
  }

  /**
   * Creates a new regex validator.
   * 
   * @param regex the regular expression
   * @param message the error message
   */
  public RegExValidator(String regex, final String message) {
    this.regex = regex;
    setMessages(new RegExMessages() {
      @Override
      public String regExMessage() {
        return message;
      }
    });
  }
  
  /**
   * Returns the messages.
   * 
   * @return the messages
   */
  public RegExMessages getMessages() {
    if (messages == null) {
      messages = new DefaultRegExMessages();
    }
    return messages;
  }

  /**
   * Returns the regular expression.
   * 
   * @return the regular expression
   */
  public String getRegex() {
    return regex;
  }

  /**
   * Sets the messages.
   * 
   * @param messages the messages
   */
  public void setMessages(RegExMessages messages) {
    this.messages = messages;
  }

  /**
   * Sets the regular expression.
   * 
   * @param regex the regular expression
   */
  public void setRegex(String regex) {
    if (!Util.equalWithNull(this.regex, regex)) {
      compiledRegExp = null;
      this.regex = regex;
    }
  }
  
  /**
   * Returns a compiled {@link RegExp} object to be used to actually perform the validation. After
   * this has been created it is cached for subsequent reuse.
   *
   * @return the compiled regex string
   */
  protected RegExp getCompiledRegExp() {
    assert regex != null : "RegExValidator requires that regex not be null";
    if (compiledRegExp == null) {
      compiledRegExp = RegExp.compile(regex);
    }
    return compiledRegExp;
  }

  @Override
  public List<EditorError> validate(Editor<String> field, String value) {
    if (value != null && !value.equals("")) {
      if (!getCompiledRegExp().test(value)) {
        return createError(new DefaultEditorError(field, getMessages().regExMessage(), value));
      }
    }
    return null;
  }

}