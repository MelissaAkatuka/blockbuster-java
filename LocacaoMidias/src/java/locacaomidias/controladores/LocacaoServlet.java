package locacaomidias.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locacaomidias.dao.ClienteDAO;
import locacaomidias.dao.ExemplarDAO;
import locacaomidias.dao.Item_LocacaoDAO;
import locacaomidias.dao.LocacaoDAO;
import locacaomidias.entidades.Cliente;
import locacaomidias.entidades.Exemplar;
import locacaomidias.entidades.Item_Locacao;
import locacaomidias.entidades.Locacao;
import locacaomidias.utils.Utils;

@WebServlet( name = "LocacaoServlet", 
             urlPatterns = { "/processaLocacao" } )
public class LocacaoServlet extends HttpServlet {

    protected void processRequest( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        RequestDispatcher disp = null;
        LocacaoDAO dao = null;
        Item_LocacaoDAO itemLocacaoDao = null;
        ClienteDAO daoCliente = null;
        ExemplarDAO exemplarDao = null;
        
        try {

            daoCliente = new ClienteDAO();
            dao = new LocacaoDAO();
            itemLocacaoDao = new Item_LocacaoDAO();
            exemplarDao = new ExemplarDAO();
            
            if ( acao.equals( "inserir" ) ) {

                Long idCliente = Utils.getLong( request, "idCliente" );
                String itensLocacao = request.getParameter( "itensLocacao" );
                String dataInicio = request.getParameter("dataInicio");
                String dataFim = request.getParameter("dataFim");
                
                JsonReader jsr = Json.createReader( 
                        new StringReader( itensLocacao ) );
                
                JsonArray jsaitensLocacao = jsr.readArray();
                
                Cliente c = daoCliente.obterPorId( Integer.parseInt(idCliente.toString()) );
                
                
                Locacao l = new Locacao();
                l.setCancelada(false);
                l.setCliente(c);
                l.setDataInicio( Utils.getDate(dataInicio));
                l.setDataFim(Utils.getDate(dataFim));
                
                Utils.validar( l, "id" );
                dao.salvar( l );
                
                for ( JsonValue jsv : jsaitensLocacao ) {
                    
                    JsonObject jso = jsv.asJsonObject();
                    
                    Long codigo_interno = Utils.getLong( 
                            jso.getString( "codigo_interno" ) );
                    BigDecimal valorAluguel = Utils.getBigDecimal(
                            jso.getString( "valorAluguel" ) );
                    
                    int id = Integer.parseInt(codigo_interno.toString());
                    Exemplar e = exemplarDao.obterPorId(id);
                    
                    Item_Locacao il = new Item_Locacao();
                    il.setExemplar(e);
                    il.setValor(valorAluguel.doubleValue());
                    il.setLocacao(l);
                    
                    itemLocacaoDao.salvar(il);
                    
                    e.setDisponivel(false);
                    
                    //exemplarDao.atualizar( e );
                    itemLocacaoDao.salvar( il );
                    
                }
                
                disp = request.getRequestDispatcher(
                        "/formularios/locacao/listagem.jsp" );

            } else if ( acao.equals( "cancelar" ) ) {

                Long id = Utils.getLong( request, "id" );
                
                Locacao l = dao.obterPorId(Integer.parseInt(id.toString()));
                l.setCancelada(true);
                dao.atualizar( l );
                
                for ( Item_Locacao il : itemLocacaoDao.obterItensPorIdLocacao( Integer.parseInt(id.toString()) ) ) {
                    Exemplar e = il.getExemplar();
                    e.setDisponivel(true);
                    exemplarDao.atualizar( e );
                }
                
                response.setContentType( "application/json;charset=UTF-8" );
                
                JsonObject jo = Json.createObjectBuilder()
                        .add( "status", "ok" )
                        .build();
                
                try ( PrintWriter out = response.getWriter() ) {
                    out.print( jo );
                }

            }

        } catch ( SQLException exc ) {
            disp = Utils.prepararDespachoErro( request, exc.getMessage() );
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
        return "LocacaoServlet";
    }

}
