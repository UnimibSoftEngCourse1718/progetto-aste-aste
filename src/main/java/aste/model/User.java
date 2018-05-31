package aste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "User.Login",
query = "SELECT u FROM User u WHERE firstName =:firstName "
)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
    private String username;
	
	@Column
    private String password;
	
	@Column
    private String nome;
	
	@Column
    private String cognome;

	@Column
    private String ruolo;
	
	@Column
    private int credito;

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getRuolo() {
		return ruolo;
	}


	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}


	public int getCredito() {
		return credito;
	}


	public void setCredito(int credito) {
		this.credito = credito;
	}
	
}
