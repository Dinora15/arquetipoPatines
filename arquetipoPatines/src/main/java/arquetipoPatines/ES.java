package arquetipoPatines;

import java.util.*;

public class ES {
	
	public ES() {
    }

    public static int leeEntero() {
        boolean leido = false;
        int numero = 0;
        Scanner teclado = null;

        do { //se implementa una excepcion: en la situación que se digite un char que no sea número
            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                leido = true;
            } catch (Exception var4) {
                msgln("Error: No es un número entero válido. ");
            }
        } while(!leido); //se detiene cuando se teclea un número 
        
        return numero;
    }

    public static int leeEntero(String mensaje) {//Mensaje para advertir del Error de que no es un número
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;

        do {
            msgln(mensaje);

            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                leido = true;
            } catch (Exception var5) {
                msgln("Error: No es un número entero válido. ");
            }
        } while(!leido);//Se detiene el ciclo cuando se digite un número

        return numero;
    }

    public static int leeEntero(int minimo) {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;
//Se implementa una excepcion: cuando el número ingreado sea mayor que el minimo
        do {
            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                if (numero >= minimo) {
                    leido = true;
                } else {
                    msgln("Error: Debe ser un número entero mayor o igual que " + minimo + ". ");
                }
            } catch (Exception var5) {
                msgln("Error: No es un número entero válido. ");
            }
        } while(!leido); //Se detiene el ciclo cuando se ingresa un numero = o menor al minimo

        return numero;
    }

    public static int leeEntero(String mensaje, int minimo) {// clase que implementa el mensaje si el 
    	//numero ingresado es mayor al mínimo o no es número
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;

        do {
            msgln(mensaje);

            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                if (numero >= minimo) {
                    leido = true;
                } else {
                    msgln("Error: Debe ser un número entero mayor o igual que " + minimo + ".");
                }
            } catch (Exception var6) {
                msgln("Error: No es un número entero válido. ");
            }
        } while(!leido);//Se detiene el ciclo cuando el numero ingresado es igual o menor a minimo

        return numero;
    }

    public static int leeEntero(int minimo, int maximo) throws IllegalArgumentException {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;
        if (minimo > maximo) {
        	//Se implementa una excepción: si el minimo es mayor que el maximo
            throw new IllegalArgumentException("Rango imposible. El valor mínimo no puede ser mayor que el valor máximo");
        } else {
            do {
                try {
                    teclado = new Scanner(System.in);
                    numero = teclado.nextInt();
                    if (numero >= minimo && numero <= maximo) {
                        leido = true;
                    } else {
                        msgln("Error: Debe ser un número entero mayor o igual que " + minimo + " y menor o igual que " + maximo + ". ");
                    }
                } catch (Exception var6) {
                    msgln("Error: No es un número entero válido. ");
                }
            } while(!leido);//Se detiene el ciclo si se ingresa un número y el minimo es igual o menor máximo

            return numero;
        }
    }

    public static int leeEntero(String mensaje, int minimo, int maximo) throws IllegalArgumentException {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;
        //Mensaje de error cuando se ingresa un numero por teclado donde el minimo es mayor al maximo, o no es un número
        if (minimo > maximo) {
            throw new IllegalArgumentException("Rango imposible. El valor mínimo no puede ser mayor que el valor máximo");
        } else {
            do {
                msgln(mensaje);

                try {
                    teclado = new Scanner(System.in);
                    numero = teclado.nextInt();
                    if (numero >= minimo && numero <= maximo) {
                        leido = true;
                    } else {
                        msgln("Error: Debe ser un número entero mayor o igual que " + minimo + " y menor o igual que " + maximo + ". ");
                    }
                } catch (Exception var7) {
                    msgln("Error: No es un número entero válido. ");
                }
            } while(!leido); //El ciclo se repite hasta que es número y el minimo es igual o menor al máximo

            return numero;
        }
    }

    public static double leeDoble(String mensaje, boolean positivo) {
        double numero = 0.0;
        boolean leido = false;
        Scanner teclado = null;
//Se implementa una excepción cuando se ingrese un número que no sea positivo o no es un número double, o no es número
        do {
            msgln(mensaje);

            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextDouble();
                if (numero >= 0.0 == positivo) {
                    leido = true;
                } else {
                    msgln("Error: debe ser positivo. ");
                }
            } catch (Exception var7) {
                msgln("Error: No es un número doble válido. ");
            }
        } while(!leido);//El ciclo se interrumpe cuando es un número positivo y es un número double

        return numero;
    }

    public static String leeCadena() {
        Scanner teclado = new Scanner(System.in);
        String cadena = "";//Metodo que permite ingresar por teclado una cadena

        try {//Se implementa una excepción, en caso de ingresar datos que no son string
            cadena = teclado.nextLine();
        } catch (Exception var3) {
            msgln("Error: Ha fallado la entrada de datos.");
        }

        return cadena;
    }

    public static String leeCadena(String mensaje) {//Metódo estatico que implementa mensaje cuando se ingresan datos que no son cadena
        Scanner teclado = new Scanner(System.in);
        String cadena = "";

        try {
            msgln(mensaje);
            cadena = teclado.nextLine();
        } catch (Exception var4) {
            msgln("Error: Ha fallado la entrada de datos.");
        }

        return cadena;
    }

    public static void msg(int entero) {//Método para imprimir en consola el número entero
        System.out.print(entero);
    }

    public static void msg(long enteroLargo) {//Método para imprimir en consola un número entero Largo
        System.out.print(enteroLargo);
    }

    public static void msg(float real) {//Método para imprimir en consola un número decimal
        System.out.print(real);
    }

    public static void msg(double realLargo) {//Metódo para imprimir en consola un numero doble
        System.out.print(realLargo);
    }

    public static void msg(String cadenaAImprimir) {//Método para imprimir en consola una cadena
        System.out.print(cadenaAImprimir);
    }

    public static void msgln() {
        System.out.println();
    }

    public static void msgln(int entero) {
        System.out.println(entero);
    }

    public static void msgln(long enteroLargo) {
        System.out.println(enteroLargo);
    }

    public static void msgln(float real) {
        System.out.println(real);
    }

    public static void msgln(double realLargo) {
        System.out.println(realLargo);
    }

    public static void msgln(String cadenaAImprimir) {
        System.out.println(cadenaAImprimir);
    }

    public static String leeRespuesta(String mensaje) {//Mensaje de decidir s/n continuar con alguna acción
        boolean correcta = false;
        String cadena = "";
        Scanner teclado = null;

        do {
            msgln(mensaje);
//Se implementa una excepción: si se introduce un caracter diferente a S,s,N,n
            try {
                teclado = new Scanner(System.in);
                cadena = teclado.nextLine();
                if (cadena == null || cadena.length() != 1 || !cadena.equalsIgnoreCase("S") && !cadena.equalsIgnoreCase("N")) {
                    msgln("Error: Solo se admite como respuesta un Ãºnico carÃ¡cter, que debe ser 's', 'S', 'n' o 'N'.");
                } else {
                    correcta = true;
                }
            } catch (Exception var5) {
                msgln("Error: Ha fallado la entrada de datos.");
            }
        } while(!correcta);
//convierte el ingreso de los datos a letras mayúsculas
        return cadena.toUpperCase();
    }

}
