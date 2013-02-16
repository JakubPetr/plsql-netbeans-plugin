package cz.webexo.plsql;

import cz.webexo.lexer.PlSqlTokenId;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;

@LanguageRegistration(mimeType = "text/x-plsql")
public class PlSqlLanguage extends DefaultLanguageConfig {

    @Override
    public Language getLexerLanguage() {
        return PlSqlTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return "PL/SQL";
    }

}