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

		var dup_items: Array[Char] = Array();

		// iterate over file
		for (line <- lines) {
			val half_one = line.slice(0, (line.length)/2);
			val half_two = line.slice((line.length)/2, line.length-1);
			var seen_elements: Array[Char] = Array();
			println(s"${half_one.length} ${half_two.length}");

			for (element_a <- half_one) {
				if (!(seen_elements contains element_a)) {
					for (element_b <- half_two) {
						if (element_a == element_b) {
							println(element_a);
							dup_items = dup_items :+ element_a;
						}
					}
					seen_elements = seen_elements :+ element_a;
				}
			}
		}

		var sum: Int = 0;

		for (element <- dup_items) {
			sum += alphabet_map(element)
		}

		println(sum); // return result
	}

}