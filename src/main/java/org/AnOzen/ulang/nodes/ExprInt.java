package org.AnOzen.ulang.nodes;

public class ExprInt implements Expression{
    int value;

    public ExprInt(int value){
        this.value = value;
    }

    public String toString(){
        return "Int(" + value + ")";
    }

    @Override
    public String interpret() {
        return Integer.toString(value);
    }

    @Override
    public void compile() {
        // TODO: Deal with compiling later...
    }
}
