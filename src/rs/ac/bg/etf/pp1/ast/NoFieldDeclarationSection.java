// generated with ast extension for cup
// version 0.8
// 28/0/2020 2:16:42


package rs.ac.bg.etf.pp1.ast;

public class NoFieldDeclarationSection extends FieldDeclSection {

    public NoFieldDeclarationSection () {
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
        buffer.append("NoFieldDeclarationSection(\n");

        buffer.append(tab);
        buffer.append(") [NoFieldDeclarationSection]");
        return buffer.toString();
    }
}
