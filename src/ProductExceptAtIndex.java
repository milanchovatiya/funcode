import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ProductExceptAtIndex {


    public static void main(String[] args) {


        for(Integer i : getProductsOfAllIntsExceptAtIndex(new int[]{2, 4, 10})){
            System.out.print(i + " ");
        }



    }

    public static int[] getProductsOfAllIntsExceptAtIndexExtraSpace(int[] intArray) {

        if (intArray.length < 2) {
            throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
        }

        int[] productsOfAllIntsBeforeIndex = new int[intArray.length];

        // for each integer, find the product of all the integers
        // before it, storing the total product so far each time
        int productSoFar = 1;
        for (int i = 0; i < intArray.length; i++) {
            productsOfAllIntsBeforeIndex[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        int[] productsOfAllIntsAfterIndex = new int[intArray.length];

        productSoFar = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            productsOfAllIntsAfterIndex[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        // we make an array with the length of the input array to
        // hold our products
        int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            productsOfAllIntsExceptAtIndex[i] = productsOfAllIntsBeforeIndex[i] * productsOfAllIntsAfterIndex[i];
        }

        return productsOfAllIntsExceptAtIndex;
    }


    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        if (intArray.length < 2) {
            throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
        }

        // we make an array with the length of the input array to
        // hold our products
        int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];

        // for each integer, we find the product of all the integers
        // before it, storing the total product so far each time
        int productSoFar = 1;
        for (int i = 0; i < intArray.length; i++) {
            productsOfAllIntsExceptAtIndex[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        // for each integer, we find the product of all the integers
        // after it. since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        productSoFar = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            productsOfAllIntsExceptAtIndex[i] *= productSoFar;
            productSoFar *= intArray[i];
        }

        return productsOfAllIntsExceptAtIndex;
    }
}
