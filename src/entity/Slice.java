package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Slice {

	private List<Cell> cellList = new ArrayList<>();

	private Point p;
	private Point q;

	public Slice(List<Cell> cellList) {
		super();
		this.cellList = cellList;
	}

	public Slice(Point a, Point b) {
		super();
		
		if (a.getX() >= b.getX()) {
			if (a.getY() >= b.getY()) {
				p = new Point(b.getX(), b.getY());
				q = new Point(a.getX(), a.getY());
			} else {
				p = new Point(b.getX(), a.getY());
				q = new Point(a.getX(), b.getY());
			}
		} else {
			if (a.getY() >= b.getY()) {
				p = new Point(a.getX(), b.getY());
				q = new Point(b.getX(), a.getY());
			} else {
				p = new Point(a.getX(), a.getY());
				q = new Point(b.getX(), b.getY());
			}
		}
		
	}

	public List<Cell> getCellList() {
		return cellList;
	}

	public void setCellList(List<Cell> cellList) {
		this.cellList = cellList;
	}

	public Point getP()
	{
		return p;
	}

	public void setP(Point p)
	{
		this.p = p;
	}

	public Point getQ()
	{
		return q;
	}

	public void setQ(Point q)
	{
		this.q = q;
	}
	
	public int getScore()
	{

		int deltaX = Math.abs(q.getX() - p.getX());
		int deltaY = Math.abs(q.getY() - p.getY());

		return deltaX * deltaY;

	}
	
	public static boolean checkAvailability(Cell a, Cell b, Pizza pizza) {
		
		Point p, q;
		
		if (a.getX() >= b.getX()) {
			if (a.getY() >= b.getY()) {
				p = new Point(b.getX(), b.getY());
				q = new Point(a.getX(), a.getY());
			} else {
				p = new Point(b.getX(), a.getY());
				q = new Point(a.getX(), b.getY());
			}
		} else {
			if (a.getY() >= b.getY()) {
				p = new Point(a.getX(), b.getY());
				q = new Point(b.getX(), a.getY());
			} else {
				p = new Point(a.getX(), a.getY());
				q = new Point(b.getX(), b.getY());
			}
		}
		
		for (int i = p.getX(); i <= q.getX(); i++)
		{
			for (int j = p.getY(); j <= q.getY(); j++)
			{
				Optional<Cell> optionalCell = pizza.getCell(i, j);
				Cell fixedCell = null;
				if (optionalCell.isPresent()) {
					fixedCell = optionalCell.get();
				}
				
				if (!fixedCell.isAvailable()) {
					return false;
				}
			}
		}
		
		for (int i = p.getX(); i <= q.getX(); i++)
		{
			for (int j = p.getY(); j <= q.getY(); j++)
			{
				Optional<Cell> optionalCell = pizza.getCell(i, j);
				Cell fixedCell = null;
				if (optionalCell.isPresent()) {
					fixedCell = optionalCell.get();
					fixedCell.setAvailable(false);
				}
			}
		}
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Slice [p(" + p.getX() + ", " + p.getY() + "); q(" + q.getX() + ", " + q.getY() + ")]";
	}
	
}
