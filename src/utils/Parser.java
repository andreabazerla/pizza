package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entity.Cell;
import entity.Ingredient;
import entity.Instructions;
import entity.Pizza;

public class Parser {

	public static Instructions parseInstructions(String file) {

		Instructions instructions = (Instructions) Default.OBJECT;

		try (FileReader fileReader = new FileReader(file)) {

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String instructionString;

			if ((instructionString = bufferedReader.readLine()) != null) {

				String[] instructionArray = instructionString.split(" ");

				int rows = Integer.parseInt(instructionArray[0]);
				int columns = Integer.parseInt(instructionArray[1]);
				int min = Integer.parseInt(instructionArray[2]);
				int max = Integer.parseInt(instructionArray[3]);

				instructions = new Instructions(rows, columns, min, max);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return instructions;

	}

	public static List<Cell> parsePizza(String file) throws IOException {

		try (FileReader fileReader = new FileReader(file)) {

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			bufferedReader.readLine();

			List<Cell> cells = new ArrayList<>();
			int row = 0;
			String fileLine;

			while ((fileLine = bufferedReader.readLine()) != null) {

				for (int column = 0; column < fileLine.length(); column++) {

					Character character = fileLine.charAt(column);
					if (character.toString().equals(Ingredient.MUSHROOM.toString())) {
						cells.add(new Cell(row, column, Ingredient.MUSHROOM, true));
					} else if (character.toString().equals(Ingredient.TOMATO.toString())) {
						cells.add(new Cell(row, column, Ingredient.TOMATO, true));
					}

				}

				row++;
			}

			return cells;
		}
	}

	public static class Cursor {

		private int x;
		private int y;

		public Cursor() {
			super();
		}

		public Cursor(int x, int y) {
			super();
			this.x = x;
			this.y = y;
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

	}

	public static void slicePizza(Pizza pizza) {

		Cursor cursor = new Cursor(0, 0);
		List<Cell> cellList = pizza.getCells();
		

		while(true) {
			cursor.setX(cursor.getX() + 1);
			
		}

	}

}
