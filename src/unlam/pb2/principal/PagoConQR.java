package unlam.pb2.principal;

public class PagoConQR extends Transaccion implements Rechazable, Alertable, Monitoreable {
	private Cliente clienteQueAbona;
	private Dispositivo dispositivoQueCobra;
	private Double saldoAAbonar;

	public PagoConQR(Cliente clienteQueAbona, Dispositivo dispositivoQueCobra, Double saldoAAbonar) {
		this.clienteQueAbona = clienteQueAbona;
		this.dispositivoQueCobra = dispositivoQueCobra;
		this.saldoAAbonar = saldoAAbonar;
	}

	@Override
	public void monitorearla() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void marcarComoCasoSospechoso() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarSiFueFraude(Boolean fueFraude) {
		// TODO Auto-generated method stub
		
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

	public Cliente getClienteQueAbona() {
		return clienteQueAbona;
	}

	public void setClienteQueAbona(Cliente clienteQueAbona) {
		this.clienteQueAbona = clienteQueAbona;
	}

	public Dispositivo getDispositivoQueCobra() {
		return dispositivoQueCobra;
	}

	public void setDispositivoQueCobra(Dispositivo dispositivoQueCobra) {
		this.dispositivoQueCobra = dispositivoQueCobra;
	}

	public Double getSaldoAAbonar() {
		return saldoAAbonar;
	}

	public void setSaldoAAbonar(Double saldoAAbonar) {
		this.saldoAAbonar = saldoAAbonar;
	}

}
