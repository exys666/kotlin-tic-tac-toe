package tictactoe

import tictactoe.core.Board
import tictactoe.core.HumanPlayer

fun main(args: Array<String>) {

    val hp1 = HumanPlayer('X')
    val b = Board(10)
    b[3,1] = hp1

    BoardPrinter.print(b)
}
