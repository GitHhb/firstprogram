package asml.codility;

public class SolutionStartFromEndv2 {
    static final byte MAX_FUEL = 13; // maximum fuel amount the spaceship can hold + 10
    static final byte MIN_FUEL = 10; // minimum fuel amount the spaceship can hold + 10
    static final byte FUEL_LEVEL_UNKNOWN = 0;
    static final byte UNREACHABLE = -1;

    public int solution(int[] T, boolean[] B) {

        // INIT fuelreserves of spaceship to 0
        byte[] fuelLeft = new byte[T.length];

        int nrReachablePlanets = 0;

        // INIT path
        int[] path = new int[T.length];
        int iPath; // index into path
        int planet, nrNodesVisited = 0;

        // grab a planet, trace route back towards startplanet,
        // but stop when reached a planet where the ship fuel reserves are known
        forloop:
        for (int i = 0; i < T.length && nrNodesVisited < T.length; i++) {
            if (fuelLeft[i] != FUEL_LEVEL_UNKNOWN) {
                continue;
            }
            planet = i;
            iPath = 0;
            while (fuelLeft[planet] == FUEL_LEVEL_UNKNOWN) {
                // INIT fuel left on planet, unreachable by default until we find a path
                fuelLeft[planet] = UNREACHABLE;
                path[iPath] = planet;
                iPath++;
                nrNodesVisited++;
                // goto next planet
                planet = T[planet];
            }
            // if we arrived at a start planet, then initialise
            if (path[iPath - 1] == T[path[iPath - 1]]) {
                nrReachablePlanets++;
                if (B[path[iPath - 1]] == false) {
                    // no fuel at the startplanet, so we can't reach any other planet
                    break forloop;
                }
                fuelLeft[path[iPath - 1]] = B[path[iPath - 1]] ? MAX_FUEL : MIN_FUEL;
                iPath--;
            }
            // follow path from startpoint to endpoint and update fuel reserves at each planet
            while (iPath > 0) {
                iPath--;
                planet = path[iPath];
                if (fuelLeft[T[planet]] > MIN_FUEL) {
                    // still fuel left to reach this planet
                    fuelLeft[planet] = B[planet] ? MAX_FUEL : (byte) (fuelLeft[T[planet]] - 1);
                    nrReachablePlanets++;
                } else {
                    break;
                }
            }
        }
        return nrReachablePlanets;
    }

    void printit(String message, byte[] arr, int iPath) {
        System.out.printf("%10s - ", message);
        for (int i = 0; i < iPath; i++) {
            System.out.printf("%2d ", arr[i]);
        }
        System.out.println();
    }

    void printit(String message, int[] arr, int iPath) {
        System.out.printf("%10s - ", message);
        for (int i = 0; i < iPath; i++) {
            System.out.printf("%2d ", arr[i]);
        }
        System.out.println();
    }

}
