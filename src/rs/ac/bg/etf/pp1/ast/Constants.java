// generated with ast extension for cup
// version 0.8
// 2/1/2020 18:51:10


package rs.ac.bg.etf.pp1.ast;

public class Constants extends ConstList {

    private ConstDefinition ConstDefinition;
    private ConstList ConstList;

    public Constants (ConstDefinition ConstDefinition, ConstList ConstList) {
        this.ConstDefinition=ConstDefinition;
        if(ConstDefinition!=null) ConstDefinition.setParent(this);
        this.ConstList=ConstList;
        if(ConstList!=null) ConstList.setParent(this);
    }

    public ConstDefinition getConstDefinition() {
        return ConstDefinition;
    }

    public void setConstDefinition(ConstDefinition ConstDefinition) {
        this.ConstDefinition=ConstDefinition;
    }

    public ConstList getConstList() {
        return ConstList;
    }

    public void setConstList(ConstList ConstList) {
        this.ConstList=ConstList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDefinition!=null) ConstDefinition.accept(visitor);
        if(ConstList!=null) ConstList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDefinition!=null) ConstDefinition.traverseTopDown(visitor);
        if(ConstList!=null) ConstList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDefinition!=null) ConstDefinition.traverseBottomUp(visitor);
        if(ConstList!=null) ConstList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Constants(\n");

        if(ConstDefinition!=null)
            buffer.append(ConstDefinition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstList!=null)
            buffer.append(ConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Constants]");
        return buffer.toString();
    }
}
