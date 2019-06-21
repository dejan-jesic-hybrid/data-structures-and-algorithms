import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import model.Player;
import org.junit.Test;

public class ContainsElement extends AbstractCommonData {

	private static final String SRB_COUNTRY = "SRB";

	@Test
	public void containsItemInArrayListUsingNewButEqualObject() {
		List<Player> players = new ArrayList<>();
		add_1_000_000_Players(player, players);
		players.get(500_000).setName("Test name - middle");
		var playerToSearch = Player.builder()
			.name("Test name - middle")
			.country(SRB_COUNTRY)
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		System.err.println("containsItemInArrayListUsingNewButEqualObject() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 0 millis
	}

	@Test
	public void containsItemInArrayListUsingNewButUnequalObject() {
		List<Player> players = new ArrayList<>();
		add_1_000_000_Players(player, players);
		var playerToSearch = Player.builder()
			.name("Test name - unequal")
			.country(SRB_COUNTRY)
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		System.err.println("containsItemInArrayListUsingNewButUnequalObject() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 8 millis
	}

	@Test
	public void containsItemInLinkedListUsingNewButEqualObject() {
		List<Player> players = new LinkedList<>();
		add_1_000_000_Players(player, players);
		players.get(500_000).setName("Test name - middle");
		var playerToSearch = Player.builder()
			.name("Test name - middle")
			.country(SRB_COUNTRY)
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		System.err.println("containsItemInLinkedListUsingNewButEqualObject() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 0 millis
	}

	@Test
	public void containsItemInLinkedListUsingNewButUnequalObject() {
		List<Player> players = new LinkedList<>();
		add_1_000_000_Players(player, players);
		var playerToSearch = Player.builder()
			.name("Test name - unequal")
			.country(SRB_COUNTRY)
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		System.err.println("containsItemInLinkedListUsingNewButUnequalObject() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 15 millis
	}

	@Test
	public void containsItemInHashSetUsingNewButEqualObject() {
		Set<Player> players = new HashSet<>();
		add_1_000_000_Players(player, players);
		var playerToSearch = Player.builder()
			.name("Test player")
			.country(SRB_COUNTRY)
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		System.err.println("containsItemInHashSetUsingNewButEqualObject() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 0 millis
	}

	@Test
	public void containsItemInHashSetUsingNewButUnequalObject() {
		Set<Player> players = new HashSet<>();
		add_1_000_000_Players(player, players);
		var playerToSearch = Player.builder()
			.name("Test player")
			.country(SRB_COUNTRY)
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		System.err.println("containsItemInHashSetUsingNewButUnequalObject() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 0 millis
	}

}
