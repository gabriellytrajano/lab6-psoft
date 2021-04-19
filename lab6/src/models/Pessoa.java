package models;

import java.util.ArrayList;
import java.util.List;

import status.NaoHabilitada;
import status.Status;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private String endereco;
	private String numCartaoSUS;
	private String email;
	private String telefone;
	private String profissao;
	private List<String> comorbidades;
	private Status status;
	private int idade;
    private int diaPrimeiraDose;
	
	
    
	public Pessoa(String nome, String cpf, String endereco, String numCartaoSUS, String email, String telefone,
			String profissao, int idade, String[] comorbidades) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.numCartaoSUS = numCartaoSUS;
		this.email = email;
		this.telefone = telefone;
		this.profissao = profissao;
		this.comorbidades = new ArrayList<>();
		this.status = new NaoHabilitada();
		this.idade = idade;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getNumCartaoSUS() {
		return numCartaoSUS;
	}


	public void setNumCartaoSUS(String numCartaoSUS) {
		this.numCartaoSUS = numCartaoSUS;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getProfissao() {
		return profissao;
	}


	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}


	public List<String> getComorbidades() {
		return comorbidades;
	}
	
	public int getDiaPrimeiraDose() {
		return diaPrimeiraDose;
	}


	public void setDiaPrimeiraDose(int diaPrimeiraDose) {
		this.diaPrimeiraDose = diaPrimeiraDose;
	}


	public void addComorbidade(String comorbidade) {
		if(!this.comorbidades.contains(comorbidade)) {
			this.comorbidades.add(comorbidade);
		}
	}
	
	public void removeComorbidade(String comorbidade) {
		if(this.comorbidades.contains(comorbidade)) {
			this.comorbidades.remove(comorbidade);
		}
	}


	public Status getStatus() {
		return status;
	}
	
	public void atualizaStatus() {
        this.status.atualiza(this);
    }


	public void setStatus(Status status) {
		this.status = status;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	

	

}
