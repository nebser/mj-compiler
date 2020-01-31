package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.AddExpression;
import rs.ac.bg.etf.pp1.ast.Divide;
import rs.ac.bg.etf.pp1.ast.Minus;
import rs.ac.bg.etf.pp1.ast.Mod;
import rs.ac.bg.etf.pp1.ast.MulTerm;
import rs.ac.bg.etf.pp1.ast.Multiply;
import rs.ac.bg.etf.pp1.ast.Plus;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;

public class OperationCodeGenerator extends VisitorAdaptor {
	private MulTerm mulTerm;
	private AddExpression addExpression;

	public OperationCodeGenerator(MulTerm mulTerm) {
		this.mulTerm = mulTerm;
	}

	public OperationCodeGenerator(AddExpression addExpression) {
		this.addExpression = addExpression;
	}

	@Override
	public void visit(Multiply multiply) {
		Code.put(Code.mul);
	}

	@Override
	public void visit(Divide divide) {
		Code.put(Code.div);
	}

	@Override
	public void visit(Mod mod) {
		Code.put(Code.rem);
	}

	@Override
	public void visit(Minus minus) {
		Code.put(Code.sub);
	}

	@Override
	public void visit(Plus plus) {
		Code.put(Code.add);
	}
}
