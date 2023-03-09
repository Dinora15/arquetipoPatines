package arquetipoPatines;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
//importar la libreria time y la clase LocalDate;

public class Alquiler {
	//Se encapsulan los atributos del objeto alquiler
	//Permite registrar la fecha en que se alquila el patinete
	 private LocalDate inicio = LocalDate.now();	 
	    private LocalDate fin;
	    //Permite apuntar al objeto categoria de la clase Categoria
	    private Categoria categoria;

	    public LocalDate getFechaInicio() {
	        return this.inicio;
	    }
//Constructur de la clase alquiler
	    public Alquiler(Categoria categoria) {
	        this.categoria = categoria;
	    }
        // Clase que permite registrar la fecha de entrega del patinente.
	    public void Finalizar() {
	        this.fin = LocalDate.now();
	    }
	    
	    //Clase que permite obtener la ganancia por el alquiler del patinente:
	    //Se define si no hay alquiler es 0, si hay una patineta en alquiler se hace el calcula
	    //llamando al metodo getPrecioAlquilerDiario de la clase Categoria, multiplicado por los dias de alquiler
	    public double getPrecioAlquiler() {
	        return this.fin != null ? this.categoria.getPrecioAlquilerDiario() * (double)(ChronoUnit.DAYS.between(this.inicio, this.fin) + 1L) : 0.0;
	    }

}
