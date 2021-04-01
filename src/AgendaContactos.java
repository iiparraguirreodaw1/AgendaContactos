import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;

	public AgendaContactos() {
		agenda = new TreeMap<>();
		Collections.sort(null);
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

	public Set<Contacto> contactosEnLetra(char letra) {
		return agenda.get(letra);
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
		List<Personal> devuelve = new ArrayList<>();

		for (Contacto contacto : agenda.get(letra)) {
			if (contacto instanceof Personal) {
				Personal p = (Personal) contacto;
				devuelve.add(p);
			}

		}
		if (!devuelve.isEmpty()) {
			return devuelve;
		} else {
			return null;
		}
	}

	public List<Personal> felicitar() {
		List<Personal> devuelve = new ArrayList<>();

		for (Set<Contacto> contacto : agenda.values()) {
			for (Contacto c : contacto) {
				if (c instanceof Personal) {
					Personal p = (Personal) c;
					if (p.esCumpleaños()) {
						devuelve.add(p);
					}
				}
			}
		}

		return devuelve;
	}

	public Map<Relacion, List<String>> personalesPorRelacion() {
		Map<Relacion, List<String>> contactos;
		contactos = new TreeMap<>();
		for (Set<Contacto> lista : agenda.values()) {
			for (Contacto temp : lista) {
				if (temp instanceof Personal) {
					String nombreapell = temp.getApellidos() + "  " + temp.getNombre();
					if (contactos.containsKey(((Personal) temp).getRel())) {
						contactos.get(((Personal) temp).getRel()).add(nombreapell);
					} else {
						List<String> temp1 = new ArrayList<>();
						temp1.add(nombreapell);
						contactos.put(((Personal) temp).getRel(), temp1);
					}
				}
			}
		}
		return contactos;
	}

	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {
		List<Personal> devuelve = personalesEnLetra(letra);
		Collections.sort(devuelve, new Comparator<Personal>() {

			@Override
			public int compare(Personal o1, Personal o2) {
				if (o1.getFecha().isBefore(o2.getFecha())) {
					return -1;
				}

				return 1;
			}

		});
		return devuelve;
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
}
