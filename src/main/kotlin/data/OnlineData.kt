package data

import org.json.JSONObject
import java.net.URL

class OnlineData : Data {

    override fun get_rates() {
        val get = URL("https://api.exchangeratesapi.io/latest")
        var json = JSONObject(get)
    }

    override fun display(betrag: String, currency: String, targetcurrencies: Array<String>, date: String): String {
        return super.display(betrag, currency, targetcurrencies, date)
    }
}