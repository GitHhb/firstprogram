package asml.codility;

public class SolutionNoClass {
    final int MAX_PLUTONIUM = 3;

    public int solution(int[] T, boolean[] B) {

        // ********** INIT the graph representation we need

        int startNode = -1;
        // count occurrence of every node
        int[] countOccurArr = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            countOccurArr[T[i]]++;
            if (i == T[i]) {
                startNode = i;
            }
        }
        // no startnode found
        if (startNode == -1) {
            return 0;
        }
        // we won't let startnode point to itself
        countOccurArr[startNode]--;

        // create indexArr array to access
        int[] indexArr = new int[T.length + 1];
        for (int i = 1; i <= T.length; i++) {
            indexArr[i] = indexArr[i - 1] + countOccurArr[i - 1];
            countOccurArr[i - 1] = indexArr[i - 1];
        }

        // create the directed graph with startpoint as origin
        int[] nodesArr = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            if (i != T[i]) {
                nodesArr[countOccurArr[T[i]]] = i;
                countOccurArr[T[i]]++;
            }
        }

        // ********** Compute the reachable nodes

        // use indexArr to keep track of the current indexes
        // array countOccur not needed anymore, reuse it to keep track of the amount of fuel the spacecraft has
        int[] fuelAmountArr = countOccurArr;
        // queue with the nodes we need to inspect
        int[] nextNodesArr = new int[T.length];
        int indexNextNodes = 0;
        int nrReachableNodes = 0;

        // add startpoint to queue
        nextNodesArr[indexNextNodes] = startNode;
        fuelAmountArr[indexNextNodes] = refuelIfPossible(0, B[startNode]);
        nrReachableNodes++;
        indexNextNodes++;

        int i, node, fuel;
        while (indexNextNodes > 0) {
            // get a node from the queue
            node = nextNodesArr[indexNextNodes - 1];
            fuel = fuelAmountArr[indexNextNodes - 1];
            indexNextNodes--;

            // and process the successors of that node
            if (fuel > 0) {
                for (i = indexArr[node]; i < indexArr[node + 1]; i++) {
                    // add node to the queue
                    nextNodesArr[indexNextNodes] = nodesArr[i];
                    fuelAmountArr[indexNextNodes] = refuelIfPossible(fuel - 1, B[nodesArr[i]]);
                    indexNextNodes++;
                    nrReachableNodes++;
                }
            }
        }

        return nrReachableNodes;
    }

    int refuelIfPossible(int fuel, boolean hasFuel) {
        return hasFuel ? MAX_PLUTONIUM : fuel;
    }

    void printit(String s, int[] x) {
        printit(s, x, x.length);
    }

    void printit(String s, int[] x, int index) {
        System.out.printf("%10s - ", s);
        for (int i = 0; i < index; i++) {
            System.out.printf("%2d ", x[i]);
        }
        System.out.println();
    }
}
