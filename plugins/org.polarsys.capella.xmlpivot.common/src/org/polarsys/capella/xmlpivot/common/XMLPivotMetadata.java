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
package org.polarsys.capella.xmlpivot.common;

import org.eclipse.emf.ecore.EPackage;

/**
 *
 */
public interface XMLPivotMetadata {

  public final XMLPivotMetadata INSTANCE = new BasicXMLPivotMetadata();
  
  public static final String SOURCE_XMLPIVOT = "http://www.polarsys.org/capella/xmlpivot"; //$NON-NLS-1$
  
  public static final String KEY_SOURCE_NS_URI = "sourceNsURI"; //$NON-NLS-1$
  
  public String getSourceNsURI(EPackage ePackage);
  
  public void setSourceNsURI(EPackage ePackage, String originNsURI);
  
}
