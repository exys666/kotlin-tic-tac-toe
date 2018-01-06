package tictactoe.tui

import java.util.*

object PlayerMoveConsole {

    val scanner = Scanner(System.`in`)

    fun printInfo() {
        System.out.println("Please chose your move by typing \"X Y\" or \"X,Y\"")
    }

    fun printErrorInvalidInput() {
        System.out.println("Invalid input, please try again")
    }

    fun printErrorFieldTaken() {
        System.out.println("Field already taken, please choose different move")
    }

    fun readInput(): String = scanner.nextLine()
}
