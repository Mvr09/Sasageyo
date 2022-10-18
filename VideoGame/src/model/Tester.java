package src.model;

import java.util.Arrays;

/**
 * Why: This is my playifield to try functions used in other places. I am submitting this merely to show advancements
 * as well as process
 */
public class Tester {
    public static void main(String[] args) {
        int[] test = new int[] { 1, 4, 3};
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(maxValues(test)));
        int a = maxInt(test);
        System.out.println(a);
    }
    public static int[] maxValues(int[] values) {
        int tempMax;//1
        int[] organizedValues = new int[values.length + 1];
        int[] finalValues = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            tempMax = maxInt(values);
            organizedValues[i] = tempMax;
            for (int j = 0; j < values.length; j++) {
                if (tempMax == values[j]) {
                    values[j] = 0;
                    break;
                }
            }
        }
        for (int i = 0; i < organizedValues.length-1; i++) {
            finalValues[i] = organizedValues[i];
        }
        return finalValues;
    }
    public static int maxInt(int[] values){
        int tempMax = values[0];
        for (int value : values) {
            if (value > tempMax) {
                tempMax = value;
            }
        }
        return tempMax;
    }
    }