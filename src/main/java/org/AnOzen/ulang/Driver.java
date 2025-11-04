package org.AnOzen.ulang;

public class Driver {

    static void main(String[] args) throws Exception {
        switch (args[0]){
            case "interpret", "i" -> {
                Lexer lex = new Lexer(args[1]);
                lex.tokenize();
                Parser parse = new Parser(lex.tokens);
                parse.parse();
                Interpreter inter = new Interpreter(parse.program);
                inter.run();
            }
            case "compile", "c" -> {

            }
            default -> {
                System.err.printf("Error: Unknown option `%s`%n", args[0]);
                System.exit(1);
            }
        }

    }


}
