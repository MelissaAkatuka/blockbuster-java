package locacaomidias.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locacaomidias.dao.GeneroDAO;
import locacaomidias.entidades.Genero;

@WebServlet( name = "GeneroServlet", 
             urlPatterns = { "/processaGeneros" } )
public class GeneroServlet extends HttpServlet{
    
    protected void processRequest( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        GeneroDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new GeneroDAO();

            if ( acao.equals( "inserir" ) ) {

                String descricao = request.getParameter( "descricao" );

                Genero g = new Genero();
                g.setDescricao(descricao);

                dao.salvar( g );

                disp = request.getRequestDispatcher(
                        "/formularios/generos/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));
                String descricao = request.getParameter( "descricao" );

                Genero g = new Genero();
                g.setId(id);
                g.setDescricao(descricao);

                dao.atualizar( g );

                disp = request.getRequestDispatcher(
                        "/formularios/generos/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));

                Genero g = new Genero();
                g.setId(id);

                dao.excluir( g );

                disp = request.getRequestDispatcher(
                        "/formularios/generos/listagem.jsp" );

            } else {
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                Genero g = dao.obterPorId( id );
                request.setAttribute( "genero", g );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/generos/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/generos/excluir.jsp" );
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
        return "GeneroServlet";
    }
    
}
