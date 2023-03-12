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
        setCPF(cpf);
        this.estadoCivil = estadoCivil;
        setCEP(cep);
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

    public void setCPF(String cpf) {
        if (!isValidCPF(cpf)) {
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

    public String getCEP() {
        return cep;
    }

    public void setCEP(String cep) {
        if (cep.matches("\\d{8}")) {
            this.cep = cep;
        } else {
            throw new IllegalArgumentException("CEP deve conter 8 dígitos numéricos.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PessoaFisica that = (PessoaFisica) o;

        return cpf.equals(that.cpf);
    }

    @Override
    public int hashCode() {
        return cpf.hashCode();
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", genero=" + genero +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    private boolean isValidCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
        }

        int firstSum = 0;
        for (int i = 0; i < 9; i++) {
            firstSum += digits[i] * (10 - i);
       
