import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("getIndexesByNumber " + Arrays.toString(getIndexesByNumber(11, -11, 7, 3, 2, 1, 7, -10, 11, 21, 3)));
        System.out.println("getIndexesByNumber " + Arrays.toString(getIndexesByNumber(23, 3, 8, 15, 17)));
        System.out.println("getIndexesByNumber " + Arrays.toString(getIndexesByNumber(20, 3, 8, 15, 17)));
        System.out.println("getIndexesByNumber " + Arrays.toString(getIndexesByNumber(6, 3, 2, 3, 10)));

        System.out.println("containsDuplicates " + containsDuplicates(4, 5, 6, 6, 8));
        System.out.println("containsDuplicates " + containsDuplicates(4, 5, 6, 7, 8));
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
            if (array[j] + array[array.length / 2+1] == number) {
                return new int[]{array.length / 2+1, j};
            }
            if (array[j - 1] + array[array.length / 2+1] == number) {
                return new int[]{array.length / 2+1, j - 1};
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

    static boolean containsDuplicates(int... array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
