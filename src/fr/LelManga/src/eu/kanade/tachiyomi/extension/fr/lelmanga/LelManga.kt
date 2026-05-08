package eu.kanade.tachiyomi.extension.fr.lelmanga

import eu.kanade.tachiyomi.multisrc.madara.Madara
import java.text.SimpleDateFormat
import java.util.Locale

class LelManga : Madara(
    "LelManga",
    "https://lelmanga.com",
    "fr",
    SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH)
) {
    override val useNewChapterEndpoint = true
}
