package util;

public class ValidadorCPF {
    public static boolean isCPFValido(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }
}
