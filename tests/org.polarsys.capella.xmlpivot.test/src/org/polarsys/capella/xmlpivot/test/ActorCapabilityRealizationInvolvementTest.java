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

import org.polarsys.capella.core.data.cs.CsPackage;


/**
 * @generated
 */
public class ActorCapabilityRealizationInvolvementTest extends XMLPivotRoundTripTest {

  @Model(
      uri="platform:/plugin/org.polarsys.capella.xmlpivot.test/fixtures/testRoundTrip1/testRoundTrip1.melodymodeller"
  )
  public void testActorCapabilityRealizationInvolvementRoundTrip(){
    util.assertAllLinksRecreated(CsPackage.Literals.ACTOR_CAPABILITY_REALIZATION_INVOLVEMENT);
  }

}
