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
import locacaomidias.entidades.Item_Locacao;

/**
 *
 * @author Ingrid
 */
public class Item_LocacaoDAO extends DAO<Item_Locacao> {

    public Item_LocacaoDAO() throws SQLException {
    }
    
    @Override
    public void salvar(Item_Locacao obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "item_locacao (" +
                "   exemplar_codigo_interno, locacao_id, valor) " + 
                "VALUES(?, ?, ?);" );
                
        stmt.setInt(1, obj.getExemplar().getCodigo_interno());
        stmt.setInt(2, obj.getLocacao().getId());
        stmt.setDouble(3, obj.getValor());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Item_Locacao obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE item_locacao " + 
                "SET" + 
                "    valor = ? " + 
                "WHERE" + 
                "    exemplar_codigo_interno = ? AND" +
                "    locacao_id = ?;"
        );


        stmt.setDouble( 1, obj.getValor());
        stmt.setInt( 2, obj.getExemplar().getCodigo_interno() );
        stmt.setInt(3, obj.getLocacao().getId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Item_Locacao obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                        "DELETE FROM item_locacao " + 
                        "WHERE" + 
                        "    exemplar_codigo_interno = ? AND" +
                        "    locacao_id = ?;"
        );

                stmt.setInt( 1, obj.getExemplar().getCodigo_interno() );
                stmt.setInt(2, obj.getLocacao().getId());

                stmt.executeUpdate();
                stmt.close();
    }

    @Override
    public List<Item_Locacao> listarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Item_Locacao> obterItensPorIdLocacao(int locacao_id) throws SQLException {
        List<Item_Locacao> itenslocacao = new ArrayList<>();
        
        ExemplarDAO exemplarDao = new ExemplarDAO();
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT *" + 
                "FROM" + 
                "    item_locacao l " + 
                "WHERE" + 
                "    l.locacao_id = ?;"
        );

        stmt.setInt(1, locacao_id);

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {
            Item_Locacao item = new Item_Locacao();
            item.setExemplar(exemplarDao.obterPorId(rs.getInt("exemplar_codigo_interno")));
            item.setLocacao(locacaoDAO.obterPorId(locacao_id));
            item.setValor(rs.getDouble("valor"));
            itenslocacao.add(item);
        }

        rs.close();
        stmt.close();

        return itenslocacao;
    }

    @Override
    public Item_Locacao obterPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
