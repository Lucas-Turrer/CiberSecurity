package unlam.pb2.principal;

public class Transferencia extends Transaccion implements Rechazable, Alertable, Monitoreable {
	private Cliente clienteOrigen;
	private Cliente clienteDestino;
	private Double saldoATransferir;
	
	public Transferencia(Cliente clienteOrigen, Cliente clienteDestino, Double saldoATransferir) {
		this.clienteOrigen = clienteOrigen;
		this.clienteDestino = clienteDestino;
		this.saldoATransferir = saldoATransferir;
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

	public Cliente getClienteOrigen() {
		return clienteOrigen;
	}

	public void setClienteOrigen(Cliente clienteOrigen) {
		this.clienteOrigen = clienteOrigen;
	}

	public Cliente getClienteDestino() {
		return clienteDestino;
	}

	public void setClienteDestino(Cliente clienteDestino) {
		this.clienteDestino = clienteDestino;
	}

	public Double getSaldoATransferir() {
		return saldoATransferir;
	}

	public void setSaldoATransferir(Double saldoATransferir) {
		this.saldoATransferir = saldoATransferir;
	}

}
