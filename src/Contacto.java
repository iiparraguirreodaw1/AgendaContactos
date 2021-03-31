public abstract class Contacto implements Comparable<Contacto> {
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;

	public Contacto(String nombre, String apellidos, String telefono,
			String email) {
		this.nombre = nombre.toUpperCase();
		this.apellidos = apellidos.toUpperCase();
		this.telefono = telefono;
		this.email = email.toLowerCase();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public char getPrimeraLetra() {
		return nombre.charAt(0);
	}

	@Override
	public int hashCode() {
		return email.hashCode();

	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Contacto) {
			Contacto c = (Contacto) obj;
			if(this.nombre.equals(c.getNombre()) && this.apellidos.equals(c.getApellidos()) && this.email.equals(c.getEmail())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(Contacto o) {
		if(this.apellidos.equals(o.getApellidos())) {
			return this.nombre.compareTo(o.getNombre());
		}else {
			return this.apellidos.compareTo(o.getApellidos());
		}
	}
	
	@Override
	public String toString() {
		return  this.apellidos + ", " + this.nombre + " (" + this.getClass().getSimpleName() + ") " + 
				"\n" + "Tfno: " + this.telefono + " | " + "email: " + this.email + "\n";
	}
	
	public abstract String firma();
}
