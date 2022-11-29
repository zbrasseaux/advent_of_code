import scala.io.Source; // library to read input file in

object advent_of_code_2021_03_1 {
	def main(args: Array[String]): Unit = {

		val lines = Source.fromFile("03_input.txt").getLines().toList; // file as immutable list
		var sums: Array[Int] = Array();

		for (i <- 0 until 8) { // iterate over list by index
			sums = sums :+ lines.foldLeft(0)((acc,curr) => acc + curr(i).toInt);
		}

		var gamma: Array[Int] = sums.map((curr) => ((curr-48000)/lines.length.toFloat).round);
		var epsilon: Array[Int] = gamma.map((curr) => flip_bin(curr));

		for (w <- gamma) {
			print(w);
		};
		println();
		val gammaVal: Int = binToInt(gamma);
		println(gammaVal);

		for (w <- epsilon) {
			print(w);
		};
		println();
		val epsilonVal: Int = binToInt(epsilon);
		println(epsilonVal);

		println(gammaVal * epsilonVal);
	}

	def flip_bin(inDig: Int): Int = {
		if (inDig == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	def binToInt(binArr: Array[Int]): Int = {
		val binArrRev: Array[Int] = binArr.reverse;
		var currVal: Int = 0;

		for (i <- 0 until binArrRev.length) {
			currVal += (binArr(i) * power(2, i))
		}

		return currVal
	}

	def power(a: Int, b: Int): Int = {
		var curr: Int = 0;
		for (i <- 0 until b) {
			curr *= a;
		}
		return curr;
	}
}