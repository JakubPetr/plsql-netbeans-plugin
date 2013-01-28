/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.webexo.plsql;

import java.io.IOException;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.text.MultiViewEditorElement;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

public class PlSqlDataObject extends MultiDataObject {

    public PlSqlDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        registerEditor("text/x-plsql", true);
    }

    @Override
    protected int associateLookup() {
        return 1;
    }

    @MultiViewElement.Registration(displayName = "#LBL_PlSql_EDITOR",
    iconBase = "cz/webexo/plsql/ico.png",
    mimeType = "text/x-plsql",
    persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
    preferredID = "PlSql",
    position = 1000)
    @Messages("LBL_PlSql_EDITOR=Source")
    public static MultiViewEditorElement createEditor(Lookup lkp) {
        return new MultiViewEditorElement(lkp);
    }
}
