package rs.ac.bg.etf.pp1.util;

public class Var {

	private String name;
	private boolean array;

	public Var(String name, boolean array) {
		this.name = name;
		this.array = array;
	}

	public String getName() {
		return name;
	}

	public boolean isArray() {
		return array;
	}
}
