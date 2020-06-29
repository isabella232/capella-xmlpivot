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
package org.polarsys.capella.xmlpivot.merge.specification;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.diffmerge.ui.specification.IComparisonMethod;
import org.eclipse.emf.diffmerge.ui.specification.IModelScopeDefinition;
import org.polarsys.capella.core.compare.CapellaComparisonMethodFactory;
import org.polarsys.capella.xmlpivot.merge.Messages;


public class XMLPivotComparisonFactory extends CapellaComparisonMethodFactory {

  /**
   * @see org.eclipse.emf.diffmerge.ui.specification.IComparisonSpecificationFactory#getLabel()
   */
  @Override
  public String getLabel() {
    return Messages.XMLPivotComparisonFactory_Label;
  }

  /**
   * @see org.polarsys.capella.compare.CapellaComparisonFactory#getOverridenClasses()
   */
  @Override
  public Collection<Class<?>> getOverridenClasses() {
    return Collections.emptySet();
  }

  /**
   * @see org.polarsys.capella.compare.CapellaComparisonFactory#createComparisonSpecification(org.eclipse.emf.diffmerge.ui.specification.IScopeSpecification, org.eclipse.emf.diffmerge.ui.specification.IScopeSpecification, org.eclipse.emf.diffmerge.ui.specification.IScopeSpecification)
   */
  @Override
  public IComparisonMethod createComparisonMethod(IModelScopeDefinition leftScopeSpec_p, IModelScopeDefinition rightScopeSpec_p,
      IModelScopeDefinition ancestorScopeSpec_p) {
    return new XMLPivotComparisonMethod(leftScopeSpec_p, rightScopeSpec_p, ancestorScopeSpec_p);
  }

}
