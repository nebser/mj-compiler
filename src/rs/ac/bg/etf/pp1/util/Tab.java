package rs.ac.bg.etf.pp1.util;

import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class Tab extends rs.etf.pp1.symboltable.Tab {
	public static final Struct boolType = new Struct(Struct.Bool);

	public static void init() {
		rs.etf.pp1.symboltable.Tab.init();
		currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}

	public static Obj insert(int kind, String name, Struct type, int addr) {
		Obj created = insert(kind, name, type);
		created.setAdr(addr);
		return created;
	}

	public static Obj insert(int kind, String name, Struct type, int addr, int level) {
		Obj created = insert(kind, name, type);
		created.setAdr(addr);
		created.setLevel(level);
		return created;
	}

	public static String getContent() {
		DumpSymbolTableVisitor stv = new DumpSymbolTableVisitor();
		for (Scope s = currentScope; s != null; s = s.getOuter()) {
			s.accept(stv);
		}
		return stv.getOutput();
	}
}
