import scala.io.Source; // library to read input file in

object advent_of_code_2022_04_1 {
	def main(args: Array[String]): Unit = {

		// file as immutable list
		val lines = Source.fromFile("day_04.input").getLines().toList; 

		var count: Int = 0;
		
		for (line <- lines) {

			// parse out pair values
			val pairs: Array[String] = line.split(",");
			val p0: Array[String] = pairs(0).split("-");
			val p1: Array[String] = pairs(1).split("-");

			// extract values for comparison as ints
			val x0: Int = p0(0).toInt;
			val y0: Int = p0(1).toInt;
			val x1: Int = p1(0).toInt;
			val y1: Int = p1(1).toInt;
			
			// check to see if one pair is contained within another
			if ((x0 <= x1 && y0 >= y1) || (x1 <= x0 && y1 >= y0)) {
				count += 1;
			}
		}

		println(count); // return result
	}

}