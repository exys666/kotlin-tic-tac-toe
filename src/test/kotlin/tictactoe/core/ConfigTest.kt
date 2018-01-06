package tictactoe.core

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import tictactoe.exception.InvalidConfigFileException

class ConfigTest {

    @Test
    fun `read() should throw InvalidConfigFileException if file not found`() {
        assertThrows(InvalidConfigFileException::class.java) {
            Config.read("/unknown.properties")
        }
    }

    @Test
    fun `read() should throw InvalidConfigFileException if board size is missing`() {
        assertThrows(InvalidConfigFileException::class.java) {
            Config.read("/missing-board-size.properties")
        }
    }

    @Test
    fun `read() should throw InvalidConfigFileException if board size too small`() {
        assertThrows(InvalidConfigFileException::class.java) {
            Config.read("/too-small-board.properties")
        }
    }

    @Test
    fun `read() should throw InvalidConfigFileException if board size too big`() {
        assertThrows(InvalidConfigFileException::class.java) {
            Config.read("/too-big-board.properties")
        }
    }

    @Test
    fun `read() should throw InvalidConfigFileException if player symbol is missing`() {
        assertThrows(InvalidConfigFileException::class.java) {
            Config.read("/missing-player-symbol.properties")
        }
    }

    @Test
    fun `read() should throw InvalidConfigFileException if player symbol is too short`() {
        assertThrows(InvalidConfigFileException::class.java) {
            Config.read("/too-short-player-symbol.properties")
        }
    }

    @Test
    fun `read() should throw InvalidConfigFileException if player symbol is too long`() {
        assertThrows(InvalidConfigFileException::class.java) {
            Config.read("/too-long-player-symbol.properties")
        }
    }

    @Test
    fun `read() should throw InvalidConfigFileException if player symbols are not unique`() {
        assertThrows(InvalidConfigFileException::class.java) {
            Config.read("/not-unique-player-symbols.properties")
        }
    }
}
