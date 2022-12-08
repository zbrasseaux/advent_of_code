import scala.io.Source; // library to read input file in
import scala.collection.mutable.Stack; // library for stack structure
import scala.collection.mutable.Map;

object advent_of_code_2022_07_1 {
	def main(args: Array[String]): Unit = {

		// file as immutable list
		val lines = Source.fromFile("day_07.input").getLines().toList; 

		val path: Stack[String] = Stack();
		val dir_size: Map[String, Int] = Map();

		for (line <- lines) {
			val curr_line: Array[String] = line.split(" ");

			if (curr_line(0) == "$") {
				if (curr_line(1) == "cd") {
					if (curr_line(2) == "..") {
						val curr_dir = path.pop();
						dir_size(path.top) += dir_size(curr_dir);
					} else if (curr_line(2) == ".") {
						1 == 1;
					} else {
						path.push(curr_line(2));
					}
				} else if (curr_line(1) == "ls") {
					dir_size(path.top) = 0;
				}
			} else if (curr_line(0) == "dir") {
				1 == 1;
			} else {
				dir_size(path.top) += curr_line(0).toInt;
			}
		}

		val sum: Int = dir_size.foldLeft(0)((sum, curr) => {
			if (curr._2 <= 100000){
				sum + curr._2
			} else {
				sum
			}});

		// return result
		println(sum);
	}

}