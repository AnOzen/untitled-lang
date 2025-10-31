import org.AnOzen.ulang.Lexer;
import org.AnOzen.ulang.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    void testNormal(){
        Assertions.assertDoesNotThrow(() -> {
            Lexer lex = new Lexer("src/test/resources/normal.u");
            lex.tokenize();
            Parser parser = new Parser(lex.tokens);
            parser.parse();
            Assertions.assertEquals("[Set(x,Int(0)), Exit(Var(x))]", parser.statements.toString());
        });
    }

    @Test
    void testUnxTok(){
        Assertions.assertThrows(Exception.class, () -> {
            Lexer lex = new Lexer("src/test/resources/unexpectedToken.u");
            lex.tokenize();
            Parser parser = new Parser(lex.tokens);
            parser.parse();
        });
    }
}
