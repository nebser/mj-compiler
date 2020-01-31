// generated with ast extension for cup
// version 0.8
// 31/0/2020 20:3:28


package rs.ac.bg.etf.pp1.ast;

public class ParameterList extends FormParsList {

    private FormParsList FormParsList;
    private Type Type;
    private Var Var;

    public ParameterList (FormParsList FormParsList, Type Type, Var Var) {
        this.FormParsList=FormParsList;
        if(FormParsList!=null) FormParsList.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.Var=Var;
        if(Var!=null) Var.setParent(this);
    }

    public FormParsList getFormParsList() {
        return FormParsList;
    }

    public void setFormParsList(FormParsList FormParsList) {
        this.FormParsList=FormParsList;
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
        if(FormParsList!=null) FormParsList.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(Var!=null) Var.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsList!=null) FormParsList.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Var!=null) Var.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsList!=null) FormParsList.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Var!=null) Var.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ParameterList(\n");

        if(FormParsList!=null)
            buffer.append(FormParsList.toString("  "+tab));
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
