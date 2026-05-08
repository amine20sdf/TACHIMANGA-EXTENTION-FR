package eu.kanade.tachiyomi.extension.fr.scantradunion

import eu.kanade.tachiyomi.source.model.*
import eu.kanade.tachiyomi.source.online.ParsedHttpSource
import okhttp3.Request
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class ScantradUnion : ParsedHttpSource() {
    override val name = "ScantradUnion"
    override val baseUrl = "https://scantrad-union.com"
    override val lang = "fr"
    override val supportsLatest = true

    // Liste populaire
    override fun popularMangaRequest(page: Int) =
        Request.Builder().url("$baseUrl/mangas/?page=$page").build()
    override fun popularMangaSelector() = "div.manga-item"
    override fun popularMangaFromElement(element: Element) = SManga.create().apply {
        title = element.select("h3").text()
        setUrlWithoutDomain(element.select("a").attr("href"))
        thumbnail_url = element.select("img").attr("src")
    }
    override fun popularMangaNextPageSelector() = "a.next"

    // Derniers ajouts
    override fun latestUpdatesRequest(page: Int) =
        Request.Builder().url("$baseUrl/mangas/?order=latest&page=$page").build()
    override fun latestUpdatesSelector() = popularMangaSelector()
    override fun latestUpdatesFromElement(element: Element) = popularMangaFromElement(element)
    override fun latestUpdatesNextPageSelector() = popularMangaNextPageSelector()

    // Recherche
    override fun searchMangaRequest(page: Int, query: String, filters: FilterList) =
        Request.Builder().url("$baseUrl/?s=$query&page=$page").build()
    override fun searchMangaSelector() = popularMangaSelector()
    override fun searchMangaFromElement(element: Element) = popularMangaFromElement(element)
    override fun searchMangaNextPageSelector() = popularMangaNextPageSelector()

    // Détails
    override fun mangaDetailsParse(document: Document) = SManga.create().apply {
        title = document.select("h1.manga-title").text()
        description = document.select("div.synopsis").text()
        thumbnail_url = document.select("div.manga-cover img").attr("src")
        status = SManga.UNKNOWN
    }

    // Chapitres
    override fun chapterListSelector() = "li.chapter-item"
    override fun chapterFromElement(element: Element) = SChapter.create().apply {
        name = element.select("a").text()
        setUrlWithoutDomain(element.select("a").attr("href"))
    }

    // Pages
    override fun pageListParse(document: Document) =
        document.select("div.chapter-content img").mapIndexed { i, el ->
            Page(i, "", el.attr("src").takeIf { it.isNotEmpty() } ?: el.attr("data-src"))
        }
    override fun imageUrlParse(document: Document) = ""
}
