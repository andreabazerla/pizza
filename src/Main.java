import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import entity.Cell;
import entity.Instructions;
import entity.Pizza;
import entity.Slice;
import utils.Parser;

public class Main {

	// private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws IOException {

		// TODO Create constant builder
		// slicePizza(EXAMPLE_INPUT_FILE, EXAMPLE_OUTPUT_FILE);

		slicePizzaGreedy("input/example.in", "output/example.in");

	}

	private static void slicePizzaGreedy(String inputFile, String outputFile) throws IOException {

		Instructions instructions = Parser.parseInstructions(inputFile);
		System.out.println(instructions.toString());

		Pizza pizza = new Pizza(new File(inputFile), instructions, Parser.parsePizza(inputFile), new ArrayList<>());
		System.out.println(pizza.toString());

		int rows = instructions.getRows();
		int columns = instructions.getColumns();
		int min = instructions.getMin();
		int max = instructions.getMax();
		Random random = new Random();
		Optional<Cell> optionalCell;
		Cell randomCell;
		int exit = 0;

		while (pizza.getTotalScore() < columns * rows) {

			int stop = 0;

			while (true) {

				if (stop >= columns * rows) {
					pizza.reset();
					break;
				}

				int x = random.nextInt(instructions.getColumns());
				int y = random.nextInt(instructions.getRows());

				optionalCell = pizza.getCell(x, y);
				if (optionalCell.isPresent()) {
					randomCell = optionalCell.get();
					if (randomCell.isAvailable()) {

						if (!randomCell.isStop()) {

							int checked = 0;

							while (true) {

								if (checked >= (Math.min(columns, max) - randomCell.getX())
										* (Math.min(rows, max) - randomCell.getY()) - 1) {
									randomCell.setStop(true);
									pizza.resetChecked();
									checked = 0;
									stop++;
									break;
								}

								int vx = randomCell.getX() + random.nextInt(Math.min(columns, max) - randomCell.getX());
								int vy = randomCell.getY() + random.nextInt(Math.min(rows, max) - randomCell.getY());

								if (vx < x || vy < y) {
									continue;
								} else {
									if (vx == x && vy == y) {
										continue;
									}
								}

								Optional<Cell> vectorCell = pizza.getCell(vx, vy);
								Cell fixedCell = null;
								if (vectorCell.isPresent()) {
									fixedCell = vectorCell.get();

									if (!fixedCell.isChecked()) {
										fixedCell.setChecked(true);
										checked++;

										Slice slice = new Slice(randomCell, fixedCell);
										if (slice.checkAvailability(randomCell, fixedCell, pizza)) {
											System.out.println(slice);
											pizza.add(slice);
											System.out.println("Score: " + pizza.getTotalScore());
											break;
										} else {
											continue;
										}
									}
								}
							}
						}
					} else {
						stop++;
						continue;
					}
				}
			}
			System.out.println("RESET");
		}
		System.out.println("END");
	}
}