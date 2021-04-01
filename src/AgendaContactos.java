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

		return null;
	}

	public List<Personal> felicitar() {

		return null;
	}

	public Map<Relacion, List<String>> personalesPorRelacion() {
		Map<Relacion, List<String>> contactos;
		contactos = new TreeMap<>();
		for (Set<Contacto> lista : agenda.values()) {
			for (Contacto temp : lista) {
				if(temp instanceof Personal) {
					String nombreapell = temp.getApellidos() + "  " + temp.getNombre();
					if(contactos.containsKey(((Personal) temp).getRel())) {
						contactos.get(((Personal) temp).getRel()).add(nombreapell);
					}else {
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
		
		ag.añadirContacto(new Personal("Elena", "Bndia solano", "621133345",
				"bandiasol@gmail.com", "12/12/1999", Relacion.HIJA));
		
		ag.añadirContacto(new Personal("Amaia", "Romero Sain", "642222343",
				"aromerosein@gmail.com", "08/03/2012",
				Relacion.PAREJA));
		
		ag.añadirContacto(new Personal("Amaia", "Ramero Sain", "642222343",
				"aromerosein@gmail.com", "08/03/2012",
				Relacion.PAREJA));
		
		ag.añadirContacto(new Personal("Juki", "Ramero Sain", "642222343",
				"aromerosein@gmail.com", "08/03/2012",
				Relacion.PADRE));

		System.out.println(ag.personalesPorRelacion());
	}
	

}
