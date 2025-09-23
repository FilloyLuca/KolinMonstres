package org.example.monde

import org.example.monstre.EspeceMonstre

/**
 * Représente une zone du monde dans laquelle le joueur peut se déplacer et rencontrer des monstres.
 *
 * Une zone possède un identifiant, un nom, une valeur d'expérience indicative,
 * une liste d'espèces de monstres qu'on peut y rencontrer, ainsi que des liens vers les zones
 * précédente et suivante pour permettre la navigation.
 *
 * @property id Identifiant unique de la zone.
 * @property nom Nom de la zone (ex : Forêt de Lune, Grotte Obscure...).
 * @property expZone Niveau ou valeur d’expérience recommandée pour cette zone.
 * @property especeMonstres Liste des espèces de monstres disponibles dans cette zone.
 * @property zoneSuivante Référence vers la zone suivante (ou null si aucune).
 * @property zonePrecedente Référence vers la zone précédente (ou null si aucune).
 *
 * @see EspeceMonstre pour les espèces de monstres référencées.
 */
class Zone(
    var id : Int,
    var nom : String,
    var expZone : Int,
    var especeMonstres : MutableList<EspeceMonstre> = mutableListOf(),
    var zoneSuivante : Zone? = null,
    var zonePrecedente : Zone? = null
) {
    fun genereMonstre(){

    }
    //TODO faire la méthode rencontreMonstre()

}