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
package org.polarsys.capella.xmlpivot.common.predicates;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

import com.google.common.base.Function;

/**
 *
 */
public class EMFFunctions {

  /**
   * A Function that returns the label for an object. toString is used for anything that's not an EObject. Otherwise the objects
   * label provider is used.
   * 
   * FIXME unify this with ivv versioning functions, functions and predicates should all go into Capella core libraries
   */
  public static final Function<Object, String> LABEL_HELPER_FUNCTION = new Function<Object, String>(){
    @Override
    public String apply(Object input) {
      String result = "";
      if (input instanceof EObject){
        EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor((EObject) input);
        if (domain instanceof AdapterFactoryEditingDomain){
          IItemLabelProvider provider = (IItemLabelProvider) ((AdapterFactoryEditingDomain) domain).getAdapterFactory().adapt(input, IItemLabelProvider.class);
          if (provider != null){
            String text = provider.getText(input);
            if (text != null){
              result = text;
            }
          }
        }
      } else {
        result = input.toString();
      }
      return result;
    }
  };
  
  
}
