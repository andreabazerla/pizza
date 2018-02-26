package entity;

import java.io.File;
import java.io.IOException;

import utils.Parser;

public class Main {

	// TODO Implement log4j properties
	// private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

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
