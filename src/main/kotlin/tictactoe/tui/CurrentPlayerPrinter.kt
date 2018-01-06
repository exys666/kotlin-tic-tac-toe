package tictactoe.tui

import tictactoe.core.Player

object CurrentPlayerPrinter {

    fun print(player: Player) {
        System.out.println("Current player with symbol ${player.symbol}")
    }
}
