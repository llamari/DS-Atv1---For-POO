public class Pessoa {
    // características
    private String nome;
    private int idade;
    private String email;

    // métodos construtores
    public Pessoa(int idade, String nome, String email){
        setIdade(idade);
        setNome(nome);
        setEmail(email);
    }
    // métodos de funcionalidade
        //SETTER
    public void setNome(String nome){
        this.nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setEmail(String email){
        this.email = email.toLowerCase();
    }
        //GETTER
    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getEmail(){
        return email;
    }
}