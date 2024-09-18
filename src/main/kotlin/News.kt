import kotlinx.serialization.Serializable

@Serializable
data class News(
    val id: Long?,
    val title: String?,
    val place: String?,
    val description: String?,
    val site_url: String?,
    val favorites_count: Int? = 0,
    val comments_count: Int? = 0
) {
    val rating: Double
        get() = 1.0 / (1 + kotlin.math.exp(-(comments_count?.plus(1)?.let { favorites_count?.div(it.toDouble()) })!!))
}