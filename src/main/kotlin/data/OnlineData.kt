package data

import org.json.JSONObject
import java.net.URL

class OnlineData : Data {
    override fun get_rates(betrag: String, currency: String, targetcurrencies: List<String>): String {
        val api = URL("https://api.exchangeratesapi.io/latest?base=$currency").readText()
        val json = JSONObject(api)
        val calculatedrates = mutableListOf<String>()
        targetcurrencies.forEach {
            val rate = json.getJSONObject("rates").getFloat(it)
            calculatedrates.add((betrag.toFloat() * rate).toString() + " $it (Kurs: $rate)")
        }
        return super.display(betrag, currency, targetcurrencies, calculatedrates, date = json.get("date").toString())
    }
}