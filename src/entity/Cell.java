package entity;

public class Cell {

	private int x;
	private int y;
	private Ingredient ingredient;

	public Cell(int x, int y, Ingredient ingredient) {
		super();
		this.x = x;
		this.y = y;
		this.ingredient = ingredient;
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

	@Override
	public String toString() {
		return ingredient.toString();
	}

}
