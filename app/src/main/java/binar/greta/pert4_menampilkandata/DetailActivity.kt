package binar.greta.pert4_menampilkandata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import binar.greta.pert4_menampilkandata.data.ResponseNewsItem
import binar.greta.pert4_menampilkandata.ui.theme.Pert4_MenampilkanDataTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pert4_MenampilkanDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val detail = intent.getSerializableExtra("detail") as ResponseNewsItem
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(text = detail.title)
                        Text(text = detail.description)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    Pert4_MenampilkanDataTheme {
        Greeting2("Android")
    }
}