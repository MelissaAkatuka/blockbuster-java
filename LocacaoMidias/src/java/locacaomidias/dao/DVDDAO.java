package locacaomidias.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.entidades.Ator;
import locacaomidias.entidades.ClassificacaoEtaria;
import locacaomidias.entidades.DVD;
import locacaomidias.entidades.Genero;

public class DVDDAO extends DAO<DVD>{
    
    public DVDDAO() throws SQLException {
    }

    @Override
    public void salvar(DVD obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "dvds(" + 
                "    titulo, " + 
                "    ano_lancamento, " + 
                "    ator_princ_id, " + 
                "    ator_coad_id, " + 
                "    data_lancamento, " + 
                "    duracao_min, " + 
                "    genero_id, " + 
                "    classificacao_id )" + 
                "VALUES( ?, ?, ?, ?, ?, ?, ?, ? );" );

        stmt.setString( 1, obj.getTitulo() );
        stmt.setInt( 2, obj.getAnoLancamento() );
        stmt.setInt( 3, obj.getAtorPrincipal().getId() );
        stmt.setInt( 4, obj.getAtorCoadjuvante().getId() );
        stmt.setDate( 5, obj.getDataLancamento() );
        stmt.setInt( 6, obj.getDuracaoMin() );
        stmt.setInt( 7, obj.getGenero().getId() );
        stmt.setInt( 8, obj.getClassificacao().getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(DVD obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE dvds " + 
                "SET" + 
                "    titulo = ?, " + 
                "    ano_lancamento = ?," + 
                "    ator_princ_id = ?, " + 
                "    ator_coad_id = ?, " + 
                "    data_lancamento = ?, " + 
                "    duracao_min = ?, " + 
                "    genero_id = ?, " + 
                "    classificacao_id = ? " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setString( 1, obj.getTitulo() );
        stmt.setInt( 2, obj.getAnoLancamento() );
        stmt.setInt( 3, obj.getAtorPrincipal().getId() );
        stmt.setInt( 4, obj.getAtorCoadjuvante().getId() );
        stmt.setDate( 5, obj.getDataLancamento() );
        stmt.setInt( 6, obj.getDuracaoMin() );
        stmt.setInt( 7, obj.getGenero().getId() );
        stmt.setInt( 8, obj.getClassificacao().getId() );
        stmt.setInt( 9, obj.getId() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir(DVD obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM dvds " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<DVD> listarTodos() throws SQLException {
        List<DVD> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT" + 
                "    d.id dvd_id, " +
                "    d.titulo titulo, " +         
                "    d.ano_lancamento anoLancamento, " + 
                "    ap.id atorPrincipalId, " + 
                "    ap.nome atorPrincipalNome, " + 
                "    ap.sobrenome atorPrincipalSobrenome, " + 
                "    ap.data_estreia atorPrincipalEstreia, " + 
                "    ac.id atorCoadjuvanteId, " + 
                "    ac.nome atorCoadjuvanteNome, " + 
                "    ac.sobrenome atorCoadjuvanteSobrenome, " + 
                "    ac.data_estreia atorCoadjuvanteEstreia, " + 
                "    d.data_lancamento dataLancamento, " + 
                "    d.duracao_min duracaoMin, " + 
                "    g.id generoId, " + 
                "    g.descricao generoDescricao, " +        
                "    c.id classificacaoId, " +
                "    c.descricao classificacaoDesc " + 
                "FROM" + 
                "    dvds d, " + 
                "    atores ap, " + 
                "    atores ac, " + 
                "    generos g, " + 
                "    classificacao c " + 
                "WHERE" + 
                "    d.ator_princ_id = ap.id AND "+
                "    d.ator_coad_id = ac.id AND "+
                "    d.genero_id = g.id AND" +
                "    d.classificacao_id = c.id ;");

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            DVD dvd = new DVD();
            Ator atorPrinc = new Ator();
            Ator atorCoad = new Ator();
            Genero genero = new Genero();
            ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
            
            dvd.setId(rs.getInt( "dvd_id" ));
            dvd.setTitulo( rs.getString("titulo"));
            dvd.setAnoLancamento( rs.getInt("anoLancamento"));
            dvd.setDataLancamento( rs.getDate("dataLancamento"));
            dvd.setDuracaoMin( rs.getInt("duracaoMin"));
            
            atorPrinc.setId( rs.getInt("atorPrincipalId"));
            atorPrinc.setNome( rs.getString("atorPrincipalNome"));
            atorPrinc.setSobrenome(rs.getString("atorPrincipalSobrenome"));
            atorPrinc.setDataEstreia(rs.getDate("atorPrincipalEstreia"));
            
            atorCoad.setId( rs.getInt("atorCoadjuvanteId"));
            atorCoad.setNome(rs.getString("atorCoadjuvanteNome"));
            
            genero.setId( rs.getInt("generoId"));
            genero.setDescricao( rs.getString("generoDescricao"));
                
            classificacao.setId( rs.getInt("classificacaoId"));
            classificacao.setDescricao(rs.getString("classificacaoDesc"));
            atorCoad.setSobrenome(rs.getString("atorCoadjuvanteSobrenome"));
            atorCoad.setDataEstreia(rs.getDate("atorCoadjuvanteEstreia"));
            
            dvd.setAtorPrincipal(atorPrinc);
            dvd.setAtorCoadjuvante(atorCoad);
            dvd.setGenero(genero);
            dvd.setClassificacao(classificacao);
            
            lista.add( dvd );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public DVD obterPorId(int id) throws SQLException {
        
        DVD dvd = null;
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT" + 
                "    d.id dvd_id, " +
                "    d.titulo titulo, " +         
                "    d.ano_lancamento anoLancamento, " + 
                "    ap.id atorPrincipalId, " + 
                "    ap.nome atorPrincipalNome, " + 
                "    ap.sobrenome atorPrincipalSobrenome, " + 
                "    ap.data_estreia atorPrincipalEstreia, " + 
                "    ac.id atorCoadjuvanteId, " + 
                "    ac.nome atorCoadjuvanteNome, " + 
                "    ac.sobrenome atorCoadjuvanteSobrenome, " + 
                "    ac.data_estreia atorCoadjuvanteEstreia, " + 
                "    d.data_lancamento dataLancamento, " + 
                "    d.duracao_min duracaoMin, " + 
                "    g.id generoId, " + 
                "    g.descricao generoDescricao, " +        
                "    c.id classificacaoId, " +
                "    c.descricao classificacaoDesc " + 
                "FROM" + 
                "    dvds d, " + 
                "    atores ap, " + 
                "    atores ac, " + 
                "    generos g, " + 
                "    classificacao c " + 
                "WHERE" + 
                "    d.id = ? AND " +
                "    d.ator_princ_id = ap.id AND "+
                "    d.ator_coad_id = ac.id AND "+
                "    d.genero_id = g.id AND" +
                "    d.classificacao_id = c.id ;");
        
        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();
        
        if ( rs.next() ) {

            dvd = new DVD();
            Ator atorPrinc = new Ator();
            Ator atorCoad = new Ator();
            Genero genero = new Genero();
            ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
            
            dvd.setId(rs.getInt( "dvd_id" ));
            dvd.setTitulo( rs.getString("titulo"));
            dvd.setAnoLancamento( rs.getInt("anoLancamento"));
            dvd.setDataLancamento( rs.getDate("dataLancamento"));
            dvd.setDuracaoMin( rs.getInt("duracaoMin"));
            
            atorPrinc.setId( rs.getInt("atorPrincipalId"));
            atorPrinc.setNome( rs.getString("atorPrincipalNome"));
            atorPrinc.setSobrenome(rs.getString("atorPrincipalSobrenome"));
            atorPrinc.setDataEstreia(rs.getDate("atorPrincipalEstreia"));
            
            atorCoad.setId( rs.getInt("atorCoadjuvanteId"));
            atorCoad.setNome(rs.getString("atorCoadjuvanteNome"));
            atorCoad.setSobrenome(rs.getString("atorCoadjuvanteSobrenome"));
            atorCoad.setDataEstreia(rs.getDate("atorCoadjuvanteEstreia"));
            
            genero.setId( rs.getInt("generoId"));
            genero.setDescricao(rs.getString("generoDescricao"));
            
            classificacao.setId( rs.getInt("classificacaoId"));
            classificacao.setDescricao(rs.getString("classificacaoDesc"));

            dvd.setAtorPrincipal(atorPrinc);
            dvd.setAtorCoadjuvante(atorCoad);
            dvd.setGenero(genero);
            dvd.setClassificacao(classificacao);

        }

        rs.close();
        stmt.close();
        
        return dvd;
    }
    
}
