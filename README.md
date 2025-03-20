# 🦷 **Monitoramento de Saúde Bucal**

Bem-vindo ao **Monitoramento de Saúde Bucal**, um sistema web desenvolvido para ajudar usuários a cuidar da saúde bucal de forma divertida e recompensadora! Com funcionalidades como registro de hábitos bucais, geração de pontos e um marketplace para troca de recompensas, este projeto visa promover a saúde bucal de maneira engajadora.

---

## 🚀 **Funcionalidades**

- **Cadastro e Login de Usuários:**  
  Os usuários podem se cadastrar e fazer login no sistema.

- **Registro de Hábitos Bucais:**  
  Os usuários podem registrar hábitos bucais, como escovação e uso de fio dental, e ganhar pontos por isso.

- **Geração de Pontos:**  
  Cada hábito registrado gera pontos para o usuário, que podem ser acumulados.

- **Marketplace:**  
  Os pontos podem ser gastos no marketplace para adquirir recompensas, como escovas de dente, fio dental e enxaguantes bucais.

- **CRUD de Usuários e Hábitos:**  
  O sistema permite a criação, leitura, atualização e exclusão de usuários e hábitos bucais.

---

## 🛠️ **Tecnologias Utilizadas**

- **Backend:**
  - **Spring Boot:** Framework Java para desenvolvimento de aplicações web.
  - **Spring Data JPA:** Para integração com o banco de dados.
  - **Thymeleaf:** Para renderização de templates HTML.
  - **Oracle Database:** Banco de dados relacional para armazenamento de dados.

- **Frontend:**
  - **HTML5:** Estrutura das páginas.
  - **CSS3:** Estilização das páginas.
  - **Bootstrap:** Framework CSS para design responsivo.
  - **Thymeleaf:** Integração dinâmica de dados no frontend.

- **Ferramentas:**
  - **Maven:** Gerenciamento de dependências.
  - **Git:** Controle de versão.

---

## 📂 **Estrutura do Projeto**
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── saudebucal/
│   │           ├── controller/          # Controladores das rotas
│   │           ├── model/               # Entidades do banco de dados
│   │           ├── repository/          # Repositórios para acesso aos dados
│   │           ├── service/             # Lógica de negócio
│   │           └── SaudebucalApplication.java  # Classe principal
│   ├── resources/
│   │   ├── static/                      # Arquivos estáticos (CSS, imagens)
│   │   │   ├── css/
│   │   │   └── images/
│   │   ├── templates/                   # Templates Thymeleaf
│   │   │   ├── fragments/               # Fragmentos reutilizáveis
│   │   │   ├── usuarios/                # Páginas relacionadas a usuários
│   │   │   ├── habitos/                 # Páginas relacionadas a hábitos
│   │   │   ├── marketplace/             # Páginas do marketplace
│   │   │   ├── login.html               # Página de login
│   │   │   ├── registro.html            # Página de registro
│   │   │   └── index.html               # Página inicial
│   │   └── application.properties       # Configurações do projeto
└── test/                                # Testes unitários e de integração

## 📝 Endpoints da API

Método	Endpoint	               Descrição
GET	    /usuarios	               Lista todos os usuários.
GET	    /usuarios/novo	         Exibe o formulário de cadastro.
POST	  /usuarios/salvar	       Salva um novo usuário.
GET	    /usuarios/editar/{id}	   Exibe o formulário de edição.
POST	  /usuarios/editar/{id}	   Atualiza um usuário existente.
GET	    /usuarios/excluir/{id}	 Exclui um usuário.
GET	    /habitos	               Lista todos os hábitos bucais.
GET	    /habitos/novo	           Exibe o formulário de registro.
POST	  /habitos/salvar	         Salva um novo hábito.
GET	    /marketplace	           Lista os itens do marketplace.
POST	  /marketplace/comprar 	   Realiza a compra de um item.

## 👥 Participantes

Gabriel Artacho: RM553527
Gabriel Leal: RM553779
Átila Rebolo: RM552650

## 🤳 Diagrama

![image](https://github.com/user-attachments/assets/06baf8f1-e93d-4b54-bb62-ec8b87ccbe62)

