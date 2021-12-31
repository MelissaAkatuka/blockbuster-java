package locacaomidias.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.dao.AtorDAO;
import locacaomidias.entidades.Ator;

public class AtorServices {
     public List<Ator> getTodos() {

        List<Ator> lista = new ArrayList<>();
        AtorDAO dao = null;

        try {
            dao = new AtorDAO();
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
