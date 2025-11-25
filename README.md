Aula 02/09/2025 e 08/09/2025

Diferença entre Arquitetura e Design:
- Arquitetura define a estrutura do software e os padrões que ele vai seguir.
- Design é a parte de como essa estrutura vai ser implementada.

Como é a formação do conhecimento de um arquiteto modelo T?
- Vale mais ter uma amplitude maior de conhecimento do que a especialização em um único tema.
- Saber mais de um panorama geral ajuda a tomar decisões melhores para cada situação.

Trade-Off
- Não existe resposta certa ou errada, apenas decisões baseadas em trade-offs.
- O arquiteto deve analisar os prós e contras de cada opção e escolher a melhor para a situação.
  
  Cenário: Sistema de leilão
  - Serviço Quem dá o lance gera e envia o valor do lance para três serviços:
    * Capturar lance
    * Rastrear lance
    * Analisar lance

  - Opções de comunicação entre serviços
    * Uso de Tópicos (modelo um para muitos)
      - Serviço conecta-se a um único tópico.
      - Novos serviços podem ser adicionados sem alterar os serviços existentes.
      - Entrega a mensagem uma vez e todos recebem.

    * Uso de Filas (modelo um para um)
      - Serviço precisa conectar-se a múltiplas filas.
      - Para adicionar um novo serviço é necessário criar uma nova fila e modificar o serviço para enviar mensagens para essa nova fila.
      - Entrega a mensagem individualmente para cada um.

Aula 26/08/2025 e 01/09/2025

Características da arquitetura:
- Requisitos não funcionais. (Impossível atender todos os requisitos)

Decisões da arquitetura:
- Definir a estrutura do sistema.

Princípios do design:
- Definir os princípios para construir o sistema.

Arquiteto:
- Orienta a equipe.
- Mantém o padrão do projeto.
- Analisa as mudanças do sistema.
- Toma as decisões difíceis.

Aula 05/08/2025, 11/08/2025 e 12/08/2025

SOLID:
- Usar a orientação a objetos da maneira correta.
  S - Classe com responsabilidade única.
  O - Uma classe deve estar fechada para modificações e aberta para extensões.
  L - Trocar uma chamada de uma classe filho por outra classe filho mantém a funcionalidade do código.
  I - Uso de interface para comunicação entre as classes. Evita comunicação direta entre elas.
  D - Classe deve depender de uma abstração e não de implementação concreta. (Controller -> <<Interface>> -> Service)
      - Evitar extends entre classe pai e filho onde a classe filho pode assumir o papel de outra classe filho.
      - O método deve usar somente os seguintes métodos: de sua própria classe, de objetos passados como parâmetros, de objetos criados pelo próprio método, de atributos do próprio método. (Não usar variáveis globais)

Aula 04/08/2025

Abstração:
- Representação de uma entidade de maneira simplificada.

Ocultamento de informação:
- Privar variáveis para proteção. Usado getter e setter para acessá-los em outros lugares.

Coesão:
- Faz uma funcionalidade bem feita. Facilitando a leitura e ajudando no manuseio do código.

Acoplamento:
- Força da conexão entre duas classes. Caso mexa em um código de A, pode afetar o código de B. (Herança, Implementação, Associação).

- ------------------------------------------------------------------------------------------ 29/09/2025 - 2ª BIMESTRE --------------------------------------------------------------------
https://learn.microsoft.com/pt-br/azure/architecture/patterns/circuit-breaker?wt.mc_id=AZ-MVP-5003638

CIRCUIT BREAKER
O padrão "Disjuntor" ajuda a lidar com falhas que podem demorar diferentes períodos para serem resolvidas quando um aplicativo depende de serviços ou recursos remotos. Quando essas falhas são detectadas, o disjuntor interrompe temporariamente o acesso ao serviço com problema. Isso evita tentativas repetidas e inúteis, permitindo que o sistema mantenha estabilidade e resiliência.

Quando um sistema A chama um sistema B, mas não se sabe se B está disponível, o Circuit Breaker atua como proteção — assim como um disjuntor elétrico.

Estados de um Disjuntor:

Fechado (Closed) – Tudo funciona normalmente. As chamadas são permitidas.

Aberto (Open) – Após uma falha, o disjuntor “abre” e impede novas chamadas ao sistema B por um tempo.

Semiaberto (Half-Open) – Após o tempo de espera, o sistema testa novamente o serviço.

Se falhar → volta para Open

Se funcionar → retorna para Closed
É um estado de alerta, semelhante a um relé térmico testando se pode religar.

------------------------------------------------------------------------------------------ 10/06/2025 - 2ª BIMESTRE ----------------------------------------------------------------------

Definição das características da arquitetura

Devem ser:

Fora do domínio do problema.

Influenciar diretamente o design do sistema.

Essenciais para o sucesso da aplicação.

Guiar decisões arquiteturais.

Impactar a qualidade final e previsibilidade do sistema.

Categorias de Características Arquiteturais

Operacionais:

Disponibilidade – Tempo que o sistema deve permanecer ativo.

Desempenho – Tempo de resposta, testes de carga e picos.

Escalabilidade – Suporte ao aumento de usuários e dados.

Confiabilidade – Funcionamento consistente mesmo sob falhas.

Recuperabilidade – Tempo para voltar ao normal após falhas.

Robustez – Capacidade de lidar com erros externos.

Estruturais:

Manutenção – Facilidade para alterar e melhorar.

Portabilidade – Rodar em diferentes plataformas.

Reutilização – Componentização e reaproveitamento.

Atualização – Facilidade para mudar versões.

Instalação – Setup simples em diferentes ambientes.

Transversais:

Segurança – Criptografia, controle de acesso.

Privacidade – Proteção contra acessos indevidos.

Autenticação e Autorização – Identificar e limitar acessos.

Acessibilidade – Suporte a usuários com deficiência.

Legalidade – Adequação a normas e leis.

Usabilidade – Facilidade de uso.

Armazenamento – Regras de retenção de dados.

Características Explícitas vs. Implícitas

Explícitas: Documentadas claramente nos requisitos.

Implícitas: Essenciais, mas dificilmente registradas.

Definições ISO

Eficiência do desempenho – Relação entre recursos utilizados e resposta entregue.

Compatibilidade – Integração com outros sistemas.

Confiabilidade – Estabilidade e tolerância a falhas.

Segurança – Proteção e rastreabilidade de dados.

Manutenibilidade – Alterações e testes facilitados.

Portabilidade – Adaptação para diferentes ambientes.

Usabilidade – Facilidade de aprendizado e operação.

------------------------------------------------------------------------------------------ 10/07/2025 - 2ª BIMESTRE ----------------------------------------------------------------------
https://learn.microsoft.com/pt-br/azure/architecture/patterns/cqrs

CQRS
(Command Query Responsibility Segregation)
Padrão que separa operações de leitura e escrita em modelos diferentes. Cada modelo pode ser otimizado de forma independente, aumentando desempenho, escalabilidade e segurança.

Utilizado quando a escalabilidade vertical chega ao limite.

Instância primária – Apenas escrita.

Réplica(s) de leitura – Apenas leitura.
A comunicação é assíncrona, portanto pode haver atraso entre escrita e réplica.

------------------------------------------------------------------------------------------ 10/09/2025 - 2ª BIMESTRE ----------------------------------------------------------------------
https://learn.microsoft.com/pt-br/azure/architecture/patterns/retry

Estratégias de Repetição (Retry)

Ao detectar falhas na comunicação com um serviço remoto, as estratégias são:

Cancelar – Se a falha não é transitória.

Tentar novamente imediatamente – Para erros raros, como pacotes corrompidos.

Retry com atraso – Quando falhas são por serviço ocupado ou problemas de rede. Ajuda a distribuir a carga e evitar sobrecarregar ainda mais o serviço.

A GRANDE BOLA DE LAMA

Padrão que descreve um sistema sem arquitetura clara, com forte acoplamento e difícil manutenção. Surge da falta de planejamento, tornando alterações arriscadas e complexas.

ARQUITETURA UNITÁRIA

Software rodando em um único computador.
Ex.: Sistemas embarcados (TVs, geladeiras, eletrodomésticos).

CLIENTE/SERVIDOR

O cliente solicita serviços; o servidor os fornece.
Ex.: Navegador pedindo páginas a um servidor web.

DESKTOP + SERVIDOR DE BANCO

(Cliente/Servidor/Database Centric)
A lógica fica no desktop e no banco (procedures). Atualizações exigem atualizar o banco e cada máquina.

NAVEGADOR + SERVIDOR WEB (Web 1.0)

Cliente recebe HTML estático.

WEB 2.0

Cliente recebe HTML + JSON, executa lógica (SPA).
Servidor web vira API REST.

------------------------------------------------------------------------------------------ 10/10/2025 - 2ª BIMESTRE ----------------------------------------------------------------------
https://learn.microsoft.com/pt-br/azure/architecture/patterns/retry

TRÊS CAMADAS

Arquitetura popular nos anos 1990 com separação em:

Banco de dados

Servidor de aplicação

Front-end (HTML/JS)

MONOLÍTICOS x DISTRIBUÍDOS

Monolito – Tudo em uma base de código única.

Distribuído – Funcionalidades espalhadas entre diferentes serviços.

LOG DISTRIBUÍDO

Registro consistente de eventos entre vários nós de um sistema.

TRANSAÇÕES DISTRIBUÍDAS

Garantem que todas as partes de uma operação sejam concluídas ou revertidas.

------------------------------------------------------------------------------------------ 20/10/2025 - 2ª BIMESTRE ----------------------------------------------------------------------

ARQUITETURA EM CAMADAS

Organização em níveis como apresentação, negócios, persistência e banco. Pode ser estrita (camadas acessam só a imediatamente inferior) ou relaxada (saltos permitidos).

Vantagens: organização, separação de responsabilidade, testes mais fáceis.
Desvantagens: pode se tornar rígida, difícil de escalar de forma independente e não ideal para arquiteturas distribuídas modernas.

------------------------------------------------------------------------------------------ 27/10/2025 - 2ª BIMESTRE ----------------------------------------------------------------------

PIPELINE

Sequência de etapas onde cada uma recebe entrada, processa e envia para a próxima. Ideal para fluxos contínuos, transformações e etapas encadeadas. Promove baixo acoplamento e alta coesão.

------------------------------------------------------------------------------------------ 11/03/2025 - 2ª BIMESTRE ----------------------------------------------------------------------

ARQUITETURA MICROKERNEL

Divide o sistema em:

Núcleo mínimo (core) – Funcionalidades essenciais.

Plugins – Estendem ou modificam o sistema sem afetar o núcleo.

Usado em plataformas extensíveis (IDEs, sistemas com customização).

------------------------------------------------------------------------------------------ 11/10/2025 - 2ª BIMESTRE ----------------------------------------------------------------------

ARQUITETURA DE MICROSSERVIÇOS

Sistema dividido em pequenos serviços independentes, cada um com sua função e seu próprio banco, comunicando-se via APIs.

Permite entregas contínuas, escalabilidade independente e alta autonomia das equipes. Ideal para sistemas grandes que continuam crescendo.
