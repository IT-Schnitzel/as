import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.call.body
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement

suspend fun getNews(count: Int = 100): List<News> {
    val client = HttpClient()
    val location = "msk"
    val url = "https://kudago.com/public-api/v1.4/news/?lang=&fields=id,title,place,description,site_url,favorites_count,comments_countexpand=&order_by=&text_format=&ids=&location=&actual_only=true"
    val response1: String = client.get(url).body()
    var response = "[" + response1.substringAfter("[")
    response = response.dropLast(1)
    //println(response)
    //println(response1)
    val jsonFormat = Json {
        coerceInputValues = true
    }

    val newsList = mutableListOf<News>()

    // Парсинг с обработкой ошибок
    try {
        // Десериализация массива JSON
        val jsonArray = jsonFormat.decodeFromString<List<JsonObject>>(response)
        println("d")
        for (json in jsonArray) {
            try {
                val newsItem = jsonFormat.decodeFromJsonElement<News>(json)
                newsList.add(newsItem)
                //println(" ")
                //println(newsItem)
                //println(" ")
            } catch (e: Exception) {
                //println(" ")
                //println("${json}")
                println("Ошибка десериализации элемента: ${json}, ${e.message}")
            }
        }
    } catch (e: Exception) {
        println("Ошибка при получении или обработке данных: ${e.message}")
    }
    return newsList
}