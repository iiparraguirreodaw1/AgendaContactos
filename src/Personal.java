import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Personal extends Contacto {

	private LocalDate fecha;
	private DateTimeFormatter formateador;
	private Relacion rel;
	private final String FIRMA = "Un abrazo!!";

	public Personal(String nombre, String apellidos, String telefono, String email, String fecha, Relacion relacion) {
		super(nombre, apellidos, telefono, email);
		String[] split = fecha.split("/");
		this.fecha = LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0]));
		formateador = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("es", "ES"));
		rel = relacion;
	}

	@Override
	public String firma() {
		return this.FIRMA;
	}

	public boolean esCumpleaños() {
		LocalDate ahora = LocalDate.now();
		if (ahora.getDayOfMonth() == this.fecha.getDayOfMonth()) {
			if (ahora.getMonth().equals(this.fecha.getMonth())) {
				return true;
			}
		}
		return false;
	}

	public String getFechaFormateada() {
		return this.fecha.format(formateador);
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}

	public Relacion getRel() {
		return rel;
	}

	public void setRel(Relacion rel) {
		this.rel = rel;
	}

	public String getFIRMA() {
		return FIRMA;
	}

	@Override
	public String toString() {
		return super.toString() + "Fecha cumpleaños: " + getFechaFormateada() + "\n";
	}

}