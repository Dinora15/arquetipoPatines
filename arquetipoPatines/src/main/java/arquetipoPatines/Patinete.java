package arquetipoPatines;

import java.time.LocalDate;
//Se importa la librería time.LocalDate
import java.time.Period;
import java.util.Arrays;

public class Patinete {
	//se encapsulan los atributos del objeto patinente
	 private NumeroDeReferencia nRef;
	    private Categoria categoria;
	    private Estado estado;
	    private LocalDate fechaAdquisicion;
	    //Se almacenan los valores de cada Alquiler en un array alquileres
	    private Alquiler[] alquileres;
	    //Se almacenan los valores de cada Reparacion en un array reparaciones
	    private Reparacion[] reparaciones;
	    private double kmAcumulados;
	    private double precioVendido;
	    private LocalDate fechaVenta;
//Constructor vacío de la clase. Se implementan errores personalizados en la clase Patinete
	    public Patinete() throws Exception {
	        this(Categoria.BASICA);
	    }
//constructor de la clase Patienete
	    public Patinete(Categoria categoria) throws Exception {
	    	//Se inicializan los  atributos del objeto patinete
	        this.nRef = new NumeroDeReferencia(categoria);
	        this.categoria = categoria;
	        this.estado = Patinete.Estado.DISPONIBLE;
	        this.kmAcumulados = 0.0;
	        this.fechaAdquisicion = LocalDate.now();
	        this.precioVendido = 0.0;
	    }

	    public String getNumeroDeReferencia() {
	        return this.nRef.toString();
	    }

	    public Estado getEstado() {
	        return this.estado;
	    }

	    public Categoria getCategoria() {
	        return this.categoria;
	    }

	    public double getPrecioVendido() {
	        return this.precioVendido;
	    }
	    
	    

	    public double acumuladoAlquileres() {
	        double acumulado = 0.0;
//Instrucciones para almacenar en la variable acumulado, lo obtenido por el alquiler de los Patinetes
	        try {
	            Alquiler[] var3 = this.alquileres;
	            int var4 = var3.length;

	            for(int var5 = 0; var5 < var4; ++var5) {
	                Alquiler alq = var3[var5];
	                acumulado += alq.getPrecioAlquiler();
	            }
	        } catch (NullPointerException var7) {
	        }

	        return acumulado;
	    }
//Instrucciones para almacenar en la variable acumulado el coste de la reparación de los Patinetes
	    public double acumuladoReparaciones() {
	        double acumulado = 0.0;

	        try {
	            Reparacion[] var3 = this.reparaciones;
	            int var4 = var3.length;

	            for(int var5 = 0; var5 < var4; ++var5) {
	                Reparacion rep = var3[var5];
	                acumulado += rep.getImporte();
	            }
	        } catch (NullPointerException var7) {
	        }

	        return acumulado;
	    }

	    public void Alquilar() throws Exception {
	    	//Instrucciones para alquilar un patinente, con la condicional de disponibilidad
	        if (this.estado == Patinete.Estado.DISPONIBLE) {
	        	//Si está disponible se almacena en el array Alquiler
	            Alquiler[] auxiliar;	            
	            if (this.alquileres == null) {
	            	//
	                auxiliar = new Alquiler[1];
	            } else {
	                auxiliar = (Alquiler[])Arrays.copyOf(this.alquileres, this.alquileres.length + 1);
	            }
	            //Si hay disponiblidad, el patinete cambia de estado a Alquilado

	            Alquiler nuevoAlquiler = new Alquiler(this.categoria);
	            auxiliar[auxiliar.length - 1] = nuevoAlquiler;
	            this.estado = Patinete.Estado.ALQUILADO;
	            this.alquileres = auxiliar;
	        } else {
	        	//Se implementa número de referencia de patinete alquilado
	            NumeroDeReferencia var10002 = this.nRef;
	            throw new Exception("El patinete " + var10002 + " no se puede alquilar por estar " + this.getEstado());
	        }
	    }
//Instrucciones para la devolución de alquilado, donde se registra el numero de kilometros recorridos. 
	    // Y se disminuye 1 patinente del array alquilado. Se cambia estado de Patinete a Disponible
	//Se implementa una excepción: cuando la patinenta no esta alquilada.   
	    public void Devolver(double kmRecorridos) throws Exception {
	        if (this.estado == Patinete.Estado.ALQUILADO) {
	            this.estado = Patinete.Estado.DISPONIBLE;
	            this.kmAcumulados += kmRecorridos;
	            this.alquileres[this.alquileres.length - 1].Finalizar();
	        } else {
	            throw new Exception("No se puede devolver un patinete que está " + this.estado);
	        }
	    }
	    
	    //Instrucciones para vender una patinete, con la condición que este disponible
	    //Se calcula el precio de Venta, y se registra la fecha de venta. Cambia condición a Vendido

	    public double Vender() throws Exception {//Se implementa una excepión: no hay disponibilidad de patinete
	        if (this.estado == Patinete.Estado.DISPONIBLE) {
	            this.estado = Patinete.Estado.VENDIDO;
	            this.precioVendido = this.CalcularPrecioVenta();
	            this.fechaVenta = LocalDate.now();
	            return this.precioVendido;
	        } else {
	            throw new Exception("No se puede vender un patinete que está " + this.estado);
	        }
	    }
//Instrucciones para reparar un patinente, con la condición de la Disponibilidad de patienete
	    public void Reparar(double importe) throws Exception {
	    	//Se implementa una excepción cuando no haya disponibilidad de Patinentes a reparar
	        if (this.estado == Patinete.Estado.DISPONIBLE) {
	            Reparacion[] auxiliar;
	            if (this.reparaciones == null) {
	                auxiliar = new Reparacion[1];
	            } else {
	                auxiliar = (Reparacion[])Arrays.copyOf(this.reparaciones, this.reparaciones.length + 1);
	            }

	            Reparacion nuevaReparacion = new Reparacion(importe);
	            auxiliar[auxiliar.length - 1] = nuevaReparacion;
	            this.reparaciones = auxiliar;
	        } else {
	            throw new Exception("No se puede reparar un patinete que está " + this.estado);
	        }
	    }
//Instrucciones para calcular el Precio de venta en base: al precio de venta, menos meses de 
	    // antiguedad  por 10 +  gastos de reparaciones menos kilometros acumulados por alquiler todo multiplicado por .02
	    public double CalcularPrecioVenta() {
	    	//Se obtiene el precio de Coste de la Categoria a vender, de la collección Categoria
	        double pvp = this.categoria.getPrecioCoste();
	        int mesesAntiguedad = Period.between(this.fechaAdquisicion, LocalDate.now()).getMonths();
	        double valorReparaciones = 0.0;
	        if (this.reparaciones != null) {
	            Reparacion[] var6 = this.reparaciones;
	            int var7 = var6.length;

	            for(int var8 = 0; var8 < var7; ++var8) {
	                Reparacion rep = var6[var8];
	                //calculo de reparación: importe ingresado -el periodo en días de la fecha de reparación y el día de entrega en días por .0.2
	                double valorReparacion = rep.getImporte() - (double)Period.between(rep.getFecha(), LocalDate.now()).getDays() * 0.2;
	                if (valorReparacion > 0.0) {
	                    valorReparaciones += valorReparacion;
	                }
	            }
	        }

	        pvp = pvp - (double)(mesesAntiguedad * 10) + valorReparaciones - this.kmAcumulados * 0.02;
	        if (pvp < (double)this.categoria.getPVPMinimo()) {
	            pvp = (double)this.categoria.getPVPMinimo();
	        }

	        return pvp;
	    }

	    public String historial() {
	        StringBuilder movimientos = new StringBuilder("");
	        int nAlquileres = 0;
	        int nReparaciones = 0;
	        int nVentas = this.estado == Patinete.Estado.VENDIDO ? 1 : 0;


	        try {
	            nAlquileres = this.alquileres.length;
	        } catch (NullPointerException var11) {
	            nAlquileres = 0;
	        }

	        try {
	            nReparaciones = this.reparaciones.length;
	        } catch (NullPointerException var10) {
	            nReparaciones = 0;
	        }
//Se almacena en el array operacioes el numero de alquileres, el numero de reparaciones y el numero de ventas.
	        //Si hay alquileres, se registran las reparaciones 
	        
	        String[] operaciones = new String[nAlquileres + nReparaciones + nVentas + 1];
	        LocalDate var10002 = this.fechaAdquisicion;
	        operaciones[0] = "" + var10002 + " Adquirido por " + this.getCategoria().getPrecioCoste();
	        int indiceReparacion;
	        int i;
	        if (nAlquileres > 0) {
	            indiceReparacion = 0;

	            for(i = 1; i <= nAlquileres; ++i) {
	                var10002 = this.alquileres[indiceReparacion].getFechaInicio();
	                operaciones[i] = "" + var10002 + " Alquilado por " + this.alquileres[indiceReparacion].getPrecioAlquiler();
	                ++indiceReparacion;
	            }
	        }

	        if (nReparaciones > 0) {
	            indiceReparacion = 0;

	            for(i = 1 + nAlquileres; i <= nAlquileres + nReparaciones; ++i) {
	                var10002 = this.reparaciones[indiceReparacion].getFecha();
	                operaciones[i] = "" + var10002 + " Reparado por " + this.reparaciones[indiceReparacion].getImporte();
	                ++indiceReparacion;
	            }
	        }
//SE registran fecha de venta, si la patinente fue alquilada y se realizo alguna reparación
	        if (nVentas > 0) {
	            int var10001 = nAlquileres + nReparaciones + nVentas;
	            var10002 = this.fechaVenta;
	            operaciones[var10001] = "" + var10002 + " Vendido por " + this.getPrecioVendido();
	        }
//los movimientos se integran con la información del array operaciones
	        Arrays.sort(operaciones);
	        String[] var14 = operaciones;
	        i = operaciones.length;

	        for(int var8 = 0; var8 < i; ++var8) {
	            String operacion = var14[var8];
	            movimientos.append(operacion).append("\n");
	        }

	        return movimientos.toString().substring(0, movimientos.length() - 2);
	    }
//Se imprime la información del patinente
	    public String toString() {
	        return this.nRef + " " + this.estado + " Adquirido: " + this.fechaAdquisicion + " KM Recorridos: " + this.kmAcumulados;
	    }

	    public static enum Estado {
	        DISPONIBLE,
	        ALQUILADO,
	        VENDIDO;

	        private Estado() {
	        }
	    }

}
