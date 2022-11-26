import scala.io.Source;

object advent_of_code_2021_01 {
	def main(args: Array[String]): Unit = {
		val lines = Source.fromFile("01_input.csv").getLines().toList;
		for (i <- 0 until lines.length) {
			println(s"$i - ${lines.apply(i)}");
		}
	}
}