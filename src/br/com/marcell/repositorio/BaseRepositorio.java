package br.com.marcell.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.marcell.entidade.BaseEntidade;

public abstract class BaseRepositorio<T extends BaseEntidade> implements Serializable {

	private static final long serialVersionUID = 6066497227297890149L;

	@PersistenceContext
	private EntityManager entityManager;

	public abstract List<T> getAll();

	public BaseEntidade salvar(BaseEntidade objeto) {
		return ((BaseEntidade) getEntityManager().merge(objeto));
	}

	public void excluir(BaseEntidade objeto) {
		this.entityManager.remove(getEntityManager().getReference(obterClasse(), objeto.obterIdentificador()));
	}

	public BaseEntidade getId(BaseEntidade objeto) {
		return ((BaseEntidade) getEntityManager().find(obterClasse(), objeto.obterIdentificador()));
	}

	public BaseEntidade getId(Long objeto) {
		return ((BaseEntidade) getEntityManager().find(obterClasse(), objeto));
	}

	public abstract Class<? extends BaseEntidade> obterClasse();

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
