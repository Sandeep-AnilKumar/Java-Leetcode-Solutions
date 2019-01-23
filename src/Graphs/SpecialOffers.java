package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialOffers {
    private int max = Integer.MAX_VALUE;

    public static void main(String[] args) {
        SpecialOffers specialOffers = new SpecialOffers();
        List<Integer> price = Arrays.asList(2, 3, 4);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9));
        List<Integer> needs = Arrays.asList(1, 2, 1);
        System.out.println("The minimum amount to buy all the items is := " + specialOffers.shoppingOffers(price,
                special, needs));

        price = Arrays.asList(2, 5);
        special = Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10));
        needs = Arrays.asList(3, 2);
        System.out.println("The minimum amount to buy all the items is := " + new SpecialOffers().shoppingOffers(price,
                special, needs));
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        max = Math.min(max, getPrice(price, needs));
        shoppingOffersHelper(price, special, needs, 0);
        return max == Integer.MAX_VALUE ? 0 : max;
    }

    private void shoppingOffersHelper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int cur) {
        boolean found = false;
        boolean maxedOut = false;
        int i = 0, a = 0;
        List<Integer> temp;
        for (List<Integer> o : special) {
            i = 0;
            maxedOut = false;
            temp = new ArrayList<>();
            for (int n : needs) {
                a = o.get(i++);
                if (a > n) {
                    maxedOut = true;
                    break;
                }
                n -= a;
                temp.add(n);
            }

            if (maxedOut) continue;
            found = true;
            shoppingOffersHelper(price, special, temp, cur + o.get(needs.size()));
        }

        if (!found) {
            max = Math.min(max, cur + getPrice(price, needs));
        }
    }

    private int getPrice(List<Integer> price, List<Integer> needs) {
        int i = 0, cur = 0;
        for (int n : needs) {
            cur += n * price.get(i++);
        }
        return cur;
    }
}
