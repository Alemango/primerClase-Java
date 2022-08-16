import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import models.Cliente;

public class App {
    public static void main(String[] args) throws Exception {
        String nombre = "Juan";
        String frase = "Hola mi nombre es " + nombre;
        // System.out.println(frase);

        Integer edad = 25; // También se puede usar int
        frase = frase + " y tengo " + edad  + " años y voy a cumplir " + (edad + 1) + " años";
        // System.out.println(frase);

        // Booleanos + if
        Boolean esMayorDeEdad = edad >= 18;
        if(!esMayorDeEdad) {
            System.out.println(nombre + ", eres menor de edad.");
        } else {
            System.out.println(nombre + ", eres mayor de edad.");
        }

        //Booleanos + if + ingreso de datos por consola
        System.out.print("Checa la edad de alguien: ");
        String input = System.console().readLine(); // Lee una linea de texto
        Integer edadInput = Integer.parseInt(input); // Parsear un String a Integer
        Boolean esMayorDeEdadDos = edadInput >= 18;
        if(!esMayorDeEdadDos) {
            System.out.println("Eres menor de edad.");
        } else {
            System.out.println("Eres mayor de edad.");
        }

        //Ejercicio 1: Ingresar 3 números por consola y mostrar el mayor y el menor
        App.ejercicioUno(args);

        //Ejercicio 2: Calcular el promedio de 3 números ingresados por consola
        App.ejercicioDos(args);

        //Ejercicio 3: Verificar si un número es par o impar
        App.ejercicioTres(args);

        //Ejercicio 4: Verificar si un número es primo
        App.ejercicioCuatro(args);

        //Listas y arreglos
        App.agregarElementoALista(args);
        App.agregarElementoALista(args);
        App.agregarElementoALista(args);
        App.eliminarElementoALista(args);

        //POO
        App.setGetCliente(args);

        //Ejercicio 5: Crear una clase Cliente y una clase ClienteDao
        App.setGetCliente(args);
    }

    /* Ejercicio 1: Ingresar 3 números por consola y mostrar el mayor y el menor */
    private static void ejercicioUno(String[] args) {
        System.out.println("Ejercicio 1. Ingresa tres números diferentes.");
        Integer numero1 = App.ingresoNumero();    
        Integer numero2 = App.ingresoNumero();
        Integer numero3 = App.ingresoNumero();

        App.calcularNumeroMayor(numero1, numero2, numero3);
        App.calcularNumeroMenor(numero1, numero2, numero3);
    }    

    /* Ejercicio 2: Calcula el promedio de tres números */
    private static void ejercicioDos(String[] args) {
        System.out.println("Ejercicio 2. Ingresa tres números diferentes.");
        Integer numero1 = App.ingresoNumero();    
        Integer numero2 = App.ingresoNumero();
        Integer numero3 = App.ingresoNumero();

        System.out.println("El promedio de los tres números es " + App.promedioTresNumeros(numero1, numero2, numero3));
    }

    /* Ejercicio 3: Número par o impar */
    private static void ejercicioTres(String[] args){
        System.out.println("Ejercicio 3. Ingresa un número y te diré si es par o impar.");
        Integer numero = App.ingresoNumero();

        App.esParOImpar(numero);
    }

    /* Ejercicio 4: Primeros 100 números primos */
    private static void ejercicioCuatro(String[] args){
        System.out.println("Ejercicio 4. Primeros 100 números primos.");
        App.primeros100NumerosPrimos();
    }

    /* Función que recibe un número a través de consola */
    private static int ingresoNumero() {
        System.out.println("Ingresa un numero: ");
        String input = System.console().readLine(); // Lee una linea de texto
        Integer numero = Integer.parseInt(input); // Parsear un String a Integer
        return numero;
    } 
    
    /* Función que recibe texto desde la consola */
    private static String ingresoTexto() {
        System.out.println("Ingresa: ");
        String input = System.console().readLine(); // Lee una linea de texto
        return input;
    }

    /* Función que calcula el mayor de 3 números */
    private static void calcularNumeroMayor(Integer numero1, Integer numero2, Integer numero3) {
        Integer numeroMayor = numero1;
        if(numero2 > numeroMayor) {
            numeroMayor = numero2;
        }
        if(numero3 > numeroMayor) {
            numeroMayor = numero3;
        }
        System.out.println("El numero mayor es: " + numeroMayor);
    }

    /* Función que calcula el menor de 3 números */
    private static void calcularNumeroMenor(Integer numero1, Integer numero2, Integer numero3) {
        Integer numeroMenor = numero1;
        if(numero2 < numeroMenor) {
            numeroMenor = numero2;
        }
        if(numero3 < numeroMenor) {
            numeroMenor = numero3;
        }
        System.out.println("El numero menor es: " + numeroMenor);
    }

    /* Función que calcula el promedio de 3 números */
    private static float promedioTresNumeros(Integer numero1, Integer numero2, Integer numero3) {
        return (numero1 + numero2 + numero3) / 3;
    }

    /* Función para saber si un número es par o impar */
    private static void esParOImpar(Integer numero) {
        if(numero % 2 == 0) {
            System.out.println("El número es par");
        } else {
            System.out.println("El número es impar");
        }
    }

    /* Función para calcular los primeros 100 números primos */
    private static void primeros100NumerosPrimos() {
        int i = 1;
        while(i <= 100) {
            if(App.esPrimo(i)) {
                System.out.println(i);
            }
            i++;
        }
    }

    /* Función para saber si un número es primo */
    private static boolean esPrimo(int numero) {
        int i = 2;
        while(i < numero) {
            if(numero % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    static List<String> lista = new ArrayList<String>(); // Lista de Strings, para no preocuparnos por el tamaño de la lista/array

    /* Función para agregar elementos a la lista */
    private static void agregarElementoALista(String[] args){
        String nuevoElemento = App.ingresoTexto();
        lista.add(nuevoElemento);
        System.out.println(lista);
    }

    /* Función para eliminar elementos de la lista */
    private static void eliminarElementoALista(String[] args){
        System.out.println("Eliminar un elemento de la lista por su contenido(nombre exacto): ");
        String elementoAEliminar = App.ingresoTexto();
        lista.remove(elementoAEliminar);
        System.out.println(lista);
    }

    private static void setGetCliente(String[] args) throws SQLException {
        Cliente uno = new Cliente();
        System.out.println("Ingrese el nombre del cliente: ");
        uno.setNombre(App.ingresoTexto());
        System.out.println("Ingrese el apellido del cliente: ");
        uno.setApellido(App.ingresoTexto());
        System.out.println("Ingrese el email del cliente: ");
        uno.setEmail(App.ingresoTexto());
        System.out.println("Ingrese el telefono del cliente: ");
        uno.setTelefono(App.ingresoTexto());

        System.out.println(uno.getNombreCompleto() + " | " + uno.getEmail() + " | " + uno.getTelefono());

        ClienteDao dao = new ClienteDao();
        dao.agregar(uno);
        System.out.println(dao.listar().iterator().next().getNombreCompleto());
    }
}