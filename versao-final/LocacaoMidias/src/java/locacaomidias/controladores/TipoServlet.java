package locacaomidias.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locacaomidias.dao.TipoDAO;
import locacaomidias.entidades.Tipo;

@WebServlet( name = "TipoServlet", 
             urlPatterns = { "/processaTipos" } )
public class TipoServlet extends HttpServlet{
    
    protected void processRequest( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        TipoDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new TipoDAO();

            if ( acao.equals( "inserir" ) ) {

                String descricao = request.getParameter( "descricao" );

                Tipo t = new Tipo();
                t.setDescricao(descricao);

                dao.salvar( t );

                disp = request.getRequestDispatcher(
                        "/formularios/tipos/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));
                String descricao = request.getParameter( "descricao" );

                Tipo t = new Tipo();
                t.setId(id);
                t.setDescricao(descricao);

                dao.atualizar( t );

                disp = request.getRequestDispatcher(
                        "/formularios/tipos/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));

                Tipo t = new Tipo();
                t.setId(id);

                dao.excluir( t );

                disp = request.getRequestDispatcher(
                        "/formularios/tipos/listagem.jsp" );

            } else {
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                Tipo t = dao.obterPorId( id );
                request.setAttribute( "tipo", t );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/tipos/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/tipos/excluir.jsp" );
                }
                
            }

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
        return "TipoServlet";
    }
    
}
