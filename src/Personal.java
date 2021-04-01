import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Personal extends Contacto{

	private String fechaParseado = "";
	private String patron = "yyyy MM dd";
	private DateTimeFormatter form;
	private LocalDate date;
	private Relacion rel;
	private final String FIRMA = "Un abrazo!!";
	
	
	public Personal(String nombre, String apellidos, String telefono, String email, String fecha, Relacion relacion) {
		super(nombre, apellidos, telefono, email);
		this.fechaParseado = fecha.replaceAll("/", "-");
		// fecha año primero, luego mes, luego dia
		form = DateTimeFormatter.ofPattern(patron);
		date = LocalDate.parse(fechaParseado, form);
		 rel = relacion;
	}
	
	@Override
	public String firma() {	
		return this.FIRMA;
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
		return super.toString() + "Fecha nacimiento: " + date.getDayOfMonth() + " " + date.getMonth().name().substring(0, 4) + " " + date.getYear();
	}
	
	public static void main(String[] args) {
		Personal p = new Personal("Elena", "Bueno Ganuza", "6786547699",
						"ebuenogan@gmail.com", "17/03/2000", Relacion.AMIGOS);
		System.out.println(p.toString());
	}

	
}