package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.ArrayVar;
import rs.ac.bg.etf.pp1.ast.PrimitiveVar;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {
	protected int count;

	public int getCount() {
		return count;
	}

	public static class VarCounter extends CounterVisitor {

		@Override
		public void visit(PrimitiveVar primitiveVar) {
			count++;
		}

		@Override
		public void visit(ArrayVar arrayVar) {
			count++;
		}
	}
}
