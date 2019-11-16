package asml.codility;

public class SolutionStartFromEnd {
    static final byte MAX_FUEL = 3; // maximum fuel amount the spaceship can hold
    static final byte FUEL_LEVEL_UNKNOWN = MAX_FUEL + 1;

    public int solution(int[] T, boolean[] B) {

        int iteraties = 0;
        // To minimize use of memory combine status of:
        // - endpoints
        final byte PLANET_IS_NO_ENDPOINT = 1;
        final byte PLANET_IS_ENDPOINT = 0;
        // - remaining fuel

        // INIT value for all planets: PLANET_IS_ENDPOINT
        byte[] endpoints = new byte[T.length];

        // INIT fuelreserves of spaceship to 0
        byte[] fuelLeft = new byte[T.length];

        int startPlanet;
        int nrReachablePlanets = 0;
        // determine endpoints and startPlanet and INIT fuelLevel
        for (int i = 0; i < T.length; i++) {
            endpoints[T[i]] = PLANET_IS_NO_ENDPOINT;
            fuelLeft[i] = FUEL_LEVEL_UNKNOWN;
            if (i == T[i]) {
                // INIT fuel level on startPlanet
                fuelLeft[i] = B[i] ? MAX_FUEL : 0;
                nrReachablePlanets++;

            }
        }

        // INIT path
        int[] path = new int[T.length];
        int iPath = 0; // index into path
        int planet, nextPlanet, fuellevel;

        // find all endpoints
        for (int i = 0; i < T.length; i++) {
            // only create path is this planet is an endpoint
            if (endpoints[i] == PLANET_IS_NO_ENDPOINT) {
                continue;
            }
            // planet i is an endpoint
            // create paths with planets and fuel remaining from startpoint to endpoint
            // first create reverse path from endpoint to startpoint
            path[iPath] = i;
            iPath++;
            planet = i;
            while (fuelLeft[planet] == FUEL_LEVEL_UNKNOWN) {
                // goto next planet
                planet = T[planet];
                path[iPath] = planet;
                iPath++;
                iteraties++;
            }

            // follow path from startpoint to endpoint and update fuel reserves at each planet
            while (iPath > 1) {
                iPath--;
                planet = path[iPath];
                nextPlanet = path[iPath - 1];
                if (fuelLeft[planet] > 0) {
                    // still fuel left to reach next planet
                    fuelLeft[nextPlanet] = B[nextPlanet] ? MAX_FUEL : (byte) (fuelLeft[planet] - 1);
                    nrReachablePlanets++;
                } else {
                    // no fuel left to reach next planet
                    fuelLeft[nextPlanet] = -1;
                }
                iteraties++;
            }
            // reset path
            iPath--;
        }
//        System.out.println("Array size " + T.length);
//        System.out.println("Iteraties: " + iteraties);
        return nrReachablePlanets;
    }

    void printit(String message, byte[] arr){
        System.out.printf("%10s - ", message);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%2d ", arr[i]);
        }
        System.out.println();
    }

    void printit(String message, int[] arr){
        System.out.printf("%10s - ", message);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%2d ", arr[i]);
        }
        System.out.println();
    }

}
