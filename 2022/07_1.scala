import scala.io.Source; // library to read input file in
import scala.collection.mutable.Stack; // library for stack structure
import scala.collection.mutable.Map; // mutable map structure

object advent_of_code_2022_07_1 {
	def main(args: Array[String]): Unit = {

		// file as immutable list
		val lines = Source.fromFile("day_07.input").getLines().toList; 

		val path: Stack[String] = Stack(); // working directory stack
		val dir_size: Map[String, Int] = Map(); // map of sizes of viewed dirs

		for (line <- lines) {
			val curr_line: Array[String] = line.split(" "); // parse out line
			val full_path: String = path.toArray.mkString("/");

			if (curr_line(0) == "$") { // parse for commands
				if (curr_line(1) == "cd") { // parse for cd commands
					if (curr_line(2) == "..") { // navigate to parent dir
						// val curr_dir = path.toArray.mkString("/"); // move to parent dir and get curr dir
						path.pop()
						// println(s"${full_path}: ${dir_size(full_path)} <- ${curr_dir}: ${dir_size(curr_dir)}")
						// dir_size(full_path) += dir_size(curr_dir); // add dir size to parent
					} else {
						path.push(curr_line(2)); // navigate to given directory
					}
				} else if (curr_line(1) == "ls") { // list items in dir
					dir_size(full_path) = 0; // initialize current dir in map
				}
			} else if (curr_line(0) == "dir") {
				1 == 1; // skip dir lines
			} else {
				val curr_file_size: Int = curr_line(0).toInt;
				val temp_stack: Stack[String] = Stack();

				for (i <- 0 until path.length) {
					val temp_path: String = path.toArray.mkString("/");
					dir_size(temp_path) += curr_file_size;
					val curr_file_dir: String = path.pop();
					temp_stack.push(curr_file_dir);
				}

				for (i <- 0 until temp_stack.length) {
					val x: String = temp_stack.pop();
					path.push(x);
				}

				dir_size(full_path) += curr_line(0).toInt; // append file size to map
			}

			try {
				println(s"${full_path}\t${dir_size(full_path)}");
			} catch {
				case x: NoSuchElementException => println();
			}
		}

		// sum up directory sizes where directory size is less than 100000
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