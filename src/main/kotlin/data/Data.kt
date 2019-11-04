package data

/**
 * Interface for strategies
 */
interface Data {

    /**
     * Gets the rates from the api or from local files
     *
     * @param betrag The amount of money to be converted
     * @param currency The currency of the money
     * @param targetcurrencies The currency(ies) that the money will be converted to
     * @return calls display with the calculatedrates
     */
    fun get_rates(betrag: String, currency: String, targetcurrencies: List<String>): String

    /**
     *Gets the rates from the api or from local files
     * @param betrag The amount of money to be converted
     * @param currency The currency of the money
     * @param targetcurrencies The currency(ies) that the money will be converted to
     * @return returns a formatted html string
     */
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