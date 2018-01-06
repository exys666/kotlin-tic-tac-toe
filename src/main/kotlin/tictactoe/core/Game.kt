package tictactoe.core

import tictactoe.tui.BoardPrinter
import tictactoe.tui.ConsoleCleaner
import tictactoe.tui.CurrentPlayerPrinter
import tictactoe.tui.WinnerPrinter
import java.util.*

class Game private constructor(
        val players: Array<Player>,
        val board: Board,
        private var currentPlayerIndex: Int
) {

    constructor(players: Array<Player>, boardSize: Int)
            : this(players, Board(boardSize), Random().nextInt(players.size))

    val currentPlayer: Player
        get() = players[currentPlayerIndex]

    val winner: Player?
        get() = board.winner

    fun start() {
        while (!board.isFinished) {
            ConsoleCleaner.clean()
            BoardPrinter.print(board)
            CurrentPlayerPrinter.print(currentPlayer)
            currentPlayer.move(board)
            nextPlayer()
        }

        ConsoleCleaner.clean()
        BoardPrinter.print(board)
        WinnerPrinter.print(winner)
    }

    private fun nextPlayer() {
        currentPlayerIndex++
        currentPlayerIndex = if (currentPlayerIndex >= players.size) 0 else currentPlayerIndex
    }
}
