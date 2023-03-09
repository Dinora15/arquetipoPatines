package arquetipoPatines;

import java.time.LocalDate;
//se implementa la libleria time de java
public class Reparacion {
//se encapsulan los atributos del objeto ReparaCion
	private LocalDate fechaReparacion = LocalDate.now();
    private double importe;

    //Constructor clase Reparación
    public Reparacion(double importe) {
        this.importe = importe;
    }

    public LocalDate getFecha() {
        return this.fechaReparacion;
    }

    public double getImporte() {
        return this.importe;
    }

    public String toString() {
        return "Reparación realizada el " + this.fechaReparacion + " por un importe de " + this.importe + "€";
    }
}
