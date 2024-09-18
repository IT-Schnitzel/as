import java.time.LocalDate

fun List<News>.getMostRatedNews(count: Int, period: ClosedRange<LocalDate>): List<News> {
    return this.filter {
        // Предполагаем, что dateNews - это поле в вашем DTO, представляющее дату публикации
        val dateNews = LocalDate.parse(it.description) // Замените на актуальное поле даты
        dateNews in period
    }.sortedByDescending { it.rating }
        .take(count)
}
