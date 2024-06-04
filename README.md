<h1 align="center"> 🍜 RamenGO </h1>
<p align="center">
     <a alt="Java">
        <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
    </a>
  <a alt="Maven">
    <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white"/>
  </a>
    <a alt="Postgres">
        <img src="https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white" />
    </a>
    <a alt="Spring">
        <img src="	https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
    </a>
    <a alt="Spring Security">
        <img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white" />
    </a>
    <a alt="AWS S3">
        <img src="https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white">
    </a>
</p>
<h2>📝 Descrição </h2>
Bem-vindo ao projeto RamenGo! Este é um sistema de gerenciamento de pedidos para um restaurante especializado em ramen. O projeto é composto por dois microserviços:

1. `RamenGo Orders Service`: Este microserviço é responsável por lidar com o processamento de pedidos e a comunicação com os clientes.

2. `RamenGo Admin Service`: Este microserviço complementar fornece funcionalidades administrativas, como o gerenciamento de produtos e imagens do cardápio.


> [!Warning]
> Este projeto contém dois microserviços interdependentes: RamenGo Orders Service e RamenGo Admin Service. Certifique-se de iniciar ambos os serviços para garantir o funcionamento correto do sistema.

 📮: [Collection - Postman](ramenGO.postman_collection.json)


<h2>🚀 Entregáveis</h2>

A API possui os seguintes endpoints:

```markdown
POST /orders - Cria um novo pedido
GET /proteins - Lista proteins
GET /broths - Lista broths
```

**BODY**
```json
{
    "brothId": 1,
    "proteinId": 1
}
```

[Link da aplicação rodando](https://redventures.onrender.com)



<h2>Recursos adicionais</h2>

> [!Important]
> Para acessar o repositório: [Repositório - ramenGO-manager](https://github.com/silvadebora/ramengo-manager)

Além dos entregáveis, o projeto também conta com outro microserviços, sendo nele possível fazer a inserção de protein e broth. 
Entretanto, para acessar esses endpoints é necessário realizar o registro e login, para assim ter acesso ao token que permite
a a inserção de protein e broth.



<h2>💻 Arquitetura</h2>

[Link da arquitetura](https://whimsical.com/ramengo-WHtVQoiNLnqNv85ytmXywg)

<h2>💻 Configuração</h2>

<table align="center">
	<td>Linguagem</td>
	<td>Java</td>
</tr>
<tr>
	<td>Framework</td>
	<td>Spring Boot</td>
</tr>
<tr>
	<td>Build Tool</td>
	<td>Maven</td>
</tr>
<tr>
	<td>Banco de Dados</td>
	<td>PostgreSQL</td>
</tr>
<tr>
	<td>Test</td>
	<td>JUnit e Mockito</td>
</tr>
<tr>
	<td>Java Version</td>
	<td>17</td>
</tr>
</table>

<hr> 

<a href = "mailto:contatodeboravicente@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
<a href="https://www.linkedin.com/in/deborasilvadlvs" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
