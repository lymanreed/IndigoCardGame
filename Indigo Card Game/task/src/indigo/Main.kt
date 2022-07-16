package indigo

fun main() {

    println("Indigo Card Game")

    // who goes first?
    var firstPlayer = "user"
    while (true) {
        println("Play first?")
        when (readln().lowercase()) {
            "yes" -> break
            "no" -> {
                firstPlayer = "computer"
                break
            }
            else -> continue
        }
    }

    val deck = makeDeck()
    val user = mutableListOf<String>()
    val computer = mutableListOf<String>()
    val table = mutableListOf<String>()

    val userCards = mutableListOf<String>()
    val computerCards = mutableListOf<String>()

    var currentPlayer = firstPlayer
    var lastWinner = firstPlayer

    repeat(4) {
        table.add(deck.removeFirst())
    }
    println("Initial cards on the table: ${table.joinToString(" ")}")

    var quitFlag = false
    while (deck.size > 0) {
        repeat(6) {
            user.add(deck.removeFirst())
            computer.add(deck.removeFirst())
        }
        computer.sortBy { it.last() }
        while (user.size > 0 || computer.size > 0) {
            println()
            if (table.size == 0) {
                println("No cards on the table")
            } else {
                println("${table.size} cards on the table, and the top card is ${table.last()}")
            }
            if (currentPlayer == "user") {
                showCards(user)
                while (true) {
                    println("Choose a card to play (1-${user.size}):")
                    val choice = readln()
                    if (choice.lowercase() == "exit") {
                        quitFlag = true
                        break
                    }
                    if (choice.toIntOrNull() in 1..user.size) {
                        val chosenCard = user[choice.toInt() - 1]
                        if (table.size > 0 && checkMatch(chosenCard, table.last())) {
                            userCards.addAll(table)
                            table.clear()
                            userCards.add(user.removeAt(choice.toInt() - 1))
                            println("Player wins cards")
                            lastWinner = "user"
                            showScores(userCards, computerCards, firstPlayer)
                        } else {
                            table.add(user.removeAt(choice.toInt() - 1))
                        }
                        break
                    }
                }
            } else {
                for (card in computer) print("$card ")
                println()
                val chosenCard = computerChoosesCard(computer, table)
                println("Computer plays $chosenCard")
                if (table.size > 0 && checkMatch(chosenCard, table.last())) {
                    computerCards.addAll(table)
                    table.clear()
                    computer.remove(chosenCard)
                    computerCards.add(chosenCard)
                    println("Computer wins cards")
                    lastWinner = "computer"
                    showScores(userCards, computerCards, firstPlayer)
                } else {
                    computer.remove(chosenCard)
                    table.add(chosenCard)
                }
            }
            if (quitFlag) break
            currentPlayer = if (currentPlayer == "user") "computer" else "user"
        }
        if (quitFlag) break
    }

    println()
    if (!quitFlag) {
        if (table.size == 0) {
            println("No cards on the table")
        } else {
            println("${table.size} cards on the table, and the top card is ${table.last()}")
        }
        if (lastWinner == "user") {
            userCards += table
        } else {
            computerCards += table
        }
        showScores(userCards, computerCards, firstPlayer, true)
    }
    println("Game Over")
}

fun showCards(cards: List<String>) {
    print("Cards in hand: ")
    cards.forEachIndexed { index, card ->
        print("${index + 1})$card ")
    }
    println()
}

    fun showScores(userWins: MutableList<String>, computerWins: MutableList<String>,
               playedFirst: String, last: Boolean = false) {
    var userScore = 0
    var computerScore = 0
    if (last) {
        if (userWins.size > computerWins.size) {
            userScore += 3
        } else if (computerWins.size > userWins.size) {
            computerScore += 3
        } else {
            if (playedFirst == "user") userScore += 3
            else computerScore += 3
        }
        println()
    }

    val winners = listOf('A', '1', 'J', 'Q', 'K')

    print("Score: ")
    for (card in userWins) {
        if (card[0] in winners) {
            userScore += 1
        }
    }

    print("Player $userScore - ")
    for (card in computerWins) {
        if (card[0] in winners) {
            computerScore += 1
        }
    }
    println("Computer $computerScore")

    println("Cards: Player ${userWins.size} - Computer ${computerWins.size}")
}

fun checkMatch(playerCard: String, tableCard: String): Boolean {
    return playerCard.first() == tableCard.first() || playerCard.last() == tableCard.last()
}

fun makeDeck(): MutableList<String> {

    val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    val suits = listOf("♦", "♥", "♠", "♣")
    val cards = mutableListOf<String>()

    for (s in suits) {
        for (r in ranks) {
            cards.add("$r$s")
        }
    }

    return cards.shuffled().toMutableList()
}

fun computerChoosesCard(computerCards: List<String>, tableCards: List<String>): String {

//    println(computerCards)
    if (computerCards.size == 1) return computerCards.first()

    if (tableCards.isEmpty()) return emptyTable(computerCards)

    val candidateCards = computerCards.filter {
        it.last() == tableCards.last().last() || it.first() == tableCards.last().first()
    }
    
    if (candidateCards.isEmpty()) return emptyTable(computerCards)

    if (candidateCards.size == 1) return candidateCards.first()

    val multipleSuites = candidateCards.filter { it.last() == tableCards.last().last() }
    if (multipleSuites.size > 1) return multipleSuites.first()

    val multipleRanks = candidateCards.filter { it.first() == tableCards.last().first() }
    if (multipleRanks.size > 1) return multipleRanks.first()

    return candidateCards.first()

}

fun emptyTable(computerCards: List<String>): String {
    for (i in 0 until computerCards.size - 1)
        if (computerCards[i].last() == computerCards[i + 1].last())
            return computerCards[i]

    val checkCards = computerCards.sortedBy { it.first() }
    for (i in 0 until checkCards.size - 1)
        if (checkCards[i].first() == checkCards[i + 1].first())
            return checkCards[i]

    return computerCards.first()

}