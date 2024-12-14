# DAM2024
Dispozitive și aplicații mobile - Seminar

# Proiect
## Aplicație de Gestiune a unui magazin online
O aplicație în care utilizatorii își pot cumpara produse online.

## Funcționalități principale:
### Activități pentru: produse, detalii despre produse, review-uri, vouchere.
### Formular pentru login,register si adăugare de review-uri pentru produse.
### Transfer de parametrii intre activități
### Baza de date ROOM si elemente de preluare date din rețea sub forma de JSON.
### Filtrare produselor in ListView-uri.
### Sistem de Log out.

## Configurarea locației SDK-ului Android (in cazul erorii de configuratie)

Dacă locația SDK-ului Android nu este configurată în variabila globală `ANDROID_HOME`, va trebui să setați această locație la nivel de proiect, creând manual fișierul `local.properties`. Acest fișier lipsește deoarece este exclus din repository (inclus în `.gitignore`).

---

### Pași pentru configurare

1. **Creați un fișier numit `local.properties` în directorul rădăcină al proiectului.**  
   Acesta trebuie să fie la același nivel cu fișierele `build.gradle` și directoarele proiectului.

2. **Adăugați următoarea linie în fișier, specificând calea către Android SDK:**

   - Pentru sistemele Windows:
     ```properties
     sdk.dir=C:\\Users\\YOUR_USERNAME\\AppData\\Local\\Android\\Sdk
     ```

   - Alternativ (format cu slash-uri normale):
     ```properties
     sdk.dir=C:/Users/YOUR_USERNAME/AppData/Local/Android/Sdk
     ```

   > Înlocuiți `YOUR_USERNAME` cu numele utilizatorului Windows.

---

#### Notă

Dacă nu știți locația exactă a SDK-ului pe sistemul vostru, o puteți verifica în Android Studio:  
**File > Settings > Search: Android SDK**
