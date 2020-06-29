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
package org.polarsys.capella.xmlpivot.test;

import org.polarsys.capella.core.data.interaction.AbstractCapabilityGeneralization;
import org.polarsys.capella.core.data.oa.OperationalCapability;


@Model(
    uri = XMLPivotRoundTripTest.DEFAULT_FIXTURES_LOCATION + "/AbstractCapabilityGeneralizationTest/AbstractCapabilityGeneralizationTest.melodymodeller"
)
public class AbstractCapabilityGeneralizationTest extends XMLPivotRoundTripTest {
  
  public void testAbstractCapabilityGeneralizationRoundTrip(){
    final String oc1Name = "OperationalCapability 1"; //$NON-NLS-1$
    final String oc2Name = "OperationalCapability 2"; //$NON-NLS-1$
    OperationalCapability oc1 = (OperationalCapability) util.getImportElementByName(oc1Name);
    OperationalCapability oc2 = (OperationalCapability) util.getImportElementByName(oc2Name);
    
    assertTrue(oc2.getSuper().size() == 1);
    assertSame(oc2.getSuper().get(0), oc1);
    
    assertEquals(1, oc2.getSuperGeneralizations().size());
    AbstractCapabilityGeneralization generalization = oc2.getSuperGeneralizations().get(0);
    assertSame(generalization.getSuper(), oc1);
  }

  public void testAbstractCapabilityGeneralizationRoundTrip2(){
    final String oc3Name = "OperationalCapability 3"; //$NON-NLS-1$
    final String oc4Name = "OperationalCapability 4"; //$NON-NLS-1$
    final String oc5Name = "OperationalCapability 5"; //$NON-NLS-1$
    OperationalCapability oc3 = (OperationalCapability) util.getImportElementByName(oc3Name);
    OperationalCapability oc4 = (OperationalCapability) util.getImportElementByName(oc4Name);
    OperationalCapability oc5 = (OperationalCapability) util.getImportElementByName(oc5Name);
    
    assertTrue(oc5.getSuper().size() == 2);
    assertTrue(oc5.getSuper().get(0) == oc3);
    assertTrue(oc5.getSuper().get(1) == oc4);
    
    assertEquals(2, oc5.getSuperGeneralizations().size());
    assertTrue(oc5.getSuperGeneralizations().get(0).getSuper() == oc3);
    assertTrue(oc5.getSuperGeneralizations().get(1).getSuper() == oc4);
  }
  
}
