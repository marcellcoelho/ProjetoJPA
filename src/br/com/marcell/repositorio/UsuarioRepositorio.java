package br.com.marcell.repositorio;

import java.util.List;

import br.com.marcell.entidade.BaseEntidade;
import br.com.marcell.entidade.Usuario;

public class UsuarioRepositorio extends BaseRepositorio<Usuario> {

	private static final long serialVersionUID = 4042082052914848366L;

	@Override
	public Class<? extends BaseEntidade> obterClasse() {
		return Usuario.class;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getAll() {
		StringBuffer sql =  new StringBuffer();
		sql.append("SELECT * FROM TB_USUARIO");
		return getEntityManager().createNativeQuery(sql.toString(), Usuario.class).getResultList();
	}

}
