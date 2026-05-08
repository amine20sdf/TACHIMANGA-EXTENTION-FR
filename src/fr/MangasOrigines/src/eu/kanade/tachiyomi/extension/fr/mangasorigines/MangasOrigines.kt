package eu.kanade.tachiyomi.extension.fr.mangasorigines

import eu.kanade.tachiyomi.multisrc.madara.Madara
import java.text.SimpleDateFormat
import java.util.Locale

class MangasOrigines : Madara(
    "Mangas Origines",
    "https://mangas-origines.fr",
    "fr",
    SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH)
) {
    override val useNewChapterEndpoint = true
    override val filterNonMangaItems = false
}
