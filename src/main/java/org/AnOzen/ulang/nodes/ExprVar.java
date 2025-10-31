package org.AnOzen.ulang.nodes;

import java.util.HashMap;

public class ExprVar implements Expression{
    String name;

    public ExprVar(String ident) {
        name = ident;
    }

    @Override
    public String toString() {
        return "Var(" + name + ")";
    }

    @Override
    public String interpret(HashMap<String, String> environment) {
        return environment.get(name);
    }

    @Override
    public void compile() {
        // TODO: Deal with compiling later...
    }
}
