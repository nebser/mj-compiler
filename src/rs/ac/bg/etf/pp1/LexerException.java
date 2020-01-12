package rs.ac.bg.etf.pp1;

public class LexerException extends Error {
	private String symbol;
	private int line;
	private int column;

	public LexerException(String symbol, int line, int column) {
		this.symbol = symbol;
		this.line = line;
		this.column = column;
	}

	public String toString() {
		return "Leksicka greska (" + this.symbol + ") u liniji " + this.line + " i koloni " + this.column;
	}
}
