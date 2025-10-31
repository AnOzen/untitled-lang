package org.AnOzen.ulang;

import org.AnOzen.ulang.nodes.Statement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Interpreter {
    ArrayList<Statement> program;
    HashMap<String, String> environment;
    int index = 0;

    public Interpreter(ArrayList<Statement> statements) {
        program = statements;
        environment = new HashMap<>();
    }

    static void main(String[] args) throws Exception {
        Lexer lex = new Lexer(args[0]);
        lex.tokenize();
        Parser parse = new Parser(lex.tokens);
        parse.parse();
        Interpreter inter = new Interpreter(parse.statements);
        inter.run();
    }

    public void run() {
        while (index < program.size()) {
            Statement state = program.get(index++);
            state.interpret(environment);
        }
    }
}
