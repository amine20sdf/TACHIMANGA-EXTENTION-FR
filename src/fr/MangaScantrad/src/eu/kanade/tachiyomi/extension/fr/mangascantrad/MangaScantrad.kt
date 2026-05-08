package eu.kanade.tachiyomi.extension.fr.mangascantrad

import eu.kanade.tachiyomi.multisrc.madara.Madara
import java.text.SimpleDateFormat
import java.util.Locale

class MangaScantrad : Madara(
    "MangaScantrad",
    "https://manga-scantrad.io",
    "fr",
    SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH)
) {
    override val useNewChapterEndpoint = true
}
