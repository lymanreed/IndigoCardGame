fun parseCardNumber(cardNumber: String): Long {

    val invalid = "Invalid Card Number!"

    val cardNumberArray = cardNumber.split(" ")

    if (cardNumberArray.size != 4) {
        throw Exception(invalid)
//        return 0
    }

    for (part in cardNumberArray) {
        if (part.length != 4) {
            throw Exception(invalid)
//            return 0
        }
    }

    val numberString = cardNumberArray.joinToString("")

    if (numberString.length != 16) {
        throw Exception(invalid)
//        return 0
    }

    val number = numberString.toLongOrNull()
    if (number != null) {
        return number
    } else {
        throw Exception(invalid)
    }
}