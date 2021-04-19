package status;

import models.Pessoa;

public class HabilitadaSegundaDose implements Status{
	
	@Override
	public void atualiza(Pessoa pessoa) {
		pessoa.setStatus(new FinalizadaVacinacao());
		
	}

	@Override
	public String toString() {
		return "Habilitada para tomar a 2ª dose";
	}

	
}
