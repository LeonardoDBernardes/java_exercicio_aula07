public class PessoaFisica {

    private String nome;
    private String sobrenome;
    private char genero;
    private int idade;
    private String cpf;
    private String estadoCivil;
    private String cep;

    public PessoaFisica(String nome, String sobrenome, char genero, int idade, String cpf, String estadoCivil, String cep) {
        setNome(nome);
        setSobrenome(sobrenome);
        setGenero(genero);
        setIdade(idade);
        setCpf(cpf);
        setEstadoCivil(estadoCivil);
        setCep(cep);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new NullPointerException("Nome não pode ser nulo");
        }
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        if (sobrenome == null) {
            throw new NullPointerException("Sobrenome não pode ser nulo");
        }
        this.sobrenome = sobrenome;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa");
        }
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!validarCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        if (estadoCivil == null) {
            throw new NullPointerException("Estado civil não pode ser nulo");
        }
        this.estadoCivil = estadoCivil;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep != null && cep.matches("\\d{8}")) {
            this.cep = cep;
        } else {
            throw new IllegalArgumentException("CEP inválido");
        }
    }

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