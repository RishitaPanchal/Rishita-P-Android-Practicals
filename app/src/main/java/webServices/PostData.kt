package webServices

/** Dataclass for request */
data class PostData(
    val job: String,
    val name: String
)

/** Dataclass for response */
data class PostResponseData(
    val name: String,
    val job: String,
    val id: String,
    val createdAt: String
)