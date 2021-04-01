import java.util.Random;

public class Profesional extends Contacto {

	private String nombreEmpresa;
	private Random rnd;
	private final String[] SALUDOS = {"Atentamente", "Saludos", "Saludos cordiales", "Mis mejores deseos"};

	public Profesional(String nombre, String apellidos, String telefono, String email, String nombreEmpresa) {
		super(nombre, apellidos, telefono, email);
		this.nombreEmpresa = parsearEmpresa(nombreEmpresa);
		this.rnd = new Random();
	}

	private String parsearEmpresa(String nombre) {
		String output = "";
		String[] split = nombre.split(" ");
		for (String nombreSpliteado : split) {
			output += nombreSpliteado.substring(0, 1).toUpperCase()
				    + nombreSpliteado.substring(1, nombreSpliteado.length()) + " ";
		}
		return output;
	}
	
	@Override
	public String firma() {
		return SALUDOS[rnd.nextInt(SALUDOS.length)];
	}
	
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	@Override
	public String toString() {
		return super.toString() + "Empresa: " + nombreEmpresa + "\n";
	}
}
