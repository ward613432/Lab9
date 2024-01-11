import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] dataPoints = new int[100];

        // init array
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = random.nextInt(100) + 1;
        }

        // display array & calculate additional points
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.printf("%s | ", dataPoints[i]);
        }

        // display info of data points
        System.out.printf("\nSum: %-8d\n", sum(dataPoints));
        System.out.printf("Average: %-8f\n", (double) sum(dataPoints)/dataPoints.length);
        System.out.printf("Min: %-8d\n", min(dataPoints));
        System.out.printf("Max: %-8d\n", max(dataPoints));

        // iterate to find count mentions of user input (1-100) in data points
        int userValue = InputHelper.getRangedInt(scanner, "Input a value 1-100", 1, 100);
        System.out.printf("The value %d was displayed %d times.\n", userValue, occurenceScan(dataPoints, userValue, false));

        // iterate to find index of first mention of user input (1-100) in data points
        userValue = InputHelper.getRangedInt(scanner, "Input a value 1-100", 1, 100);

        if (contains(dataPoints, userValue)) {
            System.out.printf("The value %d was first mentioned at index %d", userValue, occurenceScan(dataPoints, userValue, true));
        } else {
            System.out.printf("The value %d was never mentioned in dataPoints.\n", userValue);
        }
    }

    public static int min(int values[]) {
        int min = 101;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < min) { min = values[i]; }
        }
        return min;
    }

    public static int max(int values[]) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) { max = values[i]; }
        }
        return max;
    }

    public static int occurenceScan(int values[], int target, boolean returnFirstOccurence) {
        int occurences = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                if (returnFirstOccurence) {
                    return i;
                } else {
                    occurences++;
                }
            }
        }
        return occurences;
    }

    public static int sum (int values[]) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    public static boolean contains(int values[], int target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                return true;
            }
        }
        return false;
    }
}