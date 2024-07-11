
package bean;

public class Hotel implements Comparable<Hotel> {
    private int idHotel, precio;
    private String Nombre, zona;

    public Hotel() {
    }

    public Hotel(int idHotel, String Nombre, String zona, int precio) {
        this.idHotel = idHotel;
        this.Nombre = Nombre;
        this.zona = zona;
        this.precio = precio;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "idHotel=" + idHotel + ", precio=" + precio + ", Nombre=" + Nombre + ", zona=" + zona ;
    }

	@Override
	public int compareTo(Hotel hotel2) {

		int resultado = Double.compare(this.getPrecio(), hotel2.getPrecio());
        if (resultado == 0) {
            return Integer.compare(this.getIdHotel(), hotel2.getIdHotel());
        }
        return resultado;
	}
    
    
    
}
