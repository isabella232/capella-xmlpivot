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
package org.polarsys.capella.xmlpivot.exporter;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * <p>
 * <strong>EXPERIMENTAL</strong>. This class or interface has been added as part of a work in progress. There is no
 * guarantee that this API will work or that it will remain the same. Please do not use this API without consulting with
 * the Capella team.
 * </p>
 */
public class ConceptualExportPlugin extends Plugin {

  /** A label for dialogs */
  public static final String LABEL = "XML Export";

  // The shared instance
  private static ConceptualExportPlugin plugin;

  /**
   * The constructor
   */
  public ConceptualExportPlugin() {
    // Nothing needed
  }

  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
  }

  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static ConceptualExportPlugin getDefault() {
    return plugin;
  }

}
