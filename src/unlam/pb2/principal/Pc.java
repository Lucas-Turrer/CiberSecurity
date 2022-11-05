package unlam.pb2.principal;

public class Pc extends Dispositivo {
	private String sistemaOperativo;
	private Localidad localidadDeConexion;

	public Pc(String sistemaOperativo, Localidad localidadDeConexion) {
		this.sistemaOperativo = sistemaOperativo;
		this.localidadDeConexion = localidadDeConexion;
	}

}
