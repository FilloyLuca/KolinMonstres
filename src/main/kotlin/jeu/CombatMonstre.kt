package org.example.jeu

import org.example.dresseur.Entraineur
import org.example.joueur
import org.example.monstre.EspeceMonstre
import org.example.monstre.IndividuMonstre
import org.example.monstre1

class CombatMonstre (
    var monstreJoueur : IndividuMonstre,
    var monstreSauvage : IndividuMonstre,
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

    /**
     * Indique si le joueur a gagné le combat.
     *
     * Conditions de victoire :
     * 1. Le monstre sauvage a été capturé.
     * 2. Le monstre sauvage a ses PV à 0 (vaincu).
     *
     * Note :
     * - Le monstre du joueur gagne de l'expérience seulement dans le deuxième cas.
     *
     * @return `true` si le joueur a gagné, sinon `false`.
     */
//    fun joueurGagne(): Boolean{
//        if (monstreSauvage.pv <= 0){
//            println("${joueur.nom} a gagné !")
//            val gainExp = monstreSauvage.exp * 0.20
//            monstreJoueur.exp += gainExp
//            println("${monstreJoueur.nom} gagne ${gainExp} exp.")
//            return true
//        }else{return false}
//        if (monstreSauvage.entraineur == joueur){
//            println("${monstreSauvage.nom} a été capturé !")
//            return true
//        }else{
//            return false
//        }
//    }

    fun joueurGagne(): Boolean{
        // Victoire par K.O.
        if (monstreSauvage.pv <= 0){
            println("${joueur.nom} a gagné !")
            val gainExp = monstreSauvage.exp * 0.20
            monstreJoueur.exp += gainExp
            println("${monstreJoueur.nom} gagne $gainExp exp.")
            return true
        }
        // Victoire par capture
        if (monstreSauvage.entraineur == joueur){
            println("${monstreSauvage.nom} a été capturé !")
            return true
        }
        return false
    }


}