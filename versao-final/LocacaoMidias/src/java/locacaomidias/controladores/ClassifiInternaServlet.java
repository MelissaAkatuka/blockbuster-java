package locacaomidias.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locacaomidias.dao.ClassificacaoInternaDAO;
import locacaomidias.entidades.ClassificacaoInterna;

@WebServlet( name = "ClassifiInternaServlet", 
             urlPatterns = { "/processaClassificacaoInterna" } )
public class ClassifiInternaServlet extends HttpServlet{
    protected void processRequest( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        ClassificacaoInternaDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new ClassificacaoInternaDAO();

            if ( acao.equals( "inserir" ) ) {

                String descricao = request.getParameter( "descricao" );
                String valor = request.getParameter( "valorAluguel" );

                ClassificacaoInterna c = new ClassificacaoInterna();
                c.setDescricao(descricao);
                c.setValorAluguel(Double.parseDouble(valor));

                dao.salvar( c );

                disp = request.getRequestDispatcher(
                        "/formularios/classificacaointerna/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));
                String descricao = request.getParameter( "descricao" );
                String valor = request.getParameter( "valorAluguel" );

                ClassificacaoInterna c = new ClassificacaoInterna();
                c.setId( id );
                c.setDescricao(descricao);
                c.setValorAluguel(Double.parseDouble(valor));

                dao.atualizar( c );

                disp = request.getRequestDispatcher(
                        "/formularios/classificacaointerna/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));

                ClassificacaoInterna c = new ClassificacaoInterna();
                c.setId( id );

                dao.excluir( c );

                disp = request.getRequestDispatcher(
                        "/formularios/classificacaointerna/listagem.jsp" );

            } else {
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                ClassificacaoInterna c = dao.obterPorId( id );
                request.setAttribute( "classificacao", c );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/classificacaointerna/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/classificacaointerna/excluir.jsp" );
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
        return "ClassifiInternaServlet";
    }
}
