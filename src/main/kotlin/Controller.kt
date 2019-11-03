import data.Data
import data.OfflineData
import data.OnlineData
import javafx.application.Application
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import javafx.scene.web.WebEngine
import javafx.scene.web.WebView
import javafx.stage.Stage
import org.json.JSONObject
import java.net.URL

class Controller : Application() {
    lateinit var currencyTextField: TextField
    lateinit var targetCurrencyTextField: TextField
    lateinit var convertButton: Button
    lateinit var amountTextField: TextField
    lateinit var webView: WebView
    lateinit var webEngine: WebEngine
    lateinit var liveDataCheckBox: CheckBox
    lateinit var exitButton: Button
    lateinit var resetButton: Button
    var strategy: Data = OnlineData()

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val root: Parent = FXMLLoader.load(javaClass.getResource("/view.fxml"))
        primaryStage.title = "Currency Converter"
        primaryStage.scene = Scene(root, 900.0, 600.0)
        primaryStage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Controller::class.java)
        }
    }

    @FXML
    fun initialize() {
        webEngine = webView.engine
    }

    fun liveDataChanger() {
        strategy = when (liveDataCheckBox.isSelected) {
            true -> OfflineData()
            false -> OnlineData()
        }
    }

    fun convert() {
        webEngine.loadContent(strategy.get_rates(amountTextField.text, currencyTextField.text, targetCurrencyTextField.text.split(",")))
    }

    fun exit() {
        TODO("Aber irgendwie unnötig")
    }

    fun reset() {
        currencyTextField.clear()
        targetCurrencyTextField.clear()
        amountTextField.clear()
        webEngine.load("about:blank")
     }

}
