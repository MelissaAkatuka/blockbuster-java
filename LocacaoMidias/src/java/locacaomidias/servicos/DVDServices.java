package locacaomidias.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.dao.DVDDAO;
import locacaomidias.entidades.DVD;

public class DVDServices {
    public List<DVD> getTodos() {

        List<DVD> lista = new ArrayList<>();
        DVDDAO dao = null;

        try {
            dao = new DVDDAO();
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
