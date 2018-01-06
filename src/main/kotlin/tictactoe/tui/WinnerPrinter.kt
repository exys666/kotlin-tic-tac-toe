package tictactoe.tui

import tictactoe.core.Player

object WinnerPrinter {

    fun print(player: Player?) {
        player
                ?.also { System.out.println("Winner is player with symbol ${player.symbol}") }
                ?: System.out.println("No winner, the game ended in a draw")
    }
}
