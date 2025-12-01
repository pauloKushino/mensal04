package util;

public class ValidadorCPF {
    public static boolean isCPFValido(String cpf) {
        // Implementação simplificada: verifica se tem 11 dígitos
        return cpf != null && cpf.matches("\\d{11}");
    }
}
