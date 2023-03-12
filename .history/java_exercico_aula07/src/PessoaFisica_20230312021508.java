import java.util.Objects;

public class PessoaFisica {
    
    private String nome;
    private String sobrenome;
    private char genero;
    private int idade;
    private String cpf;
    private String estadoCivil;
    private String cep;

    public PessoaFisica(String nome, String sobrenome, char genero, int idade, String cpf, String estadoCivil, String cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.idade = idade;
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
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
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!validarCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.cpf = cpf;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep != null && cep.matches("\\d{8}")) {
            this.cep = cep;
        } else {
            throw new IllegalArgumentException("CEP inválido.");
        }
    }

    private boolean validarCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        int[] multiplicadores1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] multiplicadores2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        String cpfSemDigito = cpf.substring(0, 9);
        String digito1 = calcularDigitoVerificador(cpfSemDigito, multiplicadores1);
        String digito2 = calcularDigitoVerificador(cpfSemDigito + digito1, multiplicadores2);
        return cpf.equals(cpfSemDigito + digito1 + digito2);
    }

    private String calcularDigitoVerificador(String cpfParcial, int[] multiplicadores) {
        int soma = 0;
        for (int i = 0; i < cpfParcial.length(); i++) {
            soma += Integer.parseInt(String.valueOf(cpfParcial.charAt(i))) * multiplicadores[i];
        }
        int resto = soma % 11;
        if (resto < 2) {
            return "0";
        } else {
            return String.valueOf(11 - resto);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
