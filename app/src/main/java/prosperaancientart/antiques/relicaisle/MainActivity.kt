package prosperaancientart.antiques.relicaisle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import prosperaancientart.antiques.relicaisle.ui.composable.approot.AppRoot
import prosperaancientart.antiques.relicaisle.ui.theme.QFFMAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QFFMAppTheme {
                AppRoot()
            }
        }
    }
}
