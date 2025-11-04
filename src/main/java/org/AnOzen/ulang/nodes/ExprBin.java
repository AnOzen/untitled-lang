package org.AnOzen.ulang.nodes;

import java.util.HashMap;

public class ExprBin implements Expression{
    Expression lhs;
    Expression rhs;
    BinOpType type;


    public String toString() {
        return "BinOp("+ lhs + "," + type.name() + "," + rhs + ")";
    }

    public ExprBin(Expression l, Expression r, BinOpType t){
        lhs = l;
        rhs = r;
        type = t;
    }

    @Override
    public String interpret(HashMap<String, String> environment) {
        String l = lhs.interpret(environment);
        String r = rhs.interpret(environment);
        switch (type){
            case ADD -> {
                return Integer.toString(Integer.parseInt(l) + Integer.parseInt(r));
            }
            case SUB -> {
                return Integer.toString(Integer.parseInt(l) - Integer.parseInt(r));
            }
            case DIV -> {
                return Integer.toString(Integer.parseInt(l) / Integer.parseInt(r));
            }
            case MUL -> {
                return Integer.toString(Integer.parseInt(l) * Integer.parseInt(r));
            }
            case MOD -> {
                return Integer.toString(Integer.parseInt(l) % Integer.parseInt(r));
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public void compile() {

    }
}
