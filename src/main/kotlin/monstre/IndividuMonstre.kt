package org.example.monstre

import org.example.dresseur.Entraineur

/**
 * Représente un monstre individuel, c’est-à-dire une instance unique d’une espèce de monstre.
 *
 * Contrairement à une espèce (`EspeceMonstre`), un individu possède un nom propre, un niveau d'expérience
 * initial, et peut être associé à un entraîneur. C’est cette classe qu’on manipule lors des combats ou
 * dans l’équipe du joueur.
 *
 * @property id Identifiant unique de l'individu (différent de l'ID de son espèce).
 * @property nom Nom donné à cet individu (peut être personnalisé par l'entraîneur).
 * @property espece Référence à l'espèce (`EspeceMonstre`) dont cet individu est issu.
 * @property entraineur Référence à l'entraîneur auquel appartient ce monstre (null si sauvage).
 * @property expInit Expérience initiale de l'individu (permet de calculer son niveau, stats, etc.).
 *
 * @see EspeceMonstre pour les caractéristiques de l’espèce.
 * @see Entraineur pour le propriétaire de ce monstre.
 */
class IndividuMonstre (
    var id : Int,
    var nom : String,
    var espece : EspeceMonstre,
    var entraineur : Entraineur?=null,
    var expInit : Double
){

}