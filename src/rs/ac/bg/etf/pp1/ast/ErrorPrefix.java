// generated with ast extension for cup
// version 0.8
// 2/1/2020 15:7:35


package rs.ac.bg.etf.pp1.ast;

public class ErrorPrefix extends VarPrefix {

    public ErrorPrefix () {
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
        buffer.append("ErrorPrefix(\n");

        buffer.append(tab);
        buffer.append(") [ErrorPrefix]");
        return buffer.toString();
    }
}
