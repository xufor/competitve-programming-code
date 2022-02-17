import java.util.Arrays;
import java.util.LinkedList;

class TowerOfHanoiV1 {
    public static void toh(char source, char auxillary, char destination,
            int numberOfDisks) {

        if (numberOfDisks == 0) {
            return;
        }
        toh(source, destination, auxillary, numberOfDisks - 1);
        System.out.println(source + " -> " + destination);
        toh(auxillary, source, destination, numberOfDisks - 1);
    }
}

class TowerOfHanoiV2 {
    public static void toh(LinkedList<Integer> source, LinkedList<Integer> auxillary, LinkedList<Integer> destination,
            int numberOfDisks) {

        if (numberOfDisks == 0) {
            return;
        }
        toh(source, destination, auxillary, numberOfDisks - 1);
        destination.addFirst(source.removeFirst());
        toh(auxillary, source, destination, numberOfDisks - 1);
    }
}

class TowerOfHanoiV3 {
    public static void toh(LinkedList<Integer> source, LinkedList<Integer> auxillary, LinkedList<Integer> destination,
            int numberOfDisks) {
        if (numberOfDisks == 1) {
            destination.addFirst(source.removeFirst());
            return;
        }
        // in this example we realize that a n shift operation is equivalent to
        // a series of (n-1), 1, (n-1) shift operation
        toh(source, destination, auxillary, numberOfDisks - 1);
        toh(source, auxillary, destination, 1);
        toh(auxillary, source, destination, numberOfDisks - 1);
    }
}

class TowerOfHanoiV4 {
    public static void toh(LinkedList<Integer> source, LinkedList<Integer> auxillary, LinkedList<Integer> destination,
            int numberOfDisks) {
        if (numberOfDisks == 1) {
            destination.addFirst(source.removeFirst());
            return;
        } else if (numberOfDisks == 2) {
            // in this condition we reaalize that the three operations are
            // simply one shift operations and can be boiled down to to three 
            // one shift calls, thus this condition can be removed
            auxillary.addFirst(source.removeFirst());
            destination.addFirst(source.removeFirst());
            destination.addFirst(auxillary.removeFirst());
            return;
        }
        toh(source, destination, auxillary, numberOfDisks - 1);
        toh(source, auxillary, destination, 1);
        toh(auxillary, source, destination, numberOfDisks - 1);
    }
}

public class TowerOfHanoi {
    public static void main(String[] args) {
        LinkedList<Integer> towerA = new LinkedList<>();
        LinkedList<Integer> towerB = new LinkedList<>();
        LinkedList<Integer> towerC = new LinkedList<>();
        towerA.addAll(Arrays.asList(new Integer[] { 1, 2, 3 }));
        TowerOfHanoiV4.toh(towerA, towerB, towerC, towerA.size());
        System.out.println(towerA);
        System.out.println(towerB);
        System.out.println(towerC);

        TowerOfHanoiV1.toh('A', 'B', 'C', 3);
    }
}