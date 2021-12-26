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
import locacaomidias.entidades.Cidade;
import locacaomidias.entidades.Estado;
import locacaomidias.entidades.Locacao;
import locacaomidias.utils.Utils;

/**
 *
 * @author Melissa
 */
public class LocacaoDAO extends DAO<Locacao>{

    @Override
    public void salvar(Locacao obj) throws SQLException {
                PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "locacao (dataInicio, dataFim, cancelada) " + 
                "VALUES(?, ?, ?);",
                new String[]{ "id" } );
                
        stmt.setDate(1, obj.getDataInicio());
        stmt.setDate(2, obj.getDataFim());
        stmt.setBoolean(3, obj.getCancelada());
        
        stmt.executeUpdate();
        obj.setId( Integer.parseInt(Utils.getChavePrimariaAposInsercao( stmt, "id" ).toString()) );
        stmt.close();
    }

    @Override
    public void atualizar(Locacao obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
        "UPDATE locacao " + 
                "SET" + 
                "    dataInicio = ?," + 
                "    dataFim = ? " + 
                "    cancelada = ? " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setDate( 1, obj.getDataInicio() );
        stmt.setDate( 2, obj.getDataFim() );
        stmt.setBoolean( 3, obj.getCancelada());
        stmt.setInt( 4, obj.getId() );

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
//        List<Locacao> lista = new ArrayList<>();
//
//        PreparedStatement stmt = getConnection().prepareStatement(
//                "SELECT" + 
//                "    c.id idCidade, " + 
//                "    c.nome nomeCidade, " + 
//                "    e.id idEstado, " + 
//                "    e.nome nomeEstado, " + 
//                "    e.sigla siglaEstado " + 
//                "FROM" + 
//                "    cliente c " + 
//                "WHERE" + 
//                "    c.estado_id = e.id " +
//                "ORDER BY c.nome, e.nome, e.sigla;" );
//
//        ResultSet rs = stmt.executeQuery();
//
//        while ( rs.next() ) {
//
//            Cidade c = new Cidade();
//            Estado e = new Estado();
//
//            c.setId( rs.getLong( "idCidade" ) );
//            c.setNome( rs.getString( "nomeCidade" ) );
//            c.setEstado( e );
//
//            e.setId( rs.getLong( "idEstado" ) );
//            e.setNome( rs.getString( "nomeEstado" ) );
//            e.setSigla( rs.getString( "siglaEstado" ) );
//
//            lista.add( c );
//
//        }
//
//        rs.close();
//        stmt.close();
//
//        return lista;
    return null;
    }

    @Override
    public Locacao obterPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
