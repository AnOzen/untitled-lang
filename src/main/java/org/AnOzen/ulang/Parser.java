package org.AnOzen.ulang;

import org.AnOzen.ulang.nodes.*;

import java.util.ArrayList;

public class Parser {
    public ArrayList<Statement> program;
    ArrayList<Token> tokens;
    int index = 0;

    public Parser(ArrayList<Token> tks) {
        tokens = tks;
        program = new ArrayList<>();
    }

    Expression parseExpr(int precL) throws Exception {
        Token t = consume();

        Expression left;

        switch (t.type) {
            case INTEGER -> left = new ExprInt(Integer.parseInt(t.value));
            case VAR -> left = new ExprVar(t.value);
            case LPAREN -> {
                left = parseExpr(0);
                expectConsume(TokenType.RPAREN);
            }
            default -> throw new Exception("Unexpected Token `" + t + "`");
        }

        while (true) {

            if (peek().type == TokenType.EOF || !isBinOp(peek())) return left;

            t = consume();

            int prec = getOpPrecedence(t.type);

            Expression right;

            if (prec <= precL) {
                index--;
                return left;
            } else {
                right = parseExpr(precL + 1);
            }

            left = new ExprBin(left, right, getBinOpType(t.type));

        }

    }

    BinOpType getBinOpType(TokenType t) {
        switch (t) {
            case PLUS -> {
                return BinOpType.ADD;
            }
            case MINUS -> {
                return BinOpType.SUB;
            }
            case STAR -> {
                return BinOpType.MUL;
            }
            case SLASH -> {
                return BinOpType.DIV;
            }
            case PERCENT -> {
                return BinOpType.MOD;
            }
        }
        return null;
    }


    public void parse() throws Exception {
        while (index < tokens.size()) {
            Token current = consume();

            if (current.type == TokenType.EOF) break;
            switch (current.type) {
                case KEYEXIT -> program.add(new StateExit(parseExpr(0)));
                case KEYSET -> {
                    Token name = expectConsume(TokenType.VAR);
                    expectConsume(TokenType.EQ);
                    program.add(new StateSet(name.value, parseExpr(0)));
                }
                default -> throw new Exception(String.format("Unexpected Token `%s`", current));
            }
            expectConsume(TokenType.SEMI);
        }
    }

    Token peek() {
        return tokens.get(index);
    }

    Token consume() {
        return tokens.get(index++);
    }

    Token expectConsume(TokenType expectedType) throws Exception {
        if (peek().type != expectedType)
            throw new Exception(String.format("Expected %s, got %s", expectedType, peek().type));
        return consume();
    }

    boolean isBinOp(Token t) {
        return t.type == TokenType.PLUS || t.type == TokenType.MINUS || t.type == TokenType.STAR ||
                t.type == TokenType.SLASH || t.type == TokenType.PERCENT;
    }

    int getOpPrecedence(TokenType type) {
        switch (type) {
            case PLUS, MINUS -> {
                return 1;
            }
            case STAR, SLASH, PERCENT -> {
                return 2;
            }
        }
        return -1;
    }

}
