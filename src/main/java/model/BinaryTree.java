package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTree {

	private Node root;

	@Getter
	@Setter
	public static class Node {

		// player's rank
		private int key;

		private Player value;

		private Node left;

		private Node right;

		private Node() {

		}

		private Node(final int key, final Player value) {
			this.key = key;
			this.value = value;
		}

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
