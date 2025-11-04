package org.AnOzen.ulang.nodes;

import java.util.HashMap;

public interface Expression {
    String interpret(HashMap<String, String> environment);

    void compile();
}
