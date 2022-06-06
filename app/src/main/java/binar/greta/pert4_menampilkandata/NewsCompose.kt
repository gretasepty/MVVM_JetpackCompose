package binar.greta.pert4_menampilkandata

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import binar.greta.pert4_menampilkandata.data.ResponseNewsItem
import coil.compose.rememberImagePainter

@Composable
fun NewsCompose(news : ResponseNewsItem) {
    Column(modifier = Modifier.padding(15.dp)) {
        val mContext = LocalContext.current
        Card(modifier = Modifier
            .clickable {
                val pindah = Intent(mContext, DetailActivity::class.java)
                pindah.putExtra("detail", news)
                mContext.startActivity(pindah)
            }
            .padding(5.dp)
            .fillMaxWidth()) {
            Row() {
                Image(painter = rememberImagePainter(data = news.image), contentDescription = "icon", modifier = Modifier.height(50.dp) )
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
fun Default(){

}