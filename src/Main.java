import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import entity.Cell;
import entity.Instructions;
import entity.Pizza;
import entity.Point;
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
		Point cursor = new Point();
		
		while(true) {
		
			int x = random.nextInt(instructions.getColumns());
			int y = random.nextInt(instructions.getRows());
			
			optionalCell = pizza.getCell(x, y);
			if (optionalCell.isPresent()) {
				randomCell = optionalCell.get();
				if (randomCell.isAvailable()) {

					while(true) {
						int vx = randomCell.getX() + (random.nextInt(columns - randomCell.getX()) - randomCell.getX());
						int vy = randomCell.getY() + (random.nextInt(rows - randomCell.getY()) - randomCell.getY());
						
						if (vx == x && vy == y) {
							continue;
						}
						
						int deltaX = Math.abs(vx - x);
						int deltaY = Math.abs(vy - y);
						
						if (deltaX * deltaY > max) {
							continue;
						}
						

						randomCell.setAvailable(false);
						Optional<Cell> vectorCell = pizza.getCell(vx, vy);
						Cell fixedCell = null;
						if (vectorCell.isPresent()) {
							fixedCell = vectorCell.get();
							
							if (!Slice.checkAvailability(randomCell, fixedCell, pizza)) {
								continue;
							}
						}
						
						fixedCell.setAvailable(false);
						
						Slice slice = new Slice(randomCell, fixedCell);
						
						pizza.add(slice);
						
						System.out.println(slice);
					
					}
					
				} else {
					continue;
				}
			}
	
		}
		
	}

}
