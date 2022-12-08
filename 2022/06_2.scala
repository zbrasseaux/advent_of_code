import scala.io.Source; // library to read input file in
import scala.collection.mutable.Queue; // library for Queue structure

object advent_of_code_2022_06_1 {
	def main(args: Array[String]): Unit = {

		// file as immutable list
		val input: String = Source.fromFile("day_06.input").getLines().toList(0); 
		// start with first 13 elements
		var marker: Queue[Char] = Queue(input(0)); 
		for (i <- 1 to 12) {
			marker.enqueue(input(i))
		}
		
		var result: Int = 0; // easily store result
		
		for (i <- 13 until input.length) {
			marker.enqueue(input(i)); // add new element to get 4

			// make sure result doesn't get over written
			if (check_for_duplicates(marker) && result == 0){
				result = i + 1;
			}

			marker.dequeue(); // remove element
		}

		// return result
		println(result);

	}

	def check_for_duplicates(marker: Queue[Char]): Boolean = {
		for (i <- marker.toList) {
			var seen: Int = 0; // count number of times element occurs in list
			for (j <- marker.toList) {
				if (i == j) {
					seen += 1
				}
			}
			if (seen > 1) {
				return false; // return false if occurs more than once
			}
		}
		return true; // else return true
	}

}