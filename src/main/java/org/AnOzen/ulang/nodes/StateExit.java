package org.AnOzen.ulang.nodes;

public class StateExit implements Statement{
    Expression expr;

    public StateExit(Expression expr){
        this.expr = expr;
    }

    public String toString(){
        return "Exit(" + expr.toString() + ")";
    }

    @Override
    public void interpret() {
        String result = expr.interpret();
        System.exit(Integer.parseInt(result));
    }

    @Override
    public void compile() {
        // TODO: Deal with compiling later...
    }
}
