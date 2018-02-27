package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import utils.Direction;

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

	public void move(Pizza pizza, Cell explorer, Direction direction) {

		Optional<Cell> optionalCell = null;
		
		switch (direction) {
			case RIGHT:
				optionalCell = pizza.getCell(explorer.getX() + 1, explorer.getY());
				break;
			default:
				break;
		}
				
		if (optionalCell.isPresent()) {
			Cell cell = optionalCell.get();
			
			if (cell.isAvailable()) {
				
				List<Cell> cellEdgeList = checkEdge(pizza, this.a, this.b, direction);
				if (cellEdgeList != null) {
					
				}
				
				this.setB(cell);
				fillSlice();
			}
		}
	}
	
	private List<Cell> checkEdge(Pizza pizza, Cell a, Cell b, Direction direction)	{
		
		List<Cell> cellEdgeList = new ArrayList<>();
		Cell temp;

		if (a.getX() > b.getX() || a.getY() < b.getY()) {
			temp = a;
			a = b;
			b = temp;
		}
		
		int deltaX;
		int deltaY;
		
		deltaX = b.getX() - a.getX();
		deltaY = b.getY() - a.getY();
		
		Optional<Cell> optionalCell = pizza.getCell(b.getX() - 1, b.getY());
		while (deltaX > 0) {
			if (optionalCell.isPresent()) {
				Cell cell = optionalCell.get();
				if (cell.isAvailable()) {
					cellEdgeList.add(cell);
					cell.setAvailable(false);
				} else {
					return null;
				}
			}
			
			deltaX--;
		}
		
		optionalCell = pizza.getCell(b.getX(), b.getY() + 1);
		while (deltaY > 0) {
			if (optionalCell.isPresent()) {
				Cell cell = optionalCell.get();
				if (cell.isAvailable()) {
					cellEdgeList.add(cell);
					cell.setAvailable(false);
				} else {
					return null;
				}
			}
			
			deltaY--;
		}
		
		cellEdgeList.add(b);
		b.setAvailable(false);
		
		return cellEdgeList;
		
	}

	public void fillSlice() {
		
	}

}
