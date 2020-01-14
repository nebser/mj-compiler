// generated with ast extension for cup
// version 0.8
// 14/0/2020 1:45:27


package rs.ac.bg.etf.pp1.ast;

public class ArrayVariable extends Var {

    private ArrayVar ArrayVar;

    public ArrayVariable (ArrayVar ArrayVar) {
        this.ArrayVar=ArrayVar;
        if(ArrayVar!=null) ArrayVar.setParent(this);
    }

    public ArrayVar getArrayVar() {
        return ArrayVar;
    }

    public void setArrayVar(ArrayVar ArrayVar) {
        this.ArrayVar=ArrayVar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayVar!=null) ArrayVar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayVar!=null) ArrayVar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayVar!=null) ArrayVar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayVariable(\n");

        if(ArrayVar!=null)
            buffer.append(ArrayVar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayVariable]");
        return buffer.toString();
    }
}
