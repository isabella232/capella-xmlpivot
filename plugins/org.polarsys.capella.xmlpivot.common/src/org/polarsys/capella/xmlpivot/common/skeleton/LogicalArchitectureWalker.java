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
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.data.ctx.SystemComponent;
import org.polarsys.capella.core.data.la.LaFactory;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.la.SystemAnalysisRealization;
import org.polarsys.capella.core.model.helpers.SystemEngineeringExt;

/**
 *
 */
public class LogicalArchitectureWalker extends BlockArchitectureWalker {
  
  @Override
  public void accept(EObject parent_p, ModelWalkerHelper helper) {

    super.accept(parent_p, helper);

    LogicalArchitecture la = (LogicalArchitecture) parent_p;
    
    if (la.getOwnedFunctionPkg() == null){
      la.setOwnedFunctionPkg(helper.getFunctionPkg(la));
    }
    
    if (la.getOwnedLogicalComponentPkg() == null){
      la.setOwnedLogicalComponentPkg(helper.getLogicalComponentPkg());
    }

    if (la.getOwnedLogicalComponentPkg().getOwnedLogicalComponents().isEmpty()) {
      la.getOwnedLogicalComponentPkg().getOwnedLogicalComponents().add(helper.getLogicalComponent());
    }
 
    createSystemAnalysisRealization(la);
    createSystemRealization(la);
  }

  private void createSystemRealization(LogicalArchitecture la){
    SystemEngineering eng = SystemEngineeringExt.getSystemEngineering(la);
    if (eng != null){
      SystemAnalysis sa = SystemEngineeringExt.getOwnedSystemAnalysis(eng);
      if (sa != null){
        LogicalComponent lc = la.getOwnedLogicalComponentPkg().getOwnedLogicalComponents().get(0);
        SystemComponent sys = sa.getOwnedSystemComponentPkg().getOwnedSystemComponents().get(0);
        if (sys != null && lc != null){
          for (ComponentRealization sr : lc.getOwnedComponentRealizations()){
            if (sr.getSourceElement() == lc && sr.getTargetElement() == sys){
              return;
            }
          }
          ComponentRealization sr = CsFactory.eINSTANCE.createComponentRealization();
          lc.getOwnedComponentRealizations().add(sr);
          sr.setSourceElement(lc);
          sr.setTargetElement(sys);
        }
      }
    }
  }
  
  private void createSystemAnalysisRealization(LogicalArchitecture la){
    SystemEngineering se = SystemEngineeringExt.getSystemEngineering(la);
    if (se != null){
      SystemAnalysis sa = SystemEngineeringExt.getOwnedSystemAnalysis(se);
      if (sa != null){
        for (SystemAnalysisRealization sar : la.getOwnedSystemAnalysisRealizations()){
          if (sar.getSourceElement() == la && sar.getTargetElement() == sa){
            return;
          }
        }
        SystemAnalysisRealization sar = LaFactory.eINSTANCE.createSystemAnalysisRealization();
        la.getOwnedSystemAnalysisRealizations().add(sar);
        sar.setSourceElement(la);
        sar.setTargetElement(sa);
      }
    }
  }
  
}
