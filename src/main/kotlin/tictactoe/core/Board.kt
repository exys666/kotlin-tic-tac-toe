package tictactoe.core

class Board constructor(
        val size: Int
) {

    private val fields: Array<Array<Player?>> = Array(size) { Array(size) { null as Player? } }

    companion object {
        val MIN_SIZE = 3
        val MAX_SIZE = 10
    }

    init {
        if (size < MIN_SIZE) {
            throw IllegalArgumentException("Board size cannot be less than $MIN_SIZE")
        }
        if (size > MAX_SIZE) {
            throw IllegalArgumentException("Board size cannot be greater than $MAX_SIZE")
        }
    }

    val isFinished: Boolean
        get() = winner != null || fields.all { it.all { it != null } }

    val winner: Player?
        get() = columnWinner ?: rowWinner ?: diagonalWinner ?: contraDiagonalWinner

    private val columnWinner: Player?
        get() = fields.firstOrNull { isWinning(it) }?.let { it[0] }

    private val rowWinner: Player?
        get() = Array(size) { y -> Array(size) { x -> fields[x][y] } }.firstOrNull { isWinning(it) }?.let { it[0] }


    private val diagonalWinner: Player?
        get() = Array(size) { fields[it][it] }.let { if (isWinning(it)) it[0] else null }

    private val contraDiagonalWinner: Player?
        get() = Array(size) { fields[it][size - 1 - it] }.let { if (isWinning(it)) it[0] else null }


    private fun isWinning(line: Array<Player?>): Boolean
            = line[0] != null && line.all { it == line[0] }

    operator fun set(x: Int, y: Int, player: Player) {
        fields[x][y] = player
    }

    operator fun get(x: Int, y: Int): Player? = fields[x][y]
}
