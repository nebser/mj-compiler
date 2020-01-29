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
			Symbol s = p.parse();

			Program prog = (Program) (s.value);

			// print syntax tree content
			Counter cnt = new Counter();
			prog.traverseTopDown(cnt);
			log.info("===============SINTAKSNA ANALIZA====================");
			log.info("\n" + cnt.toString());
			if (p.isErrorDetected()) {
				log.error("Program je sintaksno neispravan");
				return;
			}

			// semantics analysis
			log.info("==============SEMANTICKA ANALIZA====================");
			SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
			prog.traverseBottomUp(semanticAnalyzer);

			// symbol table dump
			log.info("============SADRZAJ TABELE SIMBOLA==================");
			log.info("\n" + Tab.getContent());
			boolean mainDetected = semanticAnalyzer.isMainDetected();
			if (!mainDetected) {
				log.error("Main funkcija nije definisana");
			}

			if (semanticAnalyzer.isErrorDetected() || !mainDetected) {
				log.error("Program nije semanticki ispravan");
				return;
			}

			// code generation
			if (args.length < 2) {
				log.error("Ime izlaznog objektnog fajla nije specificirano");
				return;
			}
			String objFileName = args[1];
			File objFile = new File(objFileName);
			if (objFile.exists()) {
				objFile.delete();
			}

			CodeGenerator codeGenerator = new CodeGenerator();
			prog.traverseBottomUp(codeGenerator);

			log.info("Kompilacija je uspesno zavrsena");

		} catch (Exception e) {
			log.error(e.toString());
		}
	}
}
