package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Player {

	private String name;

	private String description;

	private int age;

	private int rank;

	private int atpPoints;

	private String country;

	private LocalDate dateOfBirth;

	private List<Title> titles;

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Player player = (Player) o;
		return getName().equals(player.getName()) &&
			getCountry().equals(player.getCountry()) &&
			getDateOfBirth().equals(player.getDateOfBirth());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getCountry(), getDateOfBirth());
	}

}
