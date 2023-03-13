package arquetipoPatines;


/**
 * Esta clase Driver define principalmente el comportamiento de pantalla para manejar 
 * la aplicación Tienda de patinetes.
 *
 */
public class Driver {
	
	static Tienda miTienda = new Tienda();
	
	 public Driver() {
	    }

	 /**
     	* The main function of the program.
     	*     	
     	* @param args Pass arguments to the program when it is executed     	   	
     	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 ES.msgln("Gestión de Tienda\n\n");
	        int opcion = 0;
	        do {
	            opcion = ES.leeEntero("***** Menú principal *****\n1. Comprar patinete\n2. Alquilar patinete\n3. Devolver patinete alquilado\n4. Reparar patinete\n5. Vender patinete\n6. Balance general de la tienda\n7. Balance de un patinete\n8. Historial de un patinete\n0. Fin", 0, 8);
	            switch (opcion) {
	                case 0:
	                default:
	                    break;
	                case 1:
	                    Comprar();
	                    break;
	                case 2:
	                    Alquilar();
	                    break;
	                case 3:
	                    Devolver();
	                    break;
	                case 4:
	                    Reparar();
	                    break;
	                case 5:
	                    Vender();
	                    break;
	                case 6:
	                    BalanceGeneral();
	                    break;
	                case 7:
	                    BalancePatinete();
	                    break;
	                case 8:
	                    HistorialPatinete();
	            }
	        } while(opcion != 0);

	    }

	/**
     	* The Comprar function allows the user to buy a certain number of patinets from a given category.
     	* The function first asks for the category, then it asks for how many patinets are wanted and finally it calls
     	* the Comprar method in Tienda.java with those parameters. It also prints out how many were actually bought (which may be less than what was asked).
     	*/
	    static void Comprar() {
	        int opcion = 0;

	        do {
	            opcion = ES.leeEntero("***** Submenú Comprar *****\n1. Categoría Básica\n2. Categoría Estándar\n3. Categoría Premium\n0. Salir Submenú Comprar", 0, 3);
	            if (opcion == 0) {
	                ES.msgln("Se ha anulado la compra\n");
	            } else {
	                Categoria cat = Categoria.values()[opcion - 1];
	                int cuantos = ES.leeEntero("***** Submenú comprar patinete de categoría " + cat + " *****\n¿Cuántos quiere comporar (0 para anular)? ", 0);
	                int compradosEfectivamente = miTienda.Comprar(cuantos, cat);
	                ES.msgln("######     Se han comprado " + compradosEfectivamente + " de categoría " + cat);
	                MostrarEstadoTienda();
	            }
	        } while(opcion != 0);

	    }

	/**
     	* The Alquilar function allows the user to rent a bike from the store.
     	* The user can choose between renting a bike of any category, or one of three specific categories: Basic, Standard and Premium.
     	* If there are no bikes available for rental in the chosen category (or if there are no bikes available at all), an error message is displayed.
     	*/
	    static void Alquilar() {
	        int opcion = 0;

	        do {
	            opcion = ES.leeEntero("***** Submenú Alquilar *****\n1. Categoría Básica\n2. Categoría Estándar\n3. Categoría Premium\n4. Cualquier categoria\n0. Salir o Submenú Alquilar", 0, 4);
	            if (opcion == 0) {
	                ES.msgln("Se ha anulado el alquiler\n");
	            } else {
	                String patAlquilado;
	                if (opcion == 4) {
	                    try {
	                        patAlquilado = miTienda.Alquilar();
	                    } catch (Exception var4) {
	                        patAlquilado = var4.getMessage();
	                    }
	                } else {
	                    try {
	                        Categoria cat = Categoria.values()[opcion - 1];
	                        patAlquilado = miTienda.Alquilar(cat);
	                    } catch (Exception var3) {
	                        patAlquilado = var3.getMessage();
	                    }
	                }

	                ES.msgln("######     Se ha alquilado: " + patAlquilado);
	                MostrarEstadoTienda();
	            }
	        } while(opcion != 0);

	    }

	/**
     	* The Devolver function allows the user to return a rented scooter.
     	* The function asks for the reference number of the scooter and how many kilometers it has traveled.
     	* If no kilometers have been traveled, then it cancels out of this function and returns to main menu.
     	* Otherwise, if there are more than 0 km's traveled, then it will call on Devolver from Tienda class
     	* which will check if that reference number exists in our array list or not. If so, then we update its status
     	* as well as add those km's to its total mileage counter (kmTotal). 
     	*
     	*/
	    static void Devolver() {
	        String respuesta = "Se ha anulado la devolución";
	        String codigo = ES.leeCadena("Introduzca el Número de Referencia del patinete a devolver: ");
	        double kmRecorridos = ES.leeDoble("Introduzca el número de KMs que ha recorrido (0 para cancelar): ", true);
	        if (kmRecorridos == 0.0) {
	            ES.msgln(respuesta);
	        } else if (kmRecorridos > 0.0) {
	            respuesta = miTienda.Devolver(codigo, kmRecorridos);
	            if (respuesta.equals(codigo)) {
	                ES.msgln(respuesta + " ha sido devuelto");
	            } else {
	                ES.msgln(respuesta);
	            }
	        }

	        MostrarEstadoTienda();
	    }

	/**
     	* The Reparar function allows the user to repair a scooter by entering its reference number and the cost of repairing it.
     	* If the cost is 0, then no repairs are made. Otherwise, if it's greater than 0, then repairs are made and a message is displayed on screen.
     	*/
	    static void Reparar() {
	        String respuesta = "Se ha anulado la reparación";
	        String codigo = ES.leeCadena("Introduzca el Número de Referencia del patinete a reparar: ");
	        double coste = ES.leeDoble("Introduzca el coste de la reparación (0 para cancelar): ", true);
	        if (coste == 0.0) {
	            ES.msgln(respuesta);
	        } else if (coste > 0.0) {
	            respuesta = miTienda.Reparar(codigo, coste);
	            if (respuesta.equals(codigo)) {
	                ES.msgln(respuesta + " ha sido reparado por " + coste + "€");
	            } else {
	                ES.msgln(respuesta);
	            }
	        }

	        MostrarEstadoTienda();
	    }

	 /**
     	* The Vender function allows the user to sell a scooter.
     	* The function asks for the reference number of the scooter, and then checks if it is in stock.
     	* If it is, then it asks for confirmation from the user before selling it at its current price.
     	*/
	    static void Vender() {
	        String respuesta = "Se ha anulado la venta";
	        String codigo = ES.leeCadena("Introduzca el Número de Referencia del patinete a vender: ");

	        try {
	            double precio = miTienda.getPrecioVenta(codigo);
	            String deAcuerdo = ES.leeCadena("¿Está de acuerdo en venderlo por " + precio + "€? (s/n): ");
	            if (deAcuerdo.equalsIgnoreCase("s")) {
	                miTienda.Vender(codigo);
	                respuesta = codigo + " ha sido vendido por " + precio + "€";
	            }
	        } catch (Exception var5) {
	            respuesta = respuesta + ". " + var5.getMessage();
	        }

	        ES.msgln(respuesta);
	        MostrarEstadoTienda();
	    }

	
	/**
    	* The BalanceGeneral function prints the balance general of the store.
     	*/
	    static void BalanceGeneral() {
	        String respuesta = miTienda.balanceGeneral();
	        MostrarMensajeConAlmohadillas(respuesta);
	        MostrarEstadoTienda();
	    }

	
	/**
     	* The BalancePatinete function allows the user to balance a Patinete.
     	* The function asks for the reference number of the Patinete, and then calls
     	* miTienda.balancePatinete(codigo) to perform this action. If codigo is 0,
     	* it cancels instead of balancing a Patinete. It then displays an appropriate message
     	* using MostrarMensajeConAlmohadillas() and refreshes the screen with MostrarEstadoTienda().
     	*/
	    static void BalancePatinete() {
	        String respuesta = "Se ha cancelado";
	        String codigo = ES.leeCadena("Introduzca el Número de Referencia del patinete (0 para cancelar): ");
	        if (!codigo.equals("0")) {
	            respuesta = miTienda.balancePatinete(codigo);
	        }

	        MostrarMensajeConAlmohadillas(respuesta);
	        MostrarEstadoTienda();
	    }
	

	 /**
     	* The HistorialPatinete function allows the user to view the history of a given scooter.
     	* The function asks for a reference number, and if it is not 0, then it will display
     	* all of the information about that scooter's history. If 0 is entered, then nothing happens.
     	*/	
	    static void HistorialPatinete() {
	        String respuesta = "Se ha cancelado";
	        String codigo = ES.leeCadena("Introduzca el Número de Referencia del patinete (0 para cancelar): ");
	        if (!codigo.equals("0")) {
	            respuesta = miTienda.historialPatinete(codigo);
	        }

	        MostrarMensajeConAlmohadillas(respuesta);
	        MostrarEstadoTienda();
	    }
	

	 /**
     	* The MostrarEstadoTienda function displays the current state of the store.
     	* It prints out a header, then calls toString() on miTienda and prints that out,
     	* then it prints another footer.
     	*/
	    private static void MostrarEstadoTienda() {
	        ES.msgln("######     Estado de la tienda      ######");
	        ES.msgln(miTienda.toString());
	        ES.msgln("######     Fin estado de la tienda  ######");
	    }

	/**
     	* The MostrarMensajeConAlmohadillas function prints a message surrounded by #'s.
     	*
     	* @param mensaje Display a message to the user
     	*
     	*/
	    private static void MostrarMensajeConAlmohadillas(String mensaje) {
	        ES.msgln("#####################################################");
	        ES.msgln(mensaje);
	        ES.msgln("#####################################################");
	    }

	}


