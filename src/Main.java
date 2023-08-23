import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("getIndexesByNumber " + Arrays.toString(getIndexesByNumber(23, 15, 17, 8, 3)));
        System.out.println("getIndexesByNumber " + Arrays.toString(getIndexesByNumber(44, 15, 17, 8, 3, 6, 40, 12, 32)));

        System.out.println("containsDuplicates " + containsDuplicates(4,5,6,6,8));
        System.out.println("containsDuplicates " + containsDuplicates(4,5,6,7,8));
    }

    static int[] getIndexesByNumber(int number, int... array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == number) {
                    return new int[]{i, j};
                }
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
