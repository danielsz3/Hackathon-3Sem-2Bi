# 🔵 Projeto HAKATOM UniAlfa 🔵
## Hackathon 3º Semestre | 2º Bimestre Faculdade UniAlfa

## 🔵 Descrição
  Nesse projeto sera feito o Hakatom que serve como forma de avaliação da faculdade UniAlfa, nesse Hakatom vamos ser avaliados dentro dos requisitos de todas as matérias que foram trabalhadas no decorrer do semestre, as matérias são:
  
  ➡️ Experiência do Usuário | UX
   
  ➡️ DevOps | Ferramentas para desenvolvimento
   
  ➡️ Desenvolvimento Web Avançado | PHP
   
  ➡️ Programação Orientada Objeto com Java | POO Java
   
  ➡️ Arquitetura de Computadores | EaD
   
  ➡️ Ferramentas Back-End | NodeJS
   

  Nessas matérias trabalhamos respectivamente com as funcionalidades relacionadas ao **Banco de dados**, funcionalidades de **Created**, **Read**, **Update**, **Delete** ou **CRUD**.

O sistema tem como finalidade facilitar as vacinações de idosos com dificuldade de mobilidade.

Na página principal do sistema o Usuário vai ter uma interface que mostra as vacinas disponíveis e que possibilita o usuário agendar uma visita para tomar essas vacinas sem necessitar se deslocar.

Na tela de ver agendamentos o usuário deve digitar o seu Número do SUS(CNS: que deve conter 15 dígitos e não pode conter letras ou caracteres especiais) para acessar as paginas relacionadas a cadastro ou agendamento. Haverá uma validação que pesquisa no banco se o Número do SUS existe no banco, se não existir o usuário será redirecionado para a tela de cadastro e informar os campos:

Nome Completo: que não poderá ter caracteres especiais e ter no mínimo 8 letras.

CPF: somente letras e deve ter 11 caracteres

Telefone: que não poderá ter letras e caracteres especiais, e deve ter 11 caracteres.

E-mail: que deverá conter o **@** e um **domínio**.

Nome do Cuidador: que não poderá ter caracteres especiais e ter no mínimo 4 letras.

Telefone do Cuidador: que não poderá ter letras e caracteres especiais, e deve ter 11 caracteres.

Após preencher esses dados, o usuário será redirecionado para uma tela de cadastro de endereço que ao digitar o CEP, os campos Logradouro, Bairro, Cidade e UF, serão preenchidos automaticamente. Os campos restantes deverão ser preenchidos manualmente.

CEP: deve ter 8 caracteres, não poderá ter caracteres especiais e nem letras.

Logradouro: deverá ter no mínimo 4 caracteres se houver.

Número: não poderá conter letras, deverá conter no mínimo 1 caractere.

 Bairro: deverá ter no mínimo 4 caracteres se houver.

Complemento: campo não obrigatório.

Cidade: não poderá conter caracteres especiais e deve ter no mínimo 4 letras.

UF: não poderá conter caracteres especiais e números, deve ter no mínimo 2 letras.

Após o preenchimento desses dados o usuário pode se cadastrar ou voltar, cadastrando o usuário é redirecionado para a tela de agendamento de visitas e poderá preencher o campo de data e hora. Que serão armazenados nos ícones que clicados vão mostrar os dias e os horários disponíveis e possibilitar o agendamento. 

Se acaso houver o número do SUS cadastrado anteriormente, o usuário será redirecionado para a tela que mostra seus agendamentos, possibilitando o usuário pesquisar os agendamentos por data, vacina e o posto de onde virá os agentes de saúde. Ou o usuário pode escolher voltar para a tela de ver agendamentos. 

No Cabeçalho da aplicação o usuário verá um ícone de notificações e poderá ver suas notificações que vão mostrar agendamentos feitos.  Na outra parte haverá um menu de sanduíche que ajuda na navegação entre as telas de acordo com sua lógica de acesso.

Na área do Acesso do profissional de saúde ele deverá fazer o acesso preenchendo os campos da tela de login, Código e Senha. Após o preenchimento o usuário será redirecionado para uma tela principal que possibilita ele acessar a lista de pacientes, vacinas e consultas.

Na tela de pacientes vai listar os pacientes que estão agendados. Clicando no ícone de olho, o agente pode visualizar as informações do idoso a ser visitado.  

Clicando na parte de vacinas, o agente pode visualizar as vacinas cadastradas. 

Clicando nas visitas, o agente poderá ver as visitas que foram feitas e qual o idoso visitado. Ao pressionar o ícone “+”, o agente poderá cadastrar a visita realizada. Os campos a serem preenchidos são:

CNS do Idoso: que deve conter 15 dígitos e não pode conter letras ou caracteres especiais.

Na parte de endereço que ao digitar o CEP, os campos Logradouro, Bairro, Cidade e UF, serão preenchidos automaticamente. Os campos restantes deverão ser preenchidos manualmente.

O agente deverá informar a vacina que foi aplicada e informar brevemente como foi a visita.