package assignmentbyamitr.example.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import assignmentbyamitr.example.assignment.ui.theme.AssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(posts) { post ->
                            PostItem(post = post)
                            Divider(modifier = Modifier.padding(vertical = 8.dp))
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AssignmentTheme {
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            items(posts) { post ->
                PostItem(post = post)
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}


@Composable
fun PostItem(post: Post) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Row {
                Text(text = "Amit Maity")
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .background(Color(0xFFADD8E6))
                ) {
                    Text(
                        text = "Question",
                        color = Color.Blue,
                        modifier = Modifier.padding(1.dp)
                    )
                }
            }
            Text(
                text = "2 Hours ago",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
    
    // Multimedia format: Image, Audio, Video
    when (post.mediaType) {
        MediaType.IMAGE -> {
            Image(
                painter = painterResource(id = post.mediaRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(10.dp)
            )
        }
        MediaType.AUDIO -> {
            // Add code to display audio
        }
        MediaType.VIDEO -> {
            // Add code to display video
        }
        MediaType.TEXT -> {
            // Show Text
            Text(
                text = "Amit Maity a Boy",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }
    }

    // Last Section
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_favorite_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "121 Likes",
                    fontSize = 12.sp
                )
            }
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_comment_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "9 Comments",
                    fontSize = 12.sp
                )
            }
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_share_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "Share",
                    fontSize = 12.sp
                )
            }
        }
    }
}

data class Post(
    val authorInfo: String,
    val authorImageRes: Int,
    val anotherText: String,
    val likes: Int,
    val comments: Int,
    val mediaType: MediaType,
    val mediaRes: Int,
    val time: String
)

enum class MediaType {
    IMAGE, AUDIO, VIDEO, TEXT
}

val posts = listOf(
    Post(
        authorInfo = "John Doe",
        authorImageRes = R.drawable.untitled,
        anotherText = "Just a test post",
        likes = 10,
        comments = 5,
        mediaType = MediaType.IMAGE,
        mediaRes = R.drawable.untitled,
        time = "2 Hours ago"
    ),
    Post(
        authorInfo = "Jane Smith",
        authorImageRes = R.drawable.untitled,
        anotherText = "Hello World!",
        likes = 20,
        comments = 8,
        mediaType = MediaType.TEXT,
        mediaRes = R.drawable.untitled,
        time = "2 Hours ago"
    ),
    Post(
        authorInfo = "James Brown",
        authorImageRes = R.drawable.untitled,
        anotherText = "A video post",
        likes = 15,
        comments = 3,
        mediaType = MediaType.TEXT,
        mediaRes = R.drawable.untitled,
        time = "2 Hours ago"
    ),
    Post(
        authorInfo = "John Doe",
        authorImageRes = R.drawable.untitled,
        anotherText = "Just a test post",
        likes = 10,
        comments = 5,
        mediaType = MediaType.IMAGE,
        mediaRes = R.drawable.untitled,
        time = "2 Hours ago"
    ),
    Post(
        authorInfo = "John Doe",
        authorImageRes = R.drawable.untitled,
        anotherText = "Just a test post",
        likes = 10,
        comments = 5,
        mediaType = MediaType.IMAGE,
        mediaRes = R.drawable.untitled,
        time = "2 Hours ago"
    ),
    Post(
        authorInfo = "John Doe",
        authorImageRes = R.drawable.untitled,
        anotherText = "Just a test post",
        likes = 10,
        comments = 5,
        mediaType = MediaType.IMAGE,
        mediaRes = R.drawable.untitled,
        time = "2 Hours ago"
    )
)