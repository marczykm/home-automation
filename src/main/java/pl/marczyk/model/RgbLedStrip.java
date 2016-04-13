package pl.marczyk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by marcin.marczyk on 2016-03-24.
 */
@Entity
public class RgbLedStrip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String name;

	private int red;
	private int green;
	private int blue;

	private String script;

	public RgbLedStrip() {
	}

	public void setValue(int r, int g, int b) {
		this.red = r;
		this.green = g;
		this.blue = b;
	}

	public void on() {
		setValue(255, 255, 255);
	}

	public void off() {
		setValue(0, 0, 0);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}

	public String getScript() {
		return script;
	}

	@Override public String toString() {
		return "RgbLedStrip{" +
				"id=" + id +
				", name='" + name + '\'' +
				", red=" + red +
				", green=" + green +
				", blue=" + blue +
				'}';
	}
}
