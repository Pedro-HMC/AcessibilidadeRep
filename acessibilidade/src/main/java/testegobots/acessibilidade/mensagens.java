package testegobots.acessibilidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Criando a classe mensagens com uma tabela no MySQL para guardar as mensagens em um banco de dados
@Entity
public class mensagens {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    String mensagem;

    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return this.mensagem;
    }
}