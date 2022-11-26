import scala.io.Source; // library to read input file in

object advent_of_code_2021_01 {
	def main(args: Array[String]): Unit = {

		val lines = Source.fromFile("01_input.csv").getLines().toList; // file as immutable list
		var increases = 0; // initialize variable

		for (i <- 1 until lines.length) { // iterate over list by index
			if (lines(i).toInt > lines(i-1).toInt) { // evaluate
				increases += 1; // increment when true
			}
		}
		println(increases); // result
	}
}