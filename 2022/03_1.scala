import scala.io.Source; // library to read input file in

object advent_of_code_2022_03_1 {
	def main(args: Array[String]): Unit = {

		// file as immutable list
		val lines = Source.fromFile("day_03.input").getLines().toList; 
		
		// create hashmap of char values
		val alphabet_map = scala.collection.mutable.Map("a"(0) -> 1);
		val alphabet: String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (i <- 1 until alphabet.length) {
			alphabet_map.put(alphabet(i), i+1);
		}

		// iterate over file
		for (line <- lines) {
			for (x <- line) {
				print(s"${alphabet_map(x)} ");
			}
			println();
		}

		// println(currMax); // return result
	}

}