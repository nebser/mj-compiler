// generated with ast extension for cup
// version 0.8
// 2/1/2020 5:14:46


package rs.ac.bg.etf.pp1.ast;

public class Variables extends VarList {

    private VarPrefix VarPrefix;
    private VarList VarList;

    public Variables (VarPrefix VarPrefix, VarList VarList) {
        this.VarPrefix=VarPrefix;
        if(VarPrefix!=null) VarPrefix.setParent(this);
        this.VarList=VarList;
        if(VarList!=null) VarList.setParent(this);
    }

    public VarPrefix getVarPrefix() {
        return VarPrefix;
    }

    public void setVarPrefix(VarPrefix VarPrefix) {
        this.VarPrefix=VarPrefix;
    }

    public VarList getVarList() {
        return VarList;
    }

    public void setVarList(VarList VarList) {
        this.VarList=VarList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarPrefix!=null) VarPrefix.accept(visitor);
        if(VarList!=null) VarList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarPrefix!=null) VarPrefix.traverseTopDown(visitor);
        if(VarList!=null) VarList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarPrefix!=null) VarPrefix.traverseBottomUp(visitor);
        if(VarList!=null) VarList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Variables(\n");

        if(VarPrefix!=null)
            buffer.append(VarPrefix.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarList!=null)
            buffer.append(VarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Variables]");
        return buffer.toString();
    }
}
