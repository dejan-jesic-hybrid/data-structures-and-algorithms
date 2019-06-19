package model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Title {

	private int aptPoints;

	private String city;

	private LocalDate date;

}
