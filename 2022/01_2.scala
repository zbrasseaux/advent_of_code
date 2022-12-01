import scala.io.Source; // library to read input file in

object advent_of_code_2022_01_2 {
	def main(args: Array[String]): Unit = {

		val lines = Source.fromFile("day_01.input").getLines().toList; // file as immutable list
		
		// set default values
		var sums: Array[Int] = Array();
		var currSum: Int = 0;

		// iterate over file
		for (line <- lines) {
			if (line == "") { // line seperating elves
				sums = sums :+ currSum; // add sum to array of sums
				currSum = 0; // reset sum
			} else {
				currSum += line.toInt; // increment sum
			}
		}

		sums = sums.sortWith(_ > _); // sort greatest to least

		println(sums(0) + sums(1) + sums(2)); // return result
	}

}