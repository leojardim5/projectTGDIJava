public class Regex {
    private static final String REGEX_CNPJ = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$";
    private static final String REGEX_CPF = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";

    public static boolean cnpjValido(String cnpj) {
        return Pattern.matches(REGEX_CNPJ, cnpj);
    }

    public static boolean cpfValido(String cpf) {
        return Pattern.matches(REGEX_CPF, cpf);
    }
}
