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

import org.polarsys.capella.core.data.oa.OperationalActivityPkg;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;

/**
 *
 */
public class OperationalActivityPkgWalker extends AbstractModelWalker {

  @Override
  public void accept(EObject parent_p, ModelWalkerHelper helper) { 
    OperationalActivityPkg oaPkg = (OperationalActivityPkg) parent_p;
    if (oaPkg.eContainer() instanceof OperationalAnalysis){
      if (oaPkg.getOwnedOperationalActivities().isEmpty()){
        oaPkg.getOwnedOperationalActivities().add(helper.getOperationalActivity());
      }
    }
  }
}

