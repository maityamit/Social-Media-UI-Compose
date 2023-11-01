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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
fun PostItem(post: PostModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = post.authorImageRes),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Row {
                Text(text = post.authorInfo)
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .background(Color(0xFFADD8E6))
                ) {
                    Text(
                        text = post.anotherText,
                        color = Color.Blue,
                        modifier = Modifier.padding(1.dp)
                    )
                }
            }
            Text(
                text = post.time,
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
                text = post.mainText,
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
                        .size(25.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "${post.likes} likes",
                    fontSize = 14.sp
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
                        .size(25.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "${post.comments} comments",
                    fontSize = 14.sp
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
                        .size(25.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "Share",
                    fontSize = 14.sp
                )
            }
        }
    }
}


val posts = listOf(
    PostModel(
        authorInfo = "Devesh",
        authorImageRes = R.drawable.devesh_photo,
        anotherText = "Question",
        likes = 25,
        comments = 5,
        mediaType = MediaType.TEXT,
        mediaRes = R.drawable.amit_photo,
        time = "15 Minutes ago",
        mainText = "A friendly suggestion : Writing or mentioning Upcoming SDE/Intern on your twitter bio or on LinkedIn is too risky nowadays, so start avoiding it"
    ),
    PostModel(
        authorInfo = "Amit Maity",
        authorImageRes = R.drawable.amit_photo,
        anotherText = "Marketing",
        likes = 35,
        comments = 2,
        mediaType = MediaType.IMAGE,
        mediaRes = R.drawable.post_01,
        time = "50 Minutes ago",
        mainText = "It'a a tweet"
    ),
    PostModel(
        authorInfo = "Ajeet Patel",
        authorImageRes = R.drawable.ajeet_photo,
        anotherText = "Marketing",
        likes = 15,
        comments = 3,
        mediaType = MediaType.TEXT,
        mediaRes = R.drawable.amit_photo,
        time = "58 Minutes ago",
        mainText = "Now I want to built something, indie hacking karni hai. \uD83E\uDD7A\n"
    ),
    PostModel(
        authorInfo = "Saurabh",
        authorImageRes = R.drawable.saurbh_photo,
        anotherText = "Question",
        likes = 18,
        comments = 8,
        mediaType = MediaType.IMAGE,
        mediaRes = R.drawable.post_02,
        time = "1 Hours ago",
        mainText = "It'a a tweet"
    )
)