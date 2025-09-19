package org.example.monstre

import org.example.dresseur.Entraineur
import kotlin.random.Random

/**
 * Représente un monstre individuel, c’est-à-dire une instance unique d’une espèce de monstre.
 *
 * Contrairement à une espèce (`EspeceMonstre`), un individu possède un nom propre, un niveau,
 * des statistiques variables et peut être associé à un entraîneur. C’est cette classe qu’on manipule
 * lors des combats ou dans l’équipe du joueur.
 *
 * @property id Identifiant unique de l'individu (différent de l'ID de son espèce).
 * @property nom Nom donné à cet individu (peut être personnalisé par l'entraîneur).
 * @property espece Référence à l'espèce (`EspeceMonstre`) dont cet individu est issu.
 * @property entraineur Référence à l'entraîneur auquel appartient ce monstre (null si sauvage).
 * @property expInit Expérience initiale de l'individu (permet de calculer son niveau, ses stats, etc.).
 * @property niveau Niveau courant de l'individu.
 * @property attaque Valeur d'attaque, calculée à partir de l'espèce avec une variation aléatoire.
 * @property defense Valeur de défense, calculée à partir de l'espèce avec une variation aléatoire.
 * @property vitesse Valeur de vitesse, calculée à partir de l'espèce avec une variation aléatoire.
 * @property attaqueSpe Valeur d'attaque spéciale, calculée à partir de l'espèce avec une variation aléatoire.
 * @property defenseSpe Valeur de défense spéciale, calculée à partir de l'espèce avec une variation aléatoire.
 * @property pvMax Points de vie maximum, calculés à partir de l'espèce avec une variation aléatoire.
 * @property potentiel Potentiel du monstre, un nombre aléatoire entre 0.50 et 2.00 inclus.
 * @property exp Expérience courante de l'individu.
 * @property pv Points de vie actuels, initialisés à `pvMax` et limités entre 0 et `pvMax`.
 *
 * @see EspeceMonstre Pour les caractéristiques de l'espèce.
 * @see Entraineur Pour le propriétaire potentiel de ce monstre.
 */

class IndividuMonstre (
    var id : Int,
    var nom : String,
    var espece : EspeceMonstre,
    var entraineur : Entraineur? = null,
    var expInit : Double = 0.0
){
    var niveau : Int = 1
    var attaque : Int = this.espece.baseAttaque + (-2..2).random()
    var defense : Int = this.espece.baseDefense + (-2..2).random()
    var vitesse : Int = this.espece.baseVitesse + (-2..2).random()
    var attaqueSpe : Int = this.espece.baseAttaqueSpe + (-2..2).random()
    var defenseSpe : Int = this.espece.baseDefenseSpe + (-2..2).random()
    var pvMax : Int = this.espece.basePv + (-5..5).random()

//    var potentiel : Double = Random.nextDouble(0.5,3.0)
    val potentiel: Double = Random.nextInt(50, 201) / 100.0

    var exp: Double = 0.0

    var pv: Int = pvMax
        get() = field
        set(nouveauPv) {
            field = when {
                nouveauPv < 0 -> 0           // Si la valeur est inférieure à 0, on met 0
                nouveauPv > pvMax -> pvMax   // Si la valeur est supérieure à pvMax, on met pvMax
                else -> nouveauPv            // Sinon on garde la valeur donnée
            }
        }

    /**
     * Calcule l'expérience totale nécessaire pour atteindre un niveau donné.
     *
     * @param niveau Niveau cible.
     * @return Expérience cumulée nécessaire pour atteindre ce niveau.
     */
    fun palierExp(niveau: Int): Double {
        return 100 * Math.pow((niveau - 1).toDouble(), 2.0)
    }

}