package status;

import models.Pessoa;

public class NaoHabilitada implements Status{
	
	@Override
	public void atualiza(Pessoa pessoa) {
		pessoa.setStatus(new HabilitadaPrimeiraDose());
		
	}

	@Override
	public String toString() {
		return "Não habilitado para tomar a vacina";
	}
	
	

}
