package org.AnOzen.ulang;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lexer {
    final String rawCode;
    public ArrayList<Token> tokens;
    int index = 0;

    public Lexer(String codePath) throws IOException {
        FileReader reader = new FileReader(codePath);
        rawCode = reader.readAllAsString();
        reader.close();
        tokens = new ArrayList<>();
    }

    static void main() throws Exception {
        Lexer lex = new Lexer("example.u");
        lex.tokenize();
        System.out.println(lex.tokens);
    }

    public void tokenize() throws Exception {
        char c;
        while (index < rawCode.length()) {
            c = consume();

            if (Character.isWhitespace(c)) continue;

            if (Character.isLetter(c) || c == '_') {
                StringBuilder word = new StringBuilder(Character.toString(c));
                while (Character.isLetterOrDigit((c = peek())) || c == '_') {
                    consume();
                    word.append(c);
                }

                switch (word.toString()) {
                    case "exit" -> tokens.add(new Token(TokenType.KEYEXIT, ""));
                    case "set" -> tokens.add(new Token(TokenType.KEYSET, ""));
                    default -> tokens.add(new Token(TokenType.VAR, word.toString()));
                }
                continue;
            } else if (Character.isDigit(c)) {
                StringBuilder word = new StringBuilder(Character.toString(c));
                while (Character.isDigit((c = peek()))) {
                    consume();
                    word.append(c);
                }
                tokens.add(new Token(TokenType.INTEGER, word.toString()));
                continue;
            }
            switch (c) {
                case ';' -> tokens.add(new Token(TokenType.SEMI, ""));
                case '=' -> tokens.add(new Token(TokenType.EQ, ""));
                case '+' -> tokens.add(new Token(TokenType.PLUS, ""));
                case '-' -> tokens.add(new Token(TokenType.MINUS, ""));
                case '*' -> tokens.add(new Token(TokenType.STAR, ""));
                case '/' -> tokens.add(new Token(TokenType.SLASH, ""));
                case '%' -> tokens.add(new Token(TokenType.PERCENT, ""));
            }

        }
        tokens.add(new Token(TokenType.EOF, ""));
    }

    char peek() {
        if (index >= rawCode.length())
            return 0;
        return rawCode.charAt(index);
    }

    char consume() {
        if (index >= rawCode.length())
            return 0;
        return rawCode.charAt(index++);
    }

}
