package locacaodvds.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.ClassificacaoEtariaDAO;
import locacaodvds.entidades.ClassificacaoEtaria;

public class ClassificacaoEtariaServices {
    public List<ClassificacaoEtaria> getTodos() {

        List<ClassificacaoEtaria> lista = new ArrayList<>();
        ClassificacaoEtariaDAO dao = null;

        try {
            dao = new ClassificacaoEtariaDAO();
            lista = dao.listarTodos();
        } catch ( SQLException exc ) {
            exc.printStackTrace();
        } finally {
            if ( dao != null ) {
                try {
                    dao.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
        }

        return lista;

    }
}
