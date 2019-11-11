package asml.codility;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {
    public int solution(int[] T, boolean[] B) {
        // write your code in Java SE 8

        // Init
        // amount of plutonium the ship can hold at maximum
        final int MAX_PLUTONIUM = 3;
        final int INITIAL_PLUTONIUM = 0;
        int nrReachablePlanets = 0;

        // Graph represented by array T will be transformed using class Planet.
        // We only are interested on quick access of successors of the starting point. Thus the graph will be created
        // as a directed graph with origin at the starting point.
        class Planet {
            List<Integer> nextPlanets = new ArrayList<>();
        }
        // planets[i] contains the planets reachable from planet i
        Planet[] planets = new Planet[T.length];
        // hasFuel[i] indicates fuel availability on planet i
        boolean[] hasFuel = B;

        // SpaceCraftStop keeps track of the planet where the spacecraft arrived and the remaining fuel amount.
        // If the planet has fuel storage, the spacecraft is refueled automatically.
        class SpaceCraftStop {
            int planet; // current position
            int fuel;   // amount of available fuel, after refuelling if possible

            SpaceCraftStop(int planet, int fuel) {

                this.planet = planet;
                // refuel if this planet has fuel
                this.fuel = Integer.max(fuel, hasFuel[planet] ? MAX_PLUTONIUM : 0);
            }
        }
        // SpaceCraftStops still to be processed
        List<SpaceCraftStop> spaceCraftStops = new ArrayList<>();

        // create graph of planets and get starting point
        for (int i = 0; i < T.length; i++) {
            // check for starting point
            if (i == T[i]) {
                nrReachablePlanets = 1;
                spaceCraftStops.add(new SpaceCraftStop(i, INITIAL_PLUTONIUM));
                // don't add starting point to graph
                continue;
            }

            // add planet to graph
            if (planets[T[i]] == null) {
                planets[T[i]] = new Planet();
            }
            planets[T[i]].nextPlanets.add(i);
        }

        // Start travelling
        SpaceCraftStop newStop, currentStop;
        while (spaceCraftStops.size() > 0) {
            currentStop = spaceCraftStops.get(0);
            spaceCraftStops.remove(0);
            // are there any successors for this planet?
            if (Objects.nonNull(planets[currentStop.planet])) {
                // add new stop for every planet that is reachable from the current planet
                for (int nextPlanet : planets[currentStop.planet].nextPlanets) {
                    // if spacecraft is out of fuel then stop at this planet
                    if (currentStop.fuel == 0) {
                        continue;
                    }
                    // currentStop.fuel > 1
                    newStop = new SpaceCraftStop(nextPlanet, currentStop.fuel - 1);
                    spaceCraftStops.add(newStop);
                    nrReachablePlanets++;
                }
            }
        }

        return nrReachablePlanets;
    }
}

