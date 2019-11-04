package data

import org.json.JSONObject
import java.io.File

/**
 * Strategy for fetching rates from local json file
 */
class OfflineData : Data {
    /**
     * Fetches rates from local json file
     *
     * @param betrag The amount of money to be converted
     * @param currency The currency of the money
     * @param targetcurrencies The currency(ies) that the money will be converted to
     * @return calls display with the calculatedrates
     */
    override fun get_rates(betrag: String, currency: String, targetcurrencies: List<String>): String {
        val api = File("src/main/resources/OfflineData.json").readText()
        val json = JSONObject(api)
        val calculatedrates = mutableListOf<String>()

        /* checks whether the the initial currency is EURO
            if true  -> multiply amount with targeted currency rate
            if false -> divide amount with original currency rate and afterwards multiply with targeted currency rate
         */
        when (currency == "EUR") {
            true -> targetcurrencies.forEach {
                val targetrate = json.getJSONObject("rates").getFloat(it)
                calculatedrates.add((betrag.toFloat() * targetrate).toString() + " $it (Kurs: $targetrate)")
            }
            false -> targetcurrencies.forEach {
                val targetrate: Float
                val currencyrate: Float
                with(json.getJSONObject("rates")) {
                    targetrate = getFloat(it)
                    currencyrate = getFloat(currency)
                }
                calculatedrates.add((betrag.toFloat() / currencyrate * targetrate).toString() + " $it (Kurs: ${targetrate / currencyrate})")
            }
        }
        return super.display(
            betrag, currency, targetcurrencies, calculatedrates, date = json.get("date").toString()
        )
    }
}
