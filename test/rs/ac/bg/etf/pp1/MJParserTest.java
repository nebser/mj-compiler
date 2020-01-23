package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;

public class MJParserTest {
	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}

	public static void main(String[] args) {
		Logger log = Logger.getLogger(MJParserTest.class);
		String fileName = args[0];
		File sourceCode = new File(fileName);
		log.info("Compiling source file: " + sourceCode.getAbsolutePath());
		try (Reader br = new BufferedReader(new FileReader(sourceCode))) {
			Yylex lexer = new Yylex(br);

			MJParser p = new MJParser(lexer);
			Symbol s = p.parse(); // pocetak parsiranja

			Program prog = (Program) (s.value);
			// ispis sintaksnog stabla
			log.info(prog.toString(""));
			log.info("===================================");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		}
	}
}