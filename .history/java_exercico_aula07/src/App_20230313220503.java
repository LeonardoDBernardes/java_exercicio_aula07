public class App {
    public static void main(String[] args) throws Exception {
        Person pessoa1 = new Person("Asaph", "Souza", "15454545478", "Solteiro", "12345123", 'm', 26);
        pessoa1.setCpf("11144477735");
        System.out.println(pessoa1.toString());
        System.out.println(pessoa1.getCep());
    }
}


/**
 * Uma classe que serve para representar uma pessoa.
 * @param name O nome da pessoa;
 * @param lastName O Ultimo nome da pessoa;
 * @param cpf O cpf da pessoa, ele tem que ser validado com o metodo <a href="#{@link}"> {@link Person#setCep(String)} </a>
 * @author Turma T3
 * @see Person#setCpf
 */
class Person{
    private String name, lastName, cpf, maritalStatus, cep;
    private char gender;
    /**
     * Representa a idade da pessoa em anos
     */
    private int age;
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", lastName=" + lastName + ", cpf=" + cpf + ", maritalStatus=" + maritalStatus
                + ", cep=" + cep + ", gender=" + gender + ", age=" + age + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
        result = prime * result + gender;
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (maritalStatus == null) {
            if (other.maritalStatus != null)
                return false;
        } else if (!maritalStatus.equals(other.maritalStatus))
            return false;
        if (cep == null) {
            if (other.cep != null)
                return false;
        } else if (!cep.equals(other.cep))
            return false;
        if (gender != other.gender)
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    public Person(String name, String lastName, String cpf, String maritalStatus, String cep, char gender, int age) {
        try{
            this.name = name;
            this.lastName = lastName;
            this.cpf = cpf;
            this.maritalStatus = maritalStatus;
            this.setCep(cep);
            this.gender = gender;
            this.age = age;
        }catch (Exception e){
            throw new IllegalArgumentException("Verifique as informações inseridas");
        }

    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        // cpfChecker representa o cpf verificador
        String cpfChecker = cpf.substring(0,9);
        // multiplierNumber representa o numero a ser multiplicado para cada um dos digitos
        int multiplierNumber;
        // resultsTotal é uma variavel para guardar a soma das multiplicações
        int resultsTotal;

        //inicio loop
        //loop para navegar os 9 primeiros digitos e multiplicalos pelo multiplier number
        multiplierNumber = 10;
        resultsTotal = 0;
        for (int i = 0; i < cpfChecker.length(); i++) {
            int myDigit = Character.getNumericValue(cpfChecker.charAt(i));
            resultsTotal += myDigit * multiplierNumber;
            multiplierNumber--;
        }
        // se o resto de resultsTotal for menor que 2 entao o digito adicionado é 0
        //senão o digito adicionado é 11 menos o resto de resultsTotal
        if(resultsTotal%11 < 2 ){
            cpfChecker = cpfChecker + "0";
        }else{
            cpfChecker = cpfChecker + (11 - resultsTotal%11);
        }
        //fim loop

        //inicio loop
        //loop para navegar os 9 primeiros digitos e multiplicalos pelo multiplier number
        multiplierNumber = 11;
        resultsTotal = 0;
        for (int i = 0; i < cpfChecker.length(); i++) {
            int myDigit = Character.getNumericValue(cpfChecker.charAt(i));
            resultsTotal += myDigit * multiplierNumber;
            multiplierNumber--;
        }
        // se o resto de resultsTotal for menor que 2 entao o digito adicionado é 0
        //senão o digito adicionado é 11 menos o resto de resultsTotal
        if(resultsTotal%11 < 2 ){
            cpfChecker = cpfChecker + "0";
        }else{
            cpfChecker = cpfChecker + (11 - resultsTotal%11);
        }
        //fim loop

        //verifica se os cpfs(String) são iguais:
        if(!(cpf.equals(cpfChecker))){
            throw new IllegalArgumentException("CPF invalido");
        }

        // se tudo dar certo, define o cpf do objeto como o cpf passado
        this.cpf = cpf;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    /**
     * @deprecated
     * Retorna o cep da pessoa
     * @return o cep da pessoa
     * @see String
     */
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        if(cep == null){
            throw new IllegalArgumentException("CEP Invalido: CEP não pode ser nulo");
        }
        
        int cepSize = cep.length();

        if(cepSize != 8){
            throw new IllegalArgumentException("CEP Invalido: CEP Incompleto");
        }

        for (int i = 0; i < cepSize; i++) {
            char myChar = cep.charAt(i);
            if(!(myChar >= 48 && myChar <= 57)){
                throw new IllegalArgumentException("CEP Invalido: CEP somente deve conter numeros");
            }
        }

        // se tudo dar certo, define o cep do objeto como o cep passado
        this.cep = cep;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    
}