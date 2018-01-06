package tictactoe.core

import tictactoe.tui.PlayerMoveConsole

class HumanPlayer(
        override val symbol: Char
) : Player {

    override fun move(board: Board) {
        PlayerMoveConsole.printInfo()

        while (true) {
            val line = PlayerMoveConsole.readInput()
            val coords = parse(line)

            if (coords == null || coords.first >= board.size || coords.second >= board.size) {
                PlayerMoveConsole.printErrorInvalidInput()
                continue
            }

            if (board[coords.first, coords.second] != null) {
                PlayerMoveConsole.printErrorFieldTaken()
                continue
            }

            board[coords.first, coords.second] = this
            break
        }
    }

    private fun parse(line: String): Pair<Int, Int>?
            = line.trim()
            .takeIf { it.length == 3 }
            ?.let { Pair(it.substring(0, 1), it.substring(2, 3)) }
            ?.takeIf { it.first.matches(Regex("[0-9]")) && it.second.matches(Regex("[0-9]")) }
            ?.let { Pair(it.first.toInt(), it.second.toInt()) }

}
