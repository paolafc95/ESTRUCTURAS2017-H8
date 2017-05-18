import java.util.HashMap;
/**
 *Byron Mota, 15246
 *Paola Fuentes, 151126
 * @param <K>
 *            Llave
 * @param <V>
 *            Valor
 * Clase que representa la asociacion entre key y value utilizando HashMap.
 */
public class Asociacion<K, V> implements Comparable<Asociacion<K, V>>,
		Mapeo<K, V> {

	/*Atributos*/
	private HashMap<K, V> dic;

	/**
	 * Constructor inicializa atributos
	 */
	public Asociacion() {
		dic = new HashMap<K, V>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Asociacion o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Revisa si existe o no una llave
	 * 
	 * @param key
	 *            Es la llave a la cual se le asocia un valor
	 * @return Falso o Verdadero de pendiendo en si existe una relacion en la
	 *         que esta sea la llave
	 */
	public boolean contains(K key) {
		if (dic.containsKey(key)) {
			// System.out.println("Si existe!");
			return true;
		} else {
			// System.out.println("No existe!");
			return false;
		}
	}

	/**
	 * Devuelve el valor asociado a una llave
	 * 
	 * @param key
	 *            Es la llave a la cual se le asocia un valor
	 * @return dic.get(key) Es el valor que tiene asociado la llave
	 */
	public V get(K key) {
		return dic.get(key);
	}

	/**
	 * Inserta una nueva llave con un valor asociado
	 * 
	 * @param key
	 *            Es la llave a la cual se le asocia un valor
	 * @param value
	 *            Es el valor a ingresar como asociado a la llave
	 */

	@Override
	public void put(K key, V value) {
		dic.put(key, value);

	}
}