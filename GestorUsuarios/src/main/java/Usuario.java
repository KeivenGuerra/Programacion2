import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private Map<String, String> datos;

    public Usuario(String nombreCompleto, String nickname, String clave, String tipo, String fechaCreacion) {
        this.datos = new HashMap<>();
        datos.put("Nombre Completo", nombreCompleto);
        datos.put("Nickname", nickname);
        datos.put("Clave", clave);
        datos.put("Tipo", tipo);
        datos.put("Fecha Creación", fechaCreacion);
    }

    public String buscarDato(String key) {
        return datos.getOrDefault(key, "Dato no encontrado.");
    }

    public boolean eliminarDato(String key) {
        if (datos.containsKey(key)) {
            datos.remove(key);
            return true;
        }
        return false;
    }

    public Map<String, String> getDatos() {
        return datos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreCompleto='" + datos.get("Nombre Completo") + '\'' +
                ", nickname='" + datos.get("Nickname") + '\'' +
                ", clave='" + datos.get("Clave") + '\'' +
                ", tipo='" + datos.get("Tipo") + '\'' +
                ", fechaCreacion='" + datos.get("Fecha Creación") + '\'' +
                '}';
    }
}
