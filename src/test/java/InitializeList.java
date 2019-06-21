import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.ArrayList;
import java.util.List;

import model.Player;
import org.junit.Test;

public class InitializeList extends AbstractCommonData {

	@Test
	public void arrayListDefaultInstantiation() {
		List<Player> players = new ArrayList<>();

		var start = System.nanoTime();
		add_1_000_000_Players(player, players);
		var end = System.nanoTime();

		System.err.println("arrayListDefaultInstantiation() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 778 millis
	}

	@Test
	public void arrayList_1_000_000_Instantiation() {
		List<Player> players = new ArrayList<>(1_000_000);

		var start = System.nanoTime();
		add_1_000_000_Players(player, players);
		var end = System.nanoTime();

		System.err.println("arrayList_1_000_000_Instantiation() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 893 millis
	}

}
