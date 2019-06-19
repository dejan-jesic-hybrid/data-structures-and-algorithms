import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import model.Player;
import org.junit.Test;

public class Contains extends AbstractCommonData {

	@Test
	public void containsItemInArrayListUsingNewButEqualObject() {
		List<Player> players = new ArrayList<>();
		add_100_000_000_Players(player, players);
		var playerToSearch = Player.builder()
			.name("Test player")
			.country("SRB")
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to find item in array list: %s", toMillis(start, end)));
		// Execution time: 0.000 (average)
	}

	@Test
	public void containsItemInArrayListUsingNewButUnequalObject() {
		List<Player> players = new ArrayList<>();
		add_100_000_000_Players(player, players);
		var playerToSearch = Player.builder()
			.name("Test player unequal name")
			.country("SRB")
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to find item in array list: %s", toMillis(start, end)));
		// Execution time: 574.000 millis (average)
	}

	@Test
	public void containsItemInLinkedList() {
		List<Player> players = new LinkedList<>();
		add_100_000_000_Players(player, players);
		players.get(50_000_000).setName("Test contains in linked list");
		var playerToSearch = Player.builder()
			.name("Test contains in linked list")
			.country("SRB")
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to find item in linked list: %s", toMillis(start, end)));
		// Execution time: 879.000 (average)
	}

	@Test
	public void containsItemInHashSet() {
		Set<Player> players = new HashSet<>();
		add_100_000_000_Players(player, players);
		var playerToSearch = Player.builder()
			.name("Test player")
			.country("SRB")
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to find item in hash set: %s", toMillis(start, end)));
		// Execution time: 0.137 (average)
	}

}
