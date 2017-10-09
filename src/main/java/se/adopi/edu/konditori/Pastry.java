package se.adopi.edu.konditori;

import java.util.Map;

public interface Pastry {
	public interface Ingredient {
		public String getName();
		public float getPricePerUnit();
	}

	public String getName();
	public Map<Ingredient, Float> getIngredients();
	public float getSellPrice();

	public default float costToProduce() {
		float result = 0;
		Map<Ingredient, Float> ingredients = getIngredients();
		for (Ingredient i : ingredients.keySet()) {
			result += i.getPricePerUnit() * ingredients.get(i);
		}
		return result;
	}
}
