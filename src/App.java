/*  author: Bruno Neves
    project: Duelers of Java */
    
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        Player player = new Player(10, 2, 15, 5);
        Enemy enemy = new Enemy(10, 2, 15, 5);

        boolean playerIsDecided = false;
        boolean enemyIsDecided = false;

        do{
        System.out.println(
        "Escolha sua classe: \n Bárbaro: 25 pontos de vida, 8 de força, 10 de stamina e 7 de armadura.\n Cavaleiro: 22 pontos de vida, 4 de força, 12 de stamina e 12 de armadura. \n Ladino: 20 pontos de vida 5 de força, 20 de stamina e 5 de armadura");
        String vocacaoPlayer = teclado.nextLine();
        if(vocacaoPlayer.equals("barbaro")){
            playerIsDecided = true;
            player.setVida(25); player.setForca(6); player.setStamina(10); player.setArmadura(9);
            // 25 + 6 + 10 + 9
        }
        if(vocacaoPlayer.equals("cavaleiro")){
            playerIsDecided = true;
            player.setVida(22); player.setForca(4); player.setStamina(12); player.setArmadura(12);
            // 22 + 4 + 12 + 12 = 40
        }
        if(vocacaoPlayer.equals("ladino")){
            playerIsDecided = true;
            player.setVida(20); player.setForca(5); player.setStamina(20); player.setArmadura(5);
            //20 + 5 + 20 + 5 = 40 
        }
        System.out.println("Vocação do player escolhida: "+vocacaoPlayer);
        }while(playerIsDecided == false);
        
        do{
            System.out.println(
            "Escolha sua classe: \n Bárbaro: 15 pontos de vida, 6 de força, 8 de stamina e 5 de armadura.\n Cavaleiro: 12 pontos de vida, 3 de força, 8 de stamina e 8 de armadura. \n Ladino: 10 pontos de vida 2 de força, 15 de stamina e 5 de armadura");
            String vocacaoEnemy = teclado.nextLine();
            if(vocacaoEnemy.equals("barbaro")){
                enemyIsDecided = true;
                enemy.setVida(25); enemy.setForca(6); enemy.setStamina(10); enemy.setArmadura(9);
            }
            if(vocacaoEnemy.equals("cavaleiro")){
                enemyIsDecided = true;
                enemy.setVida(22); enemy.setForca(4); enemy.setStamina(12); enemy.setArmadura(12);
            }
            if(vocacaoEnemy.equals("ladino")){
                enemyIsDecided = true;
                enemy.setVida(20); enemy.setForca(5); enemy.setStamina(20); enemy.setArmadura(5);
            }
            System.out.println("Vocação do inimigo escolhida: "+vocacaoEnemy);
            }while(enemyIsDecided == false);

        int turno = 0;
        boolean isDead = false;

        while (isDead == false) {
            // ALGORITMO PLAYER

            if (player.getVida() > 0 && isDead == false) {
                System.out.println("Turno do player, digite 'atacar, 'defender' ou 'descansar'"
                        + "\nStamina do player: " + player.getStamina());
                String comandoPlayer = teclado.nextLine();

                if (comandoPlayer.equals("atacar") && turno == 0 && player.getStamina() > 0) {
                    enemy.setVida(enemy.getVida() - player.getForca());
                    player.setStamina(player.getStamina() - 5);
                    turno = 1;
                }
                if (comandoPlayer.equals("descansar") && turno == 0) {
                    player.setStamina(player.getStamina() + 5);
                    turno = 1;
                }
                if (comandoPlayer.equals("defender") && turno == 0 && player.getStamina() > 0) {
                    player.setVida(player.getVida() + player.getArmadura());
                    player.setStamina(player.getStamina() - 5);
                    turno = 1;
                }
                if (enemy.getVida() > 0) {
                    System.out.println("\nVida do inimigo: " + enemy.getVida());
                }
                if (enemy.getVida() <= 0) {
                    System.out.println("Inimigo morreu!");
                }
                if (enemy.getStamina() <= 0) {
                    System.out.println("Inimigo sem stamina, digite 'descansar' para recuperar-se");
                }
            }

            // ALGORITMO INIMIGO

            if (enemy.getVida() > 0 && isDead == false) {
                System.out.println("Turno do inimigo, digite 'atacar', 'defender' ou 'descansar': "
                        + "\nStamina do inimigo: " + enemy.getStamina());
                String comandoEnemy = teclado.nextLine();

                if (comandoEnemy.equals("atacar") && turno == 1 && enemy.getStamina() > 0) {
                    player.setVida(player.getVida() - enemy.getForca());
                    enemy.setStamina(enemy.getStamina() - 5);
                    turno = 0;
                }
                if (comandoEnemy.equals("descansar") && turno == 1) {
                    enemy.setStamina(enemy.getStamina() + 5);
                    turno = 0;
                }
                if (comandoEnemy.equals("defender") && turno == 1 && enemy.getStamina() > 0) {
                    enemy.setVida(enemy.getVida() + enemy.getArmadura());
                    enemy.setStamina(enemy.getStamina() - 5);
                    turno = 0;
                }
                if (player.getVida() > 0) {
                    System.out.println("\nVida do player: " + player.getVida());
                }
                if (player.getVida() <= 0) {
                    System.out.println("Player morreu!");
                }
                if (player.getStamina() <= 0) {
                    System.out.println("Player sem stamina, digite 'descansar' para recuperar-se");
                }
            }

            if (player.getVida() <= 0 || enemy.getVida() <= 0) {
                isDead = true;
            }
        }

        teclado.close();
    }
}