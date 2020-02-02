// generated with ast extension for cup
// version 0.8
// 2/1/2020 5:14:46


package rs.ac.bg.etf.pp1.ast;

public class ParameterList extends FormParsList {

    private FormParsElem FormParsElem;
    private Type Type;
    private Var Var;

    public ParameterList (FormParsElem FormParsElem, Type Type, Var Var) {
        this.FormParsElem=FormParsElem;
        if(FormParsElem!=null) FormParsElem.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.Var=Var;
        if(Var!=null) Var.setParent(this);
    }

    public FormParsElem getFormParsElem() {
        return FormParsElem;
    }

    public void setFormParsElem(FormParsElem FormParsElem) {
        this.FormParsElem=FormParsElem;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public Var getVar() {
        return Var;
    }

    public void setVar(Var Var) {
        this.Var=Var;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsElem!=null) FormParsElem.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(Var!=null) Var.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsElem!=null) FormParsElem.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Var!=null) Var.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsElem!=null) FormParsElem.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Var!=null) Var.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ParameterList(\n");

        if(FormParsElem!=null)
            buffer.append(FormParsElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Var!=null)
            buffer.append(Var.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ParameterList]");
        return buffer.toString();
    }
}
