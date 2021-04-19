package status;

import models.Pessoa;

public class HabilitadaPrimeiraDose implements Status{
	
	@Override
	public void atualiza(Pessoa pessoa) {
		pessoa.setStatus(new TomouPrimeiraDose());
		
	}

	@Override
	public String toString() {
		return "Primeira dose habilitada";
	}
	
	
}
