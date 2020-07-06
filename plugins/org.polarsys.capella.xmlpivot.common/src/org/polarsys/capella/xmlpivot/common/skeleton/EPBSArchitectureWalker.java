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

import org.polarsys.capella.core.data.epbs.ConfigurationItem;
import org.polarsys.capella.core.data.epbs.EPBSArchitecture;
import org.polarsys.capella.core.data.epbs.EpbsFactory;
import org.polarsys.capella.core.data.epbs.PhysicalArchitectureRealization;
import org.polarsys.capella.core.data.epbs.PhysicalArtifactRealization;
import org.polarsys.capella.core.data.capellamodeller.SystemEngineering;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.model.helpers.SystemEngineeringExt;


/**
 *
 */
public class EPBSArchitectureWalker extends BlockArchitectureWalker {

  @Override
  public void accept(EObject eObject_p, ModelWalkerHelper helper) {

    super.accept(eObject_p, helper);

    EPBSArchitecture epbs = (EPBSArchitecture) eObject_p;

    if (epbs.getOwnedConfigurationItemPkg() == null) {
      epbs.setOwnedConfigurationItemPkg(helper.getConfigurationItemPkg());
    }
    
    if (epbs.getOwnedConfigurationItemPkg().getOwnedConfigurationItems().isEmpty()){
      epbs.getOwnedConfigurationItemPkg().getOwnedConfigurationItems().add(helper.getConfigurationItem());
    }

    if (epbs.getOwnedAbstractCapabilityPkg() == null){
      epbs.setOwnedAbstractCapabilityPkg(helper.getAbstractCapabilityPkg(epbs));
    }
    
    createPhysicalArchitectureRealization(epbs);
    createPhysicalComponentRealization(epbs);
  }
  
  private void createPhysicalComponentRealization(EPBSArchitecture epbs){
    SystemEngineering eng = SystemEngineeringExt.getSystemEngineering(epbs);
    if (eng != null){
      PhysicalArchitecture pa = SystemEngineeringExt.getOwnedPhysicalArchitecture(eng);
      if (pa != null){
        ConfigurationItem ci = epbs.getOwnedConfigurationItemPkg().getOwnedConfigurationItems().get(0);
        PhysicalComponent pc = pa.getOwnedPhysicalComponentPkg().getOwnedPhysicalComponents().get(0);
          for (PhysicalArtifactRealization par : ci.getOwnedPhysicalArtifactRealizations()){
            if (par.getSourceElement() == ci && par.getTargetElement() == pc){
              return;
            }
          }
          PhysicalArtifactRealization par = EpbsFactory.eINSTANCE.createPhysicalArtifactRealization();
          ci.getOwnedPhysicalArtifactRealizations().add(par);
          par.setSourceElement(ci);
          par.setTargetElement(pc);
      }
    }
  }

  private void createPhysicalArchitectureRealization(EPBSArchitecture epbs){
    SystemEngineering se = SystemEngineeringExt.getSystemEngineering(epbs);
    if (se != null){
      PhysicalArchitecture pa = SystemEngineeringExt.getOwnedPhysicalArchitecture(se);
      if (pa != null){
        for (PhysicalArchitectureRealization par : epbs.getOwnedPhysicalArchitectureRealizations()){
          if (par.getSourceElement() == epbs && par.getTargetElement() == pa){
            return;
          }
        }
        PhysicalArchitectureRealization par = EpbsFactory.eINSTANCE.createPhysicalArchitectureRealization();
        epbs.getOwnedPhysicalArchitectureRealizations().add(par);
        par.setSourceElement(epbs);
        par.setTargetElement(pa);
      }
    }
  }

  @Override
  protected boolean hasOwnedDataPkg(){
	  return false;
  }
  
  @Override
  protected boolean hasOwnedInterfacePkg(){
	  return false;
  }
  
  
}
