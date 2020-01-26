package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.ArrayDesignatorSuffix;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.ObjectDesignatorSuffix;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class Backpatcher extends VisitorAdaptor {
	private Obj lastField = null;
	private boolean errorDetected = false;

	Logger log = Logger.getLogger(getClass());

	public void reportError(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	private void reportSymbol(String start, Obj obj, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(start + " ");
		msg.append(obj.getName());
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		DumpSymbolTableVisitor stv = new DumpSymbolTableVisitor();
		stv.visitObjNode(obj);
		msg.append(". Cvor u tabeli simbola:\n").append(stv.getOutput());
		log.info(msg.toString());
	}

	@Override
	public void visit(Designator designator) {
		Obj obj = Tab.find(designator.getIdent());
		if (obj == Tab.noObj) {
			reportError("Simbol " + designator.getIdent() + " nije definisan", designator);
			return;
		}
		lastField = obj;
	}

	public void visit(ObjectDesignatorSuffix objectDesignatorSuffix) {
		if (lastField == null) {
			return;
		}
		String className = lastField.getName();
		if (lastField.getType().getKind() != Struct.Class) {
			reportError("Simbol " + className + " nije klasa pa se ne moze pristupiti njegovim poljima",
					objectDesignatorSuffix);
			return;
		}
		String fieldName = objectDesignatorSuffix.getIdent();
		Obj obj = lastField.getType().getMembersTable().searchKey(fieldName);
		if (obj == null) {
			reportError("Klasa " + className + " nema polje ili metodu " + fieldName, objectDesignatorSuffix);
			return;
		}
		lastField = obj;
	}

	public void visit(ArrayDesignatorSuffix arrayDesignatorSuffix) {
		if (lastField == null) {
			return;
		}
		String arrayName = lastField.getName();
		if (lastField.getType().getKind() != Struct.Array) {
			reportError("Simbol " + arrayName + " nije niz pa se ne moze indeksirati",
					arrayDesignatorSuffix.getParent());
			return;
		}
		reportSymbol("Pristupa se elementu niza", lastField, arrayDesignatorSuffix.getParent());
	}

	public boolean isErrorDetected() {
		return errorDetected;
	}
}
