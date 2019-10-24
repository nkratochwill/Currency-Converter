package data

class OfflineData : Data {
    override fun get_rates() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun display(betrag: String, currency: String, targetcurrencies: Array<String>, date: String): String {
        return super.display(betrag, currency, targetcurrencies, date)
    }
}
