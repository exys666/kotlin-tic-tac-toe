package tictactoe.core

interface Player {

    val symbol: Char

    fun move(board: Board)
}
