package assignmentbyamitr.example.assignment


data class PostModel(
    val authorInfo: String,
    val authorImageRes: Int,
    val anotherText: String,
    val likes: Int,
    val comments: Int,
    val mediaType: MediaType,
    val mediaRes: Int,
    val time: String,
    val mainText:String
)

enum class MediaType {
    IMAGE, AUDIO, VIDEO, TEXT
}