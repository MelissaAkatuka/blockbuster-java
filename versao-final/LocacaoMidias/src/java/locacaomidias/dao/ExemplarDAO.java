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
import locacaomidias.entidades.Exemplar;
import locacaomidias.entidades.Midia;


/**
 *
 * @author Melissa
 */
public class ExemplarDAO extends DAO<Exemplar>{

    public ExemplarDAO() throws SQLException {
    }
    
    @Override
    public void salvar(Exemplar obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
        "INSERT INTO " + 
                "exemplar(" + 
                "    disponivel, " + 
                "    midia_id) " + 
                "VALUES( ?, ?);"
        );
        
        stmt.setBoolean(1, obj.estaDisponivel());
        stmt.setInt( 2, obj.getMidia().getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Exemplar obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                        "UPDATE exemplar " + 
                        "SET" + 
                        "    disponivel = ? " + 
                        "WHERE" + 
                        "    codigo_interno = ?;" );
                
                stmt.setBoolean(1, obj.estaDisponivel());
                stmt.setInt( 2, obj.getCodigo_interno());

                stmt.executeUpdate();
                stmt.close();
    }

    @Override
    public void excluir(Exemplar obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM exemplar " + 
                "WHERE" + 
                "    codigo_interno = ?;" );

        stmt.setInt( 1, obj.getCodigo_interno());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Exemplar> listarTodos() throws SQLException {
        List<Exemplar> lista = new ArrayList<>();

        MidiaDAO midiadao = new MidiaDAO();
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT" + 
                "    e.codigo_interno idExemplar, " + 
                "    e.disponivel disponivel, " +
                "    m.id idMidia, " + 
                "    m.titulo titulo " + 
                "FROM" + 
                "    exemplar e, " + 
                "    midia m " + 
                "WHERE" + 
                "    m.id = e.midia_id AND " +
                "    e.disponivel = ? " +
                "ORDER BY m.titulo" );

        stmt.setBoolean(1, true);
        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            Exemplar exemplar = new Exemplar();
            Midia m = new Midia();

            exemplar.setCodigo_interno(rs.getInt( "idExemplar" ) );
            exemplar.setDisponivel(rs.getBoolean("disponivel" ) );

            int id = rs.getInt("idMidia" );
            m = midiadao.obterPorId(id);
                    
            exemplar.setMidia( m );
            
            lista.add( exemplar );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Exemplar obterPorId(int id) throws SQLException {
       Exemplar exemplar = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT" + 
                "    e.codigo_interno idExemplar, " + 
                "    m.id idMidia, " + 
                "    m.titulo titulo " + 
                "FROM" + 
                "    exemplar e, " + 
                "    midia m " + 
                "WHERE" + 
                "    e.codigo_interno = ? AND " + 
                "    m.id = e.midia_id;" );

        stmt.setLong( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

            exemplar = new Exemplar();
            Midia m = new Midia();
            m.setId(rs.getInt("idMidia" ) );
            m.setTitulo(rs.getString("titulo"));
            
            exemplar.setCodigo_interno(rs.getInt( "idExemplar" ) );
            //exemplar.setDisponivel(rs.getBoolean("estaDisponivel" ) );
            
            exemplar.setMidia( m );
            
        }

        rs.close();
        stmt.close();

        return exemplar;
    }
    
}
