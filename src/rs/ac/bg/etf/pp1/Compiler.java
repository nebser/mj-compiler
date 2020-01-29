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
import rs.ac.bg.etf.pp1.util.Tab;

public class Compiler {
	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}

	public static void main(String[] args) {
		Logger log = Logger.getLogger(Compiler.class);
		String fileName = args[0];
		File sourceCode = new File(fileName);
		log.info("Kompilacija fajla: " + sourceCode.getAbsolutePath());
		try (Reader br = new BufferedReader(new FileReader(sourceCode))) {
			Tab.init();
			Yylex lexer = new Yylex(br);

			MJParser p = new MJParser(lexer);
			Symbol s = p.parse(); // pocetak parsiranja

			Program prog = (Program) (s.value);
			// ispis sintaksnog stabla
			log.info(prog.toString(""));
			log.info("===================================");

			SemanticAnalyzer sa = new SemanticAnalyzer();
			prog.traverseBottomUp(sa);

			Tab.dump();
			boolean mainDetected = sa.isMainDetected();
			if (!mainDetected) {
				log.info("Main funkcija nije definisana");
			}

			if (sa.isErrorDetected() || !mainDetected) {
				log.info("Program nije semanticki ispravan");
				return;
			}

			String objFileName = args[1];
			File objFile = new File(objFileName);
			if (objFile.exists()) {
				objFile.delete();
			}

			CodeGenerator cg = new CodeGenerator();
			prog.traverseBottomUp(cg);

			log.info("Kompilacija je uspesno zavrsena");

		} catch (Exception e) {
			log.error(e.toString());
		}
	}
}
