import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuUsuarios {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();  
            switch (opcion) {
                case 1:
                    agregarUsuario();
                    break;
                case 2:
                    buscarUsuario();
                    break;
                case 3:
                    eliminarUsuario();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Agregar Usuario");
        System.out.println("2. Buscar Usuario");
        System.out.println("3. Eliminar Usuario");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void agregarUsuario() {
        System.out.print("Ingrese el nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nickname: ");
        String nickname = scanner.nextLine();
        System.out.print("Ingrese la clave: ");
        String clave = scanner.nextLine();
        System.out.print("Ingrese el tipo de usuario: ");
        String tipo = scanner.nextLine();
        System.out.print("Ingrese la fecha de creación (dd/MM/yyyy): ");
        String fecha = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(nombre, nickname, clave, tipo, fecha);
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario agregado exitosamente.");
    }

    public static void buscarUsuario() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.print("Ingrese el nickname del usuario que desea buscar: ");
        String nickname = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getDatos().get("Nickname").equals(nickname)) {
                System.out.println("Usuario encontrado: " + usuario);
                return;
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    public static void eliminarUsuario() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.print("Ingrese el nickname del usuario que desea eliminar: ");
        String nickname = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getDatos().get("Nickname").equals(nickname)) {
                usuarios.remove(usuario);
                System.out.println("Usuario eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Usuario no encontrado.");
    }
}
