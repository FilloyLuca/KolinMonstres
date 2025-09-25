package org.example

import org.example.dresseur.Entraineur
import org.example.item.Badge
import org.example.item.MonsterKube
import org.example.jeu.CombatMonstre
import org.example.jeu.Partie
import org.example.monde.Zone
import org.example.monstre.EspeceMonstre
import org.example.monstre.IndividuMonstre
import kotlin.math.E

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
var championTypePierre= Entraineur(3,"Pierre",1000)

var especeSpringLeaf = EspeceMonstre(
    1,
    "Springleaf",
    "Graine",
    60,
    9,
    11,
    10,
    12,
    50,
    34.0,
    6.5,
    9.0,
    8.0,
    7.0,
    30.0,
    "Petit monstre espiègle rond comme une graine, adore le soleil.",
    "Sa feuille sur la tête indique son humeur.",
    "Curieux, amical, timide"
)
var especeFlamkip = EspeceMonstre(
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
var especeAquamy = EspeceMonstre(
    7,
    "Aquamy",
    "Meteo",
    14,
    10,
    11,
    9,
    14,
    14,
    7.0,
    9.0,
    10.0,
    7.5,
    12.0,
    12.0,
    "Créature vaporeuse semblable à un nuage, produit des gouttes pures.",
    "Fait baisser la température en s’endormant.",
    "Calme, rêveur, mystérieux"
)
var especeLaoumi = EspeceMonstre(
    8,
    "Laoumi",
    "Animal",
    11,
    10,
    9,
    8,
    11,
    23,
    11.0,
    8.0,
    7.0,
    6.0,
    11.5,
    23.0,
    "Petit ourson au pelage soyeux, aime se tenir debout.",
    "Son grognement est mignon mais il protège ses amis.",
    "Affectueux, protecteur, gourmand"
)
var especeBugsyface = EspeceMonstre(
    10,
    "Bugsyface",
    "Insecte",
    10,
    13,
    8,
    7,
    13,
    45,
    7.0,
    11.0,
    6.5,
    8.0,
    11.5,
    21.0,
    "Insecte à carapace luisante, se déplace par bonds et vibre des antennes.",
    "Sa carapace devient plus dure après chaque mue.",
    "Travailleur, sociable, infatigable"
)
var especeGalum = EspeceMonstre(
    13,
    "Galum",
    "Minéral",
    12,
    15,
    6,
    8,
    12,
    55,
    9.0,
    13.0,
    4.0,
    6.5,
    10.5,
    13.0,
    "Golem ancien de pierre, yeux lumineux en garde.",
    "Peut rester immobile des heures comme une statue.",
    "Sérieux, stoïque, fiable"
)

var route1 = Zone(
    1,
    "Route 1",
    1500,
    mutableListOf(especeSpringLeaf)
)
var route2 = Zone(
    2,
    "Route 2",
    2000,
    mutableListOf(especeSpringLeaf,especeAquamy)
)

val monstre1 = IndividuMonstre(
    1,
    "springleaf",
    especeSpringLeaf,
    null,
    1500.0
)
val monstre2 = IndividuMonstre(
    2,
    "flamkip",
    especeFlamkip,
    null,
    1500.0
)
val monstre3 = IndividuMonstre(
    3,
    "aquamy",
    especeAquamy,
    null,
    1500.0
)
val monstre4 = IndividuMonstre(
    8,
    "Laoumi",
    especeLaoumi,
    null,
    1500.0
)
val monstre5 = IndividuMonstre(
    10,
    "Bugsyface",
    especeBugsyface,
    null,
    1500.0
)
val monstre6 = IndividuMonstre(
    13,
    "Galum",
    especeGalum,
    null,
    1500.0
)

val badgePiere = Badge(1,
    "Badge Roche",
    "Badge obtenu apres avoir battu le champion de l'arène  de type roche",
    championTypePierre
)

val monsterKube1 = MonsterKube(1,"Kube","Kube de monstre",0.5)

var combat1 = CombatMonstre(monstre3,monstre2)
var combat2 = CombatMonstre(monstre2,monstre1)
var combat3 = CombatMonstre(monstre1,monstre3)

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
//    println(especeSpringLeaf.afficheArt(true))
//    println(especeSpringLeaf.afficheArt(false))
//    println(especeFlamkip.afficheArt(true))
//    println(especeFlamkip.afficheArt(false))
//    println(especeAquamy.afficheArt(true))
//    println(especeAquamy.afficheArt(false))

////Class Zone
//    route1.zoneSuivante = route2
//    route2.zonePrecedente = route1

////Class IndividuMonstre
//// Test levelup()
//monstre1.levelUp()

////Test attaquer()
//monstre1.attaquer(monstre2)
//
////Test renommer()
//monstre1.renommer(monstre1)

////Test afficherDetail()
//monstre1.afficherDetail(monstre1)
//monstre2.afficherDetail(monstre2)
//monstre3.afficherDetail(monstre3)
//monstre4.afficherDetail(monstre4)
//monstre5.afficherDetail(monstre5)
//monstre6.afficherDetail(monstre6)

////Class MonsterKube
//println(monsterKube1.utiliser(monstre3))

////Class CombatMonstre
//joueur.equipeMonstre.add(monstre1)
//println(combat3.jouer())

////class Zone
//route1.genereMonstre()

////Class Partie
//val partie = Partie(1,joueur,route1)
joueur.equipeMonstre.add(monstre5)
joueur.equipeMonstre.add(monstre6)
Partie(1,joueur,route1).examineEquipe()

}