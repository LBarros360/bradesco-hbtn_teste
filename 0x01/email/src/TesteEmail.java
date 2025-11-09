import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteEmail {

    @Test
    void testar_email_com_arroba() {
        var isValid = Pessoa.emailValid("email_teste@dominio.com.br");
        Assertions.assertTrue(isValid);
    }

    @Test
    void testar_email_sem_arroba() {
        var isValid = Pessoa.emailValid("email_testedominio.com.br");
        Assertions.assertFalse(isValid);
    }

    @Test
    void testar_email_mais_50_caracteres() {
        var isValid = Pessoa.emailValid("email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br");
        Assertions.assertEquals(false, isValid);
    }
}
