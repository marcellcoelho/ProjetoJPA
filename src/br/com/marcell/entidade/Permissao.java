package br.com.marcell.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "TB_PERMISSAO")
@SequenceGenerator(name = "SQ_PERMISSAO", sequenceName = "SQ_PERMISSAO", allocationSize = 1)
public class Permissao extends BaseEntidade {

	private static final long serialVersionUID = 8115095014225327677L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERMISSAO")
	@Column(name = "ID_PERMISSAO")
	@JsonIgnore
	private Long id;

	@Column(name = "DS_DESCRICAO")
	private String descricao;

	@Column(name = "DS_PERMISAO")
	private String permissao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	@Override
	public Serializable obterIdentificador() {
		return this.id;
	}

}