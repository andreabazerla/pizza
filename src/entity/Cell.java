package entity;

public class Cell extends Point {

	private Ingredient ingredient;
	private boolean available;

	public Cell(int x, int y, Ingredient ingredient, boolean available) {
		super(x, y);
		this.ingredient = ingredient;
		this.available = available;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return ingredient.toString();
	}

}
