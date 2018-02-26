package entity;

import java.io.File;
import java.util.List;

public class Pizza {

	private final File file;
	private final Instructions instructions;
	private List<Cell> cells;

	public Pizza(File file, Instructions instructions, List<Cell> cells) {
		this.file = file;
		this.instructions = instructions;
		this.cells = cells;
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

}
