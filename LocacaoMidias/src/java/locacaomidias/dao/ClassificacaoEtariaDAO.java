package locacaomidias.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.entidades.ClassificacaoEtaria;

public class ClassificacaoEtariaDAO extends DAO<ClassificacaoEtaria>{

    public ClassificacaoEtariaDAO() throws SQLException {
    }
    
    @Override
    public void salvar(ClassificacaoEtaria obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "classificacao_etaria (descricao) " + 
                "VALUES(?);" );

        stmt.setString( 1, obj.getDescricao());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(ClassificacaoEtaria obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE classificacao_etaria " + 
                "SET" + 
                "    descricao = ?" + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setString( 1, obj.getDescricao() );
        stmt.setInt( 2, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(ClassificacaoEtaria obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM classificacao_etaria " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<ClassificacaoEtaria> listarTodos() throws SQLException {
        List<ClassificacaoEtaria> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT *" + 
                "FROM" + 
                "    classificacao_etaria c " + 
                "ORDER BY c.descricao" );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
            classificacao.setId(rs.getInt( "id" ));
            classificacao.setDescricao(rs.getString( "descricao" ));

            lista.add( classificacao );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public ClassificacaoEtaria obterPorId(int id) throws SQLException {
        ClassificacaoEtaria classificacao = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT *" + 
                "FROM" + 
                "    classificacao_etaria c " + 
                "WHERE" + 
                "    c.id = ?;" );

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

            classificacao = new ClassificacaoEtaria();
            classificacao.setId(rs.getInt( "id" ));
            classificacao.setDescricao(rs.getString( "descricao" ));

        }

        rs.close();
        stmt.close();

        return classificacao;
    }
    
}
