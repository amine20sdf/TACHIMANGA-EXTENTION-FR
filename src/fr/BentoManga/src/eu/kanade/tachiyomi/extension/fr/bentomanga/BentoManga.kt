package eu.kanade.tachiyomi.extension.fr.bentomanga

import eu.kanade.tachiyomi.multisrc.madara.Madara
import java.text.SimpleDateFormat
import java.util.Locale

class BentoManga : Madara(
    "BentoManga",
    "https://bentomanga.com",
    "fr",
    SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH)
) {
    override val useNewChapterEndpoint = true
    override val filterNonMangaItems = false
}
