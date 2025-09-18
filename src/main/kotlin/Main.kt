package org.example

import org.example.dresseur.Entraineur
import org.example.monde.Zone
import org.example.monstre.EspeceMonstre

fun changeCouleur(message: String, couleur:String=""): String {
    val reset = "\u001B[0m"
    val codeCouleur = when (couleur.lowercase()) {
        "rouge" -> "\u001B[31m"
        "vert" -> "\u001B[32m"
        "jaune" -> "\u001B[33m"
        "bleu" -> "\u001B[34m"
        "magenta" -> "\u001B[35m"
        "cyan" -> "\u001B[36m"
        "blanc" -> "\u001B[37m"
        "marron" -> "\u001B[38;5;94m"
        else -> "" // pas de couleur si non reconnu
    }
    return "$codeCouleur$message$reset"
}

var joueur = Entraineur(1,"Sacha",100)
var rival = Entraineur(2,"Regis",200)

var especeX = EspeceMonstre(
    1,
    "Springleaf",
    "Graine",
    60,
    9,
    11,
    10,
    12,
    14,
    34.0,
    6.5,
    9.0,
    8.0,
    7.0,
    10.0,
    "Petit monstre espiègle rond comme une graine, adore le soleil.",
    "Sa feuille sur la tête indique son humeur.",
    "Curieux, amical, timide"
)
var especeY = EspeceMonstre(
    4,
    "Flamkip",
    "Animal ",
    50,
    8,
    13,
    13,
    16,
    7,
    22.0,
    10.0,
    5.5,
    9.5,
    9.5,
    6.5,
    "Petit animal entouré de flammes, déteste le froid.",
    "Sa flamme change d’intensité selon son énergie.",
    "Impulsif, joueur, loyal"
)
var especeZ = EspeceMonstre(
    7,
    "Aquamy",
    "Meteo",
    55,
    10,
    11,
    9,
    14,
    14,
    27.0,
    9.0,
    10.0,
    7.5,
    12.0,
    12.0,
    "Créature vaporeuse semblable à un nuage, produit des gouttes pures.",
    "Fait baisser la température en s’endormant.",
    "Calme, rêveur, mystérieux"
)

var route1 = Zone(
    1,
    "Route 1",
    1500,
    mutableListOf(especeX)
)
var route2 = Zone(
    2,
    "Route 2",
    2000,
    mutableListOf(especeX,especeZ)
)


fun main() {
//// Test fonctionnel
//    println(changeCouleur("Hello","rouge"))
//    println(changeCouleur("world","bleu"))
//    println("hello ${changeCouleur("my","jaune")} world")
//    println(changeCouleur("truc","marron"))

////Class Entraineur
//    joueur.afficheDetail()
//    rival.afficheDetail()
//    joueur.argents+=50
//    joueur.afficheDetail()

////Class EspeceMonstre
//    println(especeX.afficheArt(true))
//    println(especeX.afficheArt(false))
//    println(especeY.afficheArt(true))
//    println(especeY.afficheArt(false))
//    println(especeZ.afficheArt(true))
//    println(especeZ.afficheArt(false))

////Class Zone
    route1.zoneSuivante = route2
    route2.zonePrecedente = route1
}