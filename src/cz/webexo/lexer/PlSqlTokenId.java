package cz.webexo.lexer;

import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;

public class PlSqlTokenId implements TokenId {

    private final String name;
    private final String primaryCategory;
    private final int id;

    PlSqlTokenId(
            String name,
            String primaryCategory,
            int id) {
        this.name = name;
        this.primaryCategory = primaryCategory;
        this.id = id;
    }

    @Override
    public String primaryCategory() {
        return primaryCategory;
    }

    @Override
    public int ordinal() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    public static Language<PlSqlTokenId> getLanguage() {
        return new PlSqlLanguageHierarchy().language();
    }    
    
}