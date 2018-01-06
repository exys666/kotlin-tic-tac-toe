package tictactoe.core

import java.util.*

class ComputerPlayer(
        override val symbol: Char
) : Player {

    override fun move(board: Board) {
        var random = Random() // TODO move random

        while (true) {
            val x = random.nextInt(board.size)
            val y = random.nextInt(board.size)

            if (board[x, y] == null) {
                board[x, y] = this
                break
            }
        }
    }
}
