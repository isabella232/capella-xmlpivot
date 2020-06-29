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

import org.polarsys.capella.core.data.cs.PhysicalPort;


/**
 * @generated NOT
 */
@Model(
    uri = XMLPivotRoundTripTest.DEFAULT_FIXTURES_LOCATION + "/PhysicalPortRealizationTest/PhysicalPortRealizationTest.melodymodeller"
)
public class PhysicalPortRealizationTest extends XMLPivotRoundTripTest {

  /**
  * @generated NOT
  */
  public void testPhysicalPortRealizationRoundTrip(){
    
    PhysicalPort pp1 = (PhysicalPort) util.getImportElementByName("PP 1"); //$NON-NLS-1$
    PhysicalPort pp2 = (PhysicalPort) util.getImportElementByName("PP 2"); //$NON-NLS-1$
    PhysicalPort pp3 = (PhysicalPort) util.getImportElementByName("PP 3"); //$NON-NLS-1$
    
    assertEquals(2,  pp3.getOwnedPhysicalPortRealizations().size());
    assertSame(pp1, pp3.getOwnedPhysicalPortRealizations().get(0).getTargetElement());
    assertSame(pp2, pp3.getOwnedPhysicalPortRealizations().get(1).getTargetElement());
    assertSame(pp3, pp3.getOwnedPhysicalPortRealizations().get(0).getSourceElement());
    assertSame(pp3, pp3.getOwnedPhysicalPortRealizations().get(1).getSourceElement());
  }

}
