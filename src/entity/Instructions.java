package entity;

public class Instructions {

	private int rows;
	private int columns;

	private int min;
	private int max;

	public Instructions(int rows, int columns, int min, int max) {
		super();
		this.rows = rows;
		this.columns = columns;
		this.min = min;
		this.max = max;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	@Override
	public String toString() {
		return rows + " " + columns + " " + min + " " + max;
	}

}
