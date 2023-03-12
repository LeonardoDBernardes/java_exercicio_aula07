import java.util.Objects;

public class PessoaFisica {

    private String nome;
    private String ultimoNome;
    private String genero;
    private int idade;
    private String cpf;
    private String estadoCivil;
    private String cep;

    public PessoaFisica(String nome, String ultimoNome, String genero, int idade, String cpf, String estadoCivil, String cep) {
        this.nome = nome;
        this.ultimoNome = ultimoNome;
        this.genero = genero;
        this.idade = idade;
        setCpf(cpf);
        this.estadoCivil = estadoCivil;
        setCep(cep);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
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
        if (validaCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
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
        if (cep.matches("\\d{8}")) {
            this.cep = cep;
        } else {
            throw new IllegalArgumentException("CEP inválido");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaFisica that = (PessoaFisica) o;
        return idade == that.idade && Objects.equals(nome, that.nome) && Objects.equals(ultimoNome, that.ultimoNome) && Objects.equals(genero, that.genero) && Objects.equals(cpf, that.cpf) && Objects.equals(estadoCivil, that.estadoCivil) && Objects.equals(cep, that.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, ultimoNome, genero, idade, cpf, estadoCivil, cep);
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + nome + '\'' +
                ", ultimoNome='" + ultimoNome + '\'' +
                ", genero='" + genero + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    private boolean validaCPF(String cpf) {
        if (cpf == null ||
