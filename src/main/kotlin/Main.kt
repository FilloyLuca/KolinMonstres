package org.example

import org.example.dresseur.Entraineur
import org.example.monstre.EspeceMonstre

/**
 * Change la couleur du message donné selon le nom de la couleur spécifié.
 * Cette fonction utilise les codes d'échappement ANSI pour appliquer une couleur à la sortie console. Si un nom de couleur
 * non reconnu ou une chaîne vide est fourni, aucune couleur n'est appliquée.
 *
 * @param message Le message auquel la couleur sera appliquée.
 * @param couleur Le nom de la couleur à appliquer (ex: "rouge", "vert", "bleu"). Par défaut c'est une chaîne vide, ce qui n'applique aucune couleur.
 * @return Le message coloré sous forme de chaîne, ou le même message si aucune couleur n'est appliquée.
 */
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

var especeX = EspeceMonstre(1,
    "Springleaf",
    "plante",
    9,
    11,
    10,
    12,
    7,
    60,
    2.2,
    1.1,
    3.2,
    6.5,
    10.0,
    34.0,
    "Petit monstre espiègle rond comme une graine, adore le soleil.",
    "Sa feuille sur la tête indique son humeur.",
    "Curieux, amical, timide"
)

var especeY = EspeceMonstre(4,
    "Flamkip",
    "feu",
    12,
    8,13,
    16,
    7,
    50,
    2.2,
    1.1,
    3.2,
    12.0,
    6.5,
    22.0,
    "Petit animal entouré de flammes, déteste le froid.",
    "Sa flamme change d’intensité selon son énergie.",
    "Impulsif, joueur, loyal"
)

var especeZ = EspeceMonstre(7,
    "Aquamy",
    "eau",
    10,
    8,
    9,
    16,
    14,
    55,
    2.2,
    10.0,
    7.5,
    12.0,
    12.0,
    22.0,
    "Créature vaporeuse semblable à un nuage, produit des gouttes pures.",
    "Fait baisser la température en s’endormant.",
    "Calme, rêveur, mystérieux"
)


fun main() {
//Test fonctionnelle
//println(changeCouleur("Hello","rouge"))
//println(changeCouleur("world","bleu"))
//println("hello ${changeCouleur("my","jaune")} world")
//println(changeCouleur("truc","marron"))


// Class Entraineur
//    joueur.afficheDetail()
//    rival.afficheDetail()
//    joueur.argents+=50
//    joueur.afficheDetail()

//Class EspeceMonstre
    println(especeX.afficheArt(true))
    println(especeX.afficheArt(false))
    println(especeY.afficheArt(true))
    println(especeY.afficheArt(false))
    println(especeZ.afficheArt(true))
    println(especeZ.afficheArt(false))


}