package arquetipoPatines;

import java.time.LocalDate;
//Se importa la libreria time clase LcalDate
public class NumeroDeReferencia {
	//Se encapsulan los atributos del objeto Numero de Referencia
	
    private static final int SECUENCIA_MAXIMA=2;
	private static short ultimoAño = (short)LocalDate.now().getYear();
    private static int[] ultimaSecuencia = new int[Categoria.values().length];
    private final String codigo;
//Se apunta al objeto categoria de la Clase Categoria 
    
   
    public NumeroDeReferencia(Categoria categoria) throws Exception {
    	//Se implementa una excepción: si se trata de implementar más de 2 referencias y el programa no se detenga
        LocalDate hoy = LocalDate.now();
        //
        if (ultimaSecuencia[categoria.ordinal()] == 2) {          
        	throw new Exception("Se ha alcanzado el número máximo de referencias para la categoria " + categoria.toString());
        } else {
        	//se define el codigo de la operación: nombre categoria.año de la operación y el valor entero asignado por java
            this.codigo = String.format("%s%04d%05d", categoria.toString(), hoy.getYear(), ++ultimaSecuencia[categoria.ordinal()]);
        }
    }
//permite imprimir el codigo
    public String toString() {
        return this.codigo;
    } 
}
