// generated with ast extension for cup
// version 0.8
// 27/0/2020 0:35:27


package rs.ac.bg.etf.pp1.ast;

public class NoMinusExpression extends Expr {

    private Term Term;
    private AddExprPart AddExprPart;

    public NoMinusExpression (Term Term, AddExprPart AddExprPart) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.AddExprPart=AddExprPart;
        if(AddExprPart!=null) AddExprPart.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public AddExprPart getAddExprPart() {
        return AddExprPart;
    }

    public void setAddExprPart(AddExprPart AddExprPart) {
        this.AddExprPart=AddExprPart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(AddExprPart!=null) AddExprPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(AddExprPart!=null) AddExprPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(AddExprPart!=null) AddExprPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoMinusExpression(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddExprPart!=null)
            buffer.append(AddExprPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NoMinusExpression]");
        return buffer.toString();
    }
}
