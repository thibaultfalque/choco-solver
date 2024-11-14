/*
 * This file is part of choco-solver, http://choco-solver.org/
 *
 * Copyright (c) 2024, IMT Atlantique. All rights reserved.
 *
 * Licensed under the BSD 4-clause license.
 *
 * See LICENSE file in the project root for full license information.
 */
package org.chocosolver.solver.search.loop.monitors;

import org.chocosolver.solver.constraints.Constraint;

public interface IMonitorApprox extends ISearchMonitor {
	
	 void whenEffectiveFilteringChange(Constraint c, int oldValue, int newValue);
	 
	 void whenWDEGWeightChange(Constraint c, double oldValue, double newValue);
	 
	 void whenBacktrackingChange(Constraint c, int oldValue, int newValue);

}
