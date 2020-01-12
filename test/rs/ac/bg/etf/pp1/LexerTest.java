package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.util.Log4JUtils;

public class LexerTest {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}

	public static void main(String[] args) throws IOException {
		Logger log = Logger.getLogger(LexerTest.class);
		String fileName = args[0];
		File sourceCode = new File(fileName);
		log.info("Compiling source file: " + sourceCode.getAbsolutePath());
		try (Reader br = new BufferedReader(new FileReader(sourceCode))) {
			Yylex lexer = new Yylex(br);
			Symbol currToken = null;
			while (true) {
				try {
					currToken = lexer.next_token();
					if (currToken.sym == sym.EOF) {
						break;
					}
					if (currToken != null && currToken.value != null)
						log.info(currToken.toString() + " " + currToken.value.toString());
				} catch (LexerException e) {
					log.error(e.toString());
				}
			}
		}
	}

}
