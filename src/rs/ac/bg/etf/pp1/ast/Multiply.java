// generated with ast extension for cup
// version 0.8
// 27/0/2020 1:29:9


package rs.ac.bg.etf.pp1.ast;

public class Multiply extends Mulop {

    public Multiply () {
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
        buffer.append("Multiply(\n");

        buffer.append(tab);
        buffer.append(") [Multiply]");
        return buffer.toString();
    }
}
