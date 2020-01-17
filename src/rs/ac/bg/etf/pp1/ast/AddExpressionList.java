// generated with ast extension for cup
// version 0.8
// 17/0/2020 1:10:35


package rs.ac.bg.etf.pp1.ast;

public class AddExpressionList extends AddExprPart {

    private AddExprPart AddExprPart;
    private Addop Addop;
    private Term Term;

    public AddExpressionList (AddExprPart AddExprPart, Addop Addop, Term Term) {
        this.AddExprPart=AddExprPart;
        if(AddExprPart!=null) AddExprPart.setParent(this);
        this.Addop=Addop;
        if(Addop!=null) Addop.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public AddExprPart getAddExprPart() {
        return AddExprPart;
    }

    public void setAddExprPart(AddExprPart AddExprPart) {
        this.AddExprPart=AddExprPart;
    }

    public Addop getAddop() {
        return Addop;
    }

    public void setAddop(Addop Addop) {
        this.Addop=Addop;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddExprPart!=null) AddExprPart.accept(visitor);
        if(Addop!=null) Addop.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddExprPart!=null) AddExprPart.traverseTopDown(visitor);
        if(Addop!=null) Addop.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddExprPart!=null) AddExprPart.traverseBottomUp(visitor);
        if(Addop!=null) Addop.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddExpressionList(\n");

        if(AddExprPart!=null)
            buffer.append(AddExprPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Addop!=null)
            buffer.append(Addop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AddExpressionList]");
        return buffer.toString();
    }
}
