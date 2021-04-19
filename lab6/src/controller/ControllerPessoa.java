package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import models.Pessoa;

public class ControllerPessoa {
	
	private List<Pessoa> pessoas;
	
	private int idadeMinimaVacina;

    public List<String> comorbidadesCadastradas;

    public List<String> profissoesCadastradas;
    
    private int diaAtual;
	
	public ControllerPessoa(int diaAtual) {
		this.diaAtual = diaAtual;
		this.pessoas = new ArrayList<>();
		this.comorbidadesCadastradas = new ArrayList<>();
		this.profissoesCadastradas = new ArrayList<>();
	}

	public void cadastraPessoa(String nome, String cpf, String endereco, String numCartaoSUS, String email, String telefone,
			String profissao, int idade, String comorbidades){
	
		
		String[] comorbidadesArray = comorbidades.split(",");
		Pessoa pessoa = new Pessoa(nome, cpf, endereco, numCartaoSUS, email, telefone, profissao, idade, comorbidadesArray);
		
        this.pessoas.add(pessoa);
        
        if (verificaIdadeMinima(idade) && verificaProfissao(profissao) && verificaComorbidades(comorbidadesArray)) {
        	pessoa.atualizaStatus();
        }
    }
	
	
	public void alteraNome(String nome, Pessoa pessoa) {
		pessoa.setNome(nome);
	}
	
	public void alteraEndereco(String endereco, Pessoa pessoa) {
		pessoa.setEndereco(endereco);
	}
	
	public void alteraEmail(String email, Pessoa pessoa) {
		pessoa.setEmail(email);
	}
	
	public void alteraTelefone(String telefone, Pessoa pessoa) {
		pessoa.setTelefone(telefone);
	}
	
	public void alteraProfissao(String profissao, Pessoa pessoa) {
		pessoa.setProfissao(profissao);
	}
	
	public void alteraComorbidade(String comorbidade, Pessoa pessoa) {
		pessoa.addComorbidade(comorbidade);
	}
	// cadastra a idade mínima para vacinação no sistema
	public void cadastraIdadeMinima(int idadeMinima) {
		this.idadeMinimaVacina = idadeMinima;
	}
	
	// adiciona comorbidade ao sistema
	public void addComorbidades(String comorbidade) {
        if(!this.comorbidadesCadastradas.contains(comorbidade))
        	comorbidadesCadastradas.add(comorbidade);
    }
	
	// adiciona profissao ao sistema
	public void addProfissoes(String profissao) {
		if(!this.profissoesCadastradas.contains(profissao))
			profissoesCadastradas.add(profissao);
	}

	// verifica se a idade passada é igual ou superior a idade minima para vacinar
	public boolean verificaIdadeMinima(int idade) {
		return idade >= this.idadeMinimaVacina;
			
	}
	
	// verifica se a profissao passada está cadastrada no sistema de profissoes 
	public boolean verificaProfissao(String profissao) {
		return this.profissoesCadastradas.contains(profissao);
	}
	
	// verifica se a comorbidade passada está cadastrada no sistema de comorbidades
	public boolean verificaComorbidades(String[] comorbidades) {
		boolean verifica = false;
		for (String comorbidade : comorbidades) {
			if (this.comorbidadesCadastradas.contains(comorbidade))
				verifica = true;
		}
		
		return verifica;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}


	public void vacina() {
        for (Pessoa pessoa : this.pessoas) {
            if (pessoa.getStatus().toString().equals("Primeira dose habilitada") ||
                    pessoa.getStatus().toString().equals("Segunda dose habilitada")) {
                pessoa.atualizaStatus();
            }
        }
    }
	
	public void mudaDia() {
        this.diaAtual++;
        for (Pessoa pessoa : this.pessoas) {
            if (pessoa.getStatus().toString().equals("Primeira dose tomada") &&
                    (this.diaAtual - pessoa.getDiaPrimeiraDose()) == 20) {
                pessoa.atualizaStatus();
            }
        }
    }
	
}
