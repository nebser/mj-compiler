package rs.ac.bg.etf.pp1;

public class LexerException extends Exception {
	private String symbol;
	private int line;

	public LexerException(String symbol, int line) {
		this.symbol = symbol;
		this.line = line;
	}

	public String toString() {
		return "Leksicka greska (" + this.symbol + ") u liniji " + this.line;
	}
}
