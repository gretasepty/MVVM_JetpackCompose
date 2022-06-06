package binar.greta.pert4_menampilkandata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import binar.greta.pert4_menampilkandata.data.ResponseNewsItem
import binar.greta.pert4_menampilkandata.ui.theme.Pert4_MenampilkanDataTheme
import binar.greta.pert4_menampilkandata.viewmodel.NewsVM
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pert4_MenampilkanDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val newsVM = viewModel(modelClass = NewsVM::class.java)
                    val datanews by newsVM.datastate.collectAsState()

                    LazyColumn{
                        if (datanews.isEmpty()){
                            item {

                            }
                        }

                        items(datanews){
                            NewsCompose(news = it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(news : ResponseNewsItem) {
    Column(modifier = Modifier.padding(15.dp)) {
        Card(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()) {
            Row() {
                Image(painter = rememberImagePainter(data = news.image), contentDescription = "icon" )
                Column(modifier = Modifier.padding(start = 15.dp)) {
                    Text(text = news.title)
                    Text(text = news.author)
                    Text(text = news.createdAt)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Pert4_MenampilkanDataTheme {
//        Greeting("", "", "","","","" "")
    }
}