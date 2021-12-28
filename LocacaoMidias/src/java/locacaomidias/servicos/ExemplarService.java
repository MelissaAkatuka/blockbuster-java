/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaomidias.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.dao.ExemplarDAO;
import locacaomidias.entidades.Exemplar;

/**
 *
 * @author Melissa
 */
public class ExemplarService {
    
    public List<Exemplar> getTodos() {
        List<Exemplar> lista = new ArrayList<>();

        try {
            ExemplarDAO dao = new ExemplarDAO();
            lista = dao.listarTodos();
        } catch ( SQLException exc ) {
            exc.printStackTrace();
        }

        return lista;
    }
    
}
