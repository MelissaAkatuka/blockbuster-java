package locacaodvds.controladores;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locacaodvds.dao.DVDDAO;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.ClassificacaoEtaria;
import locacaodvds.entidades.DVD;
import locacaodvds.entidades.Genero;

@WebServlet( name = "DVDServlet", 
             urlPatterns = { "/processaDVDs" } )
public class DVDServlet extends HttpServlet{
    protected void processRequest( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        
        DVDDAO dao = null;
        RequestDispatcher disp = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {

            dao = new DVDDAO();

            if ( acao.equals( "inserir" ) ) {
                
                String titulo = request.getParameter( "titulo" );
                String anoLanc = request.getParameter( "anoLanc" );
                String dataLanc = request.getParameter( "dataLanc" );
                String duracao = request.getParameter( "duracaoMin" );
                int atorPrincId = Integer.parseInt( 
                        request.getParameter( "atorPrincId" ) );
                int atorCoadId = Integer.parseInt( 
                        request.getParameter( "atorCoadId" ) );
                int classificacaoId = Integer.parseInt( 
                        request.getParameter( "classificacaoId" ) );
                int generoId = Integer.parseInt( 
                        request.getParameter( "generoId" ) );

                DVD dvd = new DVD();
                ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
                Genero genero = new Genero();
                Ator atorPrinc = new Ator();
                Ator atorCoad = new Ator();
                
                dvd.setTitulo(titulo);
                dvd.setAnoLancamento(Integer.parseInt(anoLanc));
                dvd.setDataLancamento(Date.valueOf( 
                        LocalDate.parse( dataLanc, dtf )));
                dvd.setDuracaoMin(Integer.parseInt(duracao));
                
                classificacao.setId(classificacaoId);
                
                genero.setId(generoId);
                
                atorPrinc.setId(atorPrincId);
                
                atorCoad.setId(atorCoadId);
                
                dvd.setAtorCoadjuvante(atorCoad);
                dvd.setAtorPrincipal(atorPrinc);
                dvd.setClassificacao(classificacao);
                dvd.setGenero(genero);
                
                dao.salvar( dvd );

                disp = request.getRequestDispatcher(
                        "/formularios/dvds/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));
                String titulo = request.getParameter( "titulo" );
                String anoLanc = request.getParameter( "anoLanc" );
                String dataLanc = request.getParameter( "dataLanc" );
                String duracao = request.getParameter( "duracaoMin" );
                int atorPrincId = Integer.parseInt( 
                        request.getParameter( "atorPrincId" ) );
                int atorCoadId = Integer.parseInt( 
                        request.getParameter( "atorCoadId" ) );
                int classificacaoId = Integer.parseInt( 
                        request.getParameter( "classificacaoId" ) );
                int generoId = Integer.parseInt( 
                        request.getParameter( "generoId" ) );

                DVD dvd = new DVD();
                ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
                Genero genero = new Genero();
                Ator atorPrinc = new Ator();
                Ator atorCoad = new Ator();
                
                dvd.setId(id);
                dvd.setTitulo(titulo);
                dvd.setAnoLancamento(Integer.parseInt(anoLanc));
                dvd.setDataLancamento(Date.valueOf( 
                        LocalDate.parse( dataLanc, dtf )));
                dvd.setDuracaoMin(Integer.parseInt(duracao));
                
                classificacao.setId(classificacaoId);
                
                genero.setId(generoId);
                
                atorPrinc.setId(atorPrincId);
                
                atorCoad.setId(atorCoadId);
                
                dvd.setAtorCoadjuvante(atorCoad);
                dvd.setAtorPrincipal(atorPrinc);
                dvd.setClassificacao(classificacao);
                dvd.setGenero(genero);

                dao.atualizar( dvd );

                disp = request.getRequestDispatcher(
                        "/formularios/dvds/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));

                DVD dvd = new DVD();
                dvd.setId(id);
                
                dao.excluir( dvd );

                disp = request.getRequestDispatcher(
                        "/formularios/dvds/listagem.jsp" );

            } else {
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                DVD dvd = dao.obterPorId( id );
                request.setAttribute( "dvd", dvd );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/dvds/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/dvds/excluir.jsp" );
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
        return "DVDServlet";
    }
}
