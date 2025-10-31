import org.AnOzen.ulang.Lexer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LexerTest {
    @Test
    void testNormal(){
        Assertions.assertDoesNotThrow(() -> {
            Lexer lex = new Lexer("src/test/resources/normal.u");
            lex.tokenize();
            Assertions.assertEquals("[KEYSET, VAR x, EQ, INTEGER 0, SEMI, KEYEXIT, VAR x, SEMI, EOF]", lex.tokens.toString());
        });
    }

    @Test
    void testUnkChar(){
        Assertions.assertThrows(Exception.class, () -> {
            Lexer lex = new Lexer("src/test/resources/unknownChar.u");
            lex.tokenize();
        });
    }

}
