package data_structures;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import model.Player;
import model.Title;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class CommonData {

	Player player;

	@Before
	public void init() {
		player = Player.builder()
			.name("Test name")
			.age(20)
			.country("SRB")
			.dateOfBirth(LocalDate.EPOCH)
			.rank(1)
			.atpPoints(1000)
			.titles(Arrays.asList(
				Title.builder().aptPoints(250).city("Paris").date(LocalDate.EPOCH).build(),
				Title.builder().aptPoints(500).city("Madrid").date(LocalDate.EPOCH).build(),
				Title.builder().aptPoints(1000).city("London").date(LocalDate.EPOCH).build()
			))
			.build();
	}

	@Test
	public void load() {
		log.info("Hello Hybrid!");
	}

	void addMillionPlayers(Player player, List<Player> players) {
		for (int index = 0; index < 1_000_000; index++) {
			player.setDescription(UUID.randomUUID().toString());
			players.add(player);
		}
	}

	void addMillionPlayers(Player player, Set<Player> players) {
		for (int index = 0; index < 1_000_000; index++) {
			player.setDescription(UUID.randomUUID().toString());
			players.add(player);
		}
	}

	List<Player> getBestPlayersFromAtpList() {
		return Arrays.asList(
			Player.builder()
				.name("Novak Đoković")
				.rank(1)
				.country("SRB")
				.dateOfBirth(LocalDate.of(1987, 5, 22))
				.build(),
			Player.builder()
				.name("Rafael Nadal")
				.rank(2)
				.country("ESP")
				.dateOfBirth(LocalDate.of(1986, 6, 3))
				.build(),
			Player.builder()
				.name("Roger Federer")
				.rank(3)
				.country("SUI")
				.dateOfBirth(LocalDate.of(1981, 8, 8))
				.build(),
			Player.builder()
				.name("Dominic Theim")
				.rank(4)
				.country("AUT")
				.dateOfBirth(LocalDate.of(1993, 9, 3))
				.build(),
			Player.builder()
				.name("Alexander Zverev")
				.rank(5)
				.country("GER")
				.dateOfBirth(LocalDate.of(1997, 4, 20))
				.build(),
			Player.builder()
				.name("Stefanos Tsitsipas")
				.rank(6)
				.country("GRE")
				.dateOfBirth(LocalDate.of(1998, 8, 12))
				.build(),
			Player.builder()
				.name("Kei Nishikori")
				.rank(7)
				.country("JPN")
				.dateOfBirth(LocalDate.of(1989, 12, 29))
				.build(),
			Player.builder()
				.name("Kevin Anderson")
				.rank(8)
				.country("RSA")
				.dateOfBirth(LocalDate.of(1986, 5, 18))
				.build()
		);
	}

}
