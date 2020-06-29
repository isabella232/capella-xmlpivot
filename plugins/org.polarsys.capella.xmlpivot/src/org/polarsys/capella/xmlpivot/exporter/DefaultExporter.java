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

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;

/** <p>
* <strong>EXPERIMENTAL</strong>. This class or interface has been added as
* part of a work in progress. There is no guarantee that this API will
* work or that it will remain the same. Please do not use this API without
* consulting with the Capella team.
* </p>
*/
public class DefaultExporter extends AbstractExporter {

	/**
	 * @param engine
	 */
	public DefaultExporter(ExportEngine engine) {
		super(engine);
	}

	

	@Override
  protected void doCopyObjects(Collection<? extends EObject> context, IProgressMonitor monitor){
	  SubMonitor subMonitor = SubMonitor.convert(monitor, 10 * context.size());
		for (EObject e : context){
			getExportEngine().copy(e);
			subMonitor.worked(10);
		}
	}
	
}
