package data

import org.json.JSONObject
import java.net.URL

class OnlineData : Data {

    override fun get_rates(betrag: String, currency: String, targetcurrencies: List<String>): String {
        val get = URL("https://api.exchangeratesapi.io/latest").readText()
        val json = JSONObject(get)
        var calculatedrates= mutableListOf<String>()
        targetcurrencies.forEach {
            calculatedrates.add((betrag.toFloat()*json.getJSONObject("rates").get(it).toString().toFloat()).toString())
        }
        return super.display(betrag, currency, targetcurrencies, calculatedrates, date = json.get("date").toString())
    }
}