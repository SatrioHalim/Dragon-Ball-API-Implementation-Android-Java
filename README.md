# Dragon Ball Ensiklopedia

> Aplikasi Android Ensklopedia karakter dan planet dari dunia Dragon Ball.

## Deskripsi

Dragon Ball Ensiklopedia adalah aplikasi Android yang dibuat dengan Java untuk menampilkan informasi tentang karakter dan planet di universe Dragon Ball. Pengguna dapat mencari dan melihat detail tiap karakter atau planet.

## Fitur

- Tampilan semua list karakter
- Tampilan semua list planet
- Pencarian karakter atau planet
- Halaman detail menampilkan informasi dan gambar

## Teknologi & Library

- Bahasa: Java
- Platform: Android (Android Studio / Gradle)
- Gambar: Picasso (untuk memuat gambar dari URL)
- Animasi: Android View Animations (untuk animasi elemen view)

Contoh dependensi Gradle (tambahkan di `app/build.gradle.kts` jika belum ada):

```kotlin
implementation("com.squareup.picasso:picasso:2.8")
implementation("com.daimajia.androidanimations:library:2.4")
```

Catatan: sesuaikan versi dependensi jika Anda menggunakan versi terbaru.

## Struktur Proyek (singkat)

- `app/` - modul aplikasi Android
- `app/src/main/java/` - kode sumber Java
- `app/src/main/res/` - resource (layout, strings, drawable)

## Cara Menjalankan

1. Buka proyek ini di Android Studio.
2. Sinkronkan Gradle dan pastikan dependensi terpasang.
3. Sambungkan perangkat atau jalankan emulator.
4. Jalankan konfigurasi `app` (Run -> Run 'app') atau dari terminal:

```powershell
.\gradlew assembleDebug
```


## Tips Development

- Pastikan permission internet (`INTERNET`) ditambahkan di `AndroidManifest.xml` untuk memuat gambar dari URL.
- Jika gambar tidak tampil, cek URL dan status jaringan.

## Kontribusi

- Untuk perbaikan atau fitur baru, buka issue atau kirim pull request.

