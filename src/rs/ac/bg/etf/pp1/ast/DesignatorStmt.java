// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:3:46


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStmt extends Matched {

    private DesignatorSentence DesignatorSentence;

    public DesignatorStmt (DesignatorSentence DesignatorSentence) {
        this.DesignatorSentence=DesignatorSentence;
        if(DesignatorSentence!=null) DesignatorSentence.setParent(this);
    }

    public DesignatorSentence getDesignatorSentence() {
        return DesignatorSentence;
    }

    public void setDesignatorSentence(DesignatorSentence DesignatorSentence) {
        this.DesignatorSentence=DesignatorSentence;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorSentence!=null) DesignatorSentence.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorSentence!=null) DesignatorSentence.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorSentence!=null) DesignatorSentence.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStmt(\n");

        if(DesignatorSentence!=null)
            buffer.append(DesignatorSentence.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStmt]");
        return buffer.toString();
    }
}
