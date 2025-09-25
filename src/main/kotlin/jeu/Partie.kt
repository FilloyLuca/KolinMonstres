package org.example.jeu

import org.example.dresseur.Entraineur
import org.example.monde.Zone
import org.example.monstre.EspeceMonstre
import org.example.monstre.IndividuMonstre
import org.example.monstre1
import org.example.monstre2
import org.example.monstre3

/**
 * Représente une partie du jeu.
 *
 * @property id Identifiant unique de la partie.
 * @property joueur Le joueur (entraîneur) qui participe à cette partie.
 * @property zone La zone dans laquelle se déroule la partie.
 * @see choisirStarter
 */
class Partie(
    val id : Int,
    val joueur : Entraineur,
    val zone : Zone
) {
    /**
     * Permet au joueur de choisir un monstre starter parmi trois générés aléatoirement.
     * Affiche un menu de sélection, demande à l'utilisateur de choisir entre 1, 2 ou 3.
     * Le monstre choisi est renommé, son entraîneur est défini, puis il est ajouté à l'équipe du joueur.
     */
    fun choisirStarter() {
        // Générer trois monstres starters
        val monstre1: IndividuMonstre = zone.genereMonstre()
        val monstre2: IndividuMonstre = zone.genereMonstre()
        val monstre3: IndividuMonstre = zone.genereMonstre()

        while (true) {
            println("Choisissez votre starter (1, 2 ou 3) :\n" + "1.SpingLeaf\n" + "2.Flamkip\n" + "3.Aquamy\n")
            val choixSelection = readLine()?.toIntOrNull()

            if (choixSelection in 1..3) {
                // Forcer le type de retour à IndividuMonstre
                val starter: IndividuMonstre = when (choixSelection) {
                    1 -> monstre1
                    2 -> monstre2
                    3 -> monstre3
                    else -> error("Choix invalide") // ne sera pas atteint grâce au test ci-dessus
                }

                // Appeler la méthode renommer sur le starter
                starter.renommer(starter)

                // Assigner l'entraîneur au starter et l'ajouter à l'équipe
                starter.entraineur = joueur
                joueur.equipeMonstre.add(starter)
                println("${starter.nom} est ajouté à l'équipe .")

                break
            } else {
                println("Choix invalide, veuillez réessayer.")
            }
        }
    }



}