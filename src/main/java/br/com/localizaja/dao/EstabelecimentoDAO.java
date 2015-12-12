package br.com.localizaja.dao;

import br.com.localizaja.entidade.Estabelecimento;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
