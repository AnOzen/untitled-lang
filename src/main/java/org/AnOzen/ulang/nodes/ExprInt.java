package org.AnOzen.ulang.nodes;

import java.util.HashMap;

public class ExprInt implements Expression {
    int value;

    public ExprInt(int value) {
        this.value = value;
    }

    public String toString() {
        return "Int(" + value + ")";
    }


    @Override
    public String interpret(HashMap<String, String> environment) {
        return Integer.toString(value);
    }

    @Override
    public void compile() {
        // TODO: Deal with compiling later...
    }
}
