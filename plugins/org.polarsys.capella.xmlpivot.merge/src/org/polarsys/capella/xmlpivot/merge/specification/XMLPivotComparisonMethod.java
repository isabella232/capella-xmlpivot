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

import org.eclipse.emf.diffmerge.api.IDiffPolicy;
import org.eclipse.emf.diffmerge.api.IMatchPolicy;
import org.eclipse.emf.diffmerge.ui.specification.IModelScopeDefinition;
import org.polarsys.capella.core.compare.CapellaComparisonMethod;
import org.polarsys.capella.core.compare.CapellaDiffPolicy;
import org.polarsys.capella.xmlpivot.merge.specification.MultiCriteriaMatchPolicy.MatchCriterionKind;


/**
 * A Capella comparison method for re-import from XML Pivot format.
 */
public class XMLPivotComparisonMethod extends CapellaComparisonMethod {

  /**
   * Constructor
   * @param leftScopeSpec_p a non-null scope specification
   * @param rightScopeSpec_p a non-null scope specification
   * @param ancestorScopeSpec_p an optional scope specification
   */
  public XMLPivotComparisonMethod(IModelScopeDefinition leftScopeSpec_p, IModelScopeDefinition rightScopeSpec_p, IModelScopeDefinition ancestorScopeSpec_p) {
    super(leftScopeSpec_p, rightScopeSpec_p, ancestorScopeSpec_p, null);
  }

  /**
   * @see org.polarsys.capella.core.compare.CapellaComparisonMethod#createMatchPolicy()
   */
  @Override
  protected IMatchPolicy createMatchPolicy() {
    CapellaMultiCriteriaMatchPolicy result = new CapellaMultiCriteriaMatchPolicy();
    result.setUseMatchCriterion(MatchCriterionKind.EXTRINSIC_ID, false);
    result.setUseMatchCriterion(MatchCriterionKind.INTRINSIC_ID, true);
    result.setUseMatchCriterion(MatchCriterionKind.NAME, false);
    result.setUseMatchCriterion(MatchCriterionKind.STRUCTURE, false);
    result.setUseMatchCriterion(MatchCriterionKind.SEMANTICS, true);
    return result;
  }

  @Override
  protected IDiffPolicy createDiffPolicy() {
    return new XMLPivotDiffPolicy(new CapellaDiffPolicy());
  }

}
