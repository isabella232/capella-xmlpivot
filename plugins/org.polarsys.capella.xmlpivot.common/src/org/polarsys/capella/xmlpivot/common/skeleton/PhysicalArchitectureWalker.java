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
import org.polarsys.capella.core.data.capellamodeller.SystemEngineering;
import org.polarsys.capella.core.data.cs.ComponentRealization;
import org.polarsys.capella.core.data.cs.CsFactory;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.pa.LogicalArchitectureRealization;
import org.polarsys.capella.core.data.pa.PaFactory;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.model.helpers.SystemEngineeringExt;

/**
 *
 */
public class PhysicalArchitectureWalker extends BlockArchitectureWalker {



  @Override
  public void accept(EObject eObject_p, ModelWalkerHelper helper) {

    super.accept(eObject_p, helper);
    
    PhysicalArchitecture pa = (PhysicalArchitecture) eObject_p;
    
    if (pa.getOwnedFunctionPkg() == null){
      pa.setOwnedFunctionPkg(helper.getFunctionPkg(pa));
    }
    
    
    if (pa.getOwnedPhysicalComponentPkg() == null){
      pa.setOwnedPhysicalComponentPkg(helper.getPhysicalComponentPkg());
    }
    
    if (pa.getOwnedPhysicalComponentPkg().getOwnedPhysicalComponents().isEmpty()){
        pa.getOwnedPhysicalComponentPkg().getOwnedPhysicalComponents().add(helper.getPhysicalComponent());
    }
    
    createLogicalArchitectureRealization(pa);
    createLogicalComponentRealization(pa);
  }
  

  private void createLogicalComponentRealization(PhysicalArchitecture pa){
    SystemEngineering eng = SystemEngineeringExt.getSystemEngineering(pa);
    if (eng != null){
      LogicalArchitecture la = SystemEngineeringExt.getOwnedLogicalArchitecture(eng);
      if (la != null){
        PhysicalComponent pc = pa.getOwnedPhysicalComponentPkg().getOwnedPhysicalComponents().get(0);
        LogicalComponent lc = la.getOwnedLogicalComponentPkg().getOwnedLogicalComponents().get(0);
        if (pc != null && lc != null){
          for (ComponentRealization lcr : pc.getOwnedComponentRealizations()){
            if (lcr.getSourceElement() == pc && lcr.getTargetElement() == lc){
              return;
            }
          }
          ComponentRealization lcr = CsFactory.eINSTANCE.createComponentRealization();
          pc.getOwnedComponentRealizations().add(lcr);
          lcr.setSourceElement(pc);
          lcr.setTargetElement(lc);
        }
      }
    }
  }
  
  private void createLogicalArchitectureRealization(PhysicalArchitecture pa){
    SystemEngineering se = SystemEngineeringExt.getSystemEngineering(pa);
    if (se != null){
      LogicalArchitecture la = SystemEngineeringExt.getOwnedLogicalArchitecture(se);
      if (la != null){
        for (LogicalArchitectureRealization lar : pa.getOwnedLogicalArchitectureRealizations()){
          if (lar.getSourceElement() == pa && lar.getTargetElement() == la){
            return;
          }
        }
        LogicalArchitectureRealization lar = PaFactory.eINSTANCE.createLogicalArchitectureRealization();
        pa.getOwnedLogicalArchitectureRealizations().add(lar);
        lar.setSourceElement(pa);
        lar.setTargetElement(la);
      }
    }
  }
  

}
