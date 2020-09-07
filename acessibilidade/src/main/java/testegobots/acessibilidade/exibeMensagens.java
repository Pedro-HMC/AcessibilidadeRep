package testegobots.acessibilidade;
//Classe para criar o template da página. Aqui será definido o html da página junto com a função para formatação das mensagens.
public class exibeMensagens {
//String criada para receber a mensagem escrita com "internetês" e formatá-la para a linguagem padrão
   public static String traduzInternetes(String mensagem){
        mensagem = mensagem.replaceAll("td","tudo");
        mensagem = mensagem.replaceAll("bm","bem");
        mensagem = mensagem.replaceAll("eh","é");
        mensagem = mensagem.replaceAll("eh","é");
        mensagem = mensagem.replaceAll("q","que");
        mensagem = mensagem.replaceAll("obg","obrigado");
        mensagem = mensagem.replaceAll("vc","você");
        mensagem = mensagem.replaceAll("tb","também");
        mensagem = mensagem.replaceAll("qto","quanto");
        mensagem = mensagem.replaceAll("qnd","quando");

        return mensagem;
     }
//Ao tentar formatar "q" e "qto" ou "qnd" acabavam aparecendo mensagens como "queto ou quend", minha solução foi criar uma formatação específica para esses 2 casos e rodá-la por cima da anterior
   public static String traduzInternetes2(String mensagem){
    mensagem = mensagem.replaceAll("queto","quanto");
    mensagem = mensagem.replaceAll("quend","quando");

    return mensagem;
   }
//Aqui está sendo criado o HTML da página
    public String mostraMensagens(Iterable<mensagens> mensagens){
        String html =
"<!DOCTYPE html>"+
"<html lang=\"pt\">"+

"<head>"+
    "<meta charset=\"UTF-8\">"+
    "<title>GoBots</title>"+
//Links para usar o Bootstrap, CSS e para a fonte da página
    "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">"+
    "<link rel=\"stylesheet\" href=\"/mensagens.css\">"+
    "<link href=\"https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap\" rel=\"stylesheet\">"+
"</head>"+

"<body>"+
//Div do cabeçalho
    "<div class=\"row header\">"+
        "<div class=\"col\">"+
        "<img width=\"150\" height=\"106\" src=\"/logoGobots.jpg\">"+
        "</div>"+
        "<div class=\"col- titulo\">Teste Prático de Desenvolvimento</div>"+
        "<div class=\"col\"></div>"+
    "</div>"+
//Div para o input que receberá as mensagens junto com um texto auxiliar
    "<div class=\"row\">"+
        "<div class=\"col\"></div>"+
        "<div class=\"col- mb-5 mt-3\">"+
                "<form action=\"/mensagens/\" method=\"post\">"+
                    "<div class=\"row\">"+
                        "<div class=\"col\"></div>"+
                        "<div class=\"col- resumo\"><label for=\"mensagem\">Insira uma mensagem no campo abaixo:</label></div>"+
                        "<div class=\"col\"></div>"+
                    "</div>"+
                    "<div class=\"row\">"+
                        "<div class=\"col\"></div>"+
                        "<div class=\"col-\">" +
                            "<input type=\"text\" id=\"mensagem\" name=\"mensagem\">"+
                            "<input type=\"submit\" value=\"Enviar\" />"+
                        "</div>" +
                        "<div class=\"col\"></div>"+
                    "</div>"+
                "</form>"+
        "</div>"+
        "<div class=\"col\"></div>"+
    "</div>"+
//Div para iniciar a lista de mensagens
    "<div class=\"row bt\">"+
        "<div class=\"col TLista \"></div>"+
        "<div class=\"col- TLista \">Lista de Mensagens</div>"+
        "<div class=\"col TLista \"></div>"+
    "</div>"+
"</body>"+

"</html>";
//Essa foi a forma que encontrei para fazer as mensagens aparecerem sempre que enviadas pelo input sem precisar criar uma nova página html. O código abaixo funciona como um "loop", sempre que uma mensagem é enviada ocorre a criação de uma nova linha para inserir ela na página
    for(mensagens m : mensagens){
    html = html +
    "<div class=\"row mt-2\">"+
        "<div class=\"col\"></div>"+
        "<div class=\"col-\">"+
//Aqui a mensagem é recebida e formatada com as Strings criadas anteriormente. Uma rodando "sobre" a outra para que os textos sejam formatados corretamente
            "<h4>"+ traduzInternetes2(traduzInternetes(m.getMensagem())) +"</h4>"+
        "</div>"+
        "<div class=\"col\"></div>"+
    "</div>";
    }
    return html;
    }
}