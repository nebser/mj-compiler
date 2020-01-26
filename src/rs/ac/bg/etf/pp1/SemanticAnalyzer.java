package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.AbstractClassDecl;
import rs.ac.bg.etf.pp1.ast.ArrayVar;
import rs.ac.bg.etf.pp1.ast.BoolConstant;
import rs.ac.bg.etf.pp1.ast.CharacterConstant;
import rs.ac.bg.etf.pp1.ast.ClassDecl;
import rs.ac.bg.etf.pp1.ast.ClassName;
import rs.ac.bg.etf.pp1.ast.Constant;
import rs.ac.bg.etf.pp1.ast.ConstantDeclarations;
import rs.ac.bg.etf.pp1.ast.Constants;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.FormalParameters;
import rs.ac.bg.etf.pp1.ast.GlobalVarDecl;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodHeader;
import rs.ac.bg.etf.pp1.ast.NoFormalParameters;
import rs.ac.bg.etf.pp1.ast.NonVoidType;
import rs.ac.bg.etf.pp1.ast.NumberConstant;
import rs.ac.bg.etf.pp1.ast.ParameterList;
import rs.ac.bg.etf.pp1.ast.PrimitiveVar;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.ProgramName;
import rs.ac.bg.etf.pp1.ast.RegularVarDecl;
import rs.ac.bg.etf.pp1.ast.SinglePar;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.Type;
import rs.ac.bg.etf.pp1.ast.Variable;
import rs.ac.bg.etf.pp1.ast.Variables;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.ac.bg.etf.pp1.ast.VoidType;
import rs.ac.bg.etf.pp1.util.ObjList;
import rs.ac.bg.etf.pp1.util.Tab;
import rs.ac.bg.etf.pp1.util.Var;
import rs.ac.bg.etf.pp1.util.VarList;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class SemanticAnalyzer extends VisitorAdaptor {

	private boolean errorDetected = false;
	private boolean mainDetected = false;

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
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
	public void visit(ProgramName programName) {
		// TODO Auto-generated method stub
		programName.obj = Tab.insert(Obj.Prog, programName.getProgName(), Tab.noType);
		Tab.openScope();
	}

	@Override
	public void visit(Program program) {
		// TODO Auto-generated method stub
		Tab.chainLocalSymbols(program.getProgramName().obj);
		Tab.closeScope();
	}

	@Override
	public void visit(NumberConstant numberConstant) {
		String name = numberConstant.getName();
		if (Tab.find(name) != Tab.noObj) {
			report_error("Simbol " + name + " je vec definisant", numberConstant);
			return;
		}
		numberConstant.obj = new Obj(Obj.Con, name, Tab.intType, numberConstant.getValue(), 0);
	}

	@Override
	public void visit(CharacterConstant characterConstant) {
		String name = characterConstant.getName();
		if (Tab.find(name) != Tab.noObj) {
			report_error("Simbol " + name + " je vec definisant", characterConstant);
			return;
		}
		characterConstant.obj = new Obj(Obj.Con, name, Tab.charType, characterConstant.getValue().charAt(1), 0);
		;
	}

	@Override
	public void visit(BoolConstant boolConstant) {
		String name = boolConstant.getName();
		if (Tab.find(name) != Tab.noObj) {
			report_error("Simbol " + name + " je vec definisant", boolConstant);
			return;
		}
		boolConstant.obj = new Obj(Obj.Con, name, Tab.boolType, boolConstant.getValue().equals("true") ? 1 : 0, 0);
		;
	}

	@Override
	public void visit(Constant constant) {
		constant.objlist = new ObjList();
		constant.objlist.add(constant.getConstDefinition().obj);
	}

	@Override
	public void visit(Constants constants) {
		constants.objlist = new ObjList();
		constants.objlist.add(constants.getConstDefinition().obj);
		constants.objlist.add(constants.getConstList().objlist);
	}

	@Override
	public void visit(Type type) {
		String typeName = type.getIdent();
		Obj typeObj = Tab.find(typeName);
		if (typeObj == Tab.noObj) {
			report_error("Tip " + typeName + " ne postoji", type);
			return;
		}
		type.struct = typeObj.getType();
	}

	@Override
	public void visit(ConstantDeclarations constantDeclarations) {
		Struct type = constantDeclarations.getType().struct;
		if (!type.equals(Tab.intType) && !type.equals(Tab.charType) && type.equals(new Struct(Struct.Bool))) {
			report_error("Tip konstante mora biti int, char ili bool", constantDeclarations);
			return;
		}
		constantDeclarations.getConstList().objlist.getObjs().forEach(o -> {
			if (type.equals(o.getType())) {
				Tab.insert(Obj.Con, o.getName(), type, o.getAdr());
			} else {
				report_error("Nekompatibilni tipovi u izrazu za inicijalizaciju konstante " + o.getName(),
						constantDeclarations);
			}
		});
	}

	@Override
	public void visit(Designator designator) {
		Obj obj = Tab.find(designator.getIdent());
		if (obj.getKind() == Obj.Con) {
			reportSymbol("Upotrebljena konstanta", obj, designator);
			return;
		}
		if (obj.getKind() == Obj.Var && obj.getLevel() == 0) {
			reportSymbol("Upotrebljena globalna promenljiva", obj, designator);
		}
	}

	@Override
	public void visit(PrimitiveVar primitiveVar) {
		primitiveVar.var = new Var(primitiveVar.getIdent(), false);
	}

	@Override
	public void visit(ArrayVar arrayVar) {
		arrayVar.var = new Var(arrayVar.getIdent(), true);
	}

	@Override
	public void visit(Variable variable) {
		variable.varlist = new VarList();
		variable.varlist.add(variable.getVar().var);
	}

	@Override
	public void visit(Variables variables) {
		variables.varlist = new VarList();
		variables.varlist.add(variables.getVar().var);
		variables.varlist.add(variables.getVarList().varlist);
	}

	@Override
	public void visit(GlobalVarDecl globalVarDecl) {
		String typeName = globalVarDecl.getType().getIdent();
		Obj typeObj = Tab.find(typeName);
		if (typeObj == Tab.noObj) {
			report_error("Tip " + typeName + " nije definisan", globalVarDecl);
			return;
		}
		globalVarDecl.getVarList().varlist.getVars().forEach(v -> {
			String varName = v.getName();
			if (Tab.currentScope.findSymbol(varName) != null) {
				report_error("Simbol " + varName + " je vec definisan", globalVarDecl);
				return;
			}
			if (v.isArray()) {
				Tab.insert(Obj.Var, varName, new Struct(Struct.Array, typeObj.getType()));

			} else {
				Tab.insert(Obj.Var, varName, typeObj.getType());
			}
		});
	}

	@Override
	public void visit(RegularVarDecl regularVarDecl) {
		String typeName = regularVarDecl.getType().getIdent();
		Obj typeObj = Tab.find(typeName);
		if (typeObj == Tab.noObj) {
			report_error("Tip " + typeName + " nije definisan", regularVarDecl);
			return;
		}
		regularVarDecl.getVarList().varlist.getVars().forEach(v -> {
			String varName = v.getName();
			if (Tab.currentScope.findSymbol(varName) != null) {
				report_error("Simbol " + varName + " je vec definisan", regularVarDecl);
				return;
			}
			if (v.isArray()) {
				Tab.insert(Obj.Var, varName, new Struct(Struct.Array, typeObj.getType()));

			} else {
				Tab.insert(Obj.Var, varName, typeObj.getType());
			}
		});
	}

	@Override
	public void visit(ClassName className) {
		Obj typeObj = Tab.find(className.getIdent());
		if (typeObj != Tab.noObj && typeObj.getKind() == Obj.Type) {
			report_error("Tip " + className.getIdent() + " je vec definisan", className);
			return;
		}
		Obj inserted = Tab.insert(Obj.Type, className.getIdent(), new Struct(Struct.Class));
		className.struct = inserted.getType();
		Tab.openScope();
	}

	@Override
	public void visit(ClassDecl classDecl) {
		Tab.chainLocalSymbols(classDecl.getClassName().struct);
		Tab.closeScope();
	}

	@Override
	public void visit(AbstractClassDecl abstractClassDecl) {
		Tab.chainLocalSymbols(abstractClassDecl.getClassName().struct);
		Tab.closeScope();
	}

	@Override
	public void visit(SinglePar singlePar) {
		String typeName = singlePar.getType().getIdent();
		Obj typeObj = Tab.find(typeName);
		if (typeObj == Tab.noObj || typeObj.getKind() != Obj.Type) {
			report_error("Tip " + typeName + " nije definisan", singlePar);
			return;
		}
		singlePar.objlist = new ObjList();
		if (singlePar.getVar().var.isArray()) {
			singlePar.objlist.add(
					new Obj(Obj.Var, singlePar.getVar().var.getName(), new Struct(Struct.Array, typeObj.getType())));
		} else {
			singlePar.objlist.add(new Obj(Obj.Var, singlePar.getVar().var.getName(), typeObj.getType()));
		}
	}

	@Override
	public void visit(ParameterList parameterList) {
		String typeName = parameterList.getType().getIdent();
		Obj typeObj = Tab.find(typeName);
		if (typeObj == Tab.noObj || typeObj.getKind() != Obj.Type) {
			report_error("Tip " + typeName + " nije definisan", parameterList);
			return;
		}
		parameterList.objlist = new ObjList();
		if (parameterList.getVar().var.isArray()) {
			parameterList.objlist.add(new Obj(Obj.Var, parameterList.getVar().var.getName(),
					new Struct(Struct.Array, typeObj.getType())));
		} else {
			parameterList.objlist.add(new Obj(Obj.Var, parameterList.getVar().var.getName(), typeObj.getType()));
		}
		parameterList.objlist.add(parameterList.getFormParsList().objlist);
	}

	@Override
	public void visit(FormalParameters formalParameters) {
		formalParameters.objlist = formalParameters.getFormParsList().objlist;
	}

	@Override
	public void visit(NoFormalParameters noFormalParameters) {
		noFormalParameters.objlist = new ObjList();
	}

	@Override
	public void visit(VoidType voidType) {
		voidType.struct = Tab.noType;
	}

	@Override
	public void visit(NonVoidType nonVoidType) {
		String typeName = nonVoidType.getType().getIdent();
		Obj typeObj = Tab.find(typeName);
		if (typeObj == Tab.noObj || typeObj.getKind() != Obj.Type) {
			report_error("Povratni tip " + typeName + " nije definisan", nonVoidType);
			return;
		}
		nonVoidType.struct = typeObj.getType();
	}

	@Override
	public void visit(MethodHeader methodHeader) {
		String methodName = methodHeader.getIdent();
		Obj typeObj = Tab.find(methodName);
		if (typeObj != Tab.noObj && typeObj.getKind() == Obj.Meth) {
			report_error("Metoda " + methodName + " je vec definisan", methodHeader);
			return;
		}
		ObjList formPars = methodHeader.getFormPars().objlist;

		if (methodName.equals(methodName)) {
			if (Tab.currentScope.getOuter().getOuter() == null) {
				report_error("Main metoda moze da bude deklarisana samo na globalnom nivou", methodHeader);
				return;
			}
			if (formPars.size() != 0) {
				report_error("Main metoda ne sme da ima argumente", methodHeader);
				return;
			}
			if (!methodHeader.getReturnType().struct.equals(Tab.noType)) {
				report_error("Main metoda ne sme da ima povratni tip", methodHeader);
				return;
			}
			mainDetected = true;
		}

		methodHeader.obj = Tab.insert(Obj.Meth, methodName, methodHeader.getReturnType().struct, 0, formPars.size());
		Tab.openScope();
		formPars.getObjs().forEach(p -> {
			Tab.insert(Obj.Var, p.getName(), p.getType());
		});
	}

	@Override
	public void visit(MethodDecl methodDecl) {
		// TODO Auto-generated method stub
		Tab.chainLocalSymbols(methodDecl.getMethodHeader().obj);
		Tab.closeScope();
	}

	public boolean isMainDetected() {
		return mainDetected;
	}
}
