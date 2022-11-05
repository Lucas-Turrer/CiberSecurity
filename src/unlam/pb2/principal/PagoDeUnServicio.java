package unlam.pb2.principal;

public class PagoDeUnServicio extends Transaccion implements Rechazable, Alertable, Monitoreable {
	private Cliente clienteQueVaAPagar;
	private Dispositivo dispositivoQueRealizaElPago;
	private Double montoAAbonar;
	private Boolean posibleFraude = false;

	public PagoDeUnServicio(Cliente clienteQueVaAPagar, Dispositivo dispositivoQueRealizaElPago, Double montoAAbonar) {
		this.clienteQueVaAPagar = clienteQueVaAPagar;
		this.dispositivoQueRealizaElPago = dispositivoQueRealizaElPago;
		this.montoAAbonar = montoAAbonar;
	}

	@Override
	public void monitorearla() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void marcarComoCasoSospechoso() {
		
	}

	@Override
	public void confirmarSiFueFraude(Boolean fueFraude) {
		posibleFraude = fueFraude;
	}

	@Override
	public Boolean monitorear() throws FraudeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer calcularScore() {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente getClienteQueVaAPagar() {
		return clienteQueVaAPagar;
	}

	public void setClienteQueVaAPagar(Cliente clienteQueVaAPagar) {
		this.clienteQueVaAPagar = clienteQueVaAPagar;
	}

	public Dispositivo getDispositivoQueRealizaElPago() {
		return dispositivoQueRealizaElPago;
	}

	public void setDispositivoQueRealizaElPago(Dispositivo dispositivoQueRealizaElPago) {
		this.dispositivoQueRealizaElPago = dispositivoQueRealizaElPago;
	}

	public Double getMontoAAbonar() {
		return montoAAbonar;
	}

	public void setMontoAAbonar(Double montoAAbonar) {
		this.montoAAbonar = montoAAbonar;
	}

	public Boolean getPosibleFraude() {
		return posibleFraude;
	}

	public void setPosibleFraude(Boolean posibleFraude) {
		this.posibleFraude = posibleFraude;
	}
	
	
	
}
