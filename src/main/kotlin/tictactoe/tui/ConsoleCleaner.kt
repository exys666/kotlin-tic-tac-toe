package tictactoe.tui

object ConsoleCleaner {

    fun clean() = System.out.print("\u001B[H\u001B[2J")
}
