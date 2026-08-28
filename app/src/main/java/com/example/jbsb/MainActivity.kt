package com.example.jbsb

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.jbsb.ui.theme.JBSBTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JBSBTheme {
                App(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    var overrideSound by remember { mutableStateOf(false) }
    Scaffold(
        modifier = modifier,
        topBar = {
            JBTopBar(
                overrideSound = overrideSound,
                onOverrideSoundChanged = { overrideSound = it }
            )
        }
    ) { innerPadding ->
        SoundBoardScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun SoundBoardScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val sounds = remember {
        listOf(
            "maiipit ka nganiii" to R.raw.maiipit,
            "engkkk engottt" to R.raw.engot,
            "patawad" to R.raw.patawad,
            "may kaliwa ba sa roight" to R.raw.roight,
            "depende kung 3 yan" to R.raw.dependekung3yan,
            "BAGANG" to R.raw.bagang,
            "BALIW BALIW BALIW" to R.raw.baliw,
            "dont block the intersection" to R.raw.intersection
        )
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(sounds) { (displayName, resId) ->
            Button(
                onClick = {
                    val mediaPlayer = MediaPlayer.create(context, resId)

                    if (mediaPlayer != null) {
                        mediaPlayer.setVolume(1.0f, 1.0f)
                        mediaPlayer.start()

                        mediaPlayer.setOnCompletionListener { mp ->
                            mp.release()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = (ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                ))
            ) {
                Text(
                    text = displayName,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JBTopBar(
    overrideSound: Boolean,
    onOverrideSoundChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = stringResource(R.string.full_app_name)
                )
                Spacer(modifier = Modifier.weight(1f))
//                Icon(
//                    imageVector = Icons.AutoMirrored.Filled.VolumeUp,
//                    contentDescription = "Volume Icon",
//                    modifier = Modifier.padding(8.dp)
//                )
//                Switch(
//                    checked = overrideSound,
//                    onCheckedChange = onOverrideSoundChanged
//                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    JBSBTheme {
        App()
    }
}