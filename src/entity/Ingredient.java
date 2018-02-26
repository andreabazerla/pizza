package entity;

public enum Ingredient {

	MUSHROOM("M"), TOMATO("T");

	private final String type;

	Ingredient(final String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}

}
