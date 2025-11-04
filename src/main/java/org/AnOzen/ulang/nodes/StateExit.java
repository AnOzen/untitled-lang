package org.AnOzen.ulang.nodes;

import java.util.HashMap;

public class StateExit implements Statement {
    Expression expr;

    public StateExit(Expression expr) {
        this.expr = expr;
    }

    public String toString() {
        return "Exit(" + expr.toString() + ")";
    }

    @Override
    public void interpret(HashMap<String, String> environment) {
        String result = expr.interpret(environment);
        System.exit(Integer.parseInt(result));
    }

    @Override
    public void compile() {
        // TODO: Deal with compiling later...
    }
}
