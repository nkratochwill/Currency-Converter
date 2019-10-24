package data

interface Data {
    fun get_rates()
    fun display(betrag: String, currency: String, targetcurrencies: Array<String>, date: String = "1970-01-01"): String {
        val s = """<p>$betrag $currency entsprechen</p>
                <ul><li>${targetcurrencies[0]}</li></ul>
            <p>Stand: $date</p>""".trimMargin()
        return s
    }
}