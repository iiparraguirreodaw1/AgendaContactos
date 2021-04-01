import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;

	
	public AgendaContactos() {
		agenda = new TreeMap<>();
	}

	public void añadirContacto(Contacto c) {
		char letra = c.getApellidos().charAt(0);
		if (agenda.containsKey(letra)) {
			agenda.get(letra).add(c);
		} else {
			Set<Contacto> temp = new TreeSet<>();
			temp.add(c);
			agenda.put(letra, temp);
		}
	}

	public void contactosEnLetra() {
		
	}

	public void totalContactos() {

	}

	public List<Contacto> buscarContactos(String texto) {
		List<Contacto> temp = new ArrayList<>();
		for (Set<Contacto> lista : agenda.values()) {
			for (Contacto contacto : lista) {
				if ((contacto.getNombre() + " " + contacto.getApellidos()).contains(texto)) {
					temp.add(contacto);
				}
			}
		}
		return temp;
	}

	public List<Personal> personalesEnLetra(char letra) {

		return null;
	}

	public List<Personal> felicitar() {

		return null;
	}

	public void personalesPorRelacion() {

	}

	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {
		return null;
	}
	
	@Override
	public String toString() {
		String output = "";
		
		
		for (Set<Contacto> lista : agenda.values()) {
			String bloque = "";
			for (Contacto contacto : lista) {
				bloque += contacto + "\n";
			}
			output += bloque + "\n";
		}
		
		
		return output;
	}
	
	public static void main(String[] args) {
		AgendaContactos ag = new AgendaContactos();
		ag.añadirContacto(new Personal("Elena", "Bueno Ganuza", "6786547699", 
				         "ebuenogan@gmail.com", "17/03/2000", Relacion.AMIGOS));
		
		ag.añadirContacto(new Personal("Berta", "Bndia solano", "621123345",
				"bandiasol@gmail.com", "12/12/1999", Relacion.HIJA));
		
		ag.añadirContacto(new Personal("Amaia", "Romero Sein", "642222343",
				"aromerosein@gmail.com", "08/03/2012",
				Relacion.PAREJA));
		
		System.out.println(ag.toString());
		
	}
	

}
