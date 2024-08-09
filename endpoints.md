## Endpoints da API RESTful

### 1. Autenticação

#### **POST /api/auth/login**

Este endpoint é utilizado para autenticar um usuário e gerar um token JWT para acesso seguro aos outros endpoints.


  ![SIGN IN](img/auth/SIGN IN.png)

- **Response:**

  O token JWT retornado deve ser usado no header `Authorization` para chamadas subsequentes, como mostrado a seguir:

  ```http
  Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
  ```

---

#### **POST /api/users**

Este endpoint é utilizado para registrar um novo usuário na aplicação.

  ![SIGN UP](img/auth/SIGN UP.png)

---

### 2. Gerenciamento de Receitas

#### **GET /api/recipes**

Este endpoint recupera uma lista de todas as receitas disponíveis.


  ![GET ALL RECIPES](img/recipe/get-all-recipes.png)






#### **POST /api/recipes**

Este endpoint é utilizado para criar uma nova receita.

  ![CREATE RECIPE](img/recipe/create-recipe.png)

#### **PUT /api/recipes/{id}**

Este endpoint é utilizado para atualizar uma receita existente.


  ![UPDATED RECIPE](img/recipe/updated-recipe.png)

#### **DELETE /api/recipes/{id}**

Este endpoint é utilizado para deletar uma receita específica.

  ![DELETE RECIPE](img/recipe/delete-recipe.png)


🎯 **Seção de endpoints!** Agora você tem uma visão completa e exemplos claros para cada operação na API, incluindo ilustrações para facilitar o entendimento. Sinta-se à vontade para ajustar ou expandir conforme necessário!