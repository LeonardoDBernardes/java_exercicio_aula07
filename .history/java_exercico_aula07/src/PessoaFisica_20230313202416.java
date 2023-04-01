public class App {
    public static void main(String[] args) throws Exception {
        Person pessoa1 = new Person("Asaph", "Souza", "15454545478", "Solteiro", "12345123", 'm', 26);
        pessoa1.setCpf("11144477705");
        System.out.println(pessoa1.toString());
    }
}

class Person{
    private String name, lastName, cpf, maritalStatus, cep;
    private char gender;
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
        String firstNine = cpf.substring(0,8);
        this.cpf = cpf;//breakpoint
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
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