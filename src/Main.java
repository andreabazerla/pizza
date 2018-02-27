import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;
import entity.Instructions;
import entity.Pizza;
import utils.Parser;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws IOException {

		// TODO Create constant builder
		// slicePizza(EXAMPLE_INPUT_FILE, EXAMPLE_OUTPUT_FILE);

		slicePizza("input/example.in", "output/example.in");

	}

	private static void slicePizza(String inputFile, String outputFile) throws IOException {

		Instructions instructions = Parser.parseInstructions(inputFile);
		System.out.println(instructions.toString());

		Pizza pizza = new Pizza(new File(inputFile), instructions, Parser.parsePizza(inputFile));
		System.out.println(pizza.toString());
		
	}

}
