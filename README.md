### Estrutura de pacotes do projeto ###
Os pacotes são os seguintes:
    interfaces: Indica as interfaces que foram utilizadas. 
    entities: Indica as classes concretas, de acordo com a especificação do professor.
    creator: Pacote utilizado para lidar com os arquivos do padrão factory. 
    command: Pacote utilizado para lidar com os arquivos do padrão command.

Todos esses pacotes estão dentro do diretório src. 
A estrutura do projeto seria a seguinte:
    root
        Programa.java
        README.MD
        src
            command
                files...
            creator
                files...
            entities
                files...
            interfaces
                files...

### Explicando como que as classes e interfaces foram implementadas ###
Começando com as principais:
Usuario:
    -> Possui os atributos básicos, nome, telefone, status, foto.
    -> Possui alguns ArrayList, sendo eles:
        grupos: Indica quais grupos o usuário participa. 
        mensagem: Indica quais mensagens o usuário enviou.
        mensagensEcluidas: Indica quais mensagens que foram canceladas de cada usuário. 
    -> Possui dois maps que indicam:
        comandos: Indica quais comandos o usuário pode executar
        mensagenGrupo: Indica a visão do usuário em relação a cada grupo. Pode alterar de usuário para usuário.
    -> O usuário possui uma Interface chamada IUsuario que está no pacote interfaces. 

Mensagens:
    -> Possui os atributos básicos, autor, tipo da mensagens(tipoMsg), corpo da mensagem(corpoMsg), data de envio(dataEnvio).
    ->Possui um ArrayList
        visualizacaoMensagem: é uma lista do tipo Usuário que contém os usuários que visualizaram a mensagem.
    ->A mensagem possui uma interface chamada IMensagem que está no pacote de interfaces.

Grupos:
    ->Possui um atributo descricao.
    ->Possui 3 ArrayList
        usuarios: Indica os usuários pertencentes ao grupo
        mensagens: Indica as mensagens do grupo
        arrayAdm: Indica os administradores do grupo.
    ->O Grupo possui uma interface chamdad IGrupo que está no pacote de interfaces. 

### Explicando como que os padrões de projetos foram implementados ###
Possiveis comandos:
    -> "Enviar Mensagem"
    -> "Incluir Usuario"        (Só funciona se passar o adm como parâmetro)
    -> "Incluir Usuario Adm"    (Só o adm pode inserir algum outro adm)
    -> "Excluir Mensagem"

Explicando o command:
    -> O padrão de projeto command possui 4 partes que são importantes serem notadas. A primeira seria a interface command/Command.java. Nela está o método chamado executarComando(). Dentro do pacote command também está localizado os arquivos de comandos concretos, que no caso seria uma lógica de comando para cada arquivo. Dentro de cada arquivo de comando, existe um construtor, o que vai ser explicado melhor a baixo e também existe o método executarComando() que veio da interface. Neste método está contido a lógica de execução do comando. 

    -> Como cada comando é um objeto, é necessário fazer a instanciação deles e para isso existe no entities/Usuario.java duas coisas que deve ser levado em conta. Existe um atributo HashMap chamado comandos e um método chamado gerarComandos(). Esse gerar comandos pega uma string indicando o nome do comando e um objeto. Esse objeto seria uma instância do comando, um exemplo a seguir:
        -> comandos.put("Enviar Mensagem", new EnviarMensagemComando()); 
    -> O exemplo acima, iria salvar esse comando no HashMap comandos do usuario. Para fazer a execução dos comandos, é preciso instânciar o usuário na main do projeto e em seguida chamar o método de gerarComandos(). Após os comandos serem gerados, é possível fazer a execução deles, utilizando esse mesmo usuário. Um exemplo a seguinr:
        -> user.gerarComandos();
        -> user.nomeDoComando("Enviar Mensagem");
    
    -> Dessa forma que o padrão command está sendo utilizado no projeto. 

Explicando o factory:
    -> Como o padrão factory tem como objetivo retornar a instância de objetos. Ele foi separado no pacote creator, neste pacote existe dois tipos de arquivos. O primeio sendo Factory* e o outro sendo o C*, o asterisco seria o resto do nome do arquivo. O Factory* seria uma classe abstrata e um método abstrato que passaria os argumentos da criação do objeto, só varia o objeto de arquivo para arquivo. E o C* herda essa classe abstrata e retorna a instância desse objeto. 

Explicando observer:
    -> O Observador seria o Usuario e o Observado seria o Grupo e a Mensagem que o usuário envia serve como um notificador de que algo foi alterado. Cada vez que um usuário envia a mensagem o grupo faz a chamada um método chamado notificaObservadores, ele percorre todos os usuários que estão nos grupos e vai avisando todos que as mensagens do grupo foram atualizadas e envia essas novas mensagens para todos os usuarios pertencetes a esse grupo.

Observação:
    Existe um arquivo chamado run.sh, ele é um script utilizado para deletar todos os "*.class" e compilar usando o javac o projeto novamente.
