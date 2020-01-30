package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.AddExpression;
import rs.ac.bg.etf.pp1.ast.Addop;
import rs.ac.bg.etf.pp1.ast.AssignDesignator;
import rs.ac.bg.etf.pp1.ast.DecrementDesignator;
import rs.ac.bg.etf.pp1.ast.Divide;
import rs.ac.bg.etf.pp1.ast.DivideEquals;
import rs.ac.bg.etf.pp1.ast.FactorTerm;
import rs.ac.bg.etf.pp1.ast.IncrementDesignator;
import rs.ac.bg.etf.pp1.ast.Minus;
import rs.ac.bg.etf.pp1.ast.MinusEquals;
import rs.ac.bg.etf.pp1.ast.Mod;
import rs.ac.bg.etf.pp1.ast.ModEquals;
import rs.ac.bg.etf.pp1.ast.MulTerm;
import rs.ac.bg.etf.pp1.ast.Mulop;
import rs.ac.bg.etf.pp1.ast.Multiply;
import rs.ac.bg.etf.pp1.ast.MultiplyEquals;
import rs.ac.bg.etf.pp1.ast.Plus;
import rs.ac.bg.etf.pp1.ast.PlusEquals;
import rs.ac.bg.etf.pp1.ast.Read;
import rs.ac.bg.etf.pp1.ast.SimpleDesignator;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	@Override
	public void visit(SimpleDesignator simpleDesignator) {
		if (simpleDesignator.obj.getType().getKind() == Struct.Array) {
			Code.load(simpleDesignator.obj);
		}
	}

	@Override
	public void visit(FactorTerm factorTerm) {
		if (factorTerm.obj.getKind() != Obj.NO_VALUE) {
			Code.load(factorTerm.obj);
		}
	}

	@Override
	public void visit(AssignDesignator assignDesignator) {
		Code.store(assignDesignator.getDesignator().obj);
	}

	@Override
	public void visit(MulTerm mulTerm) {
		Code.load(mulTerm.getFactor().obj);
		Mulop operator = mulTerm.getMulop();
		if (operator instanceof Multiply) {
			Code.put(Code.mul);
			return;
		}
		if (operator instanceof Divide) {
			Code.put(Code.div);
			return;
		}
		if (operator instanceof Mod) {
			Code.put(Code.rem);
			return;
		}
		if (operator instanceof MultiplyEquals) {
			Code.put(Code.mul);
			Code.store(mulTerm.obj);
			return;
		}
		if (operator instanceof DivideEquals) {
			Code.put(Code.div);
			Code.store(mulTerm.obj);
			return;
		}
		if (operator instanceof ModEquals) {
			Code.put(Code.rem);
			Code.store(mulTerm.obj);
			return;
		}
	}

	@Override
	public void visit(AddExpression addExpression) {
		Addop operator = addExpression.getAddop();
		if (operator instanceof Minus) {
			Code.put(Code.sub);
			return;
		}
		if (operator instanceof Plus) {
			Code.put(Code.add);
			return;
		}
		if (operator instanceof MinusEquals) {
			Code.put(Code.sub);
			Code.store(addExpression.obj);
		}
		if (operator instanceof PlusEquals) {
			Code.put(Code.add);
			Code.store(addExpression.obj);
			return;
		}
	}

	@Override
	public void visit(IncrementDesignator incrementDesignator) {
		switch (incrementDesignator.obj.getKind()) {
		case Obj.Var:
			if (incrementDesignator.obj.getLevel() > 0) {
				Code.put(Code.inc);
				Code.put(incrementDesignator.obj.getAdr());
				Code.put(1);
			} else {
				Code.load(incrementDesignator.obj);
				Code.load(incrementDesignator.obj);
				Code.loadConst(1);
				Code.put(Code.add);
				Code.store(incrementDesignator.obj);
			}
			break;
		case Obj.Elem:
			Code.put(Code.dup2);
			Code.load(incrementDesignator.obj);
			Code.loadConst(1);
			Code.put(Code.add);
			Code.store(incrementDesignator.obj);
			break;
		default:
			break;
		}
	}

	@Override
	public void visit(DecrementDesignator decrementDesignator) {
		switch (decrementDesignator.obj.getKind()) {
		case Obj.Var:
			if (decrementDesignator.obj.getLevel() > 0) {
				Code.put(Code.inc);
				Code.put(decrementDesignator.obj.getAdr());
				Code.put(-1);
			} else {
				Code.load(decrementDesignator.obj);
				Code.load(decrementDesignator.obj);
				Code.loadConst(1);
				Code.put(Code.sub);
				Code.store(decrementDesignator.obj);
			}
			break;
		case Obj.Elem:
			Code.put(Code.dup2);
			Code.load(decrementDesignator.obj);
			Code.loadConst(1);
			Code.put(Code.sub);
			Code.store(decrementDesignator.obj);
		default:
			break;
		}
	}

	@Override
	public void visit(Read read) {
		Obj obj = read.getDesignator().obj;
		if (obj.getKind() == Obj.Var) {
			Code.put(obj.getAdr());
		}
		if (obj.getType().equals(Tab.intType)) {
			Code.put(Code.read);
		} else {
			Code.put(Code.bread);
		}
		Code.store(obj);
	}
}
