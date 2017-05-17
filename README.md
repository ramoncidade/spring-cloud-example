# spring-cloud-example
Exemplo de aplicação com spring cloud apenas para estudo

Executar todos os projetos com:
- Ter um redis rodando local
- mvn clean spring-boot:run

Endpoints
  - :9090 -> Eureka
  - :1010 -> Pants service
    - /pants/ -> Para ver os itens cadastrados
  - :2020 -> Shirts service
    - /shirt/ -> Para ver os itens cadastrados
  - :7070 -> Proxy
    - /outfit/[casual ou formal]
    
    Explain
     Ao chamar o proxy ele faz a chamada para os serviços, registrados no Eureka, e monta o retorno.
