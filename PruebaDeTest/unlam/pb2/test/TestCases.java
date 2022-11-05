package unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import unlam.pb2.principal.Banco;
import unlam.pb2.principal.Celular;
import unlam.pb2.principal.Cliente;
import unlam.pb2.principal.Dispositivo;
import unlam.pb2.principal.Extraccion;
import unlam.pb2.principal.FraudeException;
import unlam.pb2.principal.Localidad;
import unlam.pb2.principal.PagoConQR;
import unlam.pb2.principal.PagoDeUnServicio;
import unlam.pb2.principal.Pc;
import unlam.pb2.principal.TipoDeBloqueo;
import unlam.pb2.principal.Transaccion;
import unlam.pb2.principal.Transferencia;

public class TestCases {

	@Test
	public void queSePuedaCrearUnCliente() {
		Cliente clienteNumero1 = new Cliente(2037931874, 10000.00, "Lucas", "Turrer", "admin", "1234");
		
		Banco bancoNacion = new Banco(1404, "Banco Nacion");
		
		bancoNacion.agregarCliente(clienteNumero1);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = bancoNacion.cantidadDeClientes();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaCrearUnDispositivo() {
		Cliente clienteNumero1 = new Cliente(2037931874, 10000.00, "Lucas", "Turrer", "admin", "1234");
		
		Dispositivo dispositivoMovil = new Celular (25252525, TipoDeBloqueo.Huella);
		Dispositivo notebook = new Pc ("Xp", Localidad.SanJusto);
		
		clienteNumero1.agregarDispositivo(dispositivoMovil);
		clienteNumero1.agregarDispositivo(notebook);
		
		Banco bancoNacion = new Banco(1404, "Banco Nacion");
		
		bancoNacion.agregarCliente(clienteNumero1);
		
	    Integer valorEsperado = 2;
	    Integer valorObtenido = clienteNumero1.cantidadDeDispositivo();
		
	    assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaMonitorearUnaExtraccion() {
		Cliente clienteNumero1 = new Cliente(2037931874, 10000.00, "Lucas", "Turrer", "admin", "1234");
		
		Dispositivo dispositivoMovil = new Celular (25252525, TipoDeBloqueo.Huella);
		Dispositivo notebook = new Pc ("Xp", Localidad.SanJusto);
		
		clienteNumero1.agregarDispositivo(dispositivoMovil);
		clienteNumero1.agregarDispositivo(notebook);
		
		Banco bancoNacion = new Banco(1404, "Banco Nacion");
		
		bancoNacion.agregarCliente(clienteNumero1);
		
	    Extraccion extraccionDeDinero = new Extraccion (10000.00, clienteNumero1);
	    
	    bancoNacion.realizarExtraccion(extraccionDeDinero);
	    
	    Boolean valorEsperado = true;
	    Boolean valorObtenido = extraccionDeDinero.getCasoSospechoso();
	    
	    assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test (expected = FraudeException.class )
	public void queSePuedaMonitorearUnaTransferencia() throws FraudeException {
		Cliente clienteNumero1 = new Cliente(2037931874, 10000.00, "Lucas", "Turrer", "admin", "1234");
		Cliente clienteNumero2 = new Cliente(2085852857, 50000.00, "Mario", "Gomez", "admin", "1234");
		
		Dispositivo dispositivoMovil = new Celular (25252525, TipoDeBloqueo.Huella);
		Dispositivo notebook = new Pc ("Xp", Localidad.SanJusto);
		
		clienteNumero1.agregarDispositivo(dispositivoMovil);
		clienteNumero1.agregarDispositivo(notebook); 
		
		Banco bancoNacion = new Banco(1404, "Banco Nacion");
		
		bancoNacion.agregarCliente(clienteNumero1);
		bancoNacion.AgregarAListaNegra(clienteNumero2);
		
		Transferencia transferenciaDeDinero = new Transferencia (clienteNumero1, clienteNumero2, 50000.00);
		bancoNacion.realizarTransferencia(transferenciaDeDinero);
	}
	
	@Test (expected = FraudeException.class )
	public void queSePuedaMonitorearUnPagoConQR() throws FraudeException {
		Cliente clienteNumero1 = new Cliente(2037931874, 10000.00, "Lucas", "Turrer", "admin", "1234");
		Cliente clienteNumero2 = new Cliente(2085852857, 50000.00, "Mario", "Gomez", "admin", "1234");
		
		Dispositivo dispositivoMovil = new Celular (25252525, TipoDeBloqueo.Huella);
		Dispositivo notebook = new Pc ("Xp", Localidad.SanJusto);
		
		clienteNumero1.agregarDispositivo(dispositivoMovil);
		clienteNumero1.agregarDispositivo(notebook); 
		
		Banco bancoNacion = new Banco(1404, "Banco Nacion");
		
		bancoNacion.agregarCliente(clienteNumero1);
		bancoNacion.AgregarAListaNegra(dispositivoMovil);
		
		PagoConQR pagoEnComercio = new PagoConQR(clienteNumero1, dispositivoMovil, 50000.00);
		bancoNacion.realizarPagoConQR(pagoEnComercio);
	}
	
	@Test (expected = FraudeException.class )
	public void queSePuedaMonitorearUnPagoDeServicio() throws FraudeException {
		Cliente clienteNumero1 = new Cliente(2037931874, 10000.00, "Lucas", "Turrer", "admin", "1234");
		
		Dispositivo dispositivoMovil = new Celular (25252525, TipoDeBloqueo.Huella);
		Dispositivo notebook = new Pc ("Xp", Localidad.SanJusto);
		
		clienteNumero1.agregarDispositivo(dispositivoMovil);
		clienteNumero1.agregarDispositivo(notebook); 
		
		Banco bancoNacion = new Banco(1404, "Banco Nacion");
		
		bancoNacion.agregarCliente(clienteNumero1);
		bancoNacion.AgregarAListaNegra(dispositivoMovil);
		
		PagoDeUnServicio pagoDeLaLuz = new PagoDeUnServicio (clienteNumero1, dispositivoMovil, 50000.00);
		bancoNacion.realizarPagoDeUnServicio(pagoDeLaLuz);
	}
	
	@Test 
	public void queSePuedaMonitorearUnAltaDeUsuario(){
		Cliente clienteNumero1 = new Cliente(2037931874, 10000.00, "Lucas", "Turrer", "admin", "1234");
		
		Dispositivo dispositivoMovil = new Celular (25252525, TipoDeBloqueo.Huella);
		Dispositivo notebook = new Pc ("Xp", Localidad.SanJusto);
		
		clienteNumero1.agregarDispositivo(dispositivoMovil);
		clienteNumero1.agregarDispositivo(notebook); 
		
		Banco bancoNacion = new Banco(1404, "Banco Nacion");
		
		bancoNacion.agregarCliente(clienteNumero1);
		
		clienteNumero1.setAdminiInicial("Hola123");
		
		String valorEsperado = "Hola123";
		String valorObtenido = clienteNumero1.getAdminiInicial();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void queSePuedaMonitorearUnCambioDeContraseña(){
		Cliente clienteNumero1 = new Cliente(2037931874, 10000.00, "Lucas", "Turrer", "admin", "1234");
		
		Dispositivo dispositivoMovil = new Celular (25252525, TipoDeBloqueo.Huella);
		Dispositivo notebook = new Pc ("Xp", Localidad.SanJusto);
		
		clienteNumero1.agregarDispositivo(dispositivoMovil);
		clienteNumero1.agregarDispositivo(notebook); 
		
		Banco bancoNacion = new Banco(1404, "Banco Nacion");
		
		bancoNacion.agregarCliente(clienteNumero1);
		
		clienteNumero1.setContraseñaInicial("Hola12345678");
		
		String valorEsperado = "Hola12345678";
		String valorObtenido = clienteNumero1.getContraseñaInicial();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void queElScoreDeUnaTransaccionRechazableSinAntecedentesDeCero() throws FraudeException{
		Cliente clienteNumero1 = new Cliente(2037931874, 10000.00, "Lucas", "Turrer", "admin", "1234");
		Cliente clienteNumero2 = new Cliente(2085852857, 50000.00, "Mario", "Gomez", "admin", "1234");
		
		Dispositivo dispositivoMovil = new Celular (25252525, TipoDeBloqueo.Huella);
		Dispositivo notebook = new Pc ("Xp", Localidad.SanJusto);
		
		clienteNumero1.agregarDispositivo(dispositivoMovil);
		clienteNumero1.agregarDispositivo(notebook); 
		
		Banco bancoNacion = new Banco(1404, "Banco Nacion");
		
		bancoNacion.agregarCliente(clienteNumero1);
		
		Transferencia transferenciaDeDinero = new Transferencia (clienteNumero1, clienteNumero2, 50000.00);
		bancoNacion.realizarTransferencia(transferenciaDeDinero);
		
		Integer valorEsperado = 0;
		Integer valorObtenido = bancoNacion.getScore();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
		public void queUnaTransaccionAlertablePuedaSerMarcadaComoFraudulenta() throws FraudeException {
			Cliente clienteNumero1 = new Cliente(2037931874, 10000.00, "Lucas", "Turrer", "admin", "1234");
			
			Dispositivo dispositivoMovil = new Celular (25252525, TipoDeBloqueo.Huella);
			Dispositivo notebook = new Pc ("Xp", Localidad.SanJusto);
			
			clienteNumero1.agregarDispositivo(dispositivoMovil);
			clienteNumero1.agregarDispositivo(notebook); 
			
			Banco bancoNacion = new Banco(1404, "Banco Nacion");
			
			bancoNacion.agregarCliente(clienteNumero1);
			bancoNacion.AgregarAListaNegra(dispositivoMovil);
			
			PagoDeUnServicio pagoDeLaLuz = new PagoDeUnServicio (clienteNumero1, dispositivoMovil, 50000.00);
			pagoDeLaLuz.confirmarSiFueFraude(true);
			
			Boolean valorEsperado = true;
			Boolean valorObtenido = pagoDeLaLuz.getPosibleFraude();
			
			assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test (expected = FraudeException.class )
	public void queUnaTransaccionDeMasDe80PuntosLanceLaExcepcionFraudeException() throws FraudeException {
		Cliente clienteNumero1 = new Cliente(2037931874, 10000.00, "Lucas", "Turrer", "admin", "1234");
		Cliente clienteNumero2 = new Cliente(2085852857, 50000.00, "Mario", "Gomez", "admin", "1234");
		
		Dispositivo dispositivoMovil = new Celular (25252525, TipoDeBloqueo.Huella);
		Dispositivo notebook = new Pc ("Xp", Localidad.SanJusto);
		
		clienteNumero1.agregarDispositivo(dispositivoMovil);
		clienteNumero1.agregarDispositivo(notebook); 
		
		Banco bancoNacion = new Banco(1404, "Banco Nacion");
		
		bancoNacion.agregarCliente(clienteNumero1);
		bancoNacion.AgregarAListaNegra(clienteNumero2);
		
		Transferencia transferenciaDeDinero = new Transferencia (clienteNumero1, clienteNumero2, 50000.00);
		bancoNacion.realizarTransferencia(transferenciaDeDinero);
	}

}
