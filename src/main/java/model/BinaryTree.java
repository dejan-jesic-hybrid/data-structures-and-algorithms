package model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BinaryTree {

	private Node root;

	@Getter
	@Setter
	@RequiredArgsConstructor()
	public static class Node {

		// player's rank
		@NonNull
		private int key;

		@NonNull
		private Player value;

		private Node left, right;

	}

	public void insert(Player player) {
		this.root = insertPlayer(root, player);
	}

	private Node insertPlayer(Node node, Player player) {
		final Node newNode = new Node(player.getRank(), player);

		if (node == null) {
			node = newNode;
			return node;
		}

		if (player.getRank() < node.key) {
			node.left = insertPlayer(node.left, player);
		} else {
			node.right = insertPlayer(node.right, player);
		}

		return node;
	}

}
