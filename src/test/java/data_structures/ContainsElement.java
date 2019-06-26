package data_structures;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import model.Player;
import org.junit.Test;

@Slf4j
public class ContainsElement extends CommonData {

	private static final String SRB_COUNTRY = "SRB";
	private static final String TEST_NAME_MIDDLE_ITEM = "Test name - middle";

	@Test
	public void containsItemInArrayListUsingNewButEqualObject() {
		List<Player> players = new ArrayList<>();
		addMillionPlayers(player, players);
		players.get(500_000).setName(TEST_NAME_MIDDLE_ITEM);
		var playerToSearch = Player.builder()
			.name(TEST_NAME_MIDDLE_ITEM)
			.country(SRB_COUNTRY)
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		log.error("containsItemInArrayListUsingNewButEqualObject() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 0 millis
	}

	@Test
	public void containsItemInArrayListUsingNewButUnequalObject() {
		List<Player> players = new ArrayList<>();
		addMillionPlayers(player, players);
		var playerToSearch = Player.builder()
			.name("Test name - unequal")
			.country(SRB_COUNTRY)
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		log.error("containsItemInArrayListUsingNewButUnequalObject() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 8 millis
	}

	@Test
	public void containsItemInLinkedListUsingNewButEqualObject() {
		List<Player> players = new LinkedList<>();
		addMillionPlayers(player, players);
		players.get(500_000).setName(TEST_NAME_MIDDLE_ITEM);
		var playerToSearch = Player.builder()
			.name(TEST_NAME_MIDDLE_ITEM)
			.country(SRB_COUNTRY)
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		log.error("containsItemInLinkedListUsingNewButEqualObject() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 0 millis
	}

	@Test
	public void containsItemInLinkedListUsingNewButUnequalObject() {
		List<Player> players = new LinkedList<>();
		addMillionPlayers(player, players);
		var playerToSearch = Player.builder()
			.name("Test name - unequal")
			.country(SRB_COUNTRY)
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		log.error("containsItemInLinkedListUsingNewButUnequalObject() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 15 millis
	}

	@Test
	public void containsItemInHashSetUsingNewButEqualObject() {
		Set<Player> players = new HashSet<>();
		addMillionPlayers(player, players);
		var playerToSearch = Player.builder()
			.name("Test player")
			.country(SRB_COUNTRY)
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		log.error("containsItemInHashSetUsingNewButEqualObject() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 0 millis
	}

	@Test
	public void containsItemInHashSetUsingNewButUnequalObject() {
		Set<Player> players = new HashSet<>();
		addMillionPlayers(player, players);
		var playerToSearch = Player.builder()
			.name("Test player")
			.country(SRB_COUNTRY)
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.nanoTime();
		players.contains(playerToSearch);
		var end = System.nanoTime();

		log.error("containsItemInHashSetUsingNewButUnequalObject() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 0 millis
	}

}
