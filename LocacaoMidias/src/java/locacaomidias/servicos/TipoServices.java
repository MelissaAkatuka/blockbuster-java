package locacaomidias.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.dao.TipoDAO;
import locacaomidias.entidades.Tipo;

public class TipoServices {
    public List<Tipo> getTodos() {

        List<Tipo> lista = new ArrayList<>();
        TipoDAO dao = null;

        try {
            dao = new TipoDAO();
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
