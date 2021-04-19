package status;

import models.Pessoa;

public class FinalizadaVacinacao implements Status{
	
	@Override
	public void atualiza(Pessoa pessoa) {
		pessoa.setStatus(new FinalizadaVacinacao());
		
	}

	@Override
	public String toString() {
		return "Vacinação finalizada";
	}
	

}
