package data_structures;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import model.Player;
import org.junit.Test;

@Slf4j
public class InitializeList extends CommonData {

	@Test
	public void arrayListDefaultInstantiation() {
		List<Player> players = new ArrayList<>();

		var start = System.currentTimeMillis();
		addMillionPlayers(player, players);
		var end = System.currentTimeMillis();

		log.info("arrayListDefaultInstantiation() = " + (end - start));
		// Execution time: 1050 millis
	}

	@Test
	public void arrayList_1_000_000_Instantiation() {
		List<Player> players = new ArrayList<>(1_000_000);

		var start = System.currentTimeMillis();
		addMillionPlayers(player, players);
		var end = System.currentTimeMillis();

		log.info("arrayList_1_000_000_Instantiation() = " + (end - start));
		// Execution time: 1170 millis
	}

}
