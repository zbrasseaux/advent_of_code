import scala.io.Source; // library to read input file in
import scala.collection.mutable.Queue; // library for stack structure

object advent_of_code_2022_10_1 {
	def main(args: Array[Int]): Unit = {

		// file as immutable list
		val lines = Source.fromFile("day_10.input").getLines().toList; 

		var x: Int = 1;
		var cycle: Int = 1;
		var curr_search: Int = 20;
		var sum: Int = 0;

		val operations: Queue[Int] = Queue();
		
		for (line <- lines) {
			// start of cycle
			// parse arg
			line.split(" ")(0) match {
				case "noop" => { // add 0 to queue
					operations.enqueue(0);
				} case "addx" => { // add 0 and val to queue (2 cycles)
					operations.enqueue(0);
					operations.enqueue(line.split(" ")(0).toInt);
				}
			}

			// dequeue (end cycle)
			val curr_val: Int = operations.dequeue();

			x += curr_val; // increment x by current value

			// search for specific cycle
			if (cycle == curr_search && curr_search < 221) {
				sum += curr_val * cycle;
				curr_search += 40;
			}

			cycle += 1; // increment cycle
		}

		// return result
		println(sum)
	}

}