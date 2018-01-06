package tictactoe.core

import tictactoe.tui.BoardPrinter

class Game private constructor(
        val players: Array<Player>,
        val board: Board,
        private var currentPlayerIndex: Int = 0
) {

    constructor(players: Array<Player>, boardSize: Int) : this(players, Board(boardSize))

    val currentPlayer: Player
        get() = players[currentPlayerIndex]

    val winner: Player?
        get() = board.winner

    fun start() {
        while (!board.isFinished) {
            BoardPrinter.print(board)
            currentPlayer.move()
            nextPlayer()
        }
    }

    private fun nextPlayer() {
        currentPlayerIndex = if (currentPlayerIndex >= players.size) 0 else currentPlayerIndex++
    }
}
