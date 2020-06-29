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
package org.polarsys.capella.xmlpivot.importer;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.polarsys.capella.core.data.fa.util.FaAdapterFactory;

/**
 *
 */
public class FaImportAdapterFactory extends FaAdapterFactory {

  @Override
  public boolean isFactoryForType(Object object_p) {
    return object_p == ImportAdapter.class || super.isFactoryForType(object_p);
  }

  private Adapter componentExchangeImportAdapter;
  
  @Override
  public Adapter createComponentExchangeAdapter(){
	  if (componentExchangeImportAdapter == null){
		  componentExchangeImportAdapter = new ComponentExchangeImportAdapter();
	  }
	  return componentExchangeImportAdapter;
  }
  

  @Override
  protected void associate(Adapter adapter_p, Notifier target_p) {
    /** never associate adapters created by this factory **/
  }
}
