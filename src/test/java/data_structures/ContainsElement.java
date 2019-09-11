package data_structures;

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

	@Test
	public void containsItemInArrayListUsingNewButEqualObject() {
		List<Player> players = new ArrayList<>();
		addMillionPlayers(player, players);
		players.get(500_000).setName("Test name - middle");
		var playerToSearch = Player.builder()
			.name("Test name - middle")
			.country("SRB")
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.currentTimeMillis();
		players.contains(playerToSearch);
		var end = System.currentTimeMillis();

		log.info("containsItemInArrayListUsingNewButEqualObject() = " + (end - start));
		// Execution time: 0 millis
	}

	@Test
	public void containsItemInArrayListUsingNewButUnequalObject() {
		List<Player> players = new ArrayList<>();
		addMillionPlayers(player, players);
		var playerToSearch = Player.builder()
			.name("Test name - unequal")
			.country("SRB")
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.currentTimeMillis();
		players.contains(playerToSearch);
		var end = System.currentTimeMillis();

		log.info("containsItemInArrayListUsingNewButUnequalObject() = " + (end - start));
		// Execution time: 11 millis
	}

	@Test
	public void containsItemInLinkedListUsingNewButEqualObject() {
		List<Player> players = new LinkedList<>();
		addMillionPlayers(player, players);
		players.get(500_000).setName("Test name - middle");
		var playerToSearch = Player.builder()
			.name("Test name - middle")
			.country("SRB")
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.currentTimeMillis();
		players.contains(playerToSearch);
		var end = System.currentTimeMillis();

		log.info("containsItemInLinkedListUsingNewButEqualObject() = " + (end - start));
		// Execution time: 0 millis
	}

	@Test
	public void containsItemInLinkedListUsingNewButUnequalObject() {
		List<Player> players = new LinkedList<>();
		addMillionPlayers(player, players);
		var playerToSearch = Player.builder()
			.name("Test name - unequal")
			.country("SRB")
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.currentTimeMillis();
		players.contains(playerToSearch);
		var end = System.currentTimeMillis();

		log.info("containsItemInLinkedListUsingNewButUnequalObject() = " + (end - start));
		// Execution time: 15 millis
	}

	@Test
	public void containsItemInHashSetUsingNewButEqualObject() {
		Set<Player> players = new HashSet<>();
		addMillionPlayers(player, players);
		var playerToSearch = Player.builder()
			.name("Test player")
			.country("SRB")
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.currentTimeMillis();
		players.contains(playerToSearch);
		var end = System.currentTimeMillis();

		log.info("containsItemInHashSetUsingNewButEqualObject() = " + (end - start));
		// Execution time: 0 millis
	}

	@Test
	public void containsItemInHashSetUsingNewButUnequalObject() {
		Set<Player> players = new HashSet<>();
		addMillionPlayers(player, players);
		var playerToSearch = Player.builder()
			.name("Test player")
			.country("SRB")
			.dateOfBirth(LocalDate.EPOCH)
			.build();

		var start = System.currentTimeMillis();
		players.contains(playerToSearch);
		var end = System.currentTimeMillis();

		log.info("containsItemInHashSetUsingNewButUnequalObject() = " + (end - start));
		// Execution time: 0 millis
	}

}
