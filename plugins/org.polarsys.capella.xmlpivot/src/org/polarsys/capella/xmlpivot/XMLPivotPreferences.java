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
package org.polarsys.capella.xmlpivot;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

/**
 *
 */
public class XMLPivotPreferences extends AbstractPreferenceInitializer {

  /**
   * Whether exporters should be decorated in order to export all ancestor objects.
   */
  public static String EXPORT_ALL_ANCESTORS = "exportAllAncestors";

  /**
   * {@inheritDoc}
   */
  @Override
  public void initializeDefaultPreferences() {
    IEclipsePreferences node = new DefaultScope().getNode(XMLPivotActivator.PLUGIN_ID);
    node.putBoolean(EXPORT_ALL_ANCESTORS, true);
  }
  
}
