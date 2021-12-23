package AmazonOA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class CouponProblem {

//    Amazon is running a promotion in which customers receive prizes for purchasing a secret combination of fruits. The combination will change each day, and the team running the promotion wants to use a code list to make it easy to change the combination. The code list contains groups of fruits. Both the order of the groups within the code list and the order of the fruits within the groups matter. However, between the groups of fruits, any number, and type of fruit is allowable. The term "anything" is used to allow for any type of fruit to appear in that location within the group.
//
//    Consider the following secret code list: [[apple, apple], [banana, anything, banana]]
//    Based on the above secret code list, a customer who made either of the following purchases would win the prize:
//    orange, apple, apple, banana, orange, banana
//            apple, apple, orange, orange, banana, apple, banana, banana
//
//    Write an algorithm to output 1 if the customer is a winner else output 0.

    @Test
    public void couponProblemTest() {
        String str = "apple,apple,orange,orange,banana,apple,banana,banana";
        List<String> shoppingCart = Stream.of(str.split(",", -1))
                .collect(Collectors.toList());
        String str1 = "banana,orange,banana,apple,apple";
        String str2 = "apple,banana,apple,banana,orange,banana";
        String str3 = "apple,apple,apple,banana";


        List<List<String>> codeList = Arrays
                .asList(Arrays.asList("apple", "apple"), Arrays.asList("banana", "anything", "banana"));
        List<List<String>> codeList1 = Arrays.asList(Arrays.asList("apple", "apple"), Arrays.asList("apple", "apple", "banana"));
        Assert.assertTrue(doesCustomerWins(codeList, Arrays.asList("orange", "apple", "apple", "banana", "orange", "banana")));
        Assert.assertTrue(doesCustomerWins(codeList, Stream.of(str.split(",", -1))
                .collect(Collectors.toList())));
        Assert.assertFalse(doesCustomerWins(codeList, Stream.of(str1.split(",", -1))
                .collect(Collectors.toList())));
        Assert.assertFalse(doesCustomerWins(codeList, Stream.of(str2.split(",", -1))
                .collect(Collectors.toList())));
        Assert.assertFalse(doesCustomerWins(codeList1, Stream.of(str3.split(",", -1))
                .collect(Collectors.toList())));
    }
    public static boolean doesCustomerWins(List<List<String>> codeList, List<String> shoppingCart){
        int index = 0;
        for(List<String> code : codeList) {
            index = doesCodeExist(code, shoppingCart, index);
            if(index == -1){
                return false;
            }
        }

        return true;
    }

    public static int doesCodeExist(List<String> code, List<String> shoppingCart, int k){
        int j = 0;
        for(int i = k; i < shoppingCart.size(); i++){
            int index = i;
            while(j < code.size() && index < shoppingCart.size() && (shoppingCart.get(index).equals(code.get(j)) || code.get(j).equals("anything"))) {
                j++;
                index++;
            }
            if(j == code.size()) {
                return index;
            } else {
                j = 0;
            }

        }

        return -1;
    }

}
