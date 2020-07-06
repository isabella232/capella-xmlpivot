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

import org.polarsys.capella.core.data.capellacommon.AbstractCapabilityPkg;
import org.polarsys.capella.core.data.capellacommon.Region;
import org.polarsys.capella.core.data.capellacommon.StateMachine;
import org.polarsys.capella.core.data.capellamodeller.SystemEngineering;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.InterfacePkg;
import org.polarsys.capella.core.data.ctx.MissionPkg;
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.data.ctx.SystemComponent;
import org.polarsys.capella.core.data.ctx.SystemComponentPkg;
import org.polarsys.capella.core.data.ctx.SystemFunction;
import org.polarsys.capella.core.data.epbs.ConfigurationItem;
import org.polarsys.capella.core.data.epbs.ConfigurationItemPkg;
import org.polarsys.capella.core.data.epbs.EPBSArchitecture;
import org.polarsys.capella.core.data.fa.AbstractFunctionalArchitecture;
import org.polarsys.capella.core.data.fa.FunctionPkg;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.la.LogicalComponentPkg;
import org.polarsys.capella.core.data.la.LogicalFunction;
import org.polarsys.capella.core.data.oa.EntityPkg;
import org.polarsys.capella.core.data.oa.OperationalActivity;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.data.oa.RolePkg;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalComponentPkg;
import org.polarsys.capella.core.data.pa.PhysicalFunction;

/**
 *
 */
public interface ModelWalkerHelper {

  public ConfigurationItem getConfigurationItem();

  public InterfacePkg getInterfacePkg();
  public DataPkg getDataPkg();
  
  public LogicalComponent getLogicalComponent();
  public LogicalComponentPkg getLogicalComponentPkg();
  
  /**
   * @return
   */
  public LogicalFunction getLogicalFunction();
  /**
   * @return
   */
  public OperationalActivity getOperationalActivity();
  
  /**
   * @return
   */
  public RolePkg getRolePkg();
  /**
   * @return
   */
  public EntityPkg getEntityPkg();
  
  /**
   * @param arch_p
   * @return
   */
  public AbstractCapabilityPkg getAbstractCapabilityPkg(BlockArchitecture arch_p);
  /**
   * @param analysis_p
   * @return
   */
  public FunctionPkg getFunctionPkg(AbstractFunctionalArchitecture arch_p);
  /**
   * @return
   */
  public MissionPkg getMissionPkg();

  /**
   * @return
   */
  public PhysicalComponent getPhysicalComponent();
  /**
   * @return
   */
  public PhysicalFunction getPhysicalFunction();
 
  /**
   * @param project_p
   * @return
   */
  public SystemEngineering getSystemEngineering();
  /**
   * @return
   */
  public Region getRegion();
  /**
   * @return
   */
  public OperationalAnalysis getOperationalAnalysis();
  /**
   * @return
   */
  public SystemAnalysis getSystemAnalysis();
  /**
   * @return
   */
  public LogicalArchitecture getLogicalArchitecture();
  /**
   * @return
   */
  public PhysicalArchitecture getPhysicalArchitecture();
  /**
   * @return
   */
  public EPBSArchitecture getEPBSArchitecture();
  /**
   * @return
   */
  public SystemFunction getSystemFunction();
  /**
   * @return
   */
  public StateMachine getStateMachine();

  public SystemComponentPkg getSystemComponentPkg();

  public PhysicalComponentPkg getPhysicalComponentPkg();

  public SystemComponent getSystemComponent();

   ConfigurationItemPkg getConfigurationItemPkg();
 
  
}
