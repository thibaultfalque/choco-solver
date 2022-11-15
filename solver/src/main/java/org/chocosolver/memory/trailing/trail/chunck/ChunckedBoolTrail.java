/*
 * This file is part of choco-solver, http://choco-solver.org/
 *
 * Copyright (c) 2022, IMT Atlantique. All rights reserved.
 *
 * Licensed under the BSD 4-clause license.
 *
 * See LICENSE file in the project root for full license information.
 */
package org.chocosolver.memory.trailing.trail.chunck;


import org.chocosolver.memory.trailing.StoredBool;
import org.chocosolver.memory.trailing.trail.IStoredBoolTrail;

import java.util.Arrays;

/**
 * A trail for integers.
 *
 * @author Fabien Hermenier
 * @author Charles Prud'homme
 * @since 29/05/2016
 */
public class ChunckedBoolTrail extends ChunckedTrail<BoolWorld> implements IStoredBoolTrail {

    private final int ws;

    /**
     * Load factor
     */
    private final double loadfactor;

    /**
     * Constructs a trail with predefined size and loadfactor
     * @param ws the initial world size
     * @param nbWorlds the initial number of worlds
     * @param loadfactor how to resize world
     */
    public ChunckedBoolTrail(int ws, int nbWorlds, double loadfactor) {
        worlds = new BoolWorld[nbWorlds];
        this.ws = ws;
        this.loadfactor = loadfactor;
        worlds[0] = current = new BoolWorld(ws, loadfactor);
    }

    @Override
    public void worldPush(int worldIndex) {
        if (worlds[worldIndex] == null) {
            current = new BoolWorld(ws, loadfactor);
            worlds[worldIndex] = current;
        } else {
            current = worlds[worldIndex];
            current.clear();
        }
        if (worldIndex == worlds.length - 1) {
            worlds = Arrays.copyOf(worlds, (int) (worlds.length * loadfactor));
        }
    }

    @Override
    public void savePreviousState(StoredBool v, boolean oldValue, int oldStamp) {
        current.savePreviousState(v, oldValue, oldStamp);
    }

}
