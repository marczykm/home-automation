package pl.marczyk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Created by marcin.marczyk on 2016-03-24.
 */
@Entity
public class Switch {

	@Transient
	private final int ON_VALUE = 1;
	@Transient
	private final int OFF_VALUE = 0;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private int value;

	private String onScript;

	private String offScript;

	public Switch() {
	}

	public void on() {
		value = ON_VALUE;
	}

	public void off() {
		value = OFF_VALUE;
	}

	public int toggle() {
		value = value == ON_VALUE ? OFF_VALUE : ON_VALUE;
		return value;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public String getOnScript() {
		return onScript;
	}

	public String getOffScript() {
		return offScript;
	}
}
