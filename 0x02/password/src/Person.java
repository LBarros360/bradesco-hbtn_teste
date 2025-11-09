import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    public boolean checkUser(String s) {
        if (s.length() < 8) {
            System.out.println("Usuario inválido - O usuário deve ter no mínimo 8 caracteres");
            return false;
        } else if (verificarCaracteresEspeciaisUser(s)) {
            System.out.println("Usuario inválido - O usuário não deve conter caracteres especiais");
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkPassword(String s) {
        if (verificarCaracteresEspeciaisPass(s)) {
            System.out.println("Senha inválida");
            return true;
        } else {
            return false;
        }
    }

    public static boolean verificarCaracteresEspeciaisUser(String texto) {
        // Regex: [^a-zA-Z0-9\s] significa "qualquer caractere que não seja letra (maiúscula ou minúscula) ou número ou espaço em branco"
        Pattern padrao = Pattern.compile("[^a-zA-Z0-9\\s]");
        Matcher matcher = padrao.matcher(texto);
        return matcher.find();
    }

    public static boolean verificarCaracteresEspeciaisPass(String texto) {
        // Regex: [^a-zA-Z0-9\s] significa "qualquer caractere que não seja letra (maiúscula ou minúscula) ou número ou espaço em branco"
        Pattern padrao = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");
        Matcher matcher = padrao.matcher(texto);
        return matcher.find();
    }
}
