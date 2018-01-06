package tictactoe.core

import tictactoe.exception.InvalidConfigFileException
import java.io.IOException
import java.util.*

data class Config(
        val boardSize: Int,
        val humanPlayer1Symbol: Char,
        val humanPlayer2Symbol: Char,
        val computerPlayerSymbol: Char
) {

    companion object {

        fun read(path: String): Config {
            val prop = readFile(path)

            val humanPlayer1Symbol = getSymbol(prop, "player.human1.symbol")
            val humanPlayer2Symbol = getSymbol(prop, "player.human2.symbol")
            val computerPlayerSymbol = getSymbol(prop, "player.computer.symbol")

            if (arrayOf(humanPlayer1Symbol, humanPlayer2Symbol, computerPlayerSymbol).toSet().size < 3)
                throw InvalidConfigFileException("Player symbols are not unique")

            return Config(getBoardSize(prop), humanPlayer1Symbol, humanPlayer2Symbol, computerPlayerSymbol)
        }

        private fun readFile(path: String): Properties = try {
            Properties().also { prop ->
                this::class.java.getResourceAsStream(path)
                        ?.also { prop.load(it) } ?: throw InvalidConfigFileException("File not found")
            }
        } catch (ex: IOException) {
            throw InvalidConfigFileException("Unable to open config file")
        }

        private fun getBoardSize(prop: Properties): Int = try {
            prop.getProperty("board.size", "").toInt().also {
                if (it < Board.MIN_SIZE || it > Board.MAX_SIZE) throw InvalidConfigFileException("Invalid board size")
            }
        } catch (ex: NumberFormatException) {
            throw InvalidConfigFileException("Invalid board size")
        }

        private fun getSymbol(prop: Properties, key: String): Char
                = (prop.getProperty(key, "")
                .takeIf { it.length == 1 }
                ?: throw InvalidConfigFileException("Invalid $key"))
                .toCharArray().first()

    }


}
