package data_structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import model.Player;
import org.junit.Test;

@Slf4j
public class SortCollections extends CommonData {

	@Test
	public void sortItemsInArrayList() {
		List<Player> players = new ArrayList<>();
		addMillionPlayers(player, players);

		var start = System.currentTimeMillis();
		players.sort(Comparator.comparing(Player::getDescription));
		var end = System.currentTimeMillis();

		log.info("sortItemsInArrayList() = " + (end - start));
		// Execution time: 18 millis
	}

	@Test
	public void sortItemsInLinkedList() {
		List<Player> players = new LinkedList<>();
		addMillionPlayers(player, players);

		var start = System.currentTimeMillis();
		players.sort(Comparator.comparing(Player::getDescription));
		var end = System.currentTimeMillis();

		log.info("sortItemsInLinkedList() = " + (end - start));
		// Execution time: 67 millis
	}

	@Test
	public void sortItemsInHashSetUsingStreamAPI() {
		Set<Player> players = new HashSet<>();
		addMillionPlayers(player, players);

		var start = System.currentTimeMillis();
		players.stream()
			.sorted(Comparator.comparing(Player::getDescription))
			.collect(Collectors.toCollection(LinkedHashSet::new));
		var end = System.currentTimeMillis();

		log.info("sortItemsInHashSetUsingStreamAPI() = " + (end - start));
		// Execution time: 2 millis
	}

	@Test
	public void sortItemsInHashSetUsingList() {
		Set<Player> players = new HashSet<>();
		addMillionPlayers(player, players);

		var start = System.currentTimeMillis();
		new ArrayList<>(players).sort(Comparator.comparing(Player::getDescription));
		var end = System.currentTimeMillis();

		log.info("sortItemsInHashSetUsingList() = " + (end - start));
		// Execution time: 2 millis
	}

}
