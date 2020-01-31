package rs.ac.bg.etf.pp1.util;

import rs.etf.pp1.symboltable.concepts.Struct;

public class DumpSymbolTableVisitor extends rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor {
	public void visitStructNode(Struct structToVisit) {
		switch (structToVisit.getKind()) {
		case Struct.Bool:
			output.append("bool");
			break;
		case Struct.Array:
			if (structToVisit.getElemType().getKind() == Struct.Bool) {
				output.append("Arr of bool");
			} else {
				super.visitStructNode(structToVisit);
			}
			break;
		default:
			super.visitStructNode(structToVisit);
		}
	}
}
