// generated with ast extension for cup
// version 0.8
// 2/1/2020 4:2:13


package rs.ac.bg.etf.pp1.ast;

public class Return extends Matched {

    private ReturnExpr ReturnExpr;

    public Return (ReturnExpr ReturnExpr) {
        this.ReturnExpr=ReturnExpr;
        if(ReturnExpr!=null) ReturnExpr.setParent(this);
    }

    public ReturnExpr getReturnExpr() {
        return ReturnExpr;
    }

    public void setReturnExpr(ReturnExpr ReturnExpr) {
        this.ReturnExpr=ReturnExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnExpr!=null) ReturnExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnExpr!=null) ReturnExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnExpr!=null) ReturnExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Return(\n");

        if(ReturnExpr!=null)
            buffer.append(ReturnExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Return]");
        return buffer.toString();
    }
}
