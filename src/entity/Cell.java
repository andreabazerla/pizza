package entity;

public class Cell extends Point {

	private Ingredient ingredient;
	private boolean available;
	private boolean checked;
	private boolean stop;
	private boolean exit;
	
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

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	@Override
	public String toString() {
		return ingredient.toString();
	}

}
