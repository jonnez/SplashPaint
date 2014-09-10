SplashPaint
===========

Code Challenge Java Magazine #4

## Eerste poging

Het bestand `SplashPaint.java` bevat de "leesbare" implementatie voor de challenge.
Het bestand `S.java` is dezelfde code, maar commentaar en zoveel mogelijk whitespace
is daarin verwijderd.

Script `run.sh` berekent het aantal karakters gebruikt in zowel de "leesbare" code
als de minified variant. Vervolgens compileert en start dit script het programma
en voorziet het het programma van de invoerdata op stdin (te vinden is in
de bestanden `painting*.txt`).

## Of toch een ander pad bewandelen

Zou het niet mooi zijn om gebruik te maken van compressie? Dat dacht ik ook.
Stel nu dat we `S.java` met zip inpakken en met bijvoorbeeld Base64 encoderen.
We zouden dan een bestand `D.java` kunnen maken die de Base64 encoded string bevat,
deze decodeert, unzipped, compileert en uitvoer! De vraag is wel of het uiteindelijke
programma korter kan worden.

Class `DecompressCompileAndRun.java` laat het beste zien hoe ik van deze methode gebruik maak.
Methode `zipAndBase64Encode()` leest bestand `S.java` in van hierboven, zipped deze data,
dan Base64 encoding, en de output daarvan is wat we uiteindelijk nodig hebben.

In variant `D1.java` is al heel wat onnodige ballast verwijderd. Deze versie gebruikt
rechtstreeks de Base64 encoded string, decodeert en unzipped, en vervolgens wordt de
class gecompileert en uitgevoerd.

In variant `D2.java` heb ik bestand `T.java` gebruikt in plaats van `S.java`. Het is
namelijk niet meer nodig dat class `S` een main methode heeft. Die restrictie geldt
nu namelijk alleen voor de uiteindelijke oplossing `D.java`. Class `T` is dus de
minified versie van class `SplashPaintZonderMain`.

Uiteindelijk is `D.java`, de minified versie van `D2.java`. Een oplossing die helaas
onder doet voor `S.java`. Jammer, nietwaar?

Ik weet helaas geen eenvoudige betere optie dan Base64 encodering. Er zijn nog wel betere,
maar een implementatie daarvoor zou weer te lang worden.
De enige conclusie die ik nu kan trekken is dat `S.java` zo kort is dat de methode niet
werkt. Maar hee, dan maak ik daar misschien wel kans mee voor de code challenge??!!

## Oplossing

In de tabel wordt het aantal tekens weergegeven dat gebruikt wordt in de oplossing S.java,
berekent met het command `wc -c *.java`.
          
Karakters|Class
---------|-----------------
      788|S
     1208|D
