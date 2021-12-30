package locacaomidias.controladores;

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
import locacaomidias.dao.ExemplarDAO;
import locacaomidias.dao.MidiaDAO;
import locacaomidias.entidades.Ator;
import locacaomidias.entidades.ClassificacaoEtaria;
import locacaomidias.entidades.ClassificacaoInterna;
import locacaomidias.entidades.Exemplar;
import locacaomidias.entidades.Midia;
import locacaomidias.entidades.Genero;
import locacaomidias.entidades.Tipo;

@WebServlet( name = "MidiaServlet", 
             urlPatterns = { "/processaMidia" } )
public class MidiaServlet extends HttpServlet{
    protected void processRequest( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        
        MidiaDAO dao = null;
        ExemplarDAO exemplardao = null;
        RequestDispatcher disp = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {

            dao = new MidiaDAO();
            exemplardao = new ExemplarDAO();
            
            if ( acao.equals( "inserir" ) ) {
                
                String titulo = request.getParameter( "titulo" );
                String anoLanc = request.getParameter( "anoLanc" );
                String codigoBarras = request.getParameter( "codigoBarras" );
                String duracao = request.getParameter( "duracaoMin" );
                int atorPrincId = Integer.parseInt( 
                        request.getParameter( "atorPrincId" ) );
                int atorCoadId = Integer.parseInt( 
                        request.getParameter( "atorCoadId" ) );
                int generoId = Integer.parseInt( 
                        request.getParameter( "generoId" ) );
                int classificacaoEtariaId = Integer.parseInt( 
                    request.getParameter( "classificacaoEtariaId" ) );
                int tipoId = Integer.parseInt( 
                        request.getParameter( "tipoId" ) );
                int classificacaoInternaId = Integer.parseInt( 
                        request.getParameter( "classificacaoInternaId" ) );

                Midia midia = new Midia();
                ClassificacaoEtaria classificacaoEtaria = new ClassificacaoEtaria();
                Genero genero = new Genero();
                Ator atorPrinc = new Ator();
                Ator atorCoad = new Ator();
                Tipo tipo = new Tipo();
                ClassificacaoInterna classificacaoInterna = new ClassificacaoInterna();
                
                midia.setTitulo(titulo);
                midia.setAnoLancamento(Integer.parseInt(anoLanc));
                midia.setCodigoBarras(codigoBarras);
                midia.setDuracaoMin(Integer.parseInt(duracao));
                               
                atorPrinc.setId(atorPrincId);
                midia.setAtorPrincipal(atorPrinc);
                
                atorCoad.setId(atorCoadId);
                midia.setAtorCoadjuvante(atorCoad);
                
                genero.setId(generoId);
                midia.setGenero(genero);
                
                classificacaoEtaria.setId(classificacaoEtariaId); 
                midia.setClassificacaoEtaria(classificacaoEtaria);
                
                tipo.setId(tipoId);
                midia.setTipo(tipo);
                
                classificacaoInterna.setId(classificacaoInternaId);
                midia.setClassificacaoInterna(classificacaoInterna);

                dao.salvar( midia );
                
                Exemplar e = new Exemplar();
                e.setDisponivel(true);
                e.setMidia(dao.obterPorCodBarras(midia.getCodigoBarras()));
                
                exemplardao.salvar(e);

                disp = request.getRequestDispatcher(
                        "/formularios/midia/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));
                String titulo = request.getParameter( "titulo" );
                String anoLanc = request.getParameter( "anoLanc" );
                String codigoBarras = request.getParameter( "codigoBarras" );
                String duracao = request.getParameter( "duracaoMin" );
                int atorPrincId = Integer.parseInt( 
                        request.getParameter( "atorPrincId" ) );
                int atorCoadId = Integer.parseInt( 
                        request.getParameter( "atorCoadId" ) );
                int generoId = Integer.parseInt( 
                        request.getParameter( "generoId" ) );
                int classificacaoEtariaId = Integer.parseInt( 
                        request.getParameter( "classificacaoEtariaId" ) );
                int tipoId = Integer.parseInt( 
                        request.getParameter( "tipoId" ) );
                int classificacaoInternaId = Integer.parseInt( 
                        request.getParameter( "classificacaoInternaId" ) );

                Midia midia = new Midia();
                ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
                Genero genero = new Genero();
                Ator atorPrinc = new Ator();
                Ator atorCoad = new Ator();
                Tipo tipo = new Tipo();
                ClassificacaoInterna classificacaoInterna = new ClassificacaoInterna();
                
                midia.setId(id);
                midia.setTitulo(titulo);
                midia.setAnoLancamento(Integer.parseInt(anoLanc));
                midia.setCodigoBarras(codigoBarras);
                midia.setDuracaoMin(Integer.parseInt(duracao));
                
                atorPrinc.setId(atorPrincId);
                atorCoad.setId(atorCoadId);
                genero.setId(generoId);
                classificacao.setId(classificacaoEtariaId);
                tipo.setId(tipoId);
                classificacaoInterna.setId(classificacaoInternaId);
                
                midia.setAtorCoadjuvante(atorCoad);
                midia.setAtorPrincipal(atorPrinc);
                midia.setClassificacaoEtaria(classificacao);
                midia.setGenero(genero);
                midia.setTipo(tipo);
                midia.setClassificacaoInterna(classificacaoInterna);

                dao.atualizar( midia );

                disp = request.getRequestDispatcher(
                        "/formularios/midia/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));

                Midia midia = new Midia();
                midia.setId(id);
                
                dao.excluir( midia );

                disp = request.getRequestDispatcher(
                        "/formularios/midia/listagem.jsp" );

            } else {
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                Midia midia = dao.obterPorId( id );
                request.setAttribute( "midia", midia );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/midia/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/midia/excluir.jsp" );
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
        return "MidiaServlet";
    }
}
