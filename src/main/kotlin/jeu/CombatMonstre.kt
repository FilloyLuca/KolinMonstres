package org.example.jeu

import org.example.dresseur.Entraineur
import org.example.item.Utilisable
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

    /**
     * Effectue l'action de l'adversaire (le monstre sauvage) pendant le tour.
     *
     * Si le monstre sauvage a encore des points de vie (PV > 0),
     * il attaque le monstre actif du joueur.
     */
    fun actionAdverse(){
        if (monstreSauvage.pv > 0){
            monstreSauvage.attaquer(monstreJoueur)
        }
    }

    /**
     * Gère l'action du joueur pendant son tour de combat.
     *
     * Le joueur peut choisir parmi plusieurs actions :
     * 1. Attaquer le monstre sauvage avec son monstre actif.
     * 2. Utiliser un objet depuis son sac.
     * 3. Changer de monstre actif dans son équipe.
     *
     * La méthode boucle tant que le choix est invalide ou jusqu'à ce qu'une action valide soit effectuée.
     * Elle termine en retournant `false` si la partie est terminée (via gameOver() ou capture réussie),
     * sinon `true` pour continuer le combat.
     *
     * @return Boolean `false` si le combat est terminé ou si une capture réussie a eu lieu, sinon `true`.
     */
    fun actionJoueur(): Boolean {
        var choixValide = false
        do {
            choixValide = true
            if (gameOver() == true) {
                return false
            } else {
                println("====================\nMenu Action : \n1. Attaquer\n2; Item\n3. Monstres \n====================")
                val choixAction = readln().toInt()
                if (choixAction == 1) {
                    monstreJoueur.attaquer(monstreSauvage)
                } else if (choixAction == 2) {
                    println("Choix de l'item :\n" + joueur.sacAItems.mapIndexed { index, item -> "${index + 1} : ${item.nom}" }
                        .joinToString("\n"))
                    println("0 : Annuler")
                    val indexChoix = readln().toInt() - 1
                    if ( indexChoix == -1){
                        choixValide = false
                    }
                    else{
                        val objetChoisi = joueur.sacAItems[indexChoix]
                        if (objetChoisi is Utilisable) {
                            val captureReussie = objetChoisi.utiliser(monstreSauvage)
                            if (captureReussie) {
                                return false
                            }
                        } else {
                            println("L'objet choisi n'est pas utilisable !")
                            choixValide = false
                        }
                    }
                } else if (choixAction == 3) {
                    println("Vos monstres :\n" + joueur.equipeMonstre.mapIndexed { index, item -> if(item.pv>0) "${index + 1} : ${item.nom}" else "" }
                        .joinToString("\n"))
                    println("0 : Annuler")
                    val indexChoix = readln().toInt() - 1
                    if ( indexChoix ==-1){
                        choixValide = false
                    } else{
                        val choixMonstre = joueur.equipeMonstre[indexChoix]
                        if (choixMonstre.pv <= 0) {
                            println("Impossible ! Ce monstre est KO")
                            choixValide = false
                        } else {
                            println("${choixMonstre} remplace ${monstreJoueur}")
                            monstreJoueur = choixMonstre
                        }
                    }
                }
            }
        } while (!choixValide)
        return true
    }
}