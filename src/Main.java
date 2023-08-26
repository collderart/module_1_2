import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("getIndexesByNumber " + Arrays.toString(getIndexesByNumber(11, -11, 7, 3, 2, 1, 7, -10, 11, 21, 3)));
        System.out.println("getIndexesByNumber " + Arrays.toString(getIndexesByNumber(23, 3, 8, 15, 17)));
        System.out.println("getIndexesByNumber " + Arrays.toString(getIndexesByNumber(20, 3, 8, 15, 17)));
        System.out.println("getIndexesByNumber " + Arrays.toString(getIndexesByNumber(6, 3, 2, 3, 10)));

        System.out.println("containsDuplicatesV1 " + containsDuplicatesV1(4, 5, 6, 6, 8));
        System.out.println("containsDuplicatesV1 " + containsDuplicatesV1(4, 5, 6, 7, 8));
        System.out.println("containsDuplicatesV2 " + containsDuplicatesV2(4, 5, 6, 6, 8));
        System.out.println("containsDuplicatesV2 " + containsDuplicatesV2(4, 5, 6, 7, 8));
    }

    static int[] getIndexesByNumber(int number, int... array) {
//        17, 15, 3, 8
        boolean switcher = true;
        for (int i = 0, j = array.length - 1; i < array.length / 2 && j > i; ) {
            if (array[i] + array[j] == number) {
                return new int[]{i, j};
            }
            if (array[i] + array[j - 1] == number) {
                return new int[]{i, j - 1};
            }
            if (array[i + 1] + array[j] == number) {
                return new int[]{i + 1, j};
            }
            if (array[i + 1] + array[j - 1] == number) {
                return new int[]{i + 1, j - 1};
            }
            if (array[i] + array[i + 1] == number) {
                return new int[]{i, i + 1};
            }
            if (array[j] + array[j - 1] == number) {
                return new int[]{j - 1, j};
            }
            if (array[i] + array[array.length / 2] == number) {
                return new int[]{i, array.length / 2};
            }
            if (array[i + 1] + array[array.length / 2] == number) {
                return new int[]{i + 1, array.length / 2};
            }
            if (array[j] + array[array.length / 2] == number) {
                return new int[]{array.length / 2, j};
            }
            if (array[j - 1] + array[array.length / 2] == number) {
                return new int[]{array.length / 2, j - 1};
            }
            if (array[j] + array[array.length / 2 + 1] == number) {
                return new int[]{array.length / 2 + 1, j};
            }
            if (array[j - 1] + array[array.length / 2 + 1] == number) {
                return new int[]{array.length / 2 + 1, j - 1};
            }
            if (switcher) {
                switcher = false;
                j--;
            } else {
                switcher = true;
                i++;
            }
        }
        return new int[0];
    }

    // both of these solutions passes all the tests from leetcode
    static boolean containsDuplicatesV1(int... array) {
        if (array.length <= 1) {
            return false;
        }
        if (array.length == 2) {
            return array[0] == array[1];
        }
        int[] sorted = Arrays.stream(array).sorted().toArray();
        for (int i = 0; i < sorted.length - 1; i++) {
            if (sorted[i] == sorted[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // this solution is faster
    static boolean containsDuplicatesV2(int... array) {
        if (array.length <= 1) {
            return false;
        }
        if (array.length == 2) {
            return array[0] == array[1];
        }
        Set<Integer> noDuplicates = new HashSet<>();
        noDuplicates.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (noDuplicates.contains(array[i])) {
                return true;
            }
            noDuplicates.add(array[i]);
        }
        return false;
    }
}
