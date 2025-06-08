data class Aluno(
    var nome: String,
    var nota1: Double,
    var nota2: Double
    ) {
    fun media(): Double = (nota1 + nota2) / 2

    fun status(): String = when {
        media() >= 7 -> "Aprovado"
        media() >= 5 -> "Recuperação"
        else -> "Reprovado"
         }
    }

    val alunos = mutableListOf<Aluno>()

    fun adicionarAluno(nome: String, nota1: Double, nota2: Double) {
    alunos.add(Aluno(nome, nota1, nota2))
    println("Aluno $nome adicionado com sucesso!")
    }

    fun listarAlunos() {
        if (alunos.isEmpty()) {
            println("Aluno não cadastrado!")
            return
        }
        println("Lista de Alunos")
        alunos.forEachIndexed { index, aluno ->
            println("${index + 1}. ${ aluno.nome } - Média: ${ aluno.media()} - Status: ${aluno.status()}")
    }
}

    fun atualizarAluno(index: Int, nome: String, nota1: Double, nota2: Double) {
        if (index in alunos.indices) {
            alunos[index] = Aluno(nome, nota1, nota2)
            println("Aluno atualizado com sucesso!")
        } else {
            println("Indice Inválido.")
    }
}

    fun removerAluno (index: Int) {
        if (index in alunos.indices) {
            val removido = alunos.removeAt(index)
            println("Aluno ${removido.nome} removido com sucesso!")
        } else {
            println("Índice Inválido.")
        }
}
    fun main() {
        while (true) {
            println("\n--- Sistema de Notas ---")
            println("1. Adicionar Aluno")
            println("2. Listar Aluno")
            println("3. Atualizar Aluno")
            println("4. Remover Aluno")
            println("5. Sair")
            print("Escolha uma opção: ")

            when (readLine()?.toIntOrNull()) {
                1 -> {
                    print ("Nome: ")
                    val nome = readLine().orEmpty()
                    print("Nota 1: ")
                    val nota1 = readLine()?.toDoubleOrNull() ?: 0.0
                    print ("Nota 2: ")
                    val nota2 = readLine()?.toDoubleOrNull() ?: 0.0
                    adicionarAluno(nome, nota1, nota2)
                }
                2 -> listarAlunos()
                3 -> {
                    listarAlunos()
                    print("Informe o número do aluno a ser atualizado: ")
                    val index = readLine()?.toIntOrNull()?.minus(1) ?: -1
                    print("Novo nome: ")
                    val nome = readLine().orEmpty()
                    print("Nova Nota 1: ")
                    val nota1 = readLine()?.toDoubleOrNull() ?: 0.0
                    print("Nova Nota 2: ")
                    val nota2 = readLine()?.toDoubleOrNull() ?: 0.00
                    atualizarAluno(index, nome, nota1, nota2)
                }
                4 -> {
                    listarAlunos()
                    print("Informe o número do Aluno a ser removido: ")
                    val index = readLine()?.toIntOrNull()?.minus(1) ?: -1
                    removerAluno(index)
                }
                5 -> {
                    print("Saindo")
                    break
                }
                else ->println("Opção Inválida")
            }
        }
    }