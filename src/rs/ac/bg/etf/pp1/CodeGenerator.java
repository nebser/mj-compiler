package rs.ac.bg.etf.pp1;

import java.util.Collection;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.AddExpression;
import rs.ac.bg.etf.pp1.ast.Addop;
import rs.ac.bg.etf.pp1.ast.AssignDesignator;
import rs.ac.bg.etf.pp1.ast.DecrementDesignator;
import rs.ac.bg.etf.pp1.ast.DesignatorWithActParsFactor;
import rs.ac.bg.etf.pp1.ast.FactorTerm;
import rs.ac.bg.etf.pp1.ast.FunctionCall;
import rs.ac.bg.etf.pp1.ast.GlobalVariableDeclarations;
import rs.ac.bg.etf.pp1.ast.IncrementDesignator;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodHeader;
import rs.ac.bg.etf.pp1.ast.MulTerm;
import rs.ac.bg.etf.pp1.ast.Mulop;
import rs.ac.bg.etf.pp1.ast.NewArrayFactor;
import rs.ac.bg.etf.pp1.ast.Print;
import rs.ac.bg.etf.pp1.ast.PrintWithNumber;
import rs.ac.bg.etf.pp1.ast.Read;
import rs.ac.bg.etf.pp1.ast.Return;
import rs.ac.bg.etf.pp1.ast.SimpleDesignator;
import rs.ac.bg.etf.pp1.ast.UnaryMinusExpression;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.ac.bg.etf.pp1.util.Tab;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	private final int WORD_SIZE = 4;

	Logger log = Logger.getLogger(getClass());

	@Override
	public void visit(GlobalVariableDeclarations globalVariableDeclarations) {
		VarCounter cnt = new VarCounter();
		globalVariableDeclarations.traverseTopDown(cnt);
		Code.dataSize = cnt.getCount() * WORD_SIZE;
	}

	@Override
	public void visit(SimpleDesignator simpleDesignator) {
		if (simpleDesignator.obj.getType().getKind() == Struct.Array) {
			Code.load(simpleDesignator.obj);
		}

	}

	@Override
	public void visit(FactorTerm factorTerm) {
		int kind = factorTerm.obj.getKind();
		if (kind != Obj.NO_VALUE && kind != Obj.Meth) {
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
		operator.accept(new OperationCodeGenerator(mulTerm));
	}

	@Override
	public void visit(AddExpression addExpression) {
		Addop operator = addExpression.getAddop();
		operator.accept(new OperationCodeGenerator(addExpression));
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
		if (obj.getType().equals(Tab.intType)) {
			Code.put(Code.read);
		} else {
			Code.put(Code.bread);
		}
		Code.store(obj);
	}

	private void printBool(int width) {
		Code.loadConst(1);
		int offsetAddress = Code.pc + 1;
		Code.putFalseJump(Code.ne, 0);

		Code.loadConst('f');
		Code.loadConst(width);
		Code.put(Code.bprint);

		Code.loadConst('a');
		Code.loadConst(1);
		Code.put(Code.bprint);

		Code.loadConst('l');
		Code.loadConst(1);
		Code.put(Code.bprint);

		Code.loadConst('s');
		Code.loadConst(1);
		Code.put(Code.bprint);

		Code.loadConst('e');
		Code.loadConst(1);
		Code.put(Code.bprint);

		int jumpOffset = Code.pc + 1;

		Code.putJump(0);

		Code.fixup(offsetAddress);

		Code.loadConst('t');
		Code.loadConst(width);
		Code.put(Code.bprint);

		Code.loadConst('r');
		Code.loadConst(1);
		Code.put(Code.bprint);

		Code.loadConst('u');
		Code.loadConst(1);
		Code.put(Code.bprint);

		Code.loadConst('e');
		Code.loadConst(1);
		Code.put(Code.bprint);

		Code.fixup(jumpOffset);
	}

	private void printInt(int width) {
		Code.loadConst(width);
		Code.put(Code.print);
	}

	private void printChar(int width) {
		Code.loadConst(width);
		Code.put(Code.bprint);
	}

	@Override
	public void visit(Print print) {
		Struct type = print.getExpr().obj.getType();
		if (type.equals(Tab.intType)) {
			printInt(1);
		} else if (type.equals(Tab.boolType)) {
			printBool(1);

		} else if (type.equals(Tab.charType)) {
			printChar(1);
		}
	}

	@Override
	public void visit(PrintWithNumber printWithNumber) {
		Struct type = printWithNumber.getExpr().obj.getType();
		if (type.equals(Tab.intType)) {
			printInt(printWithNumber.getWidth());
		} else if (type.equals(Tab.boolType)) {
			printBool(printWithNumber.getWidth());

		} else if (type.equals(Tab.charType)) {
			printChar(printWithNumber.getWidth());
		}
	}

	@Override
	public void visit(NewArrayFactor newArrayFactor) {
		Code.put(Code.newarray);
		if (newArrayFactor.getType().struct.equals(Tab.intType)) {
			Code.put(1);
		} else {
			Code.put(0);
		}
	}

	@Override
	public void visit(UnaryMinusExpression unaryMinusExpression) {
		Code.put(Code.neg);
	}

	@Override
	public void visit(DesignatorWithActParsFactor designatorWithActualPars) {
		int addr = designatorWithActualPars.getDesignator().obj.getAdr() - Code.pc;

		Code.put(Code.call);
		Code.put2(addr);
	}

	@Override
	public void visit(FunctionCall functionCall) {
		Obj desObj = functionCall.getDesignator().obj;
		int addr = desObj.getAdr() - Code.pc;

		Code.put(Code.call);
		Code.put2(addr);

		if (!desObj.getType().equals(Tab.noType)) {
			Code.put(Code.pop);
		}
	}

	@Override
	public void visit(MethodHeader methodHeader) {
		methodHeader.obj.setAdr(Code.pc);
		if (methodHeader.obj.getName().equals("main")) {
			Code.mainPc = Code.pc;
		}
		Collection<Obj> locals = methodHeader.obj.getLocalSymbols();

		Code.put(Code.enter);
		Code.put(methodHeader.obj.getLevel());
		Code.put(locals.size());
	}

	@Override
	public void visit(MethodDecl methodDecl) {
		// check if return is not the last
		if (Code.buf[Code.pc - 1] != (byte) Code.return_) {
			Code.put(Code.exit);
			Code.put(Code.return_);
		}
	}

	@Override
	public void visit(Return return_) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

}
