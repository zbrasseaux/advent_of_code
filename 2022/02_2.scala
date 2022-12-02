import scala.io.Source; // library to read input file in

object advent_of_code_2022_02_2 {
	def main(args: Array[String]): Unit = {

		// file as immutable list
		val lines = Source.fromFile("day_02.input").getLines().toList;
		// convert to actual
		val opp_plays = Map(
			"A" -> "rock", 
			"B" -> "paper",
			"C" -> "scissors",
		);
		val player_plays = Map(
			"X" -> 0, 
			"Y" -> 3,
			"Z" -> 6
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
			val player_a: String = opp_plays(line.split(" ")(0));
			val player_b: Int = player_plays(line.split(" ")(1));

			currScore += player_b + rps_values(parse_outcome(player_a, player_b));
		}

		println(currScore);
	}

	def parse_outcome(opp: String, outcome: Int): String = {
		if (opp == "rock") {
			if (outcome == 0) {
				return "scissors";
			} else if (outcome == 3){
				return "rock";
			} else {
				return "paper";
			}
		} else if (opp == "paper") {
			if (outcome == 0) {
				return "rock";
			} else if (outcome == 3){
				return "paper";
			} else {
				return "scissors";
			}
		} else {
			if (outcome == 0) {
				return "paper";
			} else if (outcome == 3){
				return "scissors";
			} else {
				return "rock";
			}
		}
	}

}