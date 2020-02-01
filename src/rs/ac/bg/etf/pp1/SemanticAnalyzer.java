package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.AbstractClassDecl;
import rs.ac.bg.etf.pp1.ast.AddExpr;
import rs.ac.bg.etf.pp1.ast.AddExpression;
import rs.ac.bg.etf.pp1.ast.Addop;
import rs.ac.bg.etf.pp1.ast.ArrayDesignator;
import rs.ac.bg.etf.pp1.ast.ArrayVar;
import rs.ac.bg.etf.pp1.ast.AssignDesignator;
import rs.ac.bg.etf.pp1.ast.BoolConstant;
import rs.ac.bg.etf.pp1.ast.BoolFactor;
import rs.ac.bg.etf.pp1.ast.CharacterConstant;
import rs.ac.bg.etf.pp1.ast.CharacterFactor;
import rs.ac.bg.etf.pp1.ast.ClassDecl;
import rs.ac.bg.etf.pp1.ast.ClassName;
import rs.ac.bg.etf.pp1.ast.Constant;
import rs.ac.bg.etf.pp1.ast.ConstantDeclarations;
import rs.ac.bg.etf.pp1.ast.Constants;
import rs.ac.bg.etf.pp1.ast.DecrementDesignator;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.DesignatorFactor;
import rs.ac.bg.etf.pp1.ast.DesignatorWithActParsFactor;
import rs.ac.bg.etf.pp1.ast.DivideEquals;
import rs.ac.bg.etf.pp1.ast.Expr;
import rs.ac.bg.etf.pp1.ast.ExpressionFactor;
import rs.ac.bg.etf.pp1.ast.Factor;
import rs.ac.bg.etf.pp1.ast.FactorTerm;
import rs.ac.bg.etf.pp1.ast.FieldDecl;
import rs.ac.bg.etf.pp1.ast.FormalParameters;
import rs.ac.bg.etf.pp1.ast.FunctionCall;
import rs.ac.bg.etf.pp1.ast.GlobalMethodDecl;
import rs.ac.bg.etf.pp1.ast.GlobalMethodHeader;
import rs.ac.bg.etf.pp1.ast.GlobalVarDecl;
import rs.ac.bg.etf.pp1.ast.IncrementDesignator;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodHeader;
import rs.ac.bg.etf.pp1.ast.MinusEquals;
import rs.ac.bg.etf.pp1.ast.ModEquals;
import rs.ac.bg.etf.pp1.ast.MulTerm;
import rs.ac.bg.etf.pp1.ast.Mulop;
import rs.ac.bg.etf.pp1.ast.MultiplyEquals;
import rs.ac.bg.etf.pp1.ast.NewArrayFactor;
import rs.ac.bg.etf.pp1.ast.NewObjectFactor;
import rs.ac.bg.etf.pp1.ast.NoFormalParameters;
import rs.ac.bg.etf.pp1.ast.NoMinusExpression;
import rs.ac.bg.etf.pp1.ast.NoReturnExpr;
import rs.ac.bg.etf.pp1.ast.NonVoidType;
import rs.ac.bg.etf.pp1.ast.NumberConstant;
import rs.ac.bg.etf.pp1.ast.NumberFactor;
import rs.ac.bg.etf.pp1.ast.ObjectDesignator;
import rs.ac.bg.etf.pp1.ast.ParameterList;
import rs.ac.bg.etf.pp1.ast.PlusEquals;
import rs.ac.bg.etf.pp1.ast.PrimitiveVar;
import rs.ac.bg.etf.pp1.ast.Print;
import rs.ac.bg.etf.pp1.ast.PrintWithNumber;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.ProgramName;
import rs.ac.bg.etf.pp1.ast.Read;
import rs.ac.bg.etf.pp1.ast.RegularVarDecl;
import rs.ac.bg.etf.pp1.ast.RetExpr;
import rs.ac.bg.etf.pp1.ast.Return;
import rs.ac.bg.etf.pp1.ast.SimpleDesignator;
import rs.ac.bg.etf.pp1.ast.SinglePar;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.Term;
import rs.ac.bg.etf.pp1.ast.TermExpression;
import rs.ac.bg.etf.pp1.ast.Type;
import rs.ac.bg.etf.pp1.ast.UnaryMinusExpression;
import rs.ac.bg.etf.pp1.ast.Variable;
import rs.ac.bg.etf.pp1.ast.Variables;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.ac.bg.etf.pp1.ast.VoidType;
import rs.ac.bg.etf.pp1.util.DumpSymbolTableVisitor;
import rs.ac.bg.etf.pp1.util.ObjList;
import rs.ac.bg.etf.pp1.util.Tab;
import rs.ac.bg.etf.pp1.util.Var;
import rs.ac.bg.etf.pp1.util.VarList;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticAnalyzer extends VisitorAdaptor {

	private boolean errorDetected = false;
	private boolean mainDetected = false;
	private Obj currentMethod = Tab.noObj;

	Logger log = Logger.getLogger(getClass());

	public void reportError(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder("Greska");
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		msg.append(": ").append(message).append('\n');
		log.error(msg.toString());
	}

	public void reportInfo(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());

	}

	private void reportSymbol(String description, Obj obj, SyntaxNode info) {
		StringBuilder msg = new StringBuilder("Pretraga");
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na ").append(line);

		msg.append('(').append(obj.getName()).append("), nadjeno ").append(description).append(' ');
		DumpSymbolTableVisitor stv = new DumpSymbolTableVisitor();
		stv.visitObjNode(obj);
		msg.append(stv.getOutput()).append('\n');
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
		if (!Tab.find(name).equals(Tab.noObj)) {
			reportError("Simbol " + name + " je vec definisant", numberConstant);
			return;
		}
		numberConstant.obj = new Obj(Obj.Con, name, Tab.intType, numberConstant.getValue(), 0);
	}

	@Override
	public void visit(CharacterConstant characterConstant) {
		String name = characterConstant.getName();
		if (!Tab.find(name).equals(Tab.noObj)) {
			reportError("Simbol " + name + " je vec definisant", characterConstant);
			return;
		}
		characterConstant.obj = new Obj(Obj.Con, name, Tab.charType, characterConstant.getValue().charAt(1), 0);
		;
	}

	@Override
	public void visit(BoolConstant boolConstant) {
		String name = boolConstant.getName();
		if (!Tab.find(name).equals(Tab.noObj)) {
			reportError("Simbol " + name + " je vec definisant", boolConstant);
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
		if (typeObj.equals(Tab.noObj)) {
			reportError("Tip " + typeName + " ne postoji", type);
			type.struct = Tab.noType;
			return;
		}
		type.struct = typeObj.getType();
	}

	@Override
	public void visit(ConstantDeclarations constantDeclarations) {
		Struct type = constantDeclarations.getType().struct;
		if (!type.equals(Tab.intType) && !type.equals(Tab.charType) && type.equals(new Struct(Struct.Bool))) {
			reportError("Tip konstante mora biti int, char ili bool", constantDeclarations);
			return;
		}
		constantDeclarations.getConstList().objlist.getObjs().forEach(o -> {
			if (type.equals(o.getType())) {
				Tab.insert(Obj.Con, o.getName(), type, o.getAdr());
			} else {
				Tab.insert(Obj.Con, o.getName(), type, 0);
				reportError("Nekompatibilni tipovi u izrazu za inicijalizaciju konstante " + o.getName(),
						constantDeclarations);
			}
		});
	}

	@Override
	public void visit(SimpleDesignator simpleDesignator) {
		Obj obj = Tab.find(simpleDesignator.getIdent());
		if (obj.equals(Tab.noObj)) {
			reportError("Simbol " + simpleDesignator.getIdent() + " nije definisan", simpleDesignator);
			simpleDesignator.obj = Tab.noObj;
			return;
		}
		switch (obj.getKind()) {
		case Obj.Con:
			reportSymbol("konstanta", obj, simpleDesignator);
			break;
		case Obj.Var:
			if (obj.getLevel() == 0) {
				reportSymbol("globalna promenljiva", obj, simpleDesignator);
			}
			break;
		default:
			break;
		}
		simpleDesignator.obj = obj;
	}

	@Override
	public void visit(ArrayDesignator arrayDesignator) {
		arrayDesignator.obj = Tab.noObj;
		Designator d = arrayDesignator.getDesignator();
		if (d.obj.equals(Tab.noObj)) {
			return;
		}
		if (d.obj.getType().getKind() != Struct.Array) {
			reportError("Tip izraza kod indeksnog pristupa mora biti niz", d);
			return;
		}
		Expr e = arrayDesignator.getExpr();
		if (!e.obj.getType().equals(Tab.intType)) {
			reportError("Indeks kod pristupanja niza mora biti tipa int", e);
			return;
		}
		reportSymbol("element niza", d.obj, d);
		arrayDesignator.obj = new Obj(Obj.Elem, d.obj.getName(), d.obj.getType().getElemType());
	}

	@Override
	public void visit(ObjectDesignator objectDesignator) {
		objectDesignator.obj = Tab.noObj;
		Designator d = objectDesignator.getDesignator();
		if (d.obj.equals(Tab.noObj)) {
			return;
		}
		Struct objectClass = d.obj.getType();
		if (objectClass.getKind() != Struct.Class) {
			reportError("Tip izraza mora biti klasa da bi se pristupalo njenim elementima ili metodama", d);
			return;
		}
		Obj member = objectClass.getMembersTable().searchKey(objectDesignator.getIdent());
		if (member == null) {
			reportError("Objekat " + d.obj.getName() + " ne sadrzi polje ili metodu " + objectDesignator.getIdent(), d);
			return;
		}
		objectDesignator.obj = member;
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
		if (typeObj.equals(Tab.noObj)) {
			reportError("Tip " + typeName + " nije definisan", globalVarDecl);
			return;
		}
		globalVarDecl.objlist = new ObjList();
		globalVarDecl.getVarList().varlist.getVars().forEach(v -> {
			String varName = v.getName();
			if (Tab.currentScope.findSymbol(varName) != null) {
				reportError("Simbol " + varName + " je vec definisan", globalVarDecl);
				return;
			}
			if (v.isArray()) {
				Obj obj = Tab.insert(Obj.Var, varName, new Struct(Struct.Array, typeObj.getType()));
				globalVarDecl.objlist.add(obj);

			} else {
				Obj obj = Tab.insert(Obj.Var, varName, typeObj.getType());
				globalVarDecl.objlist.add(obj);
			}
		});
	}

	@Override
	public void visit(RegularVarDecl regularVarDecl) {
		String typeName = regularVarDecl.getType().getIdent();
		Obj typeObj = Tab.find(typeName);
		if (typeObj.equals(Tab.noObj)) {
			reportError("Tip " + typeName + " nije definisan", regularVarDecl);
			return;
		}
		regularVarDecl.getVarList().varlist.getVars().forEach(v -> {
			String varName = v.getName();
			if (Tab.currentScope.findSymbol(varName) != null) {
				reportError("Simbol " + varName + " je vec definisan", regularVarDecl);
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
	public void visit(FieldDecl fieldDecl) {
		String typeName = fieldDecl.getType().getIdent();
		Obj typeObj = Tab.find(typeName);
		if (typeObj.equals(Tab.noObj)) {
			reportError("Tip " + typeName + " nije definisan", fieldDecl);
			return;
		}
		fieldDecl.getVarList().varlist.getVars().forEach(v -> {
			String varName = v.getName();
			if (Tab.currentScope.findSymbol(varName) != null) {
				reportError("Simbol " + varName + " je vec definisan", fieldDecl);
				return;
			}
			if (v.isArray()) {
				Tab.insert(Obj.Fld, varName, new Struct(Struct.Array, typeObj.getType()));

			} else {
				Tab.insert(Obj.Fld, varName, typeObj.getType());
			}
		});
	}

	@Override
	public void visit(ClassName className) {
		Obj typeObj = Tab.find(className.getIdent());
		if (!typeObj.equals(Tab.noObj) && typeObj.getKind() == Obj.Type) {
			reportError("Tip " + className.getIdent() + " je vec definisan", className);
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
		if (typeObj.equals(Tab.noObj) || typeObj.getKind() != Obj.Type) {
			reportError("Tip " + typeName + " nije definisan", singlePar);
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
		if (typeObj.equals(Tab.noObj) || typeObj.getKind() != Obj.Type) {
			reportError("Tip " + typeName + " nije definisan", parameterList);
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
		if (typeObj.equals(Tab.noObj) || typeObj.getKind() != Obj.Type) {
			reportError("Povratni tip " + typeName + " nije definisan", nonVoidType);
			return;
		}
		nonVoidType.struct = typeObj.getType();
	}

	@Override
	public void visit(MethodHeader methodHeader) {
		String methodName = methodHeader.getIdent();
		Obj typeObj = Tab.find(methodName);
		if (!typeObj.equals(Tab.noObj) && typeObj.getKind() == Obj.Meth) {
			reportError("Metoda " + methodName + " je vec definisan", methodHeader);
		}
		ObjList formPars = methodHeader.getFormPars().objlist;

		if (methodName.equals("main")) {
			reportError("Main metoda moze da bude deklarisana samo na globalnom nivou", methodHeader);
		}

		methodHeader.obj = Tab.insert(Obj.Meth, methodName, methodHeader.getReturnType().struct, 0, formPars.size());
		currentMethod = methodHeader.obj;
		Tab.openScope();
		formPars.getObjs().forEach(p -> {
			Tab.insert(Obj.Var, p.getName(), p.getType());
		});
	}

	@Override
	public void visit(RetExpr returnExpression) {
		returnExpression.struct = returnExpression.getExpr().obj.getType();
	}

	@Override
	public void visit(NoReturnExpr noReturnExpression) {
		noReturnExpression.struct = Tab.noType;
	}

	@Override
	public void visit(Return return_) {
		if (currentMethod.equals(Tab.noObj)) {
			reportError("Return iskaz moze biti upotrebljen iskljucivo u telu metode", return_.getReturnExpr());
			return;
		}
		Struct expectedType = currentMethod.getType();
		Struct returnType = return_.getReturnExpr().struct;
		if (expectedType.equals(Tab.noType) && !returnType.equals(Tab.noType)) {
			reportError("Return iskaz metode " + currentMethod.getName()
					+ " ne sme imati izraz posto je metoda deklarisana da vraca void", return_.getReturnExpr());
			return;
		}
		if (!expectedType.equals(returnType)) {
			reportError(
					"Ne podudara se tip return izraza sa tipom povratne vrednosti metode " + currentMethod.getName(),
					return_.getReturnExpr());
		}
	}

	@Override
	public void visit(GlobalMethodHeader globalMethodHeader) {
		String methodName = globalMethodHeader.getIdent();
		Obj typeObj = Tab.find(methodName);
		if (!typeObj.equals(Tab.noObj) && typeObj.getKind() == Obj.Meth) {
			reportError("Metoda " + methodName + " je vec definisan", globalMethodHeader);
		}
		ObjList formPars = globalMethodHeader.getFormPars().objlist;

		if (methodName.equals("main")) {
			if (formPars.size() != 0) {
				reportError("Main metoda ne sme da ima argumente", globalMethodHeader);
			}
			if (!globalMethodHeader.getReturnType().struct.equals(Tab.noType)) {
				reportError("Main metoda ne sme da ima povratni tip", globalMethodHeader);
			}
			mainDetected = true;
		}

		globalMethodHeader.obj = Tab.insert(Obj.Meth, methodName, globalMethodHeader.getReturnType().struct, 0,
				formPars.size());
		currentMethod = globalMethodHeader.obj;
		Tab.openScope();
		formPars.getObjs().forEach(p -> {
			Tab.insert(Obj.Var, p.getName(), p.getType());
		});
	}

	@Override
	public void visit(UnaryMinusExpression unaryMinusExpression) {
		unaryMinusExpression.obj = unaryMinusExpression.getAddExpr().obj;
	}

	@Override
	public void visit(NoMinusExpression noMinusExpression) {
		noMinusExpression.obj = noMinusExpression.getAddExpr().obj;
	}

	@Override
	public void visit(AddExpression addExpression) {
		AddExpr addExpr = addExpression.getAddExpr();
		if (!addExpr.obj.getType().equals(Tab.intType)) {
			reportError("Tip izraza prilikom koriscenja ovog operatora biti int", addExpr);
			addExpression.obj = Tab.noObj;
			return;
		}
		Term t = addExpression.getTerm();
		if (!t.obj.getType().equals(Tab.intType)) {
			reportError("Tip izraza prilikom koriscenja ovog operatora biti int", t);
			addExpression.obj = Tab.noObj;
			return;
		}
		Addop a = addExpression.getAddop();
		if (a instanceof PlusEquals || a instanceof MinusEquals) {
			int kind = addExpr.obj.getKind();
			if (kind != Obj.Var && kind != Obj.Elem && kind != Obj.Fld) {
				reportError("Rezultat izraza se mora smestiti u promenljivu, element niza ili polje klase", addExpr);
				addExpression.obj = Tab.noObj;
				return;
			}
		}
		addExpression.obj = new Obj(Obj.NO_VALUE, "", addExpr.obj.getType());
	}

	@Override
	public void visit(TermExpression termExpression) {
		termExpression.obj = termExpression.getTerm().obj;
	}

	@Override
	public void visit(MulTerm mulTerm) {
		Term t = mulTerm.getTerm();
		if (!t.obj.getType().equals(Tab.intType)) {
			reportError("Tip izraza prilikom koriscenja ovog operatora biti int", t);
			mulTerm.obj = Tab.noObj;
			return;
		}
		Factor f = mulTerm.getFactor();
		if (!f.obj.getType().equals(Tab.intType)) {
			reportError("Tip izraza prilikom koriscenja ovog operatora biti int", f);
			mulTerm.obj = Tab.noObj;
			return;
		}
		Mulop m = mulTerm.getMulop();
		if (m instanceof MultiplyEquals || m instanceof DivideEquals || m instanceof ModEquals) {
			int kind = t.obj.getKind();
			if (kind != Obj.Var && kind != Obj.Elem && kind != Obj.Fld) {
				reportError("Rezultat izraza se mora smestiti u promenljivu, element niza ili polje klase", t);
				mulTerm.obj = Tab.noObj;
				return;
			}
		}
		mulTerm.obj = new Obj(Obj.NO_VALUE, "", t.obj.getType());
	}

	@Override
	public void visit(FactorTerm factorTerm) {
		factorTerm.obj = factorTerm.getFactor().obj;
	}

	@Override
	public void visit(DesignatorWithActParsFactor designatorWithActParsFactor) {
		Obj o = designatorWithActParsFactor.getDesignator().obj;
		if (o.getKind() != Obj.Meth) {
			reportError("Simbol " + o.getName() + " ne predstavlja metodu klase ili funkciju",
					designatorWithActParsFactor.getDesignator());
			designatorWithActParsFactor.obj = Tab.noObj;
			return;
		}
		designatorWithActParsFactor.obj = o;
	}

	@Override
	public void visit(DesignatorFactor designatorFactor) {
		designatorFactor.obj = designatorFactor.getDesignator().obj;
	}

	@Override
	public void visit(MethodDecl methodDecl) {
		Tab.chainLocalSymbols(methodDecl.getMethodHeader().obj);
		Tab.closeScope();
		currentMethod = Tab.noObj;
	}

	@Override
	public void visit(GlobalMethodDecl globalMethodDecl) {
		Tab.chainLocalSymbols(globalMethodDecl.getGlobalMethodHeader().obj);
		Tab.closeScope();
		currentMethod = Tab.noObj;
	}

	@Override
	public void visit(BoolFactor boolFactor) {
		boolFactor.obj = new Obj(Obj.Con, "", Tab.boolType, boolFactor.getValue().equals("true") ? 1 : 0, 0);
	}

	@Override
	public void visit(CharacterFactor characterFactor) {
		characterFactor.obj = new Obj(Obj.Con, "", Tab.charType, characterFactor.getValue().charAt(1), 0);
	}

	@Override
	public void visit(NumberFactor numberFactor) {
		numberFactor.obj = new Obj(Obj.Con, "", Tab.intType, numberFactor.getValue(), 0);
	}

	@Override
	public void visit(NewArrayFactor newArrayFactor) {
		newArrayFactor.obj = Tab.noObj;
		if (!newArrayFactor.getExpr().obj.getType().equals(Tab.intType)) {
			reportError("Tip izraza za velicinu alociranog niza mora biti int", newArrayFactor.getExpr());
			return;
		}
		Struct arrayType = newArrayFactor.getType().struct;
		if (arrayType.equals(Tab.noType)) {
			return;
		}

		newArrayFactor.obj = new Obj(Obj.NO_VALUE, "", new Struct(Struct.Array, arrayType));
	}

	@Override
	public void visit(NewObjectFactor newObjectFactor) {
		newObjectFactor.obj = Tab.noObj;
		Struct typeStruct = newObjectFactor.getType().struct;
		if (typeStruct.getKind() != Struct.Class) {
			reportError("Tip izraza za alokaciju objekta mora biti korisnicki definisana klasa",
					newObjectFactor.getType());
			return;

		}
		newObjectFactor.obj = new Obj(Obj.NO_VALUE, "", typeStruct);
	}

	@Override
	public void visit(ExpressionFactor expressionFactor) {
		expressionFactor.obj = expressionFactor.getExpr().obj;
	}

	@Override
	public void visit(Print print) {
		Struct exprType = print.getExpr().obj.getType();
		if (!exprType.equals(Tab.intType) && !exprType.equals(Tab.charType) && !exprType.equals(Tab.boolType)) {
			reportError("Tip izraza za print naredbu mora biti int, char ili bool", print.getExpr());
		}
	}

	@Override
	public void visit(PrintWithNumber printWithNumber) {
		Struct exprType = printWithNumber.getExpr().obj.getType();
		if (!exprType.equals(Tab.intType) && !exprType.equals(Tab.charType) && !exprType.equals(Tab.boolType)) {
			reportError("Tip izraza za print naredbu mora biti int, char ili bool", printWithNumber.getExpr());
		}
	}

	@Override
	public void visit(Read read) {
		Obj designatorObj = read.getDesignator().obj;
		if (designatorObj.equals(Tab.noObj)) {
			return;
		}
		int designatorKind = designatorObj.getKind();
		if (designatorKind != Obj.Var && designatorKind != Obj.Elem && designatorKind != Obj.Fld) {
			reportError("Parametar funkcije read moze biti promenljiva, element niza ili polje klase",
					read.getDesignator());
		}
		Struct designatorType = designatorObj.getType();
		if (!designatorType.equals(Tab.intType) && !designatorType.equals(Tab.charType)
				&& !designatorType.equals(Tab.boolType)) {
			reportError("Parametar funkcije read mora biti tipa int, char ili bool", read.getDesignator());
		}
	}

	@Override
	public void visit(AssignDesignator assignDesignator) {
		Obj designatorObj = assignDesignator.getDesignator().obj;
		if (!designatorObj.equals(Tab.noObj)) {
			int designatorKind = designatorObj.getKind();
			if (designatorKind != Obj.Var && designatorKind != Obj.Elem && designatorKind != Obj.Fld) {
				reportError("Destinacija operatora dodele mora biti promenljiva, element niza ili polje klase",
						assignDesignator.getDesignator());
			}
		}

		Obj expressionObj = assignDesignator.getExpr().obj;
		if (!expressionObj.equals(Tab.noObj) && !designatorObj.equals(Tab.noObj)) {
			if (!expressionObj.getType().assignableTo(designatorObj.getType())) {
				reportError("Desna strana se ne moze dodeliti levoj", assignDesignator.getExpr());
			}
		}
		assignDesignator.obj = designatorObj;
	}

	@Override
	public void visit(FunctionCall functionCall) {
		Designator d = functionCall.getDesignator();
		functionCall.obj = Tab.noObj;
		if (d.obj.equals(Tab.noObj)) {
			return;
		}
		if (d.obj.getKind() != Obj.Meth) {
			reportError("Simbol " + d.obj.getName()
					+ " ne predstavlja funkciju pa se ne moze koristiti u izrazu za poziv funkcije", d);
			return;
		}
		functionCall.obj = d.obj;
	}

	@Override
	public void visit(DecrementDesignator decrementDesignator) {
		Designator d = decrementDesignator.getDesignator();
		decrementDesignator.obj = Tab.noObj;
		if (d.obj.equals(Tab.noObj)) {
			return;
		}
		int kind = d.obj.getKind();
		if (kind != Obj.Var && kind != Obj.Elem && kind != Obj.Fld) {
			reportError("Operand decrement naredbe mora predstavljati promenljivu, element niza ili polje strukture",
					d);
			return;
		}
		if (!d.obj.getType().equals(Tab.intType)) {
			reportError("Tip operanda decrement naredbe mora biti int", d);
			return;
		}
		decrementDesignator.obj = d.obj;
	}

	@Override
	public void visit(IncrementDesignator incrementDesignator) {
		Designator d = incrementDesignator.getDesignator();
		incrementDesignator.obj = Tab.noObj;
		if (d.obj.equals(Tab.noObj)) {
			return;
		}
		int kind = d.obj.getKind();
		if (kind != Obj.Var && kind != Obj.Elem && kind != Obj.Fld) {
			reportError("Operand increment naredbe mora predstavljati promenljivu, element niza ili polje strukture",
					d);
			return;
		}
		if (!d.obj.getType().equals(Tab.intType)) {
			reportError("Tip operanda increment naredbe mora biti int", d);
			return;
		}
		incrementDesignator.obj = d.obj;
	}

	public boolean isMainDetected() {
		return mainDetected;
	}

	public boolean isErrorDetected() {
		return errorDetected;
	}
}
