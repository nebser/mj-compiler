// generated with ast extension for cup
// version 0.8
// 31/0/2020 20:3:28


package rs.ac.bg.etf.pp1.ast;

public class ErrorDecl extends VarDecl {

    public ErrorDecl () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ErrorDecl(\n");

        buffer.append(tab);
        buffer.append(") [ErrorDecl]");
        return buffer.toString();
    }
}
