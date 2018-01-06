package tictactoe.tui

import tictactoe.core.Board

object BoardPrinter {

    fun print(board: Board) {
        System.out.print("  ")
        for (i in 0 until board.size) {
            System.out.print("  $i ")
        }
        System.out.println()

        printHorizontalLine(board.size)

        for (y in 0 until board.size) {
            System.out.print("$y ")
            for (x in 0 until board.size) {
                System.out.print("| ${board[x, y]?.symbol ?: " "} ")
            }
            System.out.println("|")

            printHorizontalLine(board.size)
        }
    }

    private fun printHorizontalLine(size: Int) {
        System.out.print("  ")
        repeat(size) {
            System.out.print("----")
        }
        System.out.println("-")
    }
}
