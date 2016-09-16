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
package com.sencha.gxt.chart.client.chart.series;

/**
 * Class that represents a pie slice in a series.
 */
public class Slice {
  protected double value;
  protected double startAngle;
  protected double endAngle;
  protected double rho;
  protected double margin;
  protected double startRho;
  protected double endRho;

  /**
   * Creates a slice.
   * 
   * @param value the value associated with the slice
   * @param startAngle the starting angle of the slice
   * @param endAngle the ending angle of the slice
   * @param rho the radius of the slice
   */
  public Slice(double value, double startAngle, double endAngle, double rho) {
    this.value = value;
    this.startAngle = startAngle;
    this.endAngle = endAngle;
    this.rho = rho;
  }

  /**
   * Creates a copy of the given slice.
   * 
   * @param slice the slice to be copied
   */
  public Slice(Slice slice) {
    this.value = slice.value;
    this.startAngle = slice.startAngle;
    this.endAngle = slice.endAngle;
    this.rho = slice.rho;
    this.margin = slice.margin;
    this.startRho = slice.startRho;
    this.endRho = slice.endRho;
  }

  /**
   * Returns the ending angle of the slice.
   * 
   * @return the ending angle of the slice
   */
  public double getEndAngle() {
    return endAngle;
  }

  /**
   * Returns the ending point radius of the slice.
   * 
   * @return the ending point radius of the slice
   */
  public double getEndRho() {
    return endRho;
  }

  /**
   * Returns the margin of the slice.
   * 
   * @return the margin of the slice
   */
  public double getMargin() {
    return margin;
  }

  /**
   * Returns the radius of the slice.
   * 
   * @return the radius of the slice
   */
  public double getRho() {
    return rho;
  }

  /**
   * Returns the starting angle of the slice.
   * 
   * @return the starting angle of the slice
   */
  public double getStartAngle() {
    return startAngle;
  }

  /**
   * Returns the starting point radius of the slice.
   * 
   * @return the starting point radius of the slice
   */
  public double getStartRho() {
    return startRho;
  }

  /**
   * Returns the value associated with the slice.
   * 
   * @return the value associated with the slice
   */
  public double getValue() {
    return value;
  }

  /**
   * Sets the ending angle of the slice.
   * 
   * @param endAngle the ending angle of the slice
   */
  public void setEndAngle(double endAngle) {
    this.endAngle = endAngle;
  }

  /**
   * Sets the ending point radius of the slice.
   * 
   * @param endRho the ending point radius of the slice
   */
  public void setEndRho(double endRho) {
    this.endRho = endRho;
  }

  /**
   * Sets the margin of the slice.
   * 
   * @param margin the margin of the slice
   */
  public void setMargin(double margin) {
    this.margin = margin;
  }

  /**
   * Sets the radius of the slice.
   * 
   * @param rho the radius of the slice
   */
  public void setRho(double rho) {
    this.rho = rho;
  }

  /**
   * Sets the starting angle of the slice.
   * 
   * @param startAngle the starting angle of the slice
   */
  public void setStartAngle(double startAngle) {
    this.startAngle = startAngle;
  }

  /**
   * Sets the ending point radius of the slice.
   * 
   * @param startRho the ending point radius of the slice
   */
  public void setStartRho(double startRho) {
    this.startRho = startRho;
  }

  /**
   * Sets the value associated with this slice.
   * 
   * @param value the value associated with this slice
   */
  public void setValue(double value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "startAngle:" + startAngle + ", endAngle:" + endAngle + ", rho:" + rho + ", margin:" + margin
        + ", startRho:" + startRho + ", endRho:" + endRho;
  }

}
