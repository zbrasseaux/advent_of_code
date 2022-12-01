import scala.io.Source; // library to read input file in

object advent_of_code_2022_01_1 {
	def main(args: Array[String]): Unit = {

		val lines = Source.fromFile("day_01.input").getLines().toList; // file as immutable list
		
		// set default values
		var currMax: Int = 0;
		var currSum: Int = 0;

		// iterate over file
		for (line <- lines) {
			if (line == "") { // line seperating elves
				if (currSum > currMax) {
					currMax = currSum; // new max
				}
				currSum = 0; // reset sum
			} else {
				currSum += line.toInt; // increment sum
			}
		}

		println(currMax); // return result
	}

}