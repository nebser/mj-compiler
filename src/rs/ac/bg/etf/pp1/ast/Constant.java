// generated with ast extension for cup
// version 0.8
// 27/0/2020 1:29:9


package rs.ac.bg.etf.pp1.ast;

public class Constant extends ConstList {

    private ConstDefinition ConstDefinition;

    public Constant (ConstDefinition ConstDefinition) {
        this.ConstDefinition=ConstDefinition;
        if(ConstDefinition!=null) ConstDefinition.setParent(this);
    }

    public ConstDefinition getConstDefinition() {
        return ConstDefinition;
    }

    public void setConstDefinition(ConstDefinition ConstDefinition) {
        this.ConstDefinition=ConstDefinition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDefinition!=null) ConstDefinition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDefinition!=null) ConstDefinition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDefinition!=null) ConstDefinition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Constant(\n");

        if(ConstDefinition!=null)
            buffer.append(ConstDefinition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Constant]");
        return buffer.toString();
    }
}
