package br.com.localizaja.dao;

import br.com.localizaja.entidade.Estabelecimento;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author adriana
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class EstabelecimentoDAO {

    @PersistenceContext(name = "localizaja")
    private EntityManager entityManager;

    public void salvar(Estabelecimento estabelecimento) throws Exception {
        entityManager.persist(estabelecimento);
    }

    public List<Estabelecimento> getEstabelecimentosPorLocalizacao(BigDecimal latitude, BigDecimal longitude, Integer distancia, String... seguimentos) {
        StringBuilder b = new StringBuilder();
        b.append("SELECT * FROM ESTABELECIMENTO EST");
        b.append(" INNER JOIN ENDERECO ENDERECO            ON (EST.ENDERECO_ID = ENDERECO.ID)");
        b.append(" INNER JOIN COORDENADASGEOGRAFICAS COORD ON (ENDERECO.COORDENADASGEOGRAFICAS_ID = COORD.ID)");
        b.append(" WHERE");
        b.append(" (6378.137 * ACOS(COS(RADIANS(COORD.LATITUDE)) * COS(RADIANS(?1)) *");
        b.append(" COS(RADIANS(?2) - RADIANS(COORD.LONGITUDE)) + SIN(RADIANS(COORD.LONGITUDE)) * SIN(RADIANS(?1))) <= ?3)");

        Query query = entityManager.createNativeQuery(b.toString());
        query.setParameter(1, latitude);
        query.setParameter(2, longitude);
        query.setParameter(3, distancia);

        List resultList = query.getResultList();
        System.out.println("TAMANHO " + resultList.size());

        return query.getResultList();
    }
}
