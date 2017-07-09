package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingOffers {
	public static void main(String[] args) {
		List<Integer> price = new ArrayList<>(Arrays.asList(2, 3, 4));

		List<List<Integer>> special = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		cur.add(1);
		cur.add(1);
		cur.add(0);
		cur.add(4);
		special.add(cur);

		cur = new ArrayList<>();
		cur.add(2);
		cur.add(2);
		cur.add(1);
		cur.add(9);
		special.add(cur);

		List<Integer> needs = new ArrayList<>(Arrays.asList(1, 2, 1));
		ShoppingOffers sp = new ShoppingOffers();
		System.out.println(sp.shoppingOffers(price, special, needs));
	}

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < special.size(); i++) {
			List<Integer> offer = special.get(i);
			boolean invalidOffer = false;
			for(int j = 0; j < needs.size(); j++) {
				int remain = needs.get(j) - offer.get(j);
				needs.set(j, remain);
				if(!invalidOffer && remain < 0) invalidOffer = true;
			}
			if(!invalidOffer) {
				result = Math.min(result, shoppingOffers(price, special, needs) + offer.get(needs.size()));
			}
			for(int j = 0; j < needs.size(); j++) {
				int remain = needs.get(j) + offer.get(j);
				needs.set(j, remain);
			}
		}

		int nonOfferPrice = 0;
		for(int i = 0; i < needs.size(); i++) {
			nonOfferPrice += price.get(i) * needs.get(i);
		}
		return Math.min(result, nonOfferPrice);
	}
}
