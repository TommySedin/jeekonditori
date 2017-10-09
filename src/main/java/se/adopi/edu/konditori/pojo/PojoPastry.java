package se.adopi.edu.konditori.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.adopi.edu.konditori.Pastry;

public class PojoPastry implements Pastry {
	private static class Tuple {
		private Ingredient ingredient;
		private float amount;
		Tuple(Ingredient ingredient, float amount) {
			this.ingredient = ingredient;
			this.amount = amount;
		}
	}
	
	private String name;
	private float sellPrice;
	private Map<Ingredient, Float> ingredients;

	private PojoPastry(String name, float sellPrice, Tuple... ingredients) {
		this.name = name;
		this.sellPrice = sellPrice;
		this.ingredients = new HashMap<>();
		for (Tuple t : ingredients) {
			this.ingredients.put(t.ingredient, t.amount);
		}
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public float getSellPrice() {
		return sellPrice;
	}

	@Override
	public Map<Ingredient, Float> getIngredients() {
		return ingredients;
	}

	public static List<Pastry> getPastries() {
		List<Pastry> result = new ArrayList<>();

		PojoIngredient flour = new PojoIngredient("Vetemjöl", 5f);
		PojoIngredient egg = new PojoIngredient("Ägg", 0.5f);
		PojoIngredient sugar = new PojoIngredient("Socker", 2f);
		PojoIngredient milk = new PojoIngredient("Mjölk", 5f);

		result.add(new PojoPastry("Kanelbulle", 20,
						new Tuple(flour, 0.2f),
						new Tuple(sugar, 0.15f),
						new Tuple(milk, 0.1f),
						new Tuple(egg, 0.1f)));
		result.add(new PojoPastry("Sockerkaka", 10,
						new Tuple(flour, 0.15f),
						new Tuple(sugar, 0.15f),
						new Tuple(milk, 0.1f),
						new Tuple(egg, 0.2f)));
		result.add(new PojoPastry("Punschrulle", 15,
						new Tuple(flour, 0.1f),
						new Tuple(sugar, 0.15f),
						new Tuple(milk, 0.05f),
						new Tuple(egg, 0.1f)));
		
		return result;
	}
}
