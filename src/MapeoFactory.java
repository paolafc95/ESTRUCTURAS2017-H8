/**
*Byron Mota, 15246
 *Paola Fuentes, 151126
 * @version 1.0
 * Interfaz para patron Factory.
 * 
 */
public interface MapeoFactory {
	/**
	 * @param tipoMapeo	El tipo de mapeo requerido.
	 * @return	La instaciacion del mapeo.
	 */
	Mapeo getMapeo(String tipoMapeo);
}
