// generated with ast extension for cup
// version 0.8
// 1/1/2020 3:41:25


package rs.ac.bg.etf.pp1.ast;

public class UnaryMinusExpression extends Expr {

    private String M1;
    private AddExpr AddExpr;

    public UnaryMinusExpression (String M1, AddExpr AddExpr) {
        this.M1=M1;
        this.AddExpr=AddExpr;
        if(AddExpr!=null) AddExpr.setParent(this);
    }

    public String getM1() {
        return M1;
    }

    public void setM1(String M1) {
        this.M1=M1;
    }

    public AddExpr getAddExpr() {
        return AddExpr;
    }

    public void setAddExpr(AddExpr AddExpr) {
        this.AddExpr=AddExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddExpr!=null) AddExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddExpr!=null) AddExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddExpr!=null) AddExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnaryMinusExpression(\n");

        buffer.append(" "+tab+M1);
        buffer.append("\n");

        if(AddExpr!=null)
            buffer.append(AddExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnaryMinusExpression]");
        return buffer.toString();
    }
}
