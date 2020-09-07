# AcessibilidadeRep
Repositório para o teste prático de desenvolvimento

Instruções para execução do código:

**Backend**
1. Modificar o application.properties de acordo com o banco de dados que será usado. (Mudar o /mensagens para o schema que será utilizado, assim como o username e a password)
2. Rodar a aplicação pelo terminal digitando: ./mvnw spring-boot:run

**Frontend**
1. Inserir o endereço: http://localhost:8080/mensagens/
2. Digitar uma mensagem na caixa de mensagem indicada pelo site e clicar em enviar, logo depois a mensagem aparecerá na "Lista de Mensagens" e estará salva no banco de dados.

**Sobre a API**
Embora eu tenha realizado algumas tentativas para colocar a API de text-to-speech no site nenhuma realmente funcionou, por isso não está presente no código. Minha ideia era fazer aparecer um input "Ouvir" ao lado de cada mensagem da lista, que ao ser pressionado acionaria o speaker para reproduzir o áudio daquela string. Além disso, colocaria um input "Reproduzir todas" que reproduziria o áudio das strings pela ordem que aparecem na lista de mensagens.