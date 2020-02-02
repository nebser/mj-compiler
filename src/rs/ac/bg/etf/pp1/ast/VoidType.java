// generated with ast extension for cup
// version 0.8
// 2/1/2020 16:15:51


package rs.ac.bg.etf.pp1.ast;

public class VoidType extends ReturnType {

    public VoidType () {
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
        buffer.append("VoidType(\n");

        buffer.append(tab);
        buffer.append(") [VoidType]");
        return buffer.toString();
    }
}
