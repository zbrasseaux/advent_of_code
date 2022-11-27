

import scala.io.Source; // library to read input file in

object advent_of_code_2021_02_1 {
	def main(args: Array[String]): Unit = {

		val lines = Source.fromFile("02_input.txt").getLines().toList; // file as immutable list
		var horizontal: Int = 0; // initialize variable
		var vertical: Int = 0; // initialize variable

		for (line <- lines) { // iterate over list by index
			var dir: String = line.split(" ")(0); // get direction
			var dist: Int = line.split(" ")(1).toInt; // get distance

			dir match { // switch - case
				case "up" => {vertical -= dist;}
				case "down" => {vertical += dist;}
				case "forward" => {horizontal += dist;}
			}
		}

		print(s"$vertical * $horizontal = ");
		println(vertical * horizontal); // result
	}
}