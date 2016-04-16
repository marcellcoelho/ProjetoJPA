package br.com.marcell.repositorio;

import java.util.List;

import br.com.marcell.entidade.BaseEntidade;
import br.com.marcell.entidade.Cargo;
import br.com.marcell.entidade.Usuario;

public class CargoRepositorio extends BaseRepositorio<Cargo> {

	private static final long serialVersionUID = 4042082052914848366L;

	@Override
	public Class<? extends BaseEntidade> obterClasse() {
		return Usuario.class;
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> getAll() {
		StringBuffer sql =  new StringBuffer();
		sql.append("SELECT * FROM TB_CARGO");
		return getEntityManager().createNativeQuery(sql.toString(), Cargo.class).getResultList();
	}

}
