package rs.ac.bg.etf.pp1;

import java.util.ArrayList;

import rs.ac.bg.etf.pp1.CounterVisitor.ArrayCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.FunctionCallCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.StatementCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.ClassName;
import rs.ac.bg.etf.pp1.ast.Constant;
import rs.ac.bg.etf.pp1.ast.GlobalVariableDeclarations;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class Counter extends VisitorAdaptor {

	private int globalVarDeclarations = 0;
	private int constDeclarations = 0;
	private int classDeclarations = 0;
	private int methodDeclarations = 0;
	private int globalArrayDeclarations = 0;
	private ArrayList<Method> methods = new ArrayList<Method>();

	private class Method {
		private int localVariables;
		private int functionCalls;
		private int statements;
		private String name;

		public Method(String name, int localVariables, int functionCalls, int statements) {
			this.name = name;
			this.localVariables = localVariables;
			this.functionCalls = functionCalls;
			this.statements = statements;
		}

		public String toString() {
			StringBuilder msg = new StringBuilder();
			msg.append(localVariables).append("\tlokalnih promenljivih u metodi ").append(name).append('\n');
			msg.append(functionCalls).append("\tpoziva funkcija u metodi ").append(name).append('\n');
			msg.append(statements).append("\tiskaza u metodi ").append(name).append('\n');
			return msg.toString();
		}
	};

	@Override
	public void visit(Constant Constant) {
		constDeclarations++;
	}

	@Override
	public void visit(GlobalVariableDeclarations globalVariableDeclarations) {
		VarCounter varCounter = new VarCounter();
		globalVariableDeclarations.traverseTopDown(varCounter);
		globalVarDeclarations += varCounter.getCount();

		ArrayCounter arrayCounter = new ArrayCounter();
		globalVariableDeclarations.traverseTopDown(arrayCounter);
		globalArrayDeclarations += arrayCounter.getCount();
	}

	@Override
	public void visit(MethodDecl methodDecl) {
		methodDeclarations++;

		VarCounter varCounter = new VarCounter();
		methodDecl.getVarDeclSection().traverseTopDown(varCounter);

		StatementCounter statementCounter = new StatementCounter();
		methodDecl.getStatementSection().traverseTopDown(statementCounter);

		FunctionCallCounter functionCallsCounter = new FunctionCallCounter();
		methodDecl.traverseTopDown(functionCallsCounter);

		Method m = new Method(methodDecl.getMethodHeader().getIdent(), varCounter.getCount(),
				functionCallsCounter.getCount(), statementCounter.getCount());
		methods.add(m);
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

	@Override
	public void visit(ClassName className) {
		classDeclarations++;
	}
}
