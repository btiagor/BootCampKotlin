
fun main() {
    println("**************************************************************")
    println("\tBem Vindo ao primeiro modelo da Calc em Kotlin")
    println("\tDigite dois números reais e a opção da função desejada:")
    println("\t\tSOMA - Opcão 1")
    println("\t\tSUBTRAÇÃO - Opcão 2")
    println("\t\tMULTIPLICAÇÃO - Opcão 3")
    println("\t\tDIVISÃO - Opcão 4")
    println("\t\tFATORIAL - Opcão 5")
    println("\tExemplo: 4.5 3.7 1 -> Soma entre 4.5 + 3.7 = 8.2")
    println("\tOnde temos: num1 num2 opção - > resultado")
    println("**************************************************************")

    // expressão onde estão os dois dígitos separados com espaço e opção do menu
    val expression = "6.0 13.0 3"
    val num1:Float
    val num2:Float
    var first = 0
    var second = 0

    // o for me dá o posicionamento dos espaços em branco
    for(i in 0 until expression.length){
        if(expression[i] == ' '){
            if(first == 0){
                first = i
            }else if(second == 0){
                second = i
            }
        }
    }

    // com a posição dos espaços fica fácil fazer a captura e transformação dos valores
    num1 = expression.substring(0, first).toFloat()
    num2 = expression.substring(first, second).toFloat()
    val option = if(expression.length - second -1 > 1){
        expression.substring(second, expression.length -1).toInt()
    }else{
        expression[second + 1].toString().toInt()
    }

    // chamada da função passando os parâmetros obtidos anteriormente
    println(functions(num1, num2, option))
    myPrint("FIM DE EXECUÇÃO\n\t\t\t\t\t\tOBRIGADO!!!")

}

// função que funciona de chamada para as demais
fun functions(num1:Float, num2:Float, option:Int) =
    when(option){
        1 -> {
            myPrint("SOMA")
            "SOMA entre $num1 + $num2 = ${num1.plus(num2)}"
        }
        2 -> {
            myPrint("SUBTRAÇÃO")
            "SUBTRAÇÃO entre $num1 - $num2 = ${num1.minus(num2)}"
        }
        3 -> {
            myPrint("MULTIPLICAÇÃO")
            "MULTIPLICAÇÃO entre $num1 * $num2 = ${num1.times(num2)}"
        }
        4 -> {
            myPrint("DIVISÃO")
            if(num2 == 0.0F) "DIVISÃO por zero não é possível!!!" else "DIVISÃO entre $num1 / $num2 = ${num1.div(num2)}"
        }
        5 -> {
            myPrint("FATORIAL")
            println("OBS: Para a opção FATORIAL utilizamos apenas o primeiro número inserido e convertemos ele para Int\n")
            "FATORIAL ${num1.toInt()} = ${factorial(num1.toInt())}"
        }
        else -> "OPERAÇÃO DESCONHECIDA"

    }

// função fatorial
fun factorial(num1:Int):Int{
    var value = 1
    for(i in num1 downTo 1){
        value *= i
    }
    return value
}

// função print para deixar o código mas legível
fun myPrint(function:String){
    println("\n\n**************************************************************")
    println("\t\t\t\t\t\t$function")
    println("**************************************************************\n")
}
