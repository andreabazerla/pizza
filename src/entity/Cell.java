package entity;

public class Cell {

	private int x;
	private int y;
	private Ingredient ingredient;
	private boolean available;

	public Cell(int x, int y, Ingredient ingredient, boolean available) {
		super();
		this.x = x;
		this.y = y;
		this.ingredient = ingredient;
		this.available = available;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
