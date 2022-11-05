package unlam.pb2.principal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cliente implements Denunciable {
	private Integer cuit;
	private Double saldoInicial;
	private String nombre;
	private String apellido;
	private String adminiInicial;
	private String contraseñaInicial;
	private Set <Dispositivo> dispositivoDelCliente = new HashSet ();
	private List <UltimaAccion> accionesRealizadas = new ArrayList ();

	public Cliente(Integer cuit, Double saldoInicial, String nombre, String apellido, String adminiInicial, String contraseñaInicial) {
		this.cuit = cuit;
		this.saldoInicial = saldoInicial;
		this.nombre = nombre;
		this.apellido = apellido;
		this.adminiInicial = adminiInicial;
		this.contraseñaInicial = contraseñaInicial;
	}

	public void agregarDispositivo(Dispositivo dispositivoParaAgregar) {
		dispositivoDelCliente.add(dispositivoParaAgregar);
	}

	public Integer cantidadDeDispositivo() {
		return dispositivoDelCliente.size();
	}

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getAdminiInicial() {
		return adminiInicial;
	}

	public void setAdminiInicial(String adminiInicial) {
		this.adminiInicial = adminiInicial;
		accionesRealizadas.add(UltimaAccion.cambioDeUsuario);
	}

	public String getContraseñaInicial() {
		return contraseñaInicial;
	}

	public void setContraseñaInicial(String contraseñaInicial) {
		this.contraseñaInicial = contraseñaInicial;
		accionesRealizadas.add(UltimaAccion.cambioDeContrasenia);
	}

	public Set<Dispositivo> getDispositivoDelCliente() {
		return dispositivoDelCliente;
	}

	public void setDispositivoDelCliente(Set<Dispositivo> dispositivoDelCliente) {
		this.dispositivoDelCliente = dispositivoDelCliente;
	}

	public UltimaAccion ultimaAccion() {
		return null;
	}

}
