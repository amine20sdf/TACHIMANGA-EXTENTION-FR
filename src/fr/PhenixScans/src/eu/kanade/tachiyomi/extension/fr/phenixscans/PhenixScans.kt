package eu.kanade.tachiyomi.extension.fr.phenixscans

import eu.kanade.tachiyomi.multisrc.madara.Madara
import java.text.SimpleDateFormat
import java.util.Locale

class PhenixScans : Madara(
    "PhenixScans",
    "https://phenix-scans.com",
    "fr",
    SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH)
) {
    override val useNewChapterEndpoint = true
    override val filterNonMangaItems = false
}
