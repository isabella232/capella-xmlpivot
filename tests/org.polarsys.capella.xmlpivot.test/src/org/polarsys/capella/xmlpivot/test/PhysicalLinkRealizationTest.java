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

import org.polarsys.capella.core.data.cs.PhysicalLink;


/**
 * @generated NOT
 */
@Model (
  uri = XMLPivotRoundTripTest.DEFAULT_FIXTURES_LOCATION + "/PhysicalLinkRealizationTest/PhysicalLinkRealizationTest.melodymodeller"    
)
public class PhysicalLinkRealizationTest extends XMLPivotRoundTripTest {

  /**
  * @generated NOT
  */
  public void testPhysicalLinkRealizationRoundTrip(){
    PhysicalLink p1 = (PhysicalLink) util.getImportElementByName("PL 1");
    PhysicalLink p2 = (PhysicalLink) util.getImportElementByName("PL 2");
    PhysicalLink p3 = (PhysicalLink) util.getImportElementByName("PL 3");
    
    assertEquals(2, p3.getOwnedPhysicalLinkRealizations().size());
    assertSame(p1, p3.getOwnedPhysicalLinkRealizations().get(0).getTargetElement());
    assertSame(p2, p3.getOwnedPhysicalLinkRealizations().get(1).getTargetElement());

    assertSame(p3, p3.getOwnedPhysicalLinkRealizations().get(0).getSourceElement());
    assertSame(p3, p3.getOwnedPhysicalLinkRealizations().get(1).getSourceElement());
  }

}
