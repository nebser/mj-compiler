// generated with ast extension for cup
// version 0.8
// 1/1/2020 4:6:5


package rs.ac.bg.etf.pp1.ast;

public class FieldDeclarationSection extends FieldDeclSection {

    private FieldDeclList FieldDeclList;

    public FieldDeclarationSection (FieldDeclList FieldDeclList) {
        this.FieldDeclList=FieldDeclList;
        if(FieldDeclList!=null) FieldDeclList.setParent(this);
    }

    public FieldDeclList getFieldDeclList() {
        return FieldDeclList;
    }

    public void setFieldDeclList(FieldDeclList FieldDeclList) {
        this.FieldDeclList=FieldDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FieldDeclList!=null) FieldDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FieldDeclList!=null) FieldDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FieldDeclList!=null) FieldDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FieldDeclarationSection(\n");

        if(FieldDeclList!=null)
            buffer.append(FieldDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FieldDeclarationSection]");
        return buffer.toString();
    }
}
