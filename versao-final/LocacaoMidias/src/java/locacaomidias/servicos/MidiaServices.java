package locacaomidias.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.dao.MidiaDAO;
import locacaomidias.entidades.Midia;

public class MidiaServices {
    public List<Midia> getTodos() {

        List<Midia> lista = new ArrayList<>();
        MidiaDAO dao = null;

        try {
            dao = new MidiaDAO();
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
