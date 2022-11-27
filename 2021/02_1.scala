

import scala.io.Source; // library to read input file in

object advent_of_code_2021_02_1 {
	def main(args: Array[String]): Unit = {

		val lines = Source.fromFile("02_input.txt").getLines().toList; // file as immutable list
		var forward: Int = 0; // initialize variable
		var up: Int = 0; // initialize variable
		var down: Int = 0; // initialize variable

		for (line <- lines) { // iterate over list by index
			print(line);
			var dir: String = line.split(" ")(0); // get direction
			var dist: Int = line.split(" ")(1).toInt; // get distance

			dir match { // switch - case
				case "up" => {up += dist; println(s" $up")}
				case "down" => {down += dist; println(s" $down")}
				case "forward" => {forward += dist; println(s" $forward")}
			}
		}

		print(s"($up - $down) * $forward = ");
		println((up - down) * forward); // result
	}
}