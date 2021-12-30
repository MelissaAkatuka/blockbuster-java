/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaomidias.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.entidades.Cliente;
import locacaomidias.entidades.Locacao;
import locacaomidias.utils.Utils;

/**
 *
 * @author Melissa
 */
public class LocacaoDAO extends DAO<Locacao>{

    public LocacaoDAO() throws SQLException {
    }
    
    
    @Override
    public void salvar(Locacao obj) throws SQLException {
                PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "locacao (" +
                "   dataInicio, dataFim, cancelada, cliente_id) " + 
                "VALUES(?, ?, ?, ?);",
                new String[]{ "id" } );
                
        stmt.setDate(1, obj.getDataInicio());
        stmt.setDate(2, obj.getDataFim());
        stmt.setBoolean(3, obj.getCancelada());
        stmt.setInt(4, Integer.parseInt(obj.getCliente().getId().toString()));
        
        stmt.executeUpdate();
        obj.setId( Integer.parseInt(Utils.getChavePrimariaAposInsercao( stmt, "id" ).toString()) );
        stmt.close();
    }

    @Override
    public void atualizar(Locacao obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE locacao " + 
                "SET" + 
                "    cancelada = ? " + 
                "WHERE" + 
                "    id = ?;" );


        stmt.setBoolean( 1, obj.getCancelada());
        stmt.setInt( 2, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Locacao obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                        "DELETE FROM locacao " + 
                        "WHERE" + 
                        "    id = ?;" );

                stmt.setInt( 1, obj.getId() );

                stmt.executeUpdate();
                stmt.close();    }

    @Override
    public List<Locacao> listarTodos() throws SQLException {
        List<Locacao> lista = new ArrayList<>();
        ClienteDAO dao = new ClienteDAO();
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT" + 
                "    c.id idCliente, " + 
                "    c.nome nomeCliente, " + 
                "    c.sobrenome sobrenomeCliente, " + 
                "    l.id idLoc, " +
                "    l.cancelada cancelada, " + 
                "    l.dataInicio dataInicio, " + 
                "    l.dataFim dataFim " +         
                "FROM" + 
                "    locacao l, " + 
                "    cliente c " + 
                "WHERE" + 
                "    c.id = l.cliente_id " +
                "ORDER BY l.dataInicio;" );
                
            ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            Cliente c = new Cliente();
            c = dao.obterPorId(rs.getInt("idCliente"));

            Locacao l = new Locacao();
            l.setId(rs.getInt("idLoc"));
            l.setCliente(c);
            l.setCancelada(rs.getBoolean("cancelada"));
            l.setDataInicio(rs.getDate("dataInicio"));
            l.setDataFim(rs.getDate("dataFim"));

            lista.add( l );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Locacao obterPorId(int id) throws SQLException {
        
        Locacao locacao = null;
        ClienteDAO dao = new ClienteDAO();
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT *" + 
                "FROM" + 
                "    locacao l " + 
                "WHERE" + 
                "    l.id = ?;" );

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

            locacao = new Locacao();
            locacao.setId(rs.getInt("id"));
            locacao.setDataInicio(rs.getDate("dataInicio"));
            locacao.setDataFim(rs.getDate("dataFim"));
            locacao.setCancelada(rs.getBoolean("cancelada"));
            locacao.setCliente(dao.obterPorId(rs.getInt("cliente_id")));

        }

        rs.close();
        stmt.close();

        return locacao;
    }
    
}
