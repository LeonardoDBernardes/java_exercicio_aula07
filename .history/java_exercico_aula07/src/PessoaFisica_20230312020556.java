public class PessoaFisica {
    private String nome;
    private String sobrenome;
    private Genero genero;
    private int idade;
    private String cpf;
    private EstadoCivil estadoCivil;
    private String cep;

    public PessoaFisica(String nome, String sobrenome, Genero genero, int idade, String cpf, EstadoCivil estadoCivil, String cep) {
        if (nome == null || nome.isEmpty() || sobrenome == null || sobrenome.isEmpty() || cpf == null || cpf.isEmpty() || cep == null || cep.isEmpty()) {
            throw new IllegalArgumentException("Campos obrigatórios não preenchidos.");
        }
        if (!isValidCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        if (!isValidCEP(cep)) {
            throw new IllegalArgumentException("CEP inválido.");
        }
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
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
        if (!isValidCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.cpf = cpf;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (!isValidCEP(cep)) {
            throw new IllegalArgumentException("CEP inválido.");
        }
        this.cep = cep;
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
                ",
