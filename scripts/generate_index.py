import json, os, glob

extensions = []
for apk in glob.glob("output/**/*.apk", recursive=True):
    name = os.path.basename(apk).replace(".apk", "")
    extensions.append({
        "name": name,
        "pkg": f"eu.kanade.tachiyomi.extension.fr.{name.lower()}",
        "apk": os.path.basename(apk),
        "lang": "fr",
        "code": 2,
        "version": "1.0.0",
        "nsfw": 0
    })

with open("output/index.min.json", "w") as f:
    json.dump(extensions, f, separators=(',', ':'))

print(f"index.min.json généré avec {len(extensions)} extensions")
