package eu.kanade.tachiyomi.extension.fr.sushiscan

import eu.kanade.tachiyomi.multisrc.madara.Madara
import java.text.SimpleDateFormat
import java.util.Locale

class SushiScan : Madara(
    "SushiScan",
    "https://sushiscan.net",
    "fr",
    SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH)
) {
    override val useNewChapterEndpoint = true
    override val filterNonMangaItems = false
}
