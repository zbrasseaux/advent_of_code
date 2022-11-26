

import scala.io.Source; // library to read input file in

object advent_of_code_2021_01_2 {
	def main(args: Array[String]): Unit = {

		val lines = Source.fromFile("01_input.csv").getLines().toList; // file as immutable list
		var increases: Int = 0; // initialize variable
		var currsum: Int = 0; // initialize variable
		var window_sums: Array[Int] = Array(); // empty array

		for (i <- 2 until lines.length) { // iterate over list by index
			currsum = lines(i).toInt + lines(i-1).toInt + lines(i-2).toInt; // window sums
			window_sums = window_sums :+ currsum; // append window sum
		}

		for (j <- 1 until window_sums.length) { // iterate over list by index
			if (window_sums(j) > window_sums(j-1)) { // evaluate
				increases += 1; // increment when true
			}
		}
		println(increases); // result
	}
}