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
                "    anoLancamento, " + 
                "    codigoBarras, " + 
                "    duracaoEmMinutos, " + 
                "    ator_atriz_principal, " + 
                "    ator_atriz_coadjuvante, " + 
                "    genero_id, " +
                "    classificacao_etaria_id, " +
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
                "    anoLancamento = ?, " + 
                "    codigoBarras = ?, " + 
                "    duracaoEmMinutos = ?, " + 
                "    ator_atriz_principal = ?, " + 
                "    ator_atriz_coadjuvante = ?, " + 
                "    genero_id = ?, " +
                "    classificacao_etaria_id = ?, " +
                "    tipo_id = ?, " + 
                "    classificacao_interna_id = ? " + 
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
                "    d.anoLancamento anoLancamento, " + 
                "    d.codigoBarras codigoBarras, " +
                "    d.duracaoEmMinutos duracaoMin, " +
                "    ap.id atorPrincipalId, " + 
                "    ap.nome atorPrincipalNome, " + 
                "    ap.sobrenome atorPrincipalSobrenome, " + 
                "    ap.dataEstreia atorPrincipalEstreia, " + 
                "    ac.id atorCoadjuvanteId, " + 
                "    ac.nome atorCoadjuvanteNome, " + 
                "    ac.dataEstreia atorCoadjuvanteEstreia, " + 
                "    ac.sobrenome atorCoadjuvanteSobrenome, " + 
                "    g.id generoId, " + 
                "    g.descricao generoDescricao, " +
                "    c.id classificacaoId, " +
                "    c.descricao classificacaoDesc, " + 
                "    t.id tipoId, " +
                "    t.descricao descricaoId, " +
                "    ci.id classificacaoInternaId, " +
                "    ci.descricao descricaoClassificacaoInterna, " +
                "    ci.valorAluguel valorAluguel " +
                "FROM" + 
                "    midia d, " + 
                "    ator_atriz ap, " + 
                "    ator_atriz ac, " + 
                "    genero g, " + 
                "    classificacao_etaria c, " + 
                "    tipo t, " + 
                "    classificacao_interna ci " +
                "WHERE" + 
                "    d.ator_atriz_principal = ap.id AND "+
                "    d.ator_atriz_coadjuvante = ac.id AND "+
                "    d.genero_id = g.id AND " +
                "    d.tipo_id = t.id AND " +
                "    d.classificacao_interna_id = ci.id AND " +
                "    d.classificacao_etaria_id = c.id;");

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
            midia.setAnoLancamento( rs.getInt("anoLancamento"));
            
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
            tipo.setDescricao(rs.getString("descricaoId"));
            
            classificacaoInterna.setId(rs.getInt("classificacaoInternaId"));
            classificacaoInterna.setDescricao(rs.getString("descricaoClassificacaoInterna"));
            classificacaoInterna.setValorAluguel(rs.getDouble("valorAluguel"));
            
            midia.setAtorPrincipal(atorPrinc);
            midia.setAtorCoadjuvante(atorCoad);
            midia.setGenero(genero);
            midia.setClassificacaoEtaria(classificacao);
            midia.setTipo(tipo);
            midia.setClassificacaoInterna(classificacaoInterna);
            
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
                "    d.anoLancamento anoLancamento, " + 
                "    d.codigoBarras codigoBarras, " +
                "    d.duracaoEmMinutos duracaoMin, " +
                "    ap.id atorPrincipalId, " + 
                "    ap.nome atorPrincipalNome, " + 
                "    ap.sobrenome atorPrincipalSobrenome, " + 
                "    ap.dataEstreia atorPrincipalEstreia, " + 
                "    ac.id atorCoadjuvanteId, " + 
                "    ac.nome atorCoadjuvanteNome, " + 
                "    ac.dataEstreia atorCoadjuvanteEstreia, " + 
                "    ac.sobrenome atorCoadjuvanteSobrenome, " + 
                "    g.id generoId, " + 
                "    g.descricao generoDescricao, " +
                "    c.id classificacaoId, " +
                "    c.descricao classificacaoDesc, " + 
                "    t.id tipoId, " +
                "    t.descricao descricaoId, " +
                "    ci.id classificacaoInternaId, " +
                "    ci.descricao descricaoClassificacaoInterna, " +
                "    ci.valorAluguel valorAluguel " +
                "FROM" + 
                "    midia d, " + 
                "    ator_atriz ap, " + 
                "    ator_atriz ac, " + 
                "    genero g, " + 
                "    classificacao_etaria c, " + 
                "    tipo t, " + 
                "    classificacao_interna ci " +
                "WHERE" + 
                "    d.id = ? AND " +
                "    d.ator_atriz_principal = ap.id AND "+
                "    d.ator_atriz_coadjuvante = ac.id AND "+
                "    d.genero_id = g.id AND " +
                "    d.tipo_id = t.id AND " +
                "    d.classificacao_interna_id = ci.id AND " +
                "    d.classificacao_etaria_id = c.id;");

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
            midia.setCodigoBarras(rs.getString("codigoBarras"));
            midia.setDuracaoMin( rs.getInt("duracaoMin"));
            midia.setAnoLancamento( rs.getInt("anoLancamento"));
            
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
            tipo.setDescricao(rs.getString("descricaoId"));
            
            classificacaoInterna.setId(rs.getInt("classificacaoInternaId"));
            classificacaoInterna.setDescricao(rs.getString("descricaoClassificacaoInterna"));
            classificacaoInterna.setValorAluguel(rs.getDouble("valorAluguel"));
            
            midia.setAtorPrincipal(atorPrinc);
            midia.setAtorCoadjuvante(atorCoad);
            midia.setGenero(genero);
            midia.setClassificacaoEtaria(classificacao);
            midia.setTipo(tipo);
            midia.setClassificacaoInterna(classificacaoInterna);

        }

        rs.close();
        stmt.close();
        
        return midia;
    }
    
}
