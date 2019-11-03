package data

interface Data {
    fun get_rates(betrag: String, currency: String, targetcurrencies: List<String>): String
    fun display(
        betrag: String,
        currency: String,
        targetcurrencies: List<String>,
        calculatedrates: List<String>,
        date: String = "1970-01-01"
    ): String {
        var s = "<p>$betrag $currency entsprechen</p>"
        calculatedrates.indices.forEach { s += "<ul><li>${calculatedrates[it]}</li></ul>" }
        s += "<p>Stand: $date</p>"
        return s
    }
}