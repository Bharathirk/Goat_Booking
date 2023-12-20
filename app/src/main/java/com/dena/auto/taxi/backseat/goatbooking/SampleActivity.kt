package com.dena.auto.taxi.backseat.goatbooking

import SampleData
import android.opengl.Visibility
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//https://developer.android.com/jetpack/compose/tutorial?gclid=EAIaIQobChMIl-X3haWZgwMVFy6DAx3eqgxNEAAYASABEgKLCfD_BwE&gclsrc=aw.ds
class SampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            messageCard(name = "Robert")
            Column {
                Surface(modifier = Modifier.wrapContentSize(), color = Color.Cyan) {
                    messageCard(msg = Message("stanly", "Hero"))
                }
                Spacer(modifier = Modifier.height(10.dp))

                Surface(color = Color.Yellow) {
                    messageConversation(messagesList = getMessageListData())
                }
            }
        }
    }

    private fun getMessageListData(): List<Message> {
        return SampleData.conversationSample
    }
}

@Composable
fun messageConversation(messagesList: List<Message>) {
    LazyColumn {
        items(messagesList) { messageItem ->
            messageCard(messageItem)
        }
    }

}

@Composable
fun messageCard(name: String) {
    Text(text = "Hello $name", color = Color.Blue)
}

@Composable
fun messageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.chiyan),
            contentDescription = "profile picture",
            modifier = Modifier
                .padding(all = 5.dp)
                .size(70.dp)
                .clip(CircleShape)
                .border(5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(5.dp))
        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColorChange by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            label = "changeColor"
        )
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Spacer(modifier = Modifier.height(5.dp))
            Surface(color = Color.Green) {
                Surface(
                    shape = MaterialTheme.shapes.extraSmall,
                    modifier = Modifier.padding(8.dp),
                    border = BorderStroke(width = 3.dp, color = Color.Blue)
                ) {
                    Text(
                        text = msg.author,
                        modifier = Modifier.padding(10.dp),
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 30.sp, fontStyle = FontStyle.Italic
                    )
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Surface(
                shadowElevation = 1.dp,
                shape = MaterialTheme.shapes.medium,
                color = surfaceColorChange
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(5.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }

    }
}

@Preview
@Composable
fun previewMessageCard() {
    messageCard(name = "Clara")
}

data class Message(val author: String, val body: String)