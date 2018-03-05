package entity;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class Pizza {

	private final File file;
	private final Instructions instructions;
	private List<Cell> cells;
	private List<Slice> slices;

	public Pizza(File file, Instructions instructions, List<Cell> cells, List<Slice> slices) {
		this.file = file;
		this.instructions = instructions;
		this.cells = cells;
		this.slices = slices;
	}

	public File getFile() {
		return file;
	}

	public Instructions getInstructions() {
		return instructions;
	}

	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}

	public List<Slice> getSlices() {
		return slices;
	}

	public void setSlices(List<Slice> slices) {
		this.slices = slices;
	}

	public Optional<Cell> getCell(int x, int y) {
		return cells.stream().filter(cell -> cell.getX() == x && cell.getY() == y).findFirst();
	}

	public void reset() {
		// for (Slice slice : slices) {
		// for (Cell cell : slice.getCellList()) {
		// cell.setAvailable(false);
		// cell.setChecked(false);
		// cell.setStop(false);
		// cell.setExit(false);
		// }
		// }

		for (Cell cell : cells) {
			cell.setAvailable(false);
			cell.setChecked(false);
			cell.setStop(false);
			cell.setExit(false);
		}
	}

	public void resetChecked() {
		// for (Slice slice : slices) {
		// for (Cell cell : slice.getCellList()) {
		// cell.setChecked(false);
		// }
		// }
		for (Cell cell : cells) {
			cell.setChecked(false);
		}
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		String[] array = new String[cells.size()];
		int index = 0;
		for (Cell cell : cells) {
			array[index] = cell.toString();
			index++;
		}

		index = 0;
		for (int i = 0; i < instructions.getRows(); i++) {
			for (int j = 0; j < instructions.getColumns(); j++) {
				stringBuilder.append(array[index].toString() + " ");
				index++;
			}

			stringBuilder.append("\n");
		}

		return stringBuilder.toString();
	}

	public void add(Slice slice) {
		this.slices.add(slice);
	}

	public int getTotalScore() {

		int score = 0;

		if (!this.getSlices().isEmpty()) {
			for (Slice slice : this.getSlices()) {
				score += slice.getScore();
			}
		}

		return score;
	}

	public Ingredient[][] getMatrix() {

		Ingredient[][] matrix = new Ingredient[instructions.getRows()][instructions.getColumns()];

		for (Cell cell : cells) {
			int x = cell.getX();
			int y = cell.getY();

			matrix[x][y] = cell.getIngredient();
		}

		return matrix;
	}

}
