package AmazonOA;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class ShoppingOptions {

    int result = 0;

    @Test
    public void shoppingOptionsTest() {

        List<List<Integer>> options = Arrays.asList(Arrays.asList(2, 3), Arrays.asList(4), Arrays.asList(2, 3), Arrays.asList(1, 2));
        getAllShoppingOptions(options, 10, 0);
        System.out.println(result);
        //assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }

    private void getAllShoppingOptions(List<List<Integer>> options, int dollars, int index) {
        if(dollars < 0)
            return;
        if(index >= options.size()){
            result += 1;
            return;
        }
        for(Integer product : options.get(index)) {
            getAllShoppingOptions(options, dollars - product, index + 1);
        }
    }


}
