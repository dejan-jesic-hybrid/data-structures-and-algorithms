import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import model.TestObject;
import org.junit.Before;

public abstract class AbstractData {

	TestObject testObject;

	@Before
	public void init() {
		testObject = TestObject.builder()
			.bigDecimal(BigDecimal.TEN)
			.month(Month.JANUARY)
			.integer(Integer.MAX_VALUE)
			.dates(Arrays.asList(LocalDate.MAX, LocalDate.MIN, LocalDate.EPOCH))
			.build();
	}

	void fillListWith_100_000_000_Items(TestObject testObject, List<TestObject> list) {
		for (int index = 0; index < 100_000_000; index++) {
			testObject.setString(UUID.randomUUID().toString());
			list.add(testObject);
		}
	}

	void fillSetWith_100_000_000_Items(TestObject testObject, Set<TestObject> set) {
		for (int index = 0; index < 100_000_000; index++) {
			testObject.setString(UUID.randomUUID().toString());
			set.add(testObject);
		}
	}

	BigDecimal toMillis(long start, long end) {
		return BigDecimal.valueOf((end - start))
			.divide(BigDecimal.valueOf(1_000_000), RoundingMode.HALF_UP)
			.setScale(3, RoundingMode.HALF_UP);
	}

}
