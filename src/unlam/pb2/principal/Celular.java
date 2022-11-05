package unlam.pb2.principal;

public class Celular extends Dispositivo {
	private Integer imei;
	private TipoDeBloqueo modalidadDeBloqueo;

	public Celular(Integer imei, TipoDeBloqueo modalidadDeBloqueo) {
		this.imei = imei;
		this.modalidadDeBloqueo = modalidadDeBloqueo;
	}

}
