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
        // amount of plutonium the ship can hold at maximum
        // Init
        final int MAX_PLUTONIUM = 3;
        final int INITIAL_PLUTONIUM = MAX_PLUTONIUM;
        int startpoint;
        int nrReachablePlanets = 0;

        class Planet {
            List<Integer> nextPlanets = new ArrayList<>();
        }
        // planets[i] contains next planets
        Planet[] planets = new Planet[T.length];
        // hasFuel[i] indicates fuel availability
        boolean[] hasFuel = B;

        class SpaceCraftStop {
            int planet; // current position
            int fuel;

            SpaceCraftStop(int planet, int fuel) {
                System.out.printf("next %2d = fuel %2d\n", planet, fuel);

                this.planet = planet;
                // refuel if this planet has fuel
                this.fuel = Integer.max(fuel, hasFuel[planet] ? MAX_PLUTONIUM : 0);
            }
        }
        // Track position and fuel amount
        List<SpaceCraftStop> spaceCraftStops = new ArrayList<>();

        // create graph of planets and get starting point
        for (int i = 0; i < T.length; i++) {
            if (planets[T[i]] == null) {
                planets[T[i]] = new Planet();
            }
            planets[T[i]].nextPlanets.add(i);

            if (i == T[i]) {
                nrReachablePlanets = 1;
                spaceCraftStops.add(new SpaceCraftStop(i, INITIAL_PLUTONIUM));
            }
        }

        int currentPlanet, currentFuel;
        SpaceCraftStop newStop;
        // if there is no starting point, STOP
        while (spaceCraftStops.size() > 0) {
            currentPlanet = spaceCraftStops.get(0).planet;
            currentFuel = spaceCraftStops.get(0).fuel;
            System.out.printf("curPlanet %2d = fuel %2d\n", currentPlanet, currentFuel);
            spaceCraftStops.remove(0);
            // are there any successors for this planet?
            if (Objects.nonNull(planets[currentPlanet])) {
                // create stop for every planet that is reachable from the current planet
                for (int nextPlanet : planets[currentPlanet].nextPlanets) {
                    // don't go back to the planet we came from
                    if (nextPlanet == currentPlanet || currentFuel == 0) {
                        continue;
                    }
                    newStop = new SpaceCraftStop(nextPlanet, currentFuel - 1);
                    nrReachablePlanets++;
                    spaceCraftStops.add(newStop);
                }
            }
        }

        return nrReachablePlanets;
    }
}

