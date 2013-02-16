package cz.webexo.lexer;

import java.util.*;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

public class PlSqlLanguageHierarchy extends LanguageHierarchy<PlSqlTokenId> {

    private static List<PlSqlTokenId> tokens;
    private static Map<Integer, PlSqlTokenId> idToToken;

    private static void init() {
        tokens = Arrays.<PlSqlTokenId>asList(new PlSqlTokenId[]{
            new PlSqlTokenId("EOF", "whitespace", 0),
                        
            new PlSqlTokenId("K_BINARY_INTEGER", "datatype", 12),
            new PlSqlTokenId("K_BOOLEAN", "datatype", 13),
            new PlSqlTokenId("K_CHAR", "datatype", 15),
            new PlSqlTokenId("K_DATE", "datatype", 23),
            new PlSqlTokenId("K_DECIMAL", "datatype", 24),
            new PlSqlTokenId("K_FLOAT", "datatype", 40),
            new PlSqlTokenId("K_INTEGER", "datatype", 51),
            new PlSqlTokenId("K_NUMBER", "datatype", 65),
            
            new PlSqlTokenId("S_NUMBER", "number", 111),
            new PlSqlTokenId("FLOAT", "number", 112),
            new PlSqlTokenId("INTEGER", "number", 113),
            new PlSqlTokenId("DIGIT", "number", 114),            
            
            new PlSqlTokenId("LINE_COMMENT", "comment", 115),
            new PlSqlTokenId("MULTI_LINE_COMMENT", "comment", 116),
            
            new PlSqlTokenId("K_ALL", "keyword", 5),
            new PlSqlTokenId("K_AND", "keyword", 6),
            new PlSqlTokenId("K_ANY", "keyword", 7),
            new PlSqlTokenId("K_AS", "keyword", 8),
            new PlSqlTokenId("K_ASC", "keyword", 9),
            new PlSqlTokenId("K_BEGIN", "keyword", 10),
            new PlSqlTokenId("K_BETWEEN", "keyword", 11),
            
            new PlSqlTokenId("K_BY", "keyword", 14),
            new PlSqlTokenId("K_CLOSE", "keyword", 16),
            new PlSqlTokenId("K_COMMENT", "keyword", 17),
            new PlSqlTokenId("K_COMMIT", "keyword", 18),
            new PlSqlTokenId("K_CONNECT", "keyword", 19),
            new PlSqlTokenId("K_CONSTANT", "keyword", 20),
            new PlSqlTokenId("K_CURRENT", "keyword", 21),
            new PlSqlTokenId("K_CURSOR", "keyword", 22),
            
            
            new PlSqlTokenId("K_DECLARE", "keyword", 25),
            new PlSqlTokenId("K_DEFAULT", "keyword", 26),
            new PlSqlTokenId("K_DELETE", "keyword", 27),
            new PlSqlTokenId("K_DESC", "keyword", 28),
            new PlSqlTokenId("K_DISTINCT", "keyword", 29),
            new PlSqlTokenId("K_DO", "keyword", 30),
            new PlSqlTokenId("K_ELSE", "keyword", 31),
            new PlSqlTokenId("K_ELSIF", "keyword", 32),
            new PlSqlTokenId("K_END", "keyword", 33),
            new PlSqlTokenId("K_EXCEPTION", "keyword", 34),
            new PlSqlTokenId("K_EXCEPTION_INIT", "keyword", 35),
            new PlSqlTokenId("K_EXCLUSIVE", "keyword", 36),
            new PlSqlTokenId("K_EXISTS", "keyword", 37),
            new PlSqlTokenId("K_EXIT", "keyword", 38),
            new PlSqlTokenId("K_FETCH", "keyword", 39),
            
            new PlSqlTokenId("K_FOR", "keyword", 41),
            new PlSqlTokenId("K_FROM", "keyword", 42),
            new PlSqlTokenId("K_FUNCTION", "keyword", 43),
            new PlSqlTokenId("K_GOTO", "keyword", 44),
            new PlSqlTokenId("K_GROUP", "keyword", 45),
            new PlSqlTokenId("K_HAVING", "keyword", 46),
            new PlSqlTokenId("K_IF", "keyword", 47),
            new PlSqlTokenId("K_IN", "keyword", 48),
            new PlSqlTokenId("K_INDEX", "keyword", 49),
            new PlSqlTokenId("K_INSERT", "keyword", 50),
            
            new PlSqlTokenId("K_INTERSECT", "keyword", 52),
            new PlSqlTokenId("K_INTO", "keyword", 53),
            new PlSqlTokenId("K_IS", "keyword", 54),
            new PlSqlTokenId("K_LEVEL", "keyword", 55),
            new PlSqlTokenId("K_LIKE", "keyword", 56),
            new PlSqlTokenId("K_LOCK", "keyword", 57),
            new PlSqlTokenId("K_LOOP", "keyword", 58),
            new PlSqlTokenId("K_MINUS", "keyword", 59),
            new PlSqlTokenId("K_MODE", "keyword", 60),
            new PlSqlTokenId("K_NATURAL", "keyword", 61),
            new PlSqlTokenId("K_NOT", "keyword", 62),
            new PlSqlTokenId("K_NOWAIT", "keyword", 63),
            new PlSqlTokenId("K_NULL", "keyword", 64),
            new PlSqlTokenId("K_OF", "keyword", 66),
            new PlSqlTokenId("K_ONLY", "keyword", 67),
            new PlSqlTokenId("K_OPEN", "keyword", 68),
            new PlSqlTokenId("K_OR", "keyword", 69),
            new PlSqlTokenId("K_ORDER", "keyword", 70),
            new PlSqlTokenId("K_OTHERS", "keyword", 71),
            new PlSqlTokenId("K_OUT", "keyword", 72),
            new PlSqlTokenId("K_PACKAGE", "keyword", 73),
            new PlSqlTokenId("K_POSITIVE", "keyword", 74),
            new PlSqlTokenId("K_PRAGMA", "keyword", 75),
            new PlSqlTokenId("K_PRIOR", "keyword", 76),
            new PlSqlTokenId("K_PROCEDURE", "method-declaration", 77),
            new PlSqlTokenId("K_RAISE", "keyword", 78),
            new PlSqlTokenId("K_READ", "keyword", 79),
            new PlSqlTokenId("K_REAL", "keyword", 80),
            new PlSqlTokenId("K_RECORD", "keyword", 81),
            new PlSqlTokenId("K_REF", "keyword", 82),
            new PlSqlTokenId("K_RETURN", "keyword", 83),
            new PlSqlTokenId("K_REVERSE", "keyword", 84),
            new PlSqlTokenId("K_ROLLBACK", "keyword", 85),
            new PlSqlTokenId("K_ROW", "keyword", 86),
            new PlSqlTokenId("K_SAVEPOINT", "keyword", 87),
            new PlSqlTokenId("K_SEGMENT", "keyword", 88),
            new PlSqlTokenId("K_SELECT", "keyword", 89),
            new PlSqlTokenId("K_SET", "keyword", 90),
            new PlSqlTokenId("K_SHARE", "keyword", 91),
            new PlSqlTokenId("K_SMALLINT", "datatype", 92),
            new PlSqlTokenId("K_SQL", "keyword", 93),
            new PlSqlTokenId("K_START", "keyword", 94),
            new PlSqlTokenId("K_TABLE", "keyword", 95),
            new PlSqlTokenId("K_THEN", "keyword", 96),
            new PlSqlTokenId("K_TO", "keyword", 97),
            new PlSqlTokenId("K_TRANSACTION", "keyword", 98),
            new PlSqlTokenId("K_UNION", "keyword", 99),
            new PlSqlTokenId("K_UPDATE", "keyword", 100),
            new PlSqlTokenId("K_USE", "keyword", 101),
            new PlSqlTokenId("K_VALUES", "keyword", 102),
            new PlSqlTokenId("K_VARCHAR2", "datatype", 103),
            new PlSqlTokenId("K_VARCHAR", "datatype", 104),
            new PlSqlTokenId("K_WHEN", "keyword", 105),
            new PlSqlTokenId("K_WHERE", "keyword", 106),
            new PlSqlTokenId("K_WHILE", "keyword", 107),
            new PlSqlTokenId("K_WITH", "keyword", 108),
            new PlSqlTokenId("K_WORK", "keyword", 109),
            new PlSqlTokenId("K_WRITE", "keyword", 110),
            new PlSqlTokenId("S_BIND", "keyword", 120),

            new PlSqlTokenId("LETTER", "literal", 118),
            new PlSqlTokenId("SPECIAL_CHARS", "literal", 119),
            new PlSqlTokenId("S_CHAR_LITERAL", "literal", 121),
            new PlSqlTokenId("S_QUOTED_IDENTIFIER", "identifier", 122),
            
            new PlSqlTokenId("S_IDENTIFIER", "identifier", 117)
        });
        idToToken = new HashMap<Integer, PlSqlTokenId>();
        for (PlSqlTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    static synchronized PlSqlTokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        return idToToken.get(id);
    }

    @Override
    protected synchronized Collection<PlSqlTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }

    @Override
    protected synchronized Lexer<PlSqlTokenId> createLexer(LexerRestartInfo<PlSqlTokenId> info) {
        return new PlSqlLexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/x-plsql";
    }

}