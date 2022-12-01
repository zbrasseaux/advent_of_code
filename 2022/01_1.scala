import scala.io.Source; // library to read input file in

object advent_of_code_2022_01_1 {
	def main(args: Array[String]): Unit = {

		val lines = Source.fromFile("day_01.input").getLines().toList; // file as immutable list
		
		var currMax: Int = 0;
		var currSum: Int = 0;

		for (line <- lines) {
			if (line == "") {
				if (currSum > currMax) {
					currMax = currSum;
				}
				currSum = 0;
			} else {
				currSum += line.toInt;
			}
		}

		println(currMax);
	}

}