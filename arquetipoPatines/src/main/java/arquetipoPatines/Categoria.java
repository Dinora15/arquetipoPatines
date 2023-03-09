package arquetipoPatines;

public enum Categoria {
	//Se define el listado de categorias de los Patienetes y el conjunto de las constantes {valor minimo, Alquiler, Venta} de caa uno
	 BASICA(50, 10.0, 600.0),
	    ESTANDAR(75, 12.5, 800.0),
	    PREMIUM(100, 15.0, 1000.0);
//Se encapsulan los atributos del objeto categoria
	    private final int pvpMinimo;
	    private final double alquilerDiario;
	    private final double precioCoste;
//Constructor de la clase con sus atributos
	    private Categoria(int pvp, double alq, double precio) {
	        this.pvpMinimo = pvp;
	        this.alquilerDiario = alq;
	        this.precioCoste = precio;
	    }

	    public int getPVPMinimo() {
	        return this.pvpMinimo;
	    }

	    public double getPrecioAlquilerDiario() {
	        return this.alquilerDiario;
	    }

	    public double getPrecioCoste() {
	        return this.precioCoste;
	    }

}
