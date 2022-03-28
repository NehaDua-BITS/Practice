package dsa.easy.array;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
        int[] digits = {4,4,9,9};
        int[] result = obj.plusOne(digits);

        System.out.println("Resultant array after PlusOne = " + Arrays.toString(result));
    }

    public int[] plusOne(int[] digits) {

        int length = digits.length;
        int carryForward = 1;
        for (int i = length - 1; carryForward > 0 && i >= 0; i--) {
            int sum = digits[i] + carryForward;
            carryForward = sum / 10;
            digits[i] = sum % 10;
        }

        //if there is overall carry forward
        if (carryForward > 0) {
            int[] result = new int[length+1];
            result[0] = carryForward;
            for (int i = 0; i < length; i++) {
                result[i+1] = digits[i];
            }
            return result;
        }

        return digits;
    }

    //expensive due to boxing, unboxing and streaming
//    private int[] plusOne(int[] digits) {
//        if(digits == null) {
//            return null;
//        }
//
//        int length = digits.length;
//        int carryForward = 1;
//        for (int i = length - 1; carryForward > 0 && i >=0; i--) {
//            digits[i] += carryForward;
//            carryForward = digits[i] / 10;
//            digits[i] %= 10;
//        }
//
//        //if there is overall carry forward
//        if (carryForward > 0) {
//            //List<Integer> list = Arrays.stream(digits).boxed().collect(Collectors.toList());
//            List<Integer> list = new ArrayList<>(length+1);
//            list.add(carryForward);
//            list.addAll(IntStream.of(digits).boxed().collect(Collectors.toList()));
//            System.out.println("list after insertion = " + Arrays.toString(list.toArray()));
//            return list.stream().mapToInt(x -> x.intValue()).toArray();
//        }
//
//        return digits;
//    }
}
