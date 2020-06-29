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
package org.polarsys.capella.xmlpivot.common.skeleton;

import org.eclipse.emf.ecore.EObject;

import org.polarsys.capella.core.data.cs.BlockArchitecture;

/**
 *
 */
public abstract class BlockArchitectureWalker extends AbstractModelWalker {
  
  @Override
  public void accept(EObject e, ModelWalkerHelper helper){
    BlockArchitecture arch = (BlockArchitecture) e;

    if (arch.getOwnedDataPkg() == null && hasOwnedDataPkg()){
      arch.setOwnedDataPkg(helper.getDataPkg());
    }

    if (arch.getOwnedInterfacePkg() == null && hasOwnedInterfacePkg()){
      arch.setOwnedInterfacePkg(helper.getInterfacePkg());
    }
    
    if (arch.getOwnedAbstractCapabilityPkg() == null){
      arch.setOwnedAbstractCapabilityPkg(helper.getAbstractCapabilityPkg(arch));
    }

  }
  
  protected boolean hasOwnedInterfacePkg(){
	  return true;
  }
  
  protected boolean hasOwnedDataPkg(){
	  return true;
  }
  
}
