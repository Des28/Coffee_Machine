package minesweeper

import kotlin.random.Random

var gamesField = arrayOf<Array<Char>>()
var games = arrayOf<Array<Char>>()
var x = 9
var y = 9
var mines = 0

fun main() {
    println("How many mines do you want on the field?")
    mines = readln().toInt()
    for (i in 0 until y) {
        var array = arrayOf<Char>()
        for (j in 0 until x) {
            array += '.'
        }
        gamesField += array
    }
    games = gamesField.map { it.clone() }.toTypedArray()
    gamesField(gamesField)
    games(games, gamesField, mines)

}

fun random() {
    var i = 0
    while (i in 0 until mines) {
        val x = Random.nextInt(0, 9)
        val y = Random.nextInt(0,9)
        if (gamesField[x][y] == '.') {
            gamesField[x][y] = 'X'
            i++
        }
    }
}

fun number (){
    var x = 0
    var y = 0
    while (x in 0..8) {
        while (y in 0..8) {
            if (gamesField[x][y] == 'A') gamesField[x][y] = '.'
            if (gamesField[x][y] == 'X') {
                try {
                    when {
                        gamesField[x][y - 1] == 'X' -> gamesField[x][y - 1] = 'X'
                        gamesField[x][y - 1] == '.' || gamesField[x][y - 1] == 'A'-> gamesField[x][y - 1] = '1'
                        gamesField[x][y - 1] in '1'..'9' -> gamesField[x][y - 1]++
                    }
                } catch (e: Exception) {
                    gamesField[x][y] = 'X'
                }
                try {
                    when {
                        gamesField[x][y + 1] == 'X' -> gamesField[x][y + 1] = 'X'
                        gamesField[x][y + 1] == '.' || gamesField[x][y + 1] == 'A'-> gamesField[x][y + 1] = '1'
                        gamesField[x][y + 1] in '1'..'9' -> gamesField[x][y + 1]++
                    }
                } catch (e: Exception) {
                    gamesField[x][y] = 'X'
                }
                try {
                    when {
                        gamesField[x - 1][y] == 'X' -> gamesField[x - 1][y] = 'X'
                        gamesField[x - 1][y] == '.' || gamesField[x - 1][y] == 'A' -> gamesField[x - 1][y] = '1'
                        gamesField[x - 1][y] in '1'..'9' -> gamesField[x - 1][y]++
                    }
                } catch (e: Exception) {
                    gamesField[x][y] = 'X'
                }
                try {
                    when {
                        gamesField[x + 1][y] == 'X' -> gamesField[x + 1][y] = 'X'
                        gamesField[x + 1][y] == '.' || gamesField[x + 1][y] == 'A'-> gamesField[x + 1][y] = '1'
                        gamesField[x + 1][y] in '1'..'9' -> gamesField[x + 1][y]++
                    }
                } catch (e: Exception) {
                    gamesField[x][y] = 'X'
                }
                try {
                    when {
                        gamesField[x + 1][y + 1] == 'X' -> gamesField[x + 1][y + 1] = 'X'
                        gamesField[x + 1][y + 1] == '.' || gamesField[x + 1][y + 1] == 'A' -> gamesField[x + 1][y + 1] = '1'
                        gamesField[x + 1][y + 1] in '1'..'9' -> gamesField[x + 1][y + 1]++
                    }
                } catch (e: Exception) {
                    gamesField[x][y] = 'X'
                }
                try {
                    when {
                        gamesField[x + 1][y - 1] == 'X' -> gamesField[x + 1][y - 1] = 'X'
                        gamesField[x + 1][y - 1] == '.' || gamesField[x + 1][y - 1] == 'A' -> gamesField[x + 1][y - 1] = '1'
                        gamesField[x + 1][y - 1] in '1'..'9' -> gamesField[x + 1][y - 1]++
                    }
                } catch (e: Exception) {
                    gamesField[x][y] = 'X'
                }
                try {
                    when {
                        gamesField[x - 1][y - 1] == 'X' -> gamesField[x - 1][y - 1] = 'X'
                        gamesField[x - 1][y - 1] == '.' || gamesField[x - 1][y - 1] == 'A' -> gamesField[x - 1][y - 1] = '1'
                        gamesField[x - 1][y - 1] in '1'..'9' -> gamesField[x - 1][y - 1]++
                    }
                } catch (e: Exception) {
                    gamesField[x][y] = 'X'
                }
                try {
                    when {
                        gamesField[x - 1][y + 1] == 'X' -> gamesField[x - 1][y + 1] = 'X'
                        gamesField[x - 1][y + 1] == '.' || gamesField[x - 1][y + 1] == 'A' -> gamesField[x - 1][y + 1] = '1'
                        gamesField[x - 1][y + 1] in '1'..'9' -> gamesField[x - 1][y + 1]++
                    }
                } catch (e: Exception) {
                    gamesField[x][y] = 'X'
                }
                y++
            } else y++
        }
        x++
        y = 0
    }
}

fun games(input: Array<Array<Char>>, location: Array<Array<Char>>, mines: Int) {
    var mina = 0
    var end = 0
    var one = 1
    while (mina != mines && end != mines) {
        println("Set/delete mine marks (x and y coordinates):")
        val str = readln().split(" ")
        val x = str[1].toInt() - 1
        val y = str[0].toInt() - 1
        when(str[2]) {
            "mine" -> {
                when {
                    location[x][y] == 'X' && input[x][y] == '.' -> {
                        input[x][y] = '*'
                        mina++
                    }
                    location[x][y] == 'X' && input[x][y] == '*' -> {
                        input[x][y] = '.'
                        mina--
                    }
                    input[x][y] == '.' -> {
                        input[x][y] = '*'
                        mina--
                    }
                    input[x][y] == '*' -> {
                        input[x][y] = '.'
                        mina++
                    }
                }
                gamesField(input)
            }
            "free" -> {
                if (one == 1) {
                    gamesOne(x, y)
                    one++
                }
                if (gamesField[x][y] == 'X') {
                    fail()
                    gamesField(input)
                    println("You stepped on a mine and failed!")
                    return
                }
                repeat(x,y)
                gamesField(input)
                end = end()
            }
        }
    }
    println("Congratulations! You found all the mines!")
}

fun gamesOne(x: Int, y: Int) {
        gamesField[x][y] = 'A'
    try {
        gamesField[x - 1][y] = 'A'
    } catch (e: Exception) {
        gamesField[x][y] = 'A'
    }
    try {
        gamesField[x + 1][y] = 'A'
    } catch (e: Exception) {
        gamesField[x][y] = 'A'
    }
    try {
        gamesField[x][y - 1] = 'A'
    } catch (e: Exception) {
        gamesField[x][y] = 'A'
    }
    try {
        gamesField[x][y + 1] = 'A'
    } catch (e: Exception) {
        gamesField[x][y] = 'A'
    }
    try {
        gamesField[x - 1][y - 1] = 'A'
    } catch (e: Exception) {
        gamesField[x][y] = 'A'
    }
    try {
        gamesField[x + 1][y - 1] = 'A'
    } catch (e: Exception) {
        gamesField[x][y] = 'A'
    }
    try {
        gamesField[x - 1][y + 1] = 'A'
    } catch (e: Exception) {
        gamesField[x][y] = 'A'
    }
    try {
        gamesField[x + 1][y + 1] = 'A'
    } catch (e: Exception) {
        gamesField[x][y] = 'A'
    }
    random()
    number()
}

fun gamesField(games: Array<Array<Char>>) {
    print(" │")
    for (i in 1..9) {
        print("$i")   }
    print("│")
    println()
    println("—│—————————│")
    var s = 1
    for (array in games) {
        print("$s│")
        for (value in array) {
            print("$value")
        }
        print("│")
        println()
        s += 1
    }
    println("—│—————————│")
    println()
}

fun outBounds(x: Int, y: Int): Boolean {
    return x < 0 || y < 0 || x >= 9 || y >= 9
}

fun repeat(x: Int, y: Int) {
    if(outBounds(x,y))return
    if(games[x][y] == '/')return
    if(gamesField[x][y] in '1'..'9') {
        games[x][y] = gamesField[x][y]
        return
    }
    if (gamesField[x][y] == '.') games[x][y] = '/'
    try {
        repeat(x-1, y)
    } catch (e: Exception) {
        return
    }
    try {
        repeat(x+1, y)
    } catch (e: Exception) {
        return
    }
    try {
        repeat(x, y-1)
    } catch (e: Exception) {
        return
    }
    try {
        repeat(x, y+1)
    } catch (e: Exception) {
        return
    }
    try {
        repeat(x-1, y-1)
    } catch (e: Exception) {
        return
    }
    try {
        repeat(x+1, y-1)
    } catch (e: Exception) {
        return
    }
    try {
        repeat(x-1, y+1)
    } catch (e: Exception) {
        return
    }
    try {
        repeat(x+1, y+1)
    } catch (e: Exception) {
        return
    }
}

fun end(): Int {
    var x = 0
    var y = 0
    var end = 0
    while (x in 0..8) {
        while (y in 0..8) {
            if (games[x][y] == '.') end++
            y++
        }
        x++
        y = 0
    }
    return end
}

fun fail() {
    var x = 0
    var y = 0
    while (x in 0..8) {
        while (y in 0..8) {
            if (gamesField[x][y] == 'X') games[x][y] = 'X'
            y++
        }
        x++
        y = 0
    }
}
