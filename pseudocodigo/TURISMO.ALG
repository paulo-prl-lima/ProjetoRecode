Algoritmo "turismo"

procedimento menu
inicio
   escreval()
   escreval()
   escreval("-------------------------------------------")
   escreval("   Seja bem vindo a Turismo Nordeste!      ")
   escreval("-------------------------------------------")
   escreval("---------Selecione a op��o Desejada--------")
   escreval("1: Cadastro Cliente e Pacote de Turismo")
   escreval("2: Relat�rio")
   escreval("0: Sair")
   leia(opcao)
   escreval()
   escreval()
fimprocedimento


Var

   nome, cpf, telefone, endereco, pacotes : vetor[1..3] de caracter
   i: inteiro
   opcao: caracter

Inicio

   repita
      menu
      //cadastrar usu�rio e pacote
      se (opcao = "1") entao
         para i de 1 ate 3 faca
            escreval("------------------------")
            escreval("Dados do", i ,"� cliente")
            escreval("------------------------")
            escreval("Cadastre o nome")
            leia (nome[i])
            escreval("Cadastre o cpf")
            leia (cpf[i])
            escreval("Cadastre o telefone")
            leia (telefone[i])
            escreval("Cadastre o endere�o")
            leia (endereco[i])
            escreval("Cadastre o pacotes: (Recife, Natal, Maragogi, Joao Pessoa)")
            leia (pacotes[i])
            escreval()
         fimpara
      fimse

      //relat�rio do cadastro
      se (opcao = "2") entao
         escreval("---------------------------------------")
         escreval("---------------Relat�rio---------------")
         escreval("---------------------------------------")
         para i de 1 ate 3 faca
            escreval("------------------------")
            escreval(i ,"� Cliente")
            escreval("------------------------")
            escreval("Nome: ", nome[i]," CPF: ",cpf[i]," Telefone: ",telefone[i], " Endere�o: ",telefone[i]," Pacote: ",pacotes[i])
         fimpara
      fimse
   ate opcao = "0"

Fimalgoritmo