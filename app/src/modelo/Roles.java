package modelo;
import java.util.Scanner;

public class Roles {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de roles");
        System.out.println("Seleccione un rol:");
        System.out.println("1. Admin");
        System.out.println("2. Usuario");
        System.out.println("3. Invitado");
        String[] rol = {"Admin", "Usuario", "Invitado"};
        for (String r : rol) {
            System.out.println("Rol: " + r);
        }

        
        int seleccion = scanner.nextInt();
            scanner.nextLine(); 
            if (seleccion > 3 || seleccion < 1) {
                System.out.println("Seleccion no valida");
            } else {
                System.out.println("Rol seleccionado: " + rol[seleccion - 1]);
            }

        System.out.println("ingrese su nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Nombre: " + nombre);

        
    
    }
};