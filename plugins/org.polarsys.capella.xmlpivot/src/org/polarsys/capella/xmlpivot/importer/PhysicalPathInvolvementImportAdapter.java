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
package org.polarsys.capella.xmlpivot.importer;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.polarsys.capella.core.data.capellacore.InvolvedElement;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.cs.PhysicalPathInvolvement;

/**
 */
public class PhysicalPathInvolvementImportAdapter extends AdapterImpl implements ImportAdapter {

  /**
   * {@inheritDoc}
   */
  @Override
  public void doImport(EObject technical_p, EObject simplified_p, ImportEngine engine_p) {
    PhysicalPathInvolvement involvement = (PhysicalPathInvolvement) technical_p;
    if (involvement.getInvolved() == null) {
      EReference simpleRefInvolvedElement = engine_p.getMapping()
          .getSimplified(CsPackage.Literals.PHYSICAL_PATH_INVOLVEMENT__INVOLVED_ELEMENT);
      EObject simpleInvolvedElement = (EObject) simplified_p.eGet(simpleRefInvolvedElement);
      if (simpleInvolvedElement != null) {
        EObject involvedElement = engine_p.get(simpleInvolvedElement);
        if (involvedElement instanceof InvolvedElement) {
          involvement.setInvolved((InvolvedElement) involvedElement);
        }
      }
    }
  }

}
