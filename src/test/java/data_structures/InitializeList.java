package data_structures;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

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

		var start = System.nanoTime();
		addMillionPlayers(player, players);
		var end = System.nanoTime();

		log.error("arrayListDefaultInstantiation() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 778 millis
	}

	@Test
	public void arrayList_1_000_000_Instantiation() {
		List<Player> players = new ArrayList<>(1_000_000);

		var start = System.nanoTime();
		addMillionPlayers(player, players);
		var end = System.nanoTime();

		log.error("arrayList_1_000_000_Instantiation() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 893 millis
	}

}
