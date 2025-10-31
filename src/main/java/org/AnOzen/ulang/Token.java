package org.AnOzen.ulang;

public class Token {
    TokenType type;
    String value;

    public Token(TokenType t, String val){
        type = t;
        value = val;
    }

    public String toString() {
        return value.isEmpty() ? type.toString() : type.toString() + " " + value;
    }
}
