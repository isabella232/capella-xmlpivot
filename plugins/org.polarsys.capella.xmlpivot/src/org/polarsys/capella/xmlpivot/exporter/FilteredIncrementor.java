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
package org.polarsys.capella.xmlpivot.exporter;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 */
public class FilteredIncrementor implements Function<Iterator<? extends EObject>, Iterator<? extends EObject>>{
  
  final Predicate<? super EObject> predicate;
  
  public FilteredIncrementor(Predicate<? super EObject> predicate_p){
    predicate = predicate_p;
  }
  
  @Override
  public Iterator<? extends EObject> apply(Iterator<? extends EObject> input_p) {
    return Iterators.filter(input_p, predicate);
  }

}
