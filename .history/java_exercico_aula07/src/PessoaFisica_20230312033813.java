private boolean validarCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        if (cpf.matches("(\\d)\\1{10}")) { // Verifica se todos os dígitos são iguais
            return false;
        }
        String[] cpfInvalidos = {"00000000000", "11111111111", "22222222222", "33333333333", "44444444444",
            "55555555555", "66666666666", "77777777777", "88888888888", "99999999999"}; // Lista de CPFs inválidos
        for (String cpfInvalido : cpfInvalidos) {
            if (cpfInvalido.equals(cpf)) {
                return false;
            }
        }
        int[] multiplicadores1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] multiplicadores2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        String cpfSemDigito = cpf.substring(0, 9);
        String digito1 = calcularDigitoVerificador(cpfSemDigito, multiplicadores1);
        String digito2 = calcularDigitoVerificador(cpfSemDigito + digito1, multiplicadores2);
        return cpf.equals(cpfSemDigito + digito1 + digito2);
    }
}    