package dominio.seguridad;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utilidad de seguridad para hash y verificación de contraseñas mediante SHA-256.
 * Buena práctica: Nunca almacenar contraseñas en texto plano.
 */
public final class SeguridadUtil {

    private SeguridadUtil() {
        // Constructor privado para clase de utilidades
    }

    /**
     * Genera un hash SHA-256 a partir de una contraseña en texto plano.
     */
    public static String hashearContrasena(String contrasenaPlana) {
        if (contrasenaPlana == null || contrasenaPlana.isBlank()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía.");
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(contrasenaPlana.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al instanciar el algoritmo de hash SHA-256", e);
        }
    }

    /**
     * Comprueba si una contraseña en texto plano coincide con el hash almacenado.
     */
    public static boolean verificarContrasena(String contrasenaPlana, String hashAlmacenado) {
        if (contrasenaPlana == null || hashAlmacenado == null) {
            return false;
        }
        String hashGenerado = hashearContrasena(contrasenaPlana);
        return hashGenerado.equalsIgnoreCase(hashAlmacenado);
    }
}

