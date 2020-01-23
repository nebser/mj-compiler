// generated with ast extension for cup
// version 0.8
// 23/0/2020 0:52:41


package rs.ac.bg.etf.pp1.ast;

public class ObjectDesignatorSuffix extends DesignatorSuffix {

    private DesignatorSuffix DesignatorSuffix;
    private String I2;

    public ObjectDesignatorSuffix (DesignatorSuffix DesignatorSuffix, String I2) {
        this.DesignatorSuffix=DesignatorSuffix;
        if(DesignatorSuffix!=null) DesignatorSuffix.setParent(this);
        this.I2=I2;
    }

    public DesignatorSuffix getDesignatorSuffix() {
        return DesignatorSuffix;
    }

    public void setDesignatorSuffix(DesignatorSuffix DesignatorSuffix) {
        this.DesignatorSuffix=DesignatorSuffix;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorSuffix!=null) DesignatorSuffix.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorSuffix!=null) DesignatorSuffix.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorSuffix!=null) DesignatorSuffix.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ObjectDesignatorSuffix(\n");

        if(DesignatorSuffix!=null)
            buffer.append(DesignatorSuffix.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ObjectDesignatorSuffix]");
        return buffer.toString();
    }
}