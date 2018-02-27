package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Slice {

	private List<Cell> cellList = new ArrayList<>();

	private Cell a;
	private Cell b;

	public Slice(List<Cell> cellList) {
		super();
		this.cellList = cellList;
	}

	public Slice(Cell a, Cell b) {
		super();
		this.a = a;
		this.b = b;
	}

	public List<Cell> getCellList() {
		return cellList;
	}

	public void setCellList(List<Cell> cellList) {
		this.cellList = cellList;
	}

	public Cell getA() {
		return a;
	}

	public void setA(Cell a) {
		this.a = a;
	}

	public Cell getB() {
		return b;
	}

	public void setB(Cell b) {
		this.b = b;
	}

	public void right(Pizza pizza) {

		Optional<Cell> optionalCell = pizza.getCell(this.getA().getX() + 1, this.getA().getY());
		
		if (optionalCell.isPresent()) {
			Cell cell = optionalCell.get();
			
			if (cell.isAvailable()) {
				this.setB(cell);
				cellList.add(cell);
				cell.setAvailable(false);
			}
		}
	}

}
