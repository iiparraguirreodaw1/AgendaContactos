import java.util.ArrayList;
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

	public int totalContactos() {
		int contador = 0;
		for (Set<Contacto> lista : agenda.values()) {
			contador += lista.size();
		}
		return contador;
	}

	public List<Contacto> buscarContactos(String texto) {
		List<Contacto> temp = new ArrayList<>();
		for (Set<Contacto> lista : agenda.values()) {
			for (Contacto contacto : lista) {
				if ((contacto.getNombre() + " " + contacto.getApellidos()).contains(texto.toUpperCase())) {
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
		for (char letra : agenda.keySet()) {
			String bloque = letra + " (" + agenda.get(letra).size() + " contactos) \n---------------\n";
			for (Contacto contacto : agenda.get(letra)) {
				bloque += contacto + "\n";
			}
			output += bloque;
		}
		return output;
	}
	
	public static void main(String[] args) {
		AgendaContactos ag = new AgendaContactos();
		ag.añadirContacto(new Personal("Elena", "Buenol Ganuza", "6786547699", 
				         "ebuenogan@gmail.com", "17/03/2000", Relacion.AMIGOS));
		
		ag.añadirContacto(new Personal("Berta", "Bndia solano", "621123345",
				"bandiasol@gmail.com", "12/12/1999", Relacion.HIJA));
		
		ag.añadirContacto(new Personal("Amaia", "Romero Sain", "642222343",
				"aromerosein@gmail.com", "08/03/2012",
				Relacion.PAREJA));

		
	}
	

}
