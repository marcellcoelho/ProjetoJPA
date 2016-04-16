package br.com.marcell.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", allocationSize = 1)
public class Usuario extends BaseEntidade {

	private static final long serialVersionUID = -2644240694348222711L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
	@Column(name = "ID_USUARIO")
	@JsonIgnore
	private Long id;

	@Column(name = "DS_NOME")
	private String nome;

	@Column(name = "DS_USUARIO")
	private String login;

	@Column(name = "SHA_SENHA")
	private String senha;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "TB_USUARIO_CARGO", joinColumns = { @JoinColumn(name = "FK_USUARIO") }, inverseJoinColumns = {
			@JoinColumn(name = "FK_CARGO") })
	private List<Cargo> cargos;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	@Override
	public Serializable obterIdentificador() {
		return this.id;
	}

}