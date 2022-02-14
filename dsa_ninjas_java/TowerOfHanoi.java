import java.util.Arrays;
import java.util.LinkedList;

public class TowerOfHanoi {
    public static void toh(LinkedList<Integer> source, LinkedList<Integer> auxillary, LinkedList<Integer> destination,
            int numberOfDisks) {

        if (numberOfDisks == 0) {
            return;
        }
        toh(source, destination, auxillary, numberOfDisks - 1);
        destination.addFirst(source.removeFirst());
        toh(auxillary, source, destination, numberOfDisks - 1);
    }

    public static void toh(char source, char auxillary, char destination,
            int numberOfDisks) {

        if (numberOfDisks == 0) {
            return;
        }
        toh(source, destination, auxillary, numberOfDisks - 1);
        System.out.println(source + " -> " + destination);
        toh(auxillary, source, destination, numberOfDisks - 1);
    }

    public static void main(String[] args) {
        LinkedList<Integer> towerA = new LinkedList<>();
        LinkedList<Integer> towerB = new LinkedList<>();
        LinkedList<Integer> towerC = new LinkedList<>();
        towerA.addAll(Arrays.asList(new Integer[] { 1, 2, 3 }));
        toh(towerA, towerB, towerC, towerA.size());
        System.out.println(towerA);
        System.out.println(towerB);
        System.out.println(towerC);
        
        toh('A', 'B', 'C', 3);
    }
}