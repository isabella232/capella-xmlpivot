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

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.ComponentPkg;
import org.polarsys.capella.core.data.cs.CsFactory;
import org.polarsys.capella.core.data.cs.Part;

/**
 */
public class ProjectRepairUtil {

  final ComposedAdapterFactory factory;
  
  public ProjectRepairUtil(CapellacommonModelWalkerFactory capellacommonFactory,
    CapellamodellerModelWalkerFactory capellamodellerFactory,
    OaModelWalkerFactory oaFactory,
    LaModelWalkerFactory laFactory,
    PaModelWalkerFactory paFactory,
    CtxModelWalkerFactory ctxFactory,
    InformationModelWalkerFactory informationFactory,
    EpbsModelWalkerFactory epbsFactory,
    CsModelWalkerFactory csFactory){
      factory = new ComposedAdapterFactory();
      factory.addAdapterFactory(capellacommonFactory);
      factory.addAdapterFactory(capellamodellerFactory);
      factory.addAdapterFactory(oaFactory);
      factory.addAdapterFactory(laFactory);
      factory.addAdapterFactory(paFactory);
      factory.addAdapterFactory(ctxFactory);
      factory.addAdapterFactory(informationFactory);
      factory.addAdapterFactory(epbsFactory);
      factory.addAdapterFactory(csFactory);
  }
  
  public void repair(EObject e, ModelWalkerHelper helper){
      
    repairImpl(e, factory, helper);
    repairImpl(e, factory, helper); // FIXME weird, but necessary for now
    addMissingParts(e);
  }

  
  private void addMissingParts(EObject e) {
    Collection<Component> partPresent = new HashSet<Component>();
    Collection<Component> partMissing = new HashSet<Component>();
    for (Iterator<EObject> it = e.eAllContents(); it.hasNext();) {
      EObject next = it.next();
      if (next instanceof Part) {
        Part part = (Part) next;
        if (part.getType() instanceof Component) {
          if (!partMissing.remove(part.getType())){
            partPresent.add((Component) part.getType());
          }
        }
      } else if (next instanceof Component) {
        if (!partPresent.remove(next)) {
          partMissing.add((Component) next);
        }
      }
    }

    for (Component component : partMissing) {
      Part  p = CsFactory.eINSTANCE.createPart();
      p.setAbstractType(component);
      if (component.eContainer() instanceof ComponentPkg) {
        ((ComponentPkg) component.eContainer()).getOwnedParts().add(p);
      } else if (component.eContainer() instanceof Component) {
        ((Component) component.eContainer()).getOwnedFeatures().add(p);
      }
    }
  }

  private void repairImpl(EObject e, AdapterFactory f, ModelWalkerHelper helper){
    Deque<EObject> queue = new ArrayDeque<EObject>();
    queue.add(e);
    while (!queue.isEmpty()){
      EObject next = queue.pop();
      ModelWalker walker = (ModelWalker) f.adapt(next, ModelWalker.class);
      if (walker != null){
        walker.accept(next, helper);
      }
      queue.addAll(next.eContents());
    }
  }

}
