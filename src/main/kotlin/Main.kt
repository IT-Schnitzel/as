import kotlinx.coroutines.runBlocking
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() = runBlocking {
    val newsList = getNews(count = 10)
    println("Полученные новости:")
    newsList.forEach { news ->
        println("${news.id}: ${news.title} (Рейтинг: ${news.rating})")
    }
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val startDate = LocalDate.parse("2023-01-01", formatter)
    val endDate = LocalDate.now()
    val filteredNews = newsList.getMostRatedNews(count = 5, period = startDate..endDate)
    println("\nНаиболее высоко рейтингованные новости за указанный период:")
    filteredNews.forEach { news ->
        println("${news.id}: ${news.title} (Рейтинг: ${news.rating})")
    }
    val path = "news.csv"
    saveNews(path, filteredNews)
    println("\nНовости успешно сохранены в файл: $path")
}
