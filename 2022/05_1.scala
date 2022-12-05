import scala.io.Source; // library to read input file in
import scala.collection.mutable.Stack; // library for stack structure

object advent_of_code_2022_05_1 {
	def main(args: Array[String]): Unit = {

		// file as immutable list
		val lines = Source.fromFile("day_05.input").getLines().toList; 

		// starting stacks, hardcoded for ease
		var load = scala.collection.mutable.Map(
			1->Stack('S','L','F','Z','D','B','R','H'), 
			2->Stack('R','Z','M','B','T'),
			3->Stack('S','N','H','C','L','Z'),
			4->Stack('J','F','C','S'),
			5->Stack('B','Z','R','W','H','G','P'),
			6->Stack('T','M','N','D','G','Z','J','V'),
			7->Stack('Q','P','S','F','W','N','L','G'),
			8->Stack('R','Z','M'),
			9->Stack('T','R','V','G','L','C','M')
		);

		var count: Int = 0;
		
		for (line <- lines) {

			// parse out instructions
			val parsed_line = line.split(" ");
			val number_of_crates: Int = parsed_line(1).toInt;
			val from_stack: Int = parsed_line(3).toInt;
			val to_stack: Int = parsed_line(5).toInt;

			// move crates
			for (i <- 0 until number_of_crates) {
				val curr_crate = load(from_stack).pop();
				load(to_stack).push(curr_crate)
			}
		}

		// return result
		for (i <- 1 to 9) {
			val top = load(i).pop();
			print(top);
		}

		println()
	}

}