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

import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.data.ctx.SystemContext;

/**
 *
 */
public class SystemContextWalker extends AbstractModelWalker {
  
  /**
   * @param parent_p
   */
  @Override
  public void accept(EObject parent_p, ModelWalkerHelper helper) {

    SystemContext sctx = (SystemContext) parent_p;
    if (sctx.eContainer() instanceof SystemAnalysis){
      if (sctx.getOwnedFeatures().isEmpty()){
        sctx.getOwnedFeatures().add(helper.getPart(sctx));
      }
    }
    
  }
  
}
