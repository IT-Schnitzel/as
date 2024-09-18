import java.io.File

fun saveNews(path: String, news: Collection<News>) {
    val file = File(path)

    // Проверка существования файла
    if (file.exists()) {
        println("Ошибка: файл уже существует по указанному пути.")
        return
    }

    // Запись в CSV
    file.printWriter().use { writer ->
        writer.println("id,title,place,description,siteUrl,favoritesCount,commentsCount,rating")

        news.forEach {
            writer.println("${it.id},${it.title},${it.place},${it.description},${it.site_url},${it.favorites_count},${it.comments_count},${it.rating}")
        }
    }
}