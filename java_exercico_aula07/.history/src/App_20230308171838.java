public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

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
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
        setCEP(cep);
        setCPF(cpf);
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

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) throws IllegalArgumentException {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido");
        }

        int soma = 0;
        int resto;

        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(cpf.substring(i, i + 1)) * (i + 1);
        }

        resto = soma % 11;

        int digito1;

        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }

        soma = 0;

        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(cpf.substring(i, i + 1)) * (10 - i);
        }

        soma += digito1 * 2;

        resto = soma % 11;

        int digito2;

        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        String cpfValido = cpf.substring(0, 9) + digito1 + digito2;

        if (!cpfValido.equals(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
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

    public void setCEP(String cep) throws IllegalArgumentException {
        if (cep == null || cep.length() != 8) {
            throw new IllegalArgumentException("CEP inválido");
        }
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaFisica)) return false;
        PessoaFisica that = (PessoaFisica) o;
        return idade == that.idade && Objects.equals(nome, that.nome) && Objects.equals
