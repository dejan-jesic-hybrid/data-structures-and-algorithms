import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import model.TestObject;
import org.junit.Test;

public class ContainsItemInCollections extends AbstractData {

	@Test
	public void containsItemInArrayListUsingNewButEqualObject() {
		List<TestObject> list = new ArrayList<>();
		fillListWith_100_000_000_Items(testObject, list);
		var objectToSearchFor = TestObject.builder()
			.string(list.get(99_000_000).getString())
			.bigDecimal(list.get(99_000_000).getBigDecimal())
			.integer(list.get(99_000_000).getInteger())
			.month(list.get(99_000_000).getMonth())
			.dates(Collections.singletonList(LocalDate.EPOCH))
			.build();

		var start = System.nanoTime();
		list.contains(objectToSearchFor);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to find item in array list: %s", toMillis(start, end)));
		// Execution time: 0.000 (average)
	}

	@Test
	public void containsItemInArrayListUsingNewButUnequalObject() {
		List<TestObject> list = new ArrayList<>();
		fillListWith_100_000_000_Items(testObject, list);
		var objectToSearchFor = TestObject.builder()
			.string(list.get(0).getString())
			.bigDecimal(list.get(0).getBigDecimal())
			.integer(list.get(0).getInteger())
			.month(Month.AUGUST)
			.build();

		var start = System.nanoTime();
		list.contains(objectToSearchFor);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to find item in array list: %s", toMillis(start, end)));
		// Execution time: 574.000 millis (average)
	}

	@Test
	public void containsItemInLinkedListMiddleItem() {
		List<TestObject> list = new LinkedList<>();
		fillListWith_100_000_000_Items(testObject, list);
		var objectToSearchFor = TestObject.builder()
			.integer(Integer.MIN_VALUE)
			.string(UUID.randomUUID().toString())
			.build();

		var start = System.nanoTime();
		list.contains(objectToSearchFor);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to find item in linked list: %s", toMillis(start, end)));
		// Execution time: 879.000 (average)
	}

	@Test
	public void containsItemInHashSet() {
		Set<TestObject> set = new HashSet<>();
		fillSetWith_100_000_000_Items(testObject, set);
		var objectToSearchFor = TestObject.builder()
			.integer(Integer.MIN_VALUE)
			.string(UUID.randomUUID().toString())
			.build();

		var start = System.nanoTime();
		set.contains(objectToSearchFor);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to find item in hash set: %s", (end - start) / 1_000_000));
		// Execution time: 0.137 (average)
	}

}
