// generated with ast extension for cup
// version 0.8
// 2/1/2020 17:33:33


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Unmatched Unmatched);
    public void visit(StatementSection StatementSection);
    public void visit(ReturnType ReturnType);
    public void visit(DesignatorSentence DesignatorSentence);
    public void visit(Mulop Mulop);
    public void visit(AddExpr AddExpr);
    public void visit(Matched Matched);
    public void visit(AnyMethodDeclSection AnyMethodDeclSection);
    public void visit(Relop Relop);
    public void visit(Assignop Assignop);
    public void visit(Var Var);
    public void visit(ConstDefinition ConstDefinition);
    public void visit(StatementList StatementList);
    public void visit(LoopCondition LoopCondition);
    public void visit(FactorList FactorList);
    public void visit(Addop Addop);
    public void visit(Factor Factor);
    public void visit(VarList VarList);
    public void visit(CondTerm CondTerm);
    public void visit(FormParsSection FormParsSection);
    public void visit(AbstractMethodDecl AbstractMethodDecl);
    public void visit(ConstList ConstList);
    public void visit(DeclList DeclList);
    public void visit(Designator Designator);
    public void visit(Term Term);
    public void visit(FormParsList FormParsList);
    public void visit(Condition Condition);
    public void visit(ExprList ExprList);
    public void visit(DeclSection DeclSection);
    public void visit(ExtendsStmt ExtendsStmt);
    public void visit(VarDeclList VarDeclList);
    public void visit(Expr Expr);
    public void visit(ForStatement ForStatement);
    public void visit(ActPars ActPars);
    public void visit(VarPrefix VarPrefix);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(AnyMethodDecl AnyMethodDecl);
    public void visit(VarDeclSection VarDeclSection);
    public void visit(OptionalDesignatorStatement OptionalDesignatorStatement);
    public void visit(Statement Statement);
    public void visit(DeclElem DeclElem);
    public void visit(ReturnExpr ReturnExpr);
    public void visit(VarDecl VarDecl);
    public void visit(FormParsElem FormParsElem);
    public void visit(AnyMethodDeclList AnyMethodDeclList);
    public void visit(MethodDeclSection MethodDeclSection);
    public void visit(CondFact CondFact);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(FormPars FormPars);
    public void visit(Type Type);
    public void visit(AssignopDerived1 AssignopDerived1);
    public void visit(LessOrEqual LessOrEqual);
    public void visit(Less Less);
    public void visit(GreaterOrEqual GreaterOrEqual);
    public void visit(Greater Greater);
    public void visit(Differs Differs);
    public void visit(Equals Equals);
    public void visit(ObjectDesignator ObjectDesignator);
    public void visit(ArrayDesignator ArrayDesignator);
    public void visit(SimpleDesignator SimpleDesignator);
    public void visit(ExpressionFactor ExpressionFactor);
    public void visit(NewObjectFactor NewObjectFactor);
    public void visit(NewArrayFactor NewArrayFactor);
    public void visit(BoolFactor BoolFactor);
    public void visit(CharacterFactor CharacterFactor);
    public void visit(NumberFactor NumberFactor);
    public void visit(DesignatorWithActParsFactor DesignatorWithActParsFactor);
    public void visit(DesignatorFactor DesignatorFactor);
    public void visit(ModEquals ModEquals);
    public void visit(DivideEquals DivideEquals);
    public void visit(MultiplyEquals MultiplyEquals);
    public void visit(Mod Mod);
    public void visit(Divide Divide);
    public void visit(Multiply Multiply);
    public void visit(FactorTerm FactorTerm);
    public void visit(MulTerm MulTerm);
    public void visit(MinusEquals MinusEquals);
    public void visit(PlusEquals PlusEquals);
    public void visit(Plus Plus);
    public void visit(Minus Minus);
    public void visit(TermExpression TermExpression);
    public void visit(AddExpression AddExpression);
    public void visit(NoMinusExpression NoMinusExpression);
    public void visit(UnaryMinusExpression UnaryMinusExpression);
    public void visit(SingleExpr SingleExpr);
    public void visit(ExprOp ExprOp);
    public void visit(SingleCondFact SingleCondFact);
    public void visit(CondFactList CondFactList);
    public void visit(SingleCondTerm SingleCondTerm);
    public void visit(CondTermList CondTermList);
    public void visit(Expression Expression);
    public void visit(ExpressionList ExpressionList);
    public void visit(NoActualPars NoActualPars);
    public void visit(ActualPars ActualPars);
    public void visit(DecrementDesignator DecrementDesignator);
    public void visit(IncrementDesignator IncrementDesignator);
    public void visit(FunctionCall FunctionCall);
    public void visit(AssignDesignator AssignDesignator);
    public void visit(NoDesignatorStmt NoDesignatorStmt);
    public void visit(OptionalDesignatorStmt OptionalDesignatorStmt);
    public void visit(UnmatchedElse UnmatchedElse);
    public void visit(UnmatchedIf UnmatchedIf);
    public void visit(NoReturnExpr NoReturnExpr);
    public void visit(RetExpr RetExpr);
    public void visit(ErrorDesignatorSen ErrorDesignatorSen);
    public void visit(DesignatorSen DesignatorSen);
    public void visit(PrintWithNumber PrintWithNumber);
    public void visit(Print Print);
    public void visit(Read Read);
    public void visit(Return Return);
    public void visit(Continue Continue);
    public void visit(Break Break);
    public void visit(StmtList StmtList);
    public void visit(MatchedIf MatchedIf);
    public void visit(DesignatorStmt DesignatorStmt);
    public void visit(For For);
    public void visit(ForStmt ForStmt);
    public void visit(UnmatchedStmt UnmatchedStmt);
    public void visit(MatchedStmt MatchedStmt);
    public void visit(ErrorCondition ErrorCondition);
    public void visit(RegularCondition RegularCondition);
    public void visit(SingleStatement SingleStatement);
    public void visit(Statements Statements);
    public void visit(NoStatements NoStatements);
    public void visit(RealStatements RealStatements);
    public void visit(ErrorFormParsElem ErrorFormParsElem);
    public void visit(RegularFormParsElem RegularFormParsElem);
    public void visit(SinglePar SinglePar);
    public void visit(ParameterList ParameterList);
    public void visit(NoFormalParameters NoFormalParameters);
    public void visit(FormalParameters FormalParameters);
    public void visit(VoidType VoidType);
    public void visit(NonVoidType NonVoidType);
    public void visit(ErrorFormPars ErrorFormPars);
    public void visit(ValidFormPars ValidFormPars);
    public void visit(MethodHeader MethodHeader);
    public void visit(MethodDecl MethodDecl);
    public void visit(AbstractMethodDeclaration AbstractMethodDeclaration);
    public void visit(RealMethodDeclaration RealMethodDeclaration);
    public void visit(AnyMethodDeclaration AnyMethodDeclaration);
    public void visit(AnyMethodDeclarations AnyMethodDeclarations);
    public void visit(NoAnyMethodDeclarationSection NoAnyMethodDeclarationSection);
    public void visit(AnyMethodDeclarationSection AnyMethodDeclarationSection);
    public void visit(AbstractClassDecl AbstractClassDecl);
    public void visit(VariablesDeclarationsElem VariablesDeclarationsElem);
    public void visit(VariablesDeclarations VariablesDeclarations);
    public void visit(NoVariableDeclarationSection NoVariableDeclarationSection);
    public void visit(VariableDeclarationSection VariableDeclarationSection);
    public void visit(NoExtendsStatement NoExtendsStatement);
    public void visit(ExtendsStatement ExtendsStatement);
    public void visit(ClassName ClassName);
    public void visit(ClassDecl ClassDecl);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(NoMethodDeclarationSection NoMethodDeclarationSection);
    public void visit(MethodDeclarationSection MethodDeclarationSection);
    public void visit(ArrayVar ArrayVar);
    public void visit(PrimitiveVar PrimitiveVar);
    public void visit(ErrorPrefix ErrorPrefix);
    public void visit(RegularPrefix RegularPrefix);
    public void visit(Variable Variable);
    public void visit(Variables Variables);
    public void visit(ErrorDecl ErrorDecl);
    public void visit(RegularVarDecl RegularVarDecl);
    public void visit(BoolConstant BoolConstant);
    public void visit(CharacterConstant CharacterConstant);
    public void visit(NumberConstant NumberConstant);
    public void visit(Constant Constant);
    public void visit(Constants Constants);
    public void visit(GlobalClassDeclarations GlobalClassDeclarations);
    public void visit(GlobalAbstactClassDeclarations GlobalAbstactClassDeclarations);
    public void visit(GlobalVariableDeclarations GlobalVariableDeclarations);
    public void visit(ConstantDeclarations ConstantDeclarations);
    public void visit(Declaration Declaration);
    public void visit(Declarations Declarations);
    public void visit(NoDeclarationSection NoDeclarationSection);
    public void visit(DeclarationSection DeclarationSection);
    public void visit(ProgramName ProgramName);
    public void visit(Program Program);

}
