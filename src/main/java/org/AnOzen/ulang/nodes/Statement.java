package org.AnOzen.ulang.nodes;

import java.util.HashMap;

public interface Statement {
    void interpret(HashMap<String, String> environment);

    void compile();
}
