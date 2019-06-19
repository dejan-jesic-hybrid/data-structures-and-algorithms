import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import model.BinaryTree;
import model.Player;
import org.junit.Test;
import util.BinaryTreePrinter;

public class Insert extends AbstractCommonData {

	@Test
	public void insertDataIntoBinaryTree() {
		List<Player> players = getBestPlayersFromAtpList();

		BinaryTree draw = new BinaryTree();
		var sortedPlayersByName = players.stream()
			.sorted(Comparator.comparing(Player::getName))
			.collect(Collectors.toCollection(LinkedList::new));
		sortedPlayersByName.forEach(draw::insert);

		BinaryTreePrinter.printNode(draw.getRoot());
	}

}
