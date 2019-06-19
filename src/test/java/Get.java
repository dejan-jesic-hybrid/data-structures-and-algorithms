import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Player;
import org.junit.Test;

public class Get extends AbstractCommonData {

	@Test
	public void getItemArrayList() {
		List<Player> players = new ArrayList<>(100_000_000);
		add_100_000_000_Players(player, players);

		var start = System.nanoTime();
		players.get(50_000_000);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to get an item from array list: %s", toMillis(start, end)));
		// Execution time: 0.009 millis (average)
	}

	@Test
	public void getItemLinkedList() {
		List<Player> players = new LinkedList<>();
		add_100_000_000_Players(player, players);

		var start = System.nanoTime();
		players.get(50_000_000);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to get an item from linked list: %s", toMillis(start, end)));
		// Execution time: 197.437 millis (average)
	}

}
