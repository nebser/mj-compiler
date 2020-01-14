// generated with ast extension for cup
// version 0.8
// 14/0/2020 1:45:27


package rs.ac.bg.etf.pp1.ast;

public class CharacterConstant extends Const {

    private String C1;

    public CharacterConstant (String C1) {
        this.C1=C1;
    }

    public String getC1() {
        return C1;
    }

    public void setC1(String C1) {
        this.C1=C1;
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
        buffer.append("CharacterConstant(\n");

        buffer.append(" "+tab+C1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharacterConstant]");
        return buffer.toString();
    }
}
