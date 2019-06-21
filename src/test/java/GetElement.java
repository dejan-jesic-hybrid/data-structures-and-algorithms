import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Player;
import org.junit.Test;

public class GetElement extends AbstractCommonData {

	@Test
	public void getMiddleItemFromArrayList() {
		List<Player> players = new ArrayList<>(1_000_000);
		add_1_000_000_Players(player, players);

		var start = System.nanoTime();
		players.get(500_000);
		var end = System.nanoTime();

		System.err.println("getMiddleItemFromArrayList() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 0 millis
	}

	@Test
	public void getMiddleItemFromLinkedList() {
		List<Player> players = new LinkedList<>();
		add_1_000_000_Players(player, players);

		var start = System.nanoTime();
		players.get(500_000);
		var end = System.nanoTime();

		System.err.println("getMiddleItemFromLinkedList() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 7 millis
	}

}
