package data

import org.json.JSONObject
import java.net.URL

/**
 * Strategy for fetching rates from https://exchangeratesapi.io
 */
class OnlineData : Data {

    /**
     * Fetches rates from https://api.exchangeratesapi.io/latest
     *
     * @param betrag The amount of money to be converted
     * @param currency The currency of the money
     * @param targetcurrencies The currency(ies) that the money will be converted to
     * @return calls display with the calculatedrates
     */
    override fun get_rates(betrag: String, currency: String, targetcurrencies: List<String>): String {
        val api = URL("https://api.exchangeratesapi.io/latest?base=$currency").readText()
        val json = JSONObject(api)
        val calculatedrates = mutableListOf<String>()
        targetcurrencies.forEach {
            val rate = json.getJSONObject("rates").getFloat(it)
            calculatedrates.add((betrag.toFloat() * rate).toString() + " $it (Kurs: $rate)")
        }
        return super.display(
            betrag, currency, targetcurrencies, calculatedrates, date = json.get("date").toString()
        )
    }
}
