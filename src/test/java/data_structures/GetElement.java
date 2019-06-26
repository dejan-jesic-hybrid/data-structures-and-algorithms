package data_structures;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import model.Player;
import org.junit.Test;

@Slf4j
public class GetElement extends CommonData {

	@Test
	public void getMiddleItemFromArrayList() {
		List<Player> players = new ArrayList<>(1_000_000);
		addMillionPlayers(player, players);

		var start = System.nanoTime();
		players.get(500_000);
		var end = System.nanoTime();

		log.error("getMiddleItemFromArrayList() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 0 millis
	}

	@Test
	public void getMiddleItemFromLinkedList() {
		List<Player> players = new LinkedList<>();
		addMillionPlayers(player, players);

		var start = System.nanoTime();
		players.get(500_000);
		var end = System.nanoTime();

		log.error("getMiddleItemFromLinkedList() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 7 millis
	}

}
