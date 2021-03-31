import java.time.LocalDate;
public class Personal extends Contacto{

	private String fechaParseado = "";
	LocalDate date;
	Relacion rel;
	private final String FIRMA = "Un abrazo!!";
	public Personal(String nombre, String apellidos, String telefono, String email, String fecha, Relacion relacion) {
		super(nombre, apellidos, telefono, email);
		this.fechaParseado = fecha;
		date  = LocalDate.parse(fechaParseado);
		 rel = relacion;
	}
	
	public boolean esCumpleaños() {
		LocalDate ahora = LocalDate.now();
		if(ahora.getDayOfMonth() == date.getDayOfMonth()) {
			if(ahora.getMonth().equals(date.getMonth())) {
				return true;
			}
		}
		return false;
	}

	public String getFechaParseado() {
		return fechaParseado;
	}

	public void setFechaParseado(String fechaParseado) {
		this.fechaParseado = fechaParseado;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
		return "Personal [fechaParseado=" + fechaParseado + ", date=" + date + ", rel=" + rel + ", FIRMA=" + FIRMA
				+ "]";
	}
	
	
}
