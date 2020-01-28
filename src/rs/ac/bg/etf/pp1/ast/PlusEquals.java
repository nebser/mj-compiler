// generated with ast extension for cup
// version 0.8
// 28/0/2020 2:16:42


package rs.ac.bg.etf.pp1.ast;

public class PlusEquals extends Addop {

    private String P1;

    public PlusEquals (String P1) {
        this.P1=P1;
    }

    public String getP1() {
        return P1;
    }

    public void setP1(String P1) {
        this.P1=P1;
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
        buffer.append("PlusEquals(\n");

        buffer.append(" "+tab+P1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PlusEquals]");
        return buffer.toString();
    }
}