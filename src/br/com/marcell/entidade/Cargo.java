package br.com.marcell.entidade;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "TB_CARGO")
@SequenceGenerator(name = "SQ_CARGO", sequenceName = "SQ_CARGO", allocationSize = 1)
public class Cargo extends BaseEntidade {

	private static final long serialVersionUID = -8661575897844960995L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CARGO")
	@Column(name = "ID_CARGO")
	@JsonIgnore
	private Long id;

	@Column(name = "DS_DESCRICAO")
	private String descricao;

	@Column(name = "DS_NOME")
	private String nome;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "TB_CARGO_PERMISSAO", joinColumns = { @JoinColumn(name = "FK_CARGO") }, inverseJoinColumns = {
			@JoinColumn(name = "FK_PERMISSAO") })
	private List<Permissao> permissoes;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	public Serializable obterIdentificador() {
		return this.id;
	}

}