package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestObject {

	private String string;

	private Integer integer;

	private BigDecimal bigDecimal;

	private Month month;

	private List<LocalDate> dates;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TestObject that = (TestObject) o;
		return getString().equals(that.getString()) &&
			getInteger().equals(that.getInteger()) &&
			getBigDecimal().equals(that.getBigDecimal()) &&
			getMonth() == that.getMonth();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getString(), getInteger(), getBigDecimal(), getMonth());
	}

}
