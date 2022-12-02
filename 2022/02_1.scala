import scala.io.Source; // library to read input file in

object advent_of_code_2022_02gi_1 {
	def main(args: Array[String]): Unit = {

		// file as immutable list
		val lines = Source.fromFile("day_02.input").getLines().toList;
		// convert to actual
		val rps_outcomes = Map(
			"A" -> "rock", 
			"B" -> "paper",
			"C" -> "scissors",
			"X" -> "rock", 
			"Y" -> "paper",
			"Z" -> "scissors"
		);
		// score modifiers
		val rps_values = Map(
			"rock" -> 1,
			"paper" -> 2,
			"scissors" -> 3
		);
		
		// set default values
		var currScore: Int = 0;

		// iterate over file
		for (line <- lines) {
			val player_a: String = rps_outcomes(line.split(" ")(0));
			val player_b: String = rps_outcomes(line.split(" ")(1));

			currScore += rps_values(player_b) + parse_outcome(player_a, player_b);
		}

		println(currScore);
	}

	def parse_outcome(opp: String, player: String): Int = {
		if (opp == player) {
			return 3;
		} else if (opp == "rock") {
			if (player == "paper") {
				return 6;
			} else {
				return 0
			}
		} else if (opp == "paper") {
			if (player == "scissors") {
				return 6;
			} else {
				return 0
			}
		} else {
			if (player == "rock") {
				return 6;
			} else {
				return 0
			}
		}
	}

}