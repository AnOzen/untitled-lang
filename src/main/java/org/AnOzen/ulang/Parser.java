package org.AnOzen.ulang;

import org.AnOzen.ulang.nodes.*;

import java.util.ArrayList;

public class Parser {
    ArrayList<Token> tokens;
    public ArrayList<Statement> statements;
    int index = 0;

    public Parser(ArrayList<Token> tks){
        tokens = tks;
        statements = new ArrayList<>();
    }

    Expression parseExpr() {
        Token t = consume();

        switch (t.type){
            case INTEGER -> {
                return new ExprInt(Integer.parseInt(t.value));
            }
            default -> Utils.ErrorExit("Unknown Token");
        }
        return null;
    }

    public void parse(){
        while(index < tokens.size()){
            Token current = consume();

            switch (current.type){
                case KEYEXIT -> {
                    statements.add(new StateExit(parseExpr()));
                    expectConsume(TokenType.SEMI);
                }
            }
        }
    }

    Token peek(){
        return tokens.get(index);
    }

    Token consume(){
        return tokens.get(index++);
    }

    Token expectConsume(TokenType expectedType){
        if(peek().type != expectedType) Utils.ErrorExit(String.format("Expected %s, got %s", expectedType, peek().type));
        return consume();
    }

}
