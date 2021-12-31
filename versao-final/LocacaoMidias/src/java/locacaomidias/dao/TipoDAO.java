package locacaomidias.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.entidades.Tipo;


public class TipoDAO extends DAO<Tipo>{

    public TipoDAO() throws SQLException {
    }
    
    @Override
    public void salvar(Tipo obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "tipo (descricao) " + 
                "VALUES(?);" );

        stmt.setString( 1, obj.getDescricao() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Tipo obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE tipo " + 
                "SET" + 
                "    descricao = ?" + 
                "WHERE" + 
                "    id = ?;" );
        stmt.setString( 1, obj.getDescricao());
        stmt.setInt( 2, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Tipo obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM tipo " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Tipo> listarTodos() throws SQLException {
        List<Tipo> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT *" + 
                "FROM" + 
                "    tipo t " + 
                "ORDER BY t.descricao" );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            Tipo tipo = new Tipo();
            tipo.setId(rs.getInt( "id" ));
            tipo.setDescricao(rs.getString( "descricao" ));

            lista.add( tipo );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Tipo obterPorId(int id) throws SQLException {
        Tipo tipo = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT *" + 
                "FROM" + 
                "    tipo t " + 
                "WHERE" + 
                "    t.id = ?;" );

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

            tipo = new Tipo();
            tipo.setId(rs.getInt( "id" ));
            tipo.setDescricao(rs.getString( "descricao" ));

        }

        rs.close();
        stmt.close();

        return tipo;
    }
    
}
