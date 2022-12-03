import scala.io.Source; // library to read input file in

object advent_of_code_2022_03_2 {
	def main(args: Array[String]): Unit = {

		// file as immutable list
		val lines = Source.fromFile("day_03.input").getLines().toList; 
		
		// create hashmap of char values
		val alphabet_map = scala.collection.mutable.Map("a"(0) -> 1);
		val alphabet: String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (i <- 1 until alphabet.length) {
			alphabet_map.put(alphabet(i), i+1);
		}

		var badges: Array[Char] = Array();

		val size: Int = lines.length / 3;
		println(size)

		// iterate over file
		for (line <- 1 until size) {
			val curr_index: Int = (line*3) - 1;

			// intersection of lines
			val intersection: Set[Char] = lines(curr_index).toSet.intersect(
				lines(curr_index - 1).toSet
			).intersect(
				lines(curr_index - 2).toSet
			);

			println(intersection)

			// add elements individually
			for (element <- intersection) {
				badges = badges :+ element
			}
		}

		// final sum
		var sum: Int = 0;

		for (element <- badges) {
			sum += alphabet_map(element)
		}

		println(sum); // return result
	}

}