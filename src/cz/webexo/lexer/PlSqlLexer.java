package cz.webexo.lexer;

import cz.webexo.jcclexer.PlSqlParserTokenManager;
import cz.webexo.jcclexer.SimpleCharStream;
import cz.webexo.jcclexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

class PlSqlLexer implements Lexer<PlSqlTokenId> {

    private LexerRestartInfo<PlSqlTokenId> info;
    private PlSqlParserTokenManager parserTokenManager;
    
    PlSqlLexer(LexerRestartInfo<PlSqlTokenId> info) {
        this.info = info;
        
        SimpleCharStream stream = new SimpleCharStream(info.input());
        PlSqlParserTokenManager.ReInit(stream);
    }

    @Override
    public org.netbeans.api.lexer.Token<PlSqlTokenId> nextToken() {
        Token token = PlSqlParserTokenManager.getNextToken();
        if (info.input().readLength() < 1) {
            return null;
        }
        return info.tokenFactory().createToken(PlSqlLanguageHierarchy.getToken(token.kind));
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }

}