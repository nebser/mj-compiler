// generated with ast extension for cup
// version 0.8
// 26/0/2020 3:13:26


package rs.ac.bg.etf.pp1.ast;

public class NoMethodDeclarationSection extends MethodDeclSection {

    public NoMethodDeclarationSection () {
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
        buffer.append("NoMethodDeclarationSection(\n");

        buffer.append(tab);
        buffer.append(") [NoMethodDeclarationSection]");
        return buffer.toString();
    }
}
