import scala.io.Source; // library to read input file in

object advent_of_code_2021_03_1 {
	def main(args: Array[String]): Unit = {

		val lines = Source.fromFile("03_input.txt").getLines().toList; // file as immutable list
		var sums: Array[Int] = Array();

		for (i <- 0 until 12) { // iterate over list by index
			sums = sums :+ lines.foldLeft(0)((acc,curr) => acc + curr(i).toInt);
		}

		var gamma: Array[Int] = sums.map((curr) => ((curr-48000)/lines.length.toFloat).round);
		var epsilon: Array[Int] = gamma.map((curr) => flip_bin(curr));

		for (w <- gamma) {
			print(w);
		};
		println();
		val gammaVal: Int = Integer.parseInt(gamma.foldLeft("")((acc, curr) => acc + s"$curr"), 2);
		println(gammaVal);

		for (w <- epsilon) {
			print(w);
		};
		println();
		val epsilonVal: Int = Integer.parseInt(epsilon.foldLeft("")((acc, curr) => acc + s"$curr"), 2);
		println(epsilonVal);

		println(gammaVal * epsilonVal);
	}

	// flip binary digit
	def flip_bin(inDig: Int): Int = {
		if (inDig == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}