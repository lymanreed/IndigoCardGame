class LewisCarrollBook {
    var name = ""
        get() {
            println("The name of the book is $field")
            return field
        }
        set(value) {
            println("Now, a book called $value")
            field = value
        }

    val author = "Lewis Carroll"
        get() {
            println("The author of the book is $field")
            return field
        }

    var price = 0
        set(value) {
            println("Putting a new price...")
            println("The new price is $value")
            field = value
        }
}
