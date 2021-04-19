package status;

import models.Pessoa;

public class TomouPrimeiraDose implements Status{
	
	@Override
	public void atualiza(Pessoa pessoa) {
		pessoa.setStatus(new HabilitadaSegundaDose());
		
	}

	@Override
	public String toString() {
		return "Primeira dose tomada";
	}
	
	
}
