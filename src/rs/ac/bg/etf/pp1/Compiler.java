package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.ac.bg.etf.pp1.util.Tab;
import rs.etf.pp1.mj.runtime.Code;

public class Compiler {
	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
		log = Logger.getLogger(Compiler.class);
	}

	private static Logger log;

	public static void main(String[] args) {
		String fileName = args[0];
		File sourceCode = new File(fileName);
		log.info("Kompilacija fajla: " + sourceCode.getAbsolutePath());

		try (Reader br = new BufferedReader(new FileReader(sourceCode))) {
			Tab.init();
			Yylex lexer = new Yylex(br);

			MJParser p = new MJParser(lexer);
			Symbol s = p.parse();

			if (lexer.isErrorDetected()) {
				log.info("Program je leksicki neispravan");
				return;
			}

			Program prog = (Program) (s.value);

			// print syntax tree
			System.out.println("===============SINTAKSNO STABLO=====================");
			System.out.println(prog.toString(""));

			// print syntax tree content
			Counter cnt = new Counter();
			prog.traverseTopDown(cnt);
			String content = cnt.toString();
			log.info("===============SINTAKSNA ANALIZA====================");
			log.info("\n" + content);

			// check if program is valid
			if (p.isErrorDetected()) {
				log.info("Program je sintaksno neispravan");
				return;
			}

			// semantics analysis
			log.info("==============SEMANTICKA ANALIZA====================");
			SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
			prog.traverseBottomUp(semanticAnalyzer);

			// symbol table dump
			tsdump();

			boolean mainDetected = semanticAnalyzer.isMainDetected();
			if (!mainDetected) {
				log.error("Main funkcija nije definisana");
			}

			if (semanticAnalyzer.isErrorDetected() || !mainDetected) {
				log.info("Program nije semanticki ispravan");
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

			FileOutputStream output = new FileOutputStream(objFile);
			Code.write(output);

			log.info("Kompilacija je uspesno zavrsena");

		} catch (Exception e) {
			log.error(e.toString());
		}
	}

	public static void tsdump() {
		log.info("============SADRZAJ TABELE SIMBOLA==================");
		log.info("\n" + Tab.getContent());
	}
}
