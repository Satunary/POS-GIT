# Info
Dieses Beispiel beruht auf den Unterlagen:

- https://github.com/schletz/Pos3xhif/tree/master/04%20WPF/04_Lists
- https://github.com/schletz/Pos3xhif/tree/master/04%20WPF/05_EF_Core


## Bekannte Schwachstellen:

- Datenbank wird jedesmal neu erzeugt. Kann man verhindern, indem
	man die entsprechenden Befehle in **MauiProgram.cs** auskommentiert.
- Buttons sind immer aktiv, auch wenn keine Aktionen möglich sind.

- Neuanlegen:
	- Schueler auswählen
	- Daten eingeben
	- "Neuer Schüler" drücken
	- "Änderung speichern" drücken

## Listen in XAML

[Gegenueber WPF](https://docs.microsoft.com/en-us/dotnet/desktop-wpf/data/how-to-bind-to-a-collection-and-display-data-from-a-collection?view=netdesktop-5.0)
verwenden wir in MAUI eine `CollectionView`.

## Layout

[DockLayout](https://learn.microsoft.com/de-de/dotnet/communitytoolkit/maui/layouts/docklayout) ist ein Layout, das die Kinder 
an den Rand des Layouts anheftet.

