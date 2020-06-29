/*******************************************************************************
 * Copyright (c) 2006, 2020 THALES GLOBAL SERVICES.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.xmlpivot.extraction;

import org.eclipse.osgi.util.NLS;

/**
 * Strings management class
 */
public class Messages extends NLS {

  /** Bundle name */
  public static final String _BUNDLE_NAME = "org.polarsys.capella.xmlpivot.extraction.messages"; //$NON-NLS-1$

  public static String _ECORE_EXTENSION;

  static {
    // initialize resource bundle
    NLS.initializeMessages(_BUNDLE_NAME, Messages.class);
  }

  /**
   * Constructor
   */
  private Messages() {
    // Nothing
  }

}
