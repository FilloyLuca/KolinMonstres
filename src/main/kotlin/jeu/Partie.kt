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
    /**
     * Permet au joueur de modifier l'ordre des monstres dans son équipe en échangeant
     * les positions de deux monstres choisis.
     *
     * Fonctionne uniquement si l'équipe contient au moins 2 monstres.
     * Affiche la liste actuelle des monstres, demande à l'utilisateur deux positions valides,
     * puis échange les monstres à ces positions.
     */
    fun modifierOrdreEquipe() {
        val equipe = joueur.equipeMonstre

        // 1) Vérification: au moins 2 monstres
        if (equipe.size < 2) {
            println("Impossible de modifier l'ordre : l'équipe doit contenir au moins 2 monstres.")
            return
        }

        // 2) Affichage de l'équipe (index 1..n)
        println("\nÉquipe actuelle :")
        equipe.forEachIndexed { index, m ->
            println("${index + 1}. ${m.nom} (PV ${m.pv}/${m.pvMax})")
        }

        // 3) Saisie sécurisée d'une position dans [1..size]
        fun lirePosition(message: String): Int {
            while (true) {
                print(message)
                val pos = readLine()?.trim()?.toIntOrNull()
                if (pos != null && pos in 1..equipe.size) return pos - 1 // 0-based
                println("Entrée invalide. Saisissez un nombre entre 1 et ${equipe.size}.")
            }
        }

        val fromIndex = lirePosition("\nPosition du monstre à déplacer : ")
        val toIndex = lirePosition("Nouvelle position : ")

        if (fromIndex == toIndex) {
            println("La position est identique, aucun changement effectué.")
            return
        }

        // 4) Échange
        val tmp = equipe[fromIndex]
        equipe[fromIndex] = equipe[toIndex]
        equipe[toIndex] = tmp

        // 5) Afficher le nouvel ordre
        println("\nNouvel ordre de l'équipe :")
        equipe.forEachIndexed { index, m ->
            println("${index + 1}. ${m.nom} (PV ${m.pv}/${m.pvMax})")
        }
    }

}