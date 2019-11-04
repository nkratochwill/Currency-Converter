# Currency-Converter

## GUI

- [x] Die grafische Oberfläche erlaubt die Eingabe eines
  - [x] Betrags (Zahlen)
  - [x] einer Ursprungswährung im 3-Zeichen-Format (z.B. "EUR") sowie
  - [x] einer oder mehrerer Zielwährungen (durch Komma getrennt, z.B. "GBP,USD")
- [x] Es gibt drei Buttons:
  - [x] Ein Button zum Umrechnen,
  - [x] ein Button zum Schließen und
  - [x] einer zum Zurücksetzen der Eingaben
- [ ] In einer Statusleiste (unten) wird angezeigt, ob die letzte Abfrage fehlerfrei funktionierte und ggf. welcher Fehler aufgetreten ist
- [x] In einem großen HTML-Textfeld wird die Ausgabe des Converter-Services angezeigt
- [x] Über eine Checkbox kann gesteuert werden, ob Live-Daten aus einem REST-Service oder fest hinterlegte Daten verwendet werden sollen
- [x] Die GUI wird über den Scenebuilder generiert - der generierte Code wird nicht manuell verändert

## Model

- [x] Das Model bildet die Schnittstelle zum Webservice bzw. zu den lokal hinterlegten Daten
- [x] Es gibt zwei Serivce-Strategien (eigene Klassen!):
  - [x] Eine Strategie fragt ein Online-RESTful Service ab (Empfehlung: https://exchangeratesapi.io/) und wandelt das Ergebnis in (HTML-)Text um
  - [x] Eine zweite Strategie verwendet lokal abgelegte (hardgecodete) Werte und liefert wieder das Ergebnis als (HTML-)Text zurück
  - [x] Beide Klassen übernehmen den Betrag, die Ursprungswährung und die Zielwährung(en) als Parameter
  - [x] Eine abstrakte Klasse fasst die Gemeinsamkeiten zusammen
  - Hinweis: Über das Python-Package requests können sehr einfach Webservice-Anfragen geschickt und über JSON in ein Dictionary umgewandelt werden:

## Controller

- [x] Der Controller ist der Einstiegspunkt für das Programm - er erzeugt die GUI und zeigt sie als Java-Applikation an
- [x] Er kümmert sich außerdem um das Event-Handling:
  - [x] Zurücksetzen-Button (sofern nicht schon im Designer über Signals und Slots gelöst)
    - [x] Setzt alle Eingabe- und Ausgabefelder zurück
  - [ ] Exit-Button (sofern nicht schon im Designer über Signals und Slots gelöst)
    - [ ] Schließt die Applikation
  - [x] Umrechnen-Button
    - [x] Ermittelt über die aktuell ausgewählte Strategie das Ergebnis der Umrechnung und übergibt dabei den Betrag, die Ursprungs-Währung und die Ziel-Währung
    - [x] Zeigt das Ergebnis im Ausgabefeld an und aktualisiert die Statusleiste
  - [x] Checkbox
    - [x] Wechselt je nach Checked-Status die Strategie auf RESTful-Service bzw. lokales Service
