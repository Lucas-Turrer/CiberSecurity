package unlam.pb2.principal;

import java.util.HashSet;
import java.util.Set;

public class Banco {
	private Integer codigoSucursal;
	private String nombreDelBanco;
	private Set <Cliente> listaDelCliente = new HashSet();
	private Set <Denunciable> listaNegra = new HashSet();
	private Integer score = 0;
	
	public Banco(Integer codigoSucursal, String nombreDelBanco) {
		this.codigoSucursal = codigoSucursal;
		this.nombreDelBanco = nombreDelBanco;
	}

	public void agregarCliente(Cliente clienteNuevo) {
		listaDelCliente.add(clienteNuevo);
	}

	public Integer cantidadDeClientes() {
		return listaDelCliente.size();
	}

	public Boolean realizarExtraccion(Extraccion extraccionDeDinero) {
		if(extraccionDeDinero.getMontoAExtraer() >= extraccionDeDinero.getClienteQueQuiereExtraerDinero().getSaldoInicial()) {
			extraccionDeDinero.marcarComoCasoSospechoso();
			return true;
		}
		return false;
	}

	public void realizarTransferencia(Transferencia transferenciaDeDinero) throws FraudeException {
		if(listaNegra.contains(transferenciaDeDinero.getClienteDestino())) {
			score+=80;
		}if(transferenciaDeDinero.getClienteDestino().ultimaAccion() == UltimaAccion.cambioDeContrasenia) {
			score+=20;
		} if(transferenciaDeDinero.getClienteOrigen().getSaldoInicial() == transferenciaDeDinero.getSaldoATransferir()) {
			score+=40;
		}if(score>=80) {
			throw new FraudeException();
		} 
	}

	public void AgregarAListaNegra(Denunciable denunciado) {
		listaNegra.add(denunciado);
	}

	public void realizarPagoConQR(PagoConQR pagoEnComercio) throws FraudeException {
		if(listaNegra.contains(pagoEnComercio.getDispositivoQueCobra())) {
			score+=80;
		}if(pagoEnComercio.getClienteQueAbona().ultimaAccion() == UltimaAccion.cambioDeContrasenia) {
			score+=20;
		} if(score>=80) {
			throw new FraudeException();
		}
	}

	public Integer realizarPagoDeUnServicio(PagoDeUnServicio pagoDelServicio) throws FraudeException {
		if(listaNegra.contains(pagoDelServicio.getDispositivoQueRealizaElPago())) {
			score+=80;
		}if(pagoDelServicio.getClienteQueVaAPagar().ultimaAccion() == UltimaAccion.cambioDeContrasenia) {
			score+=20;
		} if(score>=80) {
			throw new FraudeException();
		} return score;
	}

	public Integer getScore() {
		return score;
	}


}
