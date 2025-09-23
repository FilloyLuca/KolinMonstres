package org.example.jeu

import org.example.dresseur.Entraineur
import org.example.joueur
import org.example.monstre.IndividuMonstre

class CombatMonstre (
    monstreJoueur : IndividuMonstre,
    monstreSauvage : IndividuMonstre,
    var round : Int = 1
){
    /**
     * Vérifie si le joueur a perdu le combat.
     *
     * Condition de défaite :
     * - Aucun monstre de l'équipe du joueur n'a de PV > 0.
     *
     * @return `true` si le joueur a perdu, sinon `false`.
     */
    fun gameOver(): Boolean{
        for (monstre in joueur.equipeMonstre){
            if (monstre.pv > 0) return false
        }
        println("Game Over !")
        return true
    }
}