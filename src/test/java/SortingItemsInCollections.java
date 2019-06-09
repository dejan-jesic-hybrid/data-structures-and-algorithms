import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import model.TestObject;
import org.junit.Test;

public class SortingItemsInCollections extends AbstractData {

	@Test
	public void sortItemsArrayList() {
		List<TestObject> list = new ArrayList<>();
		fillListWith_100_000_000_Items(testObject, list);
		list.forEach(item -> item.setString(UUID.randomUUID().toString()));

		var start = System.nanoTime();
		list.sort(Comparator.comparing(TestObject::getString));
		var end = System.nanoTime();

		System.err.println(String.format("Millis to sort items in array list: %s", toMillis(start, end)));
		// Execution time: 792.924 millis (average)
	}

	@Test
	public void sortItemsLinkedList() {
		List<TestObject> list = new LinkedList<>();
		fillListWith_100_000_000_Items(testObject, list);
		list.forEach(item -> item.setString(UUID.randomUUID().toString()));

		var start = System.nanoTime();
		list.sort(Comparator.comparing(TestObject::getString));
		var end = System.nanoTime();

		System.err.println(String.format("Millis to sort items in linked list: %s", toMillis(start, end)));
		// Execution time: 4843.979 millis (average)
	}

	@Test
	public void sortItemsHashSetUsingStreamAPI() {
		Set<TestObject> set = new HashSet<>();
		fillSetWith_100_000_000_Items(testObject, set);

		var start = System.nanoTime();
		set.stream().sorted(Comparator.comparing(TestObject::getString))
			.collect(Collectors.toCollection(LinkedHashSet::new));
		var end = System.nanoTime();

		System.err.println(String.format("Millis to sort items in set: %s", toMillis(start, end)));
		// Execution time: ? (average)
	}

	@Test
	public void sortItemsHashSetUsingList() {
		Set<TestObject> set = new HashSet<>();
		fillSetWith_100_000_000_Items(testObject, set);

		var start = System.nanoTime();
		new ArrayList<>(set).sort(Comparator.comparing(TestObject::getString));
		var end = System.nanoTime();

		System.err.println(String.format("Millis to sort items in set: %s", toMillis(start, end)));
		// Execution time: 16659.247 (average)
	}

}
