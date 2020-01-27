// generated with ast extension for cup
// version 0.8
// 27/0/2020 1:29:9


package rs.ac.bg.etf.pp1.ast;

public class MinusEquals extends Addop {

    private String M1;

    public MinusEquals (String M1) {
        this.M1=M1;
    }

    public String getM1() {
        return M1;
    }

    public void setM1(String M1) {
        this.M1=M1;
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
        buffer.append("MinusEquals(\n");

        buffer.append(" "+tab+M1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MinusEquals]");
        return buffer.toString();
    }
}
