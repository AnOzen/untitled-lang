package org.AnOzen.ulang;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lexer {
    final String rawCode;
    public ArrayList<Token> tokens;
    int index = 0;

    public Lexer(String codePath) throws IOException {
        FileReader reader = new FileReader(new File(codePath));
        rawCode = reader.readAllAsString();
        reader.close();
        tokens = new ArrayList<>();
    }

    public void tokenize() {
        char c;
        while(index < rawCode.length()){
            c = consume();

            if(Character.isWhitespace(c)) continue;

            if (Character.isLetter(c)) {
                StringBuilder word = new StringBuilder(Character.toString(c));
                while (Character.isLetterOrDigit((c = peek()))) {
                    consume();
                    word.append(c);
                }

                switch (word.toString()) {
                    case "exit" -> tokens.add(new Token(TokenType.KEYEXIT, ""));
                    default -> Utils.ErrorExit(String.format("Unknown word `%s`", word));
                }
            } else if (Character.isDigit(c)){
                StringBuilder word = new StringBuilder(Character.toString(c));
                while(Character.isDigit((c = peek()))){
                    consume();
                    word.append(c);
                }
                tokens.add(new Token(TokenType.INTEGER, word.toString()));
            } else if (c == ';') {
                tokens.add(new Token(TokenType.SEMI, ""));
            } else {
                Utils.ErrorExit(String.format("Unknown character `%s`", c));
            }

        }
        tokens.add(new Token(TokenType.EOF, ""));
    }




    char peek(){
        if (index >= rawCode.length())
            return 0;
        return rawCode.charAt(index);
    }

    char consume(){
        if (index >= rawCode.length())
            return 0;
        return rawCode.charAt(index++);
    }

}
