/*******************************************************************************
 * Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *    
 *  Contributors:
 *     Thales - initial API and implementation
 ******************************************************************************/
package org.polarsys.capella.xmlpivot.common.skeleton;

import org.eclipse.emf.ecore.EObject;

import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalContext;

/**
 *
 */
public class LogicalContextWalker extends AbstractModelWalker {

  /**
   * @param parent_p
   */
  @Override
  public void accept(EObject eObject_p, ModelWalkerHelper helper) {
    LogicalContext lctx = (LogicalContext) eObject_p;
    if (lctx.eContainer() instanceof LogicalArchitecture){
      if (lctx.getOwnedFeatures().isEmpty()){
        lctx.getOwnedFeatures().add(helper.getPart(lctx));
      }
    }
  }

}
