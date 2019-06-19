import java.util.ArrayList;
import java.util.List;

import model.Player;
import org.junit.Test;

public class Initialize extends AbstractCommonData {

	@Test
	public void arrayListDefaultSize() {
		List<Player> players = new ArrayList<>();

		var start = System.nanoTime();
		add_100_000_000_Players(player, players);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to populate list with default capacity: %s", toMillis(start, end)));
		// Execution time: 2526.644 millis (average)
	}

	@Test
	public void arrayList_100_000_000_Size() {
		List<Player> players = new ArrayList<>(100_000_000);

		var start = System.nanoTime();
		add_100_000_000_Players(player, players);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to populate list with 1.000.000 capacity: %s", toMillis(start, end)));
		// Execution time: 1004.418 millis (average)
	}

}
