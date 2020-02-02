package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.ArrayVar;
import rs.ac.bg.etf.pp1.ast.ClassName;
import rs.ac.bg.etf.pp1.ast.Constant;
import rs.ac.bg.etf.pp1.ast.DesignatorWithActParsFactor;
import rs.ac.bg.etf.pp1.ast.ForStmt;
import rs.ac.bg.etf.pp1.ast.FunctionCall;
import rs.ac.bg.etf.pp1.ast.MatchedStmt;
import rs.ac.bg.etf.pp1.ast.MethodHeader;
import rs.ac.bg.etf.pp1.ast.Print;
import rs.ac.bg.etf.pp1.ast.PrintWithNumber;
import rs.ac.bg.etf.pp1.ast.Read;
import rs.ac.bg.etf.pp1.ast.RegularPrefix;
import rs.ac.bg.etf.pp1.ast.UnmatchedStmt;
import rs.ac.bg.etf.pp1.ast.Variable;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {
	protected int count;

	public int getCount() {
		return count;
	}

	public static class VarCounter extends CounterVisitor {

		@Override
		public void visit(Variable variable) {
			count++;
		}

		@Override
		public void visit(RegularPrefix regularVarPrefix) {
			count++;
		}

	}

	public static class ArrayCounter extends CounterVisitor {

		@Override
		public void visit(ArrayVar arrayVar) {
			count++;
		}
	}

	public static class StatementCounter extends CounterVisitor {

		@Override
		public void visit(MatchedStmt matchedStmt) {
			count++;
		}

		@Override
		public void visit(UnmatchedStmt unmatchedStmt) {
			count++;
		}

		@Override
		public void visit(ForStmt forStmt) {
			count++;
		}
	}

	public static class MethodCounter extends CounterVisitor {

		@Override
		public void visit(MethodHeader methodHeader) {
			count++;
		}
	}

	public static class ClassCounter extends CounterVisitor {

		@Override
		public void visit(ClassName className) {
			count++;
		}
	}

	public static class ConstCounter extends CounterVisitor {

		@Override
		public void visit(Constant constant) {
			count++;
		}
	}

	public static class FunctionCallCounter extends CounterVisitor {

		@Override
		public void visit(DesignatorWithActParsFactor designatorWithActParsFactor) {
			count++;
		}

		@Override
		public void visit(FunctionCall functionCall) {
			count++;
		}

		@Override
		public void visit(Read read) {
			count++;
		}

		@Override
		public void visit(Print print) {
			count++;
		}

		@Override
		public void visit(PrintWithNumber printWithNumber) {
			count++;
		}

	}
}
