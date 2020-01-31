package rs.ac.bg.etf.pp1;

import java.util.ArrayList;

import rs.ac.bg.etf.pp1.ast.ArrayVar;
import rs.ac.bg.etf.pp1.ast.ClassName;
import rs.ac.bg.etf.pp1.ast.Constant;
import rs.ac.bg.etf.pp1.ast.DesignatorWithActParsFactor;
import rs.ac.bg.etf.pp1.ast.FieldDecl;
import rs.ac.bg.etf.pp1.ast.ForStmt;
import rs.ac.bg.etf.pp1.ast.FunctionCall;
import rs.ac.bg.etf.pp1.ast.GlobalMethodHeader;
import rs.ac.bg.etf.pp1.ast.GlobalVarDecl;
import rs.ac.bg.etf.pp1.ast.MathedStmt;
import rs.ac.bg.etf.pp1.ast.MethodHeader;
import rs.ac.bg.etf.pp1.ast.PrimitiveVar;
import rs.ac.bg.etf.pp1.ast.Print;
import rs.ac.bg.etf.pp1.ast.PrintWithNumber;
import rs.ac.bg.etf.pp1.ast.Read;
import rs.ac.bg.etf.pp1.ast.RegularVarDecl;
import rs.ac.bg.etf.pp1.ast.Statement;
import rs.ac.bg.etf.pp1.ast.UnmatchedStmt;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class Counter extends VisitorAdaptor {
	private enum VarDeclMode {
		GLOBAL, LOCAL, FIELD
	};

	private int globalVarDeclarations = 0;
	private int constDeclarations = 0;
	private int classDeclarations = 0;
	private int methodDeclarations = 0;
	private int globalArrayDeclarations = 0;
	private VarDeclMode varDeclMode;
	private ArrayList<MethodContext> methods = new ArrayList<MethodContext>();
	private MethodContext currentMethod;

	private class MethodContext {
		private int localVariables;
		private int functionCalls;
		private int statements;
		private String methodName;

		public MethodContext(String methodName) {
			this.methodName = methodName;
			this.localVariables = 0;
			this.functionCalls = 0;
			this.statements = 0;
		}

		public void detectLocalVariable() {
			localVariables++;
		}

		public void detectFunctionCall() {
			functionCalls++;
		}

		public void detectStatement() {
			statements++;
		}

		public String toString() {
			StringBuilder msg = new StringBuilder();
			msg.append(localVariables).append("\tlokalnih promenljivih u metodi ").append(methodName).append('\n');
			msg.append(functionCalls).append("\tpoziva funkcija u metodi ").append(methodName).append('\n');
			msg.append(statements).append("\tiskaza u metodi ").append(methodName).append('\n');
			return msg.toString();
		}

	};

	@Override
	public void visit(GlobalVarDecl globalVarDecl) {
		varDeclMode = VarDeclMode.GLOBAL;
	}

	@Override
	public void visit(RegularVarDecl regularVarDecl) {
		varDeclMode = VarDeclMode.LOCAL;
	}

	@Override
	public void visit(FieldDecl fieldDecl) {
		varDeclMode = VarDeclMode.FIELD;
	}

	@Override
	public void visit(PrimitiveVar PrimitiveVar) {
		switch (varDeclMode) {
		case GLOBAL:
			globalVarDeclarations++;
			break;
		case LOCAL:
			currentMethod.detectLocalVariable();
			break;
		default:
			break;
		}
	}

	@Override
	public void visit(ArrayVar arrayVar) {
		switch (varDeclMode) {
		case GLOBAL:
			globalArrayDeclarations++;
			globalVarDeclarations++;
			break;
		case LOCAL:
			currentMethod.detectLocalVariable();
			break;
		default:
			break;
		}
	}

	@Override
	public void visit(MethodHeader methodHeader) {
		methodDeclarations++;
		currentMethod = new MethodContext(methodHeader.getIdent());
		methods.add(currentMethod);
	}

	@Override
	public void visit(GlobalMethodHeader globalMethodHeader) {
		methodDeclarations++;
		currentMethod = new MethodContext(globalMethodHeader.getIdent());
		methods.add(currentMethod);
	}

	@Override
	public void visit(Statement statement) {
		currentMethod.detectStatement();
	}

	@Override
	public void visit(DesignatorWithActParsFactor designatorWithActParsFactor) {
		currentMethod.detectFunctionCall();
	}

	@Override
	public void visit(FunctionCall functionCall) {
		currentMethod.detectFunctionCall();
	}

	@Override
	public void visit(Read read) {
		currentMethod.detectFunctionCall();
	}

	@Override
	public void visit(Print print) {
		currentMethod.detectFunctionCall();
	}

	@Override
	public void visit(PrintWithNumber printWithNumber) {
		currentMethod.detectFunctionCall();
	}

	@Override
	public void visit(ClassName ClassName) {
		classDeclarations++;
	}

	@Override
	public void visit(Constant Constant) {
		constDeclarations++;
	}

	@Override
	public void visit(UnmatchedStmt unmatchedStmt) {
		currentMethod.detectStatement();
	}

	@Override
	public void visit(ForStmt forStmt) {
		currentMethod.detectStatement();
	}

	@Override
	public void visit(MathedStmt MathedStmt) {
		currentMethod.detectStatement();
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append(classDeclarations).append("\tklasa\n");
		msg.append(methodDeclarations).append("\tmetoda u programu\n");
		msg.append(globalVarDeclarations).append("\tglobalnih promenljivih\n");
		msg.append(constDeclarations).append("\tglobalnih konstanti\n");
		msg.append(globalArrayDeclarations).append("\tglobalnih nizova\n");
		methods.forEach(m -> msg.append(m.toString()));
		return msg.toString();
	}
}
