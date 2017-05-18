import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
*Byron Mota, 15246
 *Paola Fuentes, 151126
 * @version 1
 * 
 */
public class Diccionario {

	static String textoArray[];

	/**
	 * Metodo que lee el contenido y lo pone en una sola linea. Este es con el
	 * que se lee el texto que viene en ingles
	 * 
	 * @param archivo
	 *            El archivo que tiene el texto en ingles
	 * @return texto variable que tiene como un string todo el texto
	 */
	static String leerContenido2(String archivo) {
		String texto = "", temp = "", bfRead;
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) {
				temp += bfRead;
			}
			texto = temp;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro archivo");
		}

		return texto;
	}

	private ArrayList<String> array = new ArrayList<String>();
	private ArrayList<String> array2 = new ArrayList<String>();
	private MapeoFactory mapeoFactory;
	private Mapeo<String, String> miMapeo;

	/**
	 * Metodo que revisa si existe una asociacion. si existe regresa el valor y
	 * si nno dice que no esta
	 * 
	 * @param key
	 * @return
	 */
	String buscarHash(String key) {
		if (miMapeo.contains(key)) {
			return miMapeo.get(key);
		} else {
			return "No esta en el Diccionario";
		}
	}

	/**
	 * Metodo que crea el arbol o hashmap (segun seleccionado) lleno de las
	 * palabras con key=palabra en ingles value=palabra en español ignorando a
	 * partir de cuando hay un corchete para mostrar en la traduccion solo la
	 * palabra y no el tipo de esta
	 * 
	 * @param archivo
	 */
	void crear(String archivo) {
		for (String i : leerContenido(archivo)) {
			int co = 0;
			String part1 = "", part2 = "";

			for (int j = 0; j < i.length(); j++) {
				char c = i.charAt(j);
				if (Character.isLetter(c)) {
					part1 += c;
				} else {
					co = j;
					break;

				}
			}

			int corchete = 0;

			i.trim();

			corchete = i.indexOf("[");

			if (corchete > 0) {
				part2 = i.substring(co, corchete);
			} else {
				part2 = i.substring(co);
			}

			part2.trim();

			// System.out.println("1" + part1);
			// System.out.println("2" + part2);
			miMapeo.put(part1, part2);
			part1 = "";
			part2 = "";

		}

	}

	/**
	 * LeerContenido recibe como parametro el archivo donde estan los datos.
	 * devuelve el texto que esta en la linea. si no se encuentra el archivo
	 * muesta error
	 * 
	 * @param archivo
	 *            Este es el archivo que contiene las palabras de forma
	 *            (ingles,espanol)
	 * @return array este es un array que tiene las palabras
	 */
	ArrayList<String> leerContenido(String archivo) {
		String bfRead;
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) {
				array.add(bfRead);
				// System.out.println(bfRead);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro archivo");
		}

		return array;
	}

	/**
	 * Metodo para instaciar la coleccion deseada.
	 * 
	 * @param tipo
	 *            para seleccionar implementacion a usar
	 */
	void listo(String tipo) {
		mapeoFactory = new Factory();
		miMapeo = mapeoFactory.getMapeo(tipo);
	}

	/**
	 * Metodo para traducir la oracion Primero lee el txt que contiene la
	 * oracion y lo agrega a un array. luego va buscando si existe la key que es
	 * la palabra en ingles, si esta existe la sustituye por su valor, y si no
	 * exsite simplemente la copia y la pone dentro de asteriscos
	 * 
	 * @param dir
	 */
	String traducir(String dir) {
		String texto = "", traduccion = "";
		int j = 0;
		texto = leerContenido2(dir);
		textoArray = texto.split(" ");
		for (String i : textoArray) {
			array2.add(i);

		}

		for (String i : textoArray) {
			if (miMapeo.contains(array2.get(j))) {
				traduccion += miMapeo.get(array2.get(j)).trim() + " ";
			} else {
				traduccion += "*" + array2.get(j).trim() + "*" + " ";

			}
			j++;
		}
		// System.out.println(traduccion);

		return traduccion;

	}

}
