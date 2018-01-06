package tictactoe

import tictactoe.core.ComputerPlayer
import tictactoe.core.Config
import tictactoe.core.Game
import tictactoe.core.HumanPlayer
import tictactoe.exception.InvalidConfigFileException

fun main(args: Array<String>) {
    try {
        val config = Config.read("/application.properties")

        val humanPlayer1 = HumanPlayer(config.humanPlayer1Symbol)
        val humanPlayer2 = HumanPlayer(config.humanPlayer2Symbol)
        val computerPlayer = ComputerPlayer(config.computerPlayerSymbol)

        val game = Game(arrayOf(humanPlayer1, humanPlayer2, computerPlayer), config.boardSize)

        game.start()
    } catch (ex: InvalidConfigFileException) {
        System.out.println("Failed to load config file: ${ex.message}")
        System.exit(1)
    } catch (ex: Exception) {
        System.out.println("Program failed for unknown reason: $ex")
        System.exit(1)
    }
}
