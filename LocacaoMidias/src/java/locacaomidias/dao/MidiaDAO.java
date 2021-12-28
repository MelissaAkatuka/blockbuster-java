package locacaomidias.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.entidades.Ator;
import locacaomidias.entidades.ClassificacaoEtaria;
import locacaomidias.entidades.ClassificacaoInterna;
import locacaomidias.entidades.Midia;
import locacaomidias.entidades.Genero;
import locacaomidias.entidades.Tipo;

public class MidiaDAO extends DAO<Midia>{
    
    public MidiaDAO() throws SQLException {
    }

    @Override
    public void salvar(Midia obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "midia(" + 
                "    titulo, " + 
                "    ano_lancamento, " + 
                "    codigo_barras, " + 
                "    duracao_min, " + 
                "    ator_princ_id, " + 
                "    ator_coad_id, " + 
                "    genero_id, " +
                "    classificacao_id, " +
                "    tipo_id, " + 
                "    classificacao_interna_id )" + 
                "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );" );

        stmt.setString( 1, obj.getTitulo() );
        stmt.setInt( 2, obj.getAnoLancamento() );
        stmt.setString( 3, obj.getCodigoBarras());
        stmt.setInt( 4, obj.getDuracaoMin() );
        stmt.setInt( 5, obj.getAtorPrincipal().getId() );
        stmt.setInt( 6, obj.getAtorCoadjuvante().getId() );
        stmt.setInt( 7, obj.getGenero().getId() );
        stmt.setInt( 8, obj.getClassificacaoEtaria().getId() );
        stmt.setInt( 9, obj.getTipo().getId() );
        stmt.setInt( 10, obj.getClassificacaoInterna().getId() );
      

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Midia obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE midia " + 
                "SET" + 
                "    titulo = ?, " + 
                "    ano_lancamento = ?, " + 
                "    codigo_barras = ?, " + 
                "    duracao_min = ?, " + 
                "    ator_princ_id = ?, " + 
                "    ator_coad_id = ?, " + 
                "    genero_id = ?, " +
                "    classificacao_id = ?, " +
                "    tipo_id = ?, " + 
                "    classificacao_interna_id = ? )" + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setString( 1, obj.getTitulo() );
        stmt.setInt( 2, obj.getAnoLancamento() );
        stmt.setString( 3, obj.getCodigoBarras());
        stmt.setInt( 4, obj.getDuracaoMin() );
        stmt.setInt( 5, obj.getAtorPrincipal().getId() );
        stmt.setInt( 6, obj.getAtorCoadjuvante().getId() );
        stmt.setInt( 7, obj.getGenero().getId() );
        stmt.setInt( 8, obj.getClassificacaoEtaria().getId() );
        stmt.setInt( 9, obj.getTipo().getId() );
        stmt.setInt( 10, obj.getClassificacaoInterna().getId() );
        stmt.setInt( 11, obj.getId() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir(Midia obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM midia " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Midia> listarTodos() throws SQLException {
        List<Midia> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT" + 
                "    d.id midia_id, " +
                "    d.titulo titulo, " +         
                "    d.ano_lancamento anoLancamento, " + 
                "    d.codigo_barras codigoBarras, " +
                "    d.duracao_min duracaoMin, " +
                "    ap.id atorPrincipalId, " + 
                "    ap.nome atorPrincipalNome, " + 
                "    ap.sobrenome atorPrincipalSobrenome, " + 
                "    ac.id atorCoadjuvanteId, " + 
                "    ac.nome atorCoadjuvanteNome, " + 
                "    ac.sobrenome atorCoadjuvanteSobrenome, " + 
                "    g.id generoId, " + 
                "    g.descricao generoDescricao, " +
                "    c.id classificacaoId, " +
                "    c.descricao classificacaoDesc " + 
                "    t.id tipoId, " +
                "    t.id descricaoId, " +
                "    ci.id classificacaoInternaId, " +
                "    ci.id descricaoClassificacaoInternaId, " +
                "FROM" + 
                "    midia d, " + 
                "    atores ap, " + 
                "    atores ac, " + 
                "    generos g, " + 
                "    classificacao c, " + 
                "    tipo t, " + 
                "    classificacaoInterna ci, " +
                "WHERE" + 
                "    d.ator_princ_id = ap.id AND "+
                "    d.ator_coad_id = ac.id AND "+
                "    d.genero_id = g.id AND" +
                "    d.tipo_id = t.id AND" +
                "    d.classificacaoInterna_id = ci.id AND" +
                "    d.classificacao_id = c.id ;");

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            Midia midia = new Midia();
            Ator atorPrinc = new Ator();
            Ator atorCoad = new Ator();
            Genero genero = new Genero();
            ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
            Tipo tipo = new Tipo();
            ClassificacaoInterna classificacaoInterna = new ClassificacaoInterna();
            
            midia.setId(rs.getInt( "midia_id" ));
            midia.setTitulo( rs.getString("titulo"));
            midia.setCodigoBarras(rs.getString("codigoBarras"));
            midia.setDuracaoMin( rs.getInt("duracaoMin"));
            
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
            
            tipo.setId(rs.getInt("tipoId"));
            tipo.setDescricao("tipoDescricao");
            
            midia.setAtorPrincipal(atorPrinc);
            midia.setAtorCoadjuvante(atorCoad);
            midia.setGenero(genero);
            midia.setClassificacaoEtaria(classificacao);
            
            classificacaoInterna.setId(rs.getInt("classificacaoInternaId"));
            classificacaoInterna.setDescricao("classificacaoInternaDescricao");

            
            lista.add( midia );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Midia obterPorId(int id) throws SQLException {
        
        Midia midia = null;
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT" + 
                "    d.id midia_id, " +
                "    d.titulo titulo, " +         
                "    d.ano_lancamento anoLancamento, " + 
                "    d.codigo_barras codigoBarras, " +
                "    d.duracao_min duracaoMin, " +
                "    ap.id atorPrincipalId, " + 
                "    ap.nome atorPrincipalNome, " + 
                "    ap.sobrenome atorPrincipalSobrenome, " + 
                "    ac.id atorCoadjuvanteId, " + 
                "    ac.nome atorCoadjuvanteNome, " + 
                "    ac.sobrenome atorCoadjuvanteSobrenome, " + 
                "    g.id generoId, " + 
                "    g.descricao generoDescricao, " +
                "    c.id classificacaoId, " +
                "    c.descricao classificacaoDesc " + 
                "    t.id tipoId, " +
                "    t.id descricaoId, " +
                "    ci.id classificacaoInternaId, " +
                "    ci.id descricaoClassificacaoInternaId, " +
                "FROM" + 
                "    midia d, " + 
                "    atores ap, " + 
                "    atores ac, " + 
                "    generos g, " + 
                "    classificacao c, " + 
                "    tipo t, " + 
                "    classificacaoInterna ci, " +
                "WHERE" + 
                "    d.id = ? AND " +
                "    d.ator_princ_id = ap.id AND "+
                "    d.ator_coad_id = ac.id AND "+
                "    d.genero_id = g.id AND" +
                "    d.tipo_id = t.id AND" +
                "    d.classificacaoInterna_id = ci.id AND" +
                "    d.classificacao_id = c.id ;");

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();
        
        if ( rs.next() ) {

            midia = new Midia();
            Ator atorPrinc = new Ator();
            Ator atorCoad = new Ator();
            Genero genero = new Genero();
            ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
            Tipo tipo = new Tipo();
            ClassificacaoInterna classificacaoInterna = new ClassificacaoInterna();
            
            midia.setId(rs.getInt( "midia_id" ));
            midia.setTitulo( rs.getString("titulo"));
            midia.setAnoLancamento( rs.getInt("anoLancamento"));
            midia.setCodigoBarras(rs.getString("codigoBarras"));
            midia.setDuracaoMin( rs.getInt("duracaoMin"));
            
            atorPrinc.setId( rs.getInt("atorPrincipalId"));
            atorPrinc.setNome( rs.getString("atorPrincipalNome"));
            atorPrinc.setSobrenome(rs.getString("atorPrincipalSobrenome"));
            
            atorCoad.setId( rs.getInt("atorCoadjuvanteId"));
            atorCoad.setNome(rs.getString("atorCoadjuvanteNome"));
            atorCoad.setSobrenome(rs.getString("atorCoadjuvanteSobrenome"));
            
            genero.setId( rs.getInt("generoId"));
            genero.setDescricao(rs.getString("generoDescricao"));
            
            classificacao.setId( rs.getInt("classificacaoId"));
            classificacao.setDescricao(rs.getString("classificacaoDesc"));
 
            tipo.setId( rs.getInt("tipoId"));
            tipo.setDescricao(rs.getString("tipoDescricao"));
            
            classificacaoInterna.setId( rs.getInt("classificacaoInternaId"));
            classificacaoInterna.setDescricao(rs.getString("classificacaoInternaDescricao"));

            midia.setAtorPrincipal(atorPrinc);
            midia.setAtorCoadjuvante(atorCoad);
            midia.setGenero(genero);
            midia.setClassificacaoEtaria(classificacao);

        }

        rs.close();
        stmt.close();
        
        return midia;
    }
    
}
