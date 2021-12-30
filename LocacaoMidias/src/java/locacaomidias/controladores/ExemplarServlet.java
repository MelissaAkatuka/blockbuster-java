/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaomidias.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locacaomidias.dao.ExemplarDAO;
import locacaomidias.dao.MidiaDAO;
import locacaomidias.entidades.Exemplar;
import locacaomidias.entidades.Midia;
import locacaomidias.utils.Utils;

/**
 *
 * @author Melissa
 */
@WebServlet(name = "ExemplarServlet",
        urlPatterns = {"/processaExemplar"})
public class ExemplarServlet extends HttpServlet {

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        RequestDispatcher disp = null;

        ExemplarDAO daoExemplar = null;
        MidiaDAO daoMidia = null;
        
        try {

            daoExemplar = new ExemplarDAO();
            daoMidia = new MidiaDAO();

            if (acao.equals("inserir")) {

                Long idMidia = Utils.getLong(request, "idMidia");
                int qtd = Integer.parseInt(request.getParameter("qtd"));

                Midia m = daoMidia.obterPorId(Integer.parseInt(idMidia.toString()));

                Exemplar e = new Exemplar();
                e.setDisponivel(true);
                e.setMidia(m);

                for (int i = 0; i < qtd; i++) {
                    Utils.validar(e, "id");
                    daoExemplar.salvar(e);
                }
                disp = request.getRequestDispatcher(
                        "/formularios/exemplar/listagem.jsp");

            } else if (acao.equals("alterar")) {

                boolean disponivel = Boolean.parseBoolean(request.getParameter("estaDisponivel"));
                Long idMidia = Utils.getLong(request, "idMidia");

                Midia m = daoMidia.obterPorId(Integer.parseInt(idMidia.toString()));

                Exemplar e = daoExemplar.obterPorId(Integer.parseInt(idMidia.toString()));
                e.setDisponivel(disponivel);
                e.setMidia(m);

                Utils.validar(e, "id");
                daoExemplar.atualizar(e);
                disp = request.getRequestDispatcher(
                        "/formularios/exemplar/listagem.jsp");

            } else if (acao.equals("excluir")) {

                Long id = Utils.getLong(request, "id");
                Exemplar e = daoExemplar.obterPorId(Integer.parseInt(id.toString()));

                daoExemplar.excluir(e);
                disp = request.getRequestDispatcher(
                        "/formularios/exemplar/listagem.jsp");

            } else {

                String id = request.getParameter("id");
                Exemplar e = daoExemplar.obterPorId(Integer.parseInt(id));
                request.setAttribute("exemplar", e);

                if (acao.equals("prepararAlteracao")) {
                    disp = request.getRequestDispatcher(
                            "/formularios/exemplar/alterar.jsp");
                } else if (acao.equals("prepararExclusao")) {
                    disp = request.getRequestDispatcher(
                            "/formularios/exemplar/excluir.jsp");
                }

            }

        } catch ( SQLException exc ) {
            exc.printStackTrace();
        } finally {
            if ( daoExemplar != null ) {
                try {
                    daoExemplar.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
        }

        if ( disp != null ) {
            disp.forward( request, response );
        }

    }
    
    @Override
    protected void doGet( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    @Override
    protected void doPost( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    @Override
    public String getServletInfo() {
        return "ExemplarServlet";
    }
}
