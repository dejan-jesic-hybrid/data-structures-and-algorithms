import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import model.Player;
import org.junit.Test;

public class SortCollections extends AbstractCommonData {

	@Test
	public void sortItemsArrayList() {
		List<Player> players = new ArrayList<>();
		add_100_000_000_Players(player, players);

		var start = System.nanoTime();
		players.sort(Comparator.comparing(Player::getDescription));
		var end = System.nanoTime();

		System.err.println(String.format("Millis to sort items in array list: %s", toMillis(start, end)));
		// Execution time: 792.924 millis (average)
	}

	@Test
	public void sortItemsLinkedList() {
		List<Player> players = new LinkedList<>();
		add_100_000_000_Players(player, players);

		var start = System.nanoTime();
		players.sort(Comparator.comparing(Player::getDescription));
		var end = System.nanoTime();

		System.err.println(String.format("Millis to sort items in linked list: %s", toMillis(start, end)));
		// Execution time: 4843.979 millis (average)
	}

	@Test
	public void sortItemsHashSetUsingStreamAPI() {
		Set<Player> players = new HashSet<>();
		add_100_000_000_Players(player, players);

		var start = System.nanoTime();
		var sortedPlayers = players.stream()
			.sorted(Comparator.comparing(Player::getDescription))
			.collect(Collectors.toCollection(LinkedHashSet::new));
		var end = System.nanoTime();

		System.err.println(String.format("Millis to sort items in set: %s", toMillis(start, end)));
		// Execution time: ? (average)
	}

	@Test
	public void sortItemsHashSetUsingList() {
		Set<Player> players = new HashSet<>();
		add_100_000_000_Players(player, players);

		var start = System.nanoTime();
		new ArrayList<>(players).sort(Comparator.comparing(Player::getDescription));
		var end = System.nanoTime();

		System.err.println(String.format("Millis to sort items in set: %s", toMillis(start, end)));
		// Execution time: 16659.247 (average)
	}

}
