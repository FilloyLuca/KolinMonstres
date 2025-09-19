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
        set(value){
            field = value

            // Vérifier si on est au niveau 1
            val estNiveau1 = (niveau == 1)

            // Boucle tant que l'expérience dépasse le palier pour monter de niveau
            while (field >= palierExp(niveau)) {
                levelUp()
                // Si on est plus au niveau 1, afficher le message
                if (!estNiveau1) {
                    println("Le monstre $nom est maintenant niveau $niveau !")
                }
            }
        }
    init {
        this.exp = expInit
    }

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

    /**
     * Augmente le niveau du monstre de 1 et met à jour ses caractéristiques.
     *
     * Cette fonction :
     * - Incrémente le niveau de l'individu.
     * - Recalcule les statistiques (attaque, défense, vitesse, attaque spéciale, défense spéciale, pvMax)
     *   en appliquant une variation aléatoire autour des bases de l'espèce.
     * - Augmente les points de vie actuels (`pv`) du nombre de points de vie maximum gagnés lors
     *   de l'augmentation du niveau.
     *
     * Le setter de `pv` assure que la nouvelle valeur reste toujours entre 0 et `pvMax`.
     */
    fun levelUp(){
        // On augmente le niveau de 1
        niveau ++

        // Sauvegarde de l'ancien pvMax pour calculer le gain de points de vie max
        val ancienPvMax = pvMax

        // Recalcul des caractéristiques avec une variation aléatoire
        attaque += (espece.modAttaque * potentiel).toInt() + (-2..2).random()
        defense += (espece.modDefense * potentiel).toInt() + (-2..2).random()
        vitesse += (espece.modVitesse * potentiel).toInt() + (-2..2).random()
        attaqueSpe += (espece.modAttaqueSpe * potentiel).toInt() + (-2..2).random()
        defenseSpe += (espece.modDefenseSpe * potentiel).toInt() + (-2..2).random()
        pvMax += (espece.modPv * potentiel).toInt() + (-5..5).random()

        // Calcul du gain de pvMax
        val gainPvMax = pvMax - ancienPvMax

        // Augmentation des PV actuels du gain obtenu
        pv += gainPvMax
    }
}