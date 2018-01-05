package tictactoe.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class BoardTest {

    @Test
    fun `Board initialization should failed if size is less than 3`() {
        assertThrows(IllegalArgumentException::class.java) {
            Board(2)
        }
    }

    @Test
    fun `Board initialization should failed if size is greater than 10`() {
        assertThrows(IllegalArgumentException::class.java) {
            Board(11)
        }
    }

    @Test
    fun `Board should be initialized empty`() {
        // given
        val board = Board(10)

        // then
        for(x in 0 until board.size) {
            for (y in 0 until board.size) {
                assertThat(board[x, y]).isNull()
            }
        }

        assertThat(board.isFinished).isFalse()
    }

    @Test
    fun `Board should set Player on given field`() {
        // given
        val board = Board(3)
        val player = HumanPlayer('X')

        // when
        board[1, 2] = player

        // then
        assertThat(board[1, 2]).isEqualTo(player)
    }

    @Test
    fun `Board should be finished if no more empty space`() {
        // given
        val board = Board(3)

        // when
        for(x in 0 until board.size) {
            for (y in 0 until board.size) {
                board[x, y] = HumanPlayer('X')
            }
        }

        // then
        assertThat(board.isFinished).isTrue()
    }

    @Test
    fun `Board should not be finished if has at least one empty space`() {
        // given
        val board = Board(10)

        // when
        for(x in 0 until board.size - 1) {
            for (y in 0 until board.size) {
                board[x, y] = HumanPlayer('X')
            }
        }

        for (y in 0 until board.size - 1) {
            board[board.size - 1, y] = HumanPlayer('X')
        }

        // then
        assertThat(board.isFinished).isFalse()
    }

    @Test
    fun `Board should have winner if horizontal line is occupied by one player`() {
        // given
        val board = Board(10)
        val player = HumanPlayer('X')

        // when
        for(x in 0 until board.size) {
            board[x, 3] = player
        }

        // then
        assertThat(board.winner).isEqualTo(player)
        assertThat(board.isFinished).isTrue()
    }

    @Test
    fun `Board should have winner if vertical line is occupied by one player`() {
        // given
        val board = Board(10)
        val player = HumanPlayer('X')

        // when
        for(y in 0 until board.size) {
            board[7, y] = player
        }

        // then
        assertThat(board.winner).isEqualTo(player)
        assertThat(board.isFinished).isTrue()
    }

    @Test
    fun `Board should have winner if diagonal line is occupied by one player`() {
        // given
        val board = Board(10)
        val player = HumanPlayer('X')

        // when
        for(i in 0 until board.size) {
            board[i, i] = player
        }

        // then
        assertThat(board.winner).isEqualTo(player)
        assertThat(board.isFinished).isTrue()
    }

    @Test
    fun `Board should have winner if contra diagonal line is occupied by one player`() {
        // given
        val board = Board(10)
        val player = HumanPlayer('X')

        // when
        for(i in 0 until board.size) {
            board[i, board.size - 1 - i] = player
        }

        // then
        assertThat(board.winner).isEqualTo(player)
        assertThat(board.isFinished).isTrue()
    }

}
