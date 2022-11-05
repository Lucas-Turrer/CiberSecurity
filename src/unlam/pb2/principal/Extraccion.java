package unlam.pb2.principal;

public class Extraccion extends Transaccion implements Rechazable, Alertable, Monitoreable{
	private Double montoAExtraer;
	private Cliente clienteQueQuiereExtraerDinero;
	private Boolean casoSospechoso;

	public Extraccion(Double montoAExtraer, Cliente clienteQueQuiereExtraerDinero) {
		this.montoAExtraer = montoAExtraer;
		this.clienteQueQuiereExtraerDinero = clienteQueQuiereExtraerDinero;
	}

	@Override
	public Boolean monitorear() throws FraudeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void marcarComoCasoSospechoso() {
		casoSospechoso = true;
	}

	@Override
	public void confirmarSiFueFraude(Boolean fueFraude) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void monitorearla() {
		// TODO Auto-generated method stub
		
	}

	public Double getMontoAExtraer() {
		return montoAExtraer;
	}

	public void setMontoAExtraer(Double montoAExtraer) {
		this.montoAExtraer = montoAExtraer;
	}

	public Cliente getClienteQueQuiereExtraerDinero() {
		return clienteQueQuiereExtraerDinero;
	}

	public void setClienteQueQuiereExtraerDinero(Cliente clienteQueQuiereExtraerDinero) {
		this.clienteQueQuiereExtraerDinero = clienteQueQuiereExtraerDinero;
	}

	public Boolean getCasoSospechoso() {
		return casoSospechoso;
	}

	public void setCasoSospechoso(Boolean casoSospechoso) {
		this.casoSospechoso = casoSospechoso;
	}

	@Override
	public Integer calcularScore() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
