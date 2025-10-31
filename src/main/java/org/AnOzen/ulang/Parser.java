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

    Expression parseExpr() throws Exception {
        Token t = consume();

        switch (t.type){
            case INTEGER -> {
                return new ExprInt(Integer.parseInt(t.value));
            }
            case VAR -> {
                return new ExprVar(t.value);
            }
            default -> throw new Exception("Unknown Token");
        }
    }

    public void parse() throws Exception {
        while(index < tokens.size()){
            Token current = consume();

            if (current.type == TokenType.EOF) break;
            switch (current.type){
                case KEYEXIT -> {
                    statements.add(new StateExit(parseExpr()));
                }
                case KEYSET -> {
                    Token name = expectConsume(TokenType.VAR);
                    expectConsume(TokenType.EQ);
                    statements.add(new StateSet(name.value, parseExpr()));
                }
                default -> throw new Exception(String.format("Unexpected Token `%s`", current));
            }
            expectConsume(TokenType.SEMI);
        }
    }

    Token peek(){
        return tokens.get(index);
    }

    Token consume(){
        return tokens.get(index++);
    }

    Token expectConsume(TokenType expectedType) throws Exception {
        if(peek().type != expectedType) throw new Exception(String.format("Expected %s, got %s", expectedType, peek().type));
        return consume();
    }

}
