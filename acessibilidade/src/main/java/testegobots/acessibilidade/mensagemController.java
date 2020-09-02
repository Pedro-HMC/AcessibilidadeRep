package testegobots.acessibilidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mensagens")
public class mensagemController {

//Instanciando o Repositorio das mensagens e a classe que exibirá as mensagens
    @Autowired
    private mensagemRepository mensagemRepository;
    private exibeMensagens exibeMensagens = new exibeMensagens();

//Endereço da página "/mensagens/"
    @GetMapping("/")
    public @ResponseBody String getAllMensagens(){
//Retornando o nosso template
        return exibeMensagens.mostraMensagens(mensagemRepository.findAll());
    }

//Para que o "loop" criado na exibeMensagens possa funcionar criando novos elementos da classe mensagem e salvando-os no repositório
    @PostMapping("/")
    public @ResponseBody String novaMensagem(@RequestParam String mensagem){

        mensagens m = new mensagens();
        m.setMensagem(mensagem);
        mensagemRepository.save(m);
//Retornando o mesmo template, mas dessa vez com a nova mensagem inserida
        return exibeMensagens.mostraMensagens(mensagemRepository.findAll());
    }
}