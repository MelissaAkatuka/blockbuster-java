package locacaodvds.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.entidades.Ator;

public class AtorDAO extends DAO<Ator> {
    
    public AtorDAO() throws SQLException {
    }

    @Override
    public void salvar(Ator obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "atores(nome, sobrenome, data_estreia) " + 
                "VALUES(?, ?, ?);" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getSobrenome() );
        stmt.setDate(3, obj.getDataEstreia());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Ator obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE atores " + 
                "SET" + 
                "    nome = ?," + 
                "    sobrenome = ?," + 
                "    data_estreia = ?" + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getSobrenome() );
        stmt.setDate(3, obj.getDataEstreia());
        stmt.setInt( 4, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Ator obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM atores " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Ator> listarTodos() throws SQLException {
         List<Ator> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT *" + 
                "FROM" + 
                "    atores a " + 
                "ORDER BY a.nome" );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            Ator ator = new Ator();
            ator.setId(rs.getInt( "id" ));
            ator.setNome(rs.getString( "nome" ));
            ator.setSobrenome(rs.getString( "sobrenome" ));
            ator.setDataEstreia(rs.getDate("data_estreia"));
            lista.add( ator );

        }

        rs.close();
        stmt.close();

        return lista;

    }

    @Override
    public Ator obterPorId(int id) throws SQLException {
        
        Ator ator = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT *" + 
                "FROM" + 
                "    atores a " + 
                "WHERE" + 
                "    a.id = ?;" );

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

            ator = new Ator();
            ator.setId(rs.getInt( "id" ));
            ator.setNome(rs.getString( "nome" ));
            ator.setSobrenome(rs.getString( "sobrenome" ));
            ator.setDataEstreia(rs.getDate("data_estreia"));

        }

        rs.close();
        stmt.close();

        return ator;
    }
    
}
