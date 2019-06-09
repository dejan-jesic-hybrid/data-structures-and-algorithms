import java.util.ArrayList;
import java.util.List;

import model.TestObject;
import org.junit.Test;

public class InitializationOfList extends AbstractData {

	@Test
	public void arrayListDefaultSize() {
		List<TestObject> arrayListDefaultSize = new ArrayList<>();

		var start = System.nanoTime();
		fillListWith_100_000_000_Items(testObject, arrayListDefaultSize);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to populate list with default capacity: %s", toMillis(start, end)));
		// Execution time: 2526.644 millis (average)
	}

	@Test
	public void arrayList_1_000_000_Size() {
		List<TestObject> arrayList_1_000_000_Size = new ArrayList<>(100_000_000);

		var start = System.nanoTime();
		fillListWith_100_000_000_Items(testObject, arrayList_1_000_000_Size);
		var end = System.nanoTime();

		System.err.println(String.format("Millis to populate list with 1.000.000 capacity: %s", toMillis(start, end)));
		// Execution time: 1004.418 millis (average)
	}

}
