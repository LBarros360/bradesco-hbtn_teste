public class Pessoa {

    public static boolean emailValid(String email) {
        if (email.isEmpty()) {
            return false;
        } else if (!email.contains("@")) {
            System.out.println("Email Inválido -  O email não contem o caracter '@'");
            return false;
        } else if (email.length() > 50) {
            System.out.println("Email Inválido - O Email possui mais de 50 caracteres");
            return false;
        } else {
            System.out.println("Email Válido");
            return true;
        }
    }
}
