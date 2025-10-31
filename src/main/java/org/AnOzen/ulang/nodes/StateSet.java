package org.AnOzen.ulang.nodes;

import java.util.HashMap;

public class StateSet implements Statement{
    String name;
    Expression expr;

    public StateSet(String name, Expression expr){
        this.name = name;
        this.expr = expr;
    }

    @Override
    public void interpret(HashMap<String, String> environment) {
        String result = expr.interpret(environment);
        environment.put(name, result);
    }

    @Override
    public void compile() {

    }

    public String toString() {
        return "Set(" + name + "," + expr + ")";
    }
}
