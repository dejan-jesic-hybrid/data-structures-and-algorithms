package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.BinaryTree;
import model.BinaryTree.Node;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BinaryTreePrinter {

	public static void printNode(BinaryTree.Node root) {
		int maxLevel = BinaryTreePrinter.maxLevel(root);
		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BinaryTreePrinter.isAllElementsNull(nodes)) {
			return;
		}

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BinaryTreePrinter.printWhitespaces(firstSpaces);

		List<Node> newNodes = new ArrayList<>();
		for (Node node : nodes) {
			if (node != null) {
				System.out.print(node.getKey());
				newNodes.add(node.getLeft());
				newNodes.add(node.getRight());
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}
			BinaryTreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("\n");

		for (int i = 1; i <= endgeLines; i++) {
			for (Node node : nodes) {
				BinaryTreePrinter.printWhitespaces(firstSpaces - i);
				if (node == null) {
					BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (node.getLeft() != null) {
					System.out.print("/");
				} else {
					BinaryTreePrinter.printWhitespaces(1);
				}

				BinaryTreePrinter.printWhitespaces(i + i - 1);

				if (node.getRight() != null) {
					System.out.print("\\");
				} else {
					BinaryTreePrinter.printWhitespaces(1);
				}

				BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println();
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static int maxLevel(Node node) {
		if (node == null) {
			return 0;
		}
		return Math.max(
			BinaryTreePrinter.maxLevel(node.getLeft()),
			BinaryTreePrinter.maxLevel(node.getRight())
		) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}
		return true;
	}

}