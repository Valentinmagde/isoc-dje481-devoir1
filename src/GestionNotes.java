import java.util.Scanner;

/**
 * La classe GestionNotes permet de gérer les notes des étudiants.
 * Elle permet à l'utilisateur de saisir les notes, de calculer des statistiques
 * sur ces notes, et d'afficher les résultats.
 * 
 * Cette classe est conçue pour être utilisée dans un programme console.
 * 
 * Les statistiques calculées comprennent :
 *  - La note la plus haute
 *  - La note la plus basse
 *  - La moyenne de la classe
 *  - Le nombre d'étudiants ayant une note au moins égale à la moyenne
 *  - Le nombre d'admis (note >= 10)
 *  - Le nombre de recalés (note < 7)
 *  - Le nombre d'étudiants devant passer le rattrapage (7 <= note < 10)
 * 
 * @author Valentin Magde <valentinmagde@gmail.com>
 * @version 1.0
 */
public class GestionNotes {

    /**
     * Point d'entrée du programme. Permet de saisir les notes des étudiants,
     * de calculer les statistiques et de les afficher.
     * 
     * @param args Arguments de ligne de commande (non utilisés dans ce programme).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Étape 1: Demande du nombre d'étudiants
        System.out.print("Entrez le nombre d'étudiants à gérer : ");
        int n = scanner.nextInt();

        // Étape 2: Création du tableau pour stocker les notes
        double[] notes = new double[n];

        // Étape 3: Saisie des notes des étudiants
        for (int i = 0; i < n; i++) {
            System.out.print("Entrez la note de l'étudiant " + (i + 1) + " : ");
            notes[i] = scanner.nextDouble();
        }

        // Étape 4: Calcul des statistiques
        double notePremiere = notes[0];
        double noteDerniere = notes[0];
        double somme = 0;
        int nbAuMoinsMoyenne = 0;
        int nbAdmis = 0;
        int nbRecales = 0;
        int nbRattrapage = 0;

        for (int i = 0; i < n; i++) {
            double note = notes[i];
            somme += note;

            // Recherche de la note la plus haute et la plus basse
            if (note > notePremiere) {
                notePremiere = note;
            }
            if (note < noteDerniere) {
                noteDerniere = note;
            }
        }

        double moyenneClasse = somme / n;

        for (double note : notes) {
            if (note >= moyenneClasse) {
                nbAuMoinsMoyenne++;
            }
            if (note >= 10) {
                nbAdmis++;
            } else if (note < 7) {
                nbRecales++;
            } else {
                nbRattrapage++;
            }
        }

        // Étape 5: Affichage des statistiques
        System.out.println("\nStatistiques de la classe :");
        System.out.printf("Note du premier : %.2f%n", notePremiere);
        System.out.printf("Note du dernier : %.2f%n", noteDerniere);
        System.out.printf("Moyenne de la classe : %.2f%n", moyenneClasse);
        System.out.println("Nombre d'étudiants ayant une note au moins égale à la moyenne : " + nbAuMoinsMoyenne);
        System.out.println("Nombre d'admis (note >= 10) : " + nbAdmis);
        System.out.println("Nombre de recalés (note < 7) : " + nbRecales);
        System.out.println("Nombre d'étudiants devant passer le rattrapage (7 <= note < 10) : " + nbRattrapage);
    }
}
