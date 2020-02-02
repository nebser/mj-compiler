// generated with ast extension for cup
// version 0.8
// 2/1/2020 15:7:35


package rs.ac.bg.etf.pp1.ast;

public class ForStmt extends Statement {

    private For For;
    private OptionalDesignatorStatement OptionalDesignatorStatement;
    private LoopCondition LoopCondition;
    private OptionalDesignatorStatement OptionalDesignatorStatement1;
    private Statement Statement;

    public ForStmt (For For, OptionalDesignatorStatement OptionalDesignatorStatement, LoopCondition LoopCondition, OptionalDesignatorStatement OptionalDesignatorStatement1, Statement Statement) {
        this.For=For;
        if(For!=null) For.setParent(this);
        this.OptionalDesignatorStatement=OptionalDesignatorStatement;
        if(OptionalDesignatorStatement!=null) OptionalDesignatorStatement.setParent(this);
        this.LoopCondition=LoopCondition;
        if(LoopCondition!=null) LoopCondition.setParent(this);
        this.OptionalDesignatorStatement1=OptionalDesignatorStatement1;
        if(OptionalDesignatorStatement1!=null) OptionalDesignatorStatement1.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public For getFor() {
        return For;
    }

    public void setFor(For For) {
        this.For=For;
    }

    public OptionalDesignatorStatement getOptionalDesignatorStatement() {
        return OptionalDesignatorStatement;
    }

    public void setOptionalDesignatorStatement(OptionalDesignatorStatement OptionalDesignatorStatement) {
        this.OptionalDesignatorStatement=OptionalDesignatorStatement;
    }

    public LoopCondition getLoopCondition() {
        return LoopCondition;
    }

    public void setLoopCondition(LoopCondition LoopCondition) {
        this.LoopCondition=LoopCondition;
    }

    public OptionalDesignatorStatement getOptionalDesignatorStatement1() {
        return OptionalDesignatorStatement1;
    }

    public void setOptionalDesignatorStatement1(OptionalDesignatorStatement OptionalDesignatorStatement1) {
        this.OptionalDesignatorStatement1=OptionalDesignatorStatement1;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(For!=null) For.accept(visitor);
        if(OptionalDesignatorStatement!=null) OptionalDesignatorStatement.accept(visitor);
        if(LoopCondition!=null) LoopCondition.accept(visitor);
        if(OptionalDesignatorStatement1!=null) OptionalDesignatorStatement1.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(For!=null) For.traverseTopDown(visitor);
        if(OptionalDesignatorStatement!=null) OptionalDesignatorStatement.traverseTopDown(visitor);
        if(LoopCondition!=null) LoopCondition.traverseTopDown(visitor);
        if(OptionalDesignatorStatement1!=null) OptionalDesignatorStatement1.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(For!=null) For.traverseBottomUp(visitor);
        if(OptionalDesignatorStatement!=null) OptionalDesignatorStatement.traverseBottomUp(visitor);
        if(LoopCondition!=null) LoopCondition.traverseBottomUp(visitor);
        if(OptionalDesignatorStatement1!=null) OptionalDesignatorStatement1.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForStmt(\n");

        if(For!=null)
            buffer.append(For.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalDesignatorStatement!=null)
            buffer.append(OptionalDesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LoopCondition!=null)
            buffer.append(LoopCondition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalDesignatorStatement1!=null)
            buffer.append(OptionalDesignatorStatement1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForStmt]");
        return buffer.toString();
    }
}
