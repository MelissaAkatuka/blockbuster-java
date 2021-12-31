package locacaomidias.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.entidades.ClassificacaoInterna;

public class ClassificacaoInternaDAO extends DAO<ClassificacaoInterna>{

    public ClassificacaoInternaDAO() throws SQLException {
    }
    
    @Override
    public void salvar(ClassificacaoInterna obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "classificacao_interna (descricao, valorAluguel) " + 
                "VALUES(?, ?);" );

        stmt.setString( 1, obj.getDescricao());
        stmt.setDouble( 2, obj.getValorAluguel());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(ClassificacaoInterna obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE classificacao_interna " + 
                "SET" + 
                "    descricao = ?, " + 
                "    valorAluguel = ? " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setString( 1, obj.getDescricao() );
        stmt.setDouble( 2, obj.getValorAluguel());
        stmt.setInt( 3, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(ClassificacaoInterna obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM classificacao_interna " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<ClassificacaoInterna> listarTodos() throws SQLException {
        List<ClassificacaoInterna> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT *" + 
                "FROM" + 
                "    classificacao_interna c " + 
                "ORDER BY c.descricao" );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            ClassificacaoInterna classificacao = new ClassificacaoInterna();
            classificacao.setId(rs.getInt( "id" ));
            classificacao.setDescricao(rs.getString( "descricao" ));
            classificacao.setValorAluguel(rs.getDouble("valorAluguel"));

            lista.add( classificacao );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public ClassificacaoInterna obterPorId(int id) throws SQLException {
        ClassificacaoInterna classificacao = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT *" + 
                "FROM" + 
                "    classificacao_interna c " + 
                "WHERE" + 
                "    c.id = ?;" );

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

            classificacao = new ClassificacaoInterna();
            classificacao.setId(rs.getInt( "id" ));
            classificacao.setDescricao(rs.getString( "descricao" ));
            classificacao.setValorAluguel(rs.getDouble("valorAluguel"));

        }

        rs.close();
        stmt.close();

        return classificacao;
    }
    
}
