import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Game {

    //Defining variables for the size of the game screen
    int gameWidth = 1280;
    int gameHeight = 720;

    //Using a package to create a window:
    JFrame gameWindow;
    Container container;

    //Creating the character select screen:
    JPanel characterClassPanel, characterDescriptionPanel, characterConfirmPanel;
    JButton characterConfirmButton;
    JButton characterKnightButton, characterMercButton, characterWarriorButton, characterHeraldButton, characterThiefButton, characterAssassinButton, characterSorcButton, characterPyroButton, characterClericButton;
    String [] characterSelect;

    //Creating the intro text screen:
    JPanel introTextPanel, introTextConfirmPanel;
    JLabel introTextLabel;
    JButton introTextConfirmButton;
    ImageIcon backgroundImage;

    //Creating a title screen:
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;

    //Using a JLabel to display text and changing the font
    JLabel titleNameLabel = new JLabel("Adventure Game");
    JLabel hpLabel, hpLabelNumber, staminaLabel, staminaLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont;
    Font normalFont;

    //Creating a start button
    JButton startButton;

    //Creating the main text 'area'
    JTextArea mainTextArea;

    //Initialising the 'handler' methods
    CharacterScreenHandler characterScreenHandler = new CharacterScreenHandler();

    TitleScreenHandler titleScreenHandler = new TitleScreenHandler();

    GameScreenHandler gameScreenHandler = new GameScreenHandler();

    ChoiceHandler choiceHandler = new ChoiceHandler();

    //Creating the 'choice' buttons
    JButton choice1, choice2, choice3, choice4;
    JButton choiceButton;
    JButton choiceButtonList[];

    //Assigning the ChoiceOption to a string to allow to put in any number of dialogue choices
    String[] choiceOption;

    //Assigning the player variables (HP, Stamina, Equipped weapon)
    int playerHP, playerStamina, defaultStamina, monsterHP, silverRing;
    String playerWeapon, position;
    int playerDamage = 0;
    int playerStaminaLoss;

    public static void main(String[] args) {

        new Game();

    }

    public Game(){

        //Registering the Fonts
        try{
            titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("runescape_uf.ttf")).deriveFont(120f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("runescape_uf.ttf")));
        }
        catch(IOException | FontFormatException e){

        }

        try{
            normalFont = Font.createFont(Font.TRUETYPE_FONT, new File("runescape_uf.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("runescape_uf.ttf")));
        }
        catch(IOException | FontFormatException e){

        }

        CreateGameWindow();
        CreateTitleScreen();





    }

    //Creating the game window which will be used across all screens in the game
    public void CreateGameWindow () {
        gameWindow = new JFrame(); //Initialising the JFrame
        gameWindow.setSize(gameWidth, gameHeight);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Setting the [x] button to close the window
        gameWindow.getContentPane().setBackground(Color.BLACK);
        gameWindow.setLayout(null); //Disable the default layout, so a custom layout can be used
        gameWindow.setVisible(true); //Makes the window appear on the screen

        container = gameWindow.getContentPane();

    }

    public void CreateTitleScreen () {
        //Title writing
        titleNamePanel = new JPanel(); //Initialising the title screen
        titleNamePanel.setBounds( gameWidth/8,  gameWidth/8,  900, 400); //Setting the position/size of the title panel
        titleNamePanel.setBackground(Color.BLACK);

        //Setting the text colour, and font type of the title text
        titleNameLabel.setForeground(Color.YELLOW);
        titleNameLabel.setFont(titleFont);

        //Start Button
        startButtonPanel = new JPanel(); //Initialising the start button panel
        startButtonPanel.setBounds(300, 500, 700, 200);
        startButtonPanel.setBackground(Color.BLACK);

        startButton = new JButton("BEGIN ANEW"); //Initialising the start button with the START text
        startButton.setBackground(Color.BLACK); //Formatting the start button
        startButton.setForeground(Color.YELLOW);
        startButton.setFont(normalFont);
        startButton.addActionListener(characterScreenHandler); //Button recognises the click and performs the TitleScreenHandler function
        startButton.setFocusPainted(false);

        //Adding the title text to the title panel
        titleNamePanel.add(titleNameLabel);

        //Adding the start button to the start panel
        startButtonPanel.add(startButton);

        //Adding all panels to the container
        container.add(titleNamePanel);
        container.add(startButtonPanel);
    }

    public void CreateCharacterScreen () {

        //Removing the previous panels
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        //Character Class text
        characterClassPanel = new JPanel();
        characterClassPanel.setBounds(100, 50, 300, 550);
        characterClassPanel.setBackground(Color.BLUE);
        characterClassPanel.setLayout(new GridLayout(9, 1));

        /*
        characterSelect = new String[] {"Knight", "Mercenary", "Warrior", "Herald", "Thief", "Assassin", "Sorcerer", "Cleric", "Pyromancer"};
        CharacterChoiceButton(characterSelect.length);
        characterClassPanel.setLayout(new GridLayout(characterSelect.length, 1));

         */

        //Have to use an explicit method before finding a way to use a for loop

        //Knight Class
        characterKnightButton = new JButton("Knight");
        characterKnightButton.setBackground(Color.BLACK);
        characterKnightButton.setForeground(Color.YELLOW);
        characterKnightButton.setFont(normalFont);
        characterKnightButton.setFocusPainted(false);
        //characterKnightButton.addActionListener(choiceHandler);
        characterClassPanel.add(characterKnightButton);

        //Mercenary Class
        characterMercButton = new JButton("Mercenary");
        characterMercButton.setBackground(Color.BLACK);
        characterMercButton.setForeground(Color.YELLOW);
        characterMercButton.setFont(normalFont);
        characterMercButton.setFocusPainted(false);
        //characterMercButton.addActionListener(choiceHandler);
        characterClassPanel.add(characterMercButton);

        //Warrior Class
        characterWarriorButton = new JButton("Warrior");
        characterWarriorButton.setBackground(Color.BLACK);
        characterWarriorButton.setForeground(Color.YELLOW);
        characterWarriorButton.setFont(normalFont);
        characterWarriorButton.setFocusPainted(false);
        //characterWarriorButton.addActionListener(choiceHandler);
        characterClassPanel.add(characterWarriorButton);

        //Herald Class
        characterHeraldButton = new JButton("Herald");
        characterHeraldButton.setBackground(Color.BLACK);
        characterHeraldButton.setForeground(Color.YELLOW);
        characterHeraldButton.setFont(normalFont);
        characterHeraldButton.setFocusPainted(false);
        //characterHeraldButton.addActionListener(choiceHandler);
        characterClassPanel.add(characterHeraldButton);

        //Thief Class
        characterThiefButton = new JButton("Thief");
        characterThiefButton.setBackground(Color.BLACK);
        characterThiefButton.setForeground(Color.YELLOW);
        characterThiefButton.setFont(normalFont);
        characterThiefButton.setFocusPainted(false);
        //characterThiefButton.addActionListener(choiceHandler);
        characterClassPanel.add(characterThiefButton);

        //Assassin Class
        characterAssassinButton = new JButton("Assassin");
        characterAssassinButton.setBackground(Color.BLACK);
        characterAssassinButton.setForeground(Color.YELLOW);
        characterAssassinButton.setFont(normalFont);
        characterAssassinButton.setFocusPainted(false);
        //characterAssassinButton.addActionListener(choiceHandler);
        characterClassPanel.add(characterAssassinButton);

        //Sorcerer Class
        characterSorcButton = new JButton("Sorcerer");
        characterSorcButton.setBackground(Color.BLACK);
        characterSorcButton.setForeground(Color.YELLOW);
        characterSorcButton.setFont(normalFont);
        characterSorcButton.setFocusPainted(false);
        //characterSorcButton.addActionListener(choiceHandler);
        characterClassPanel.add(characterSorcButton);

        //Cleric Class
        characterClericButton = new JButton("Cleric");
        characterClericButton.setBackground(Color.BLACK);
        characterClericButton.setForeground(Color.YELLOW);
        characterClericButton.setFont(normalFont);
        characterClericButton.setFocusPainted(false);
        //characterClericButton.addActionListener(choiceHandler);
        characterClassPanel.add(characterClericButton);

        //Pyromancer Class
        characterPyroButton = new JButton("Pyromancer");
        characterPyroButton.setBackground(Color.BLACK);
        characterPyroButton.setForeground(Color.YELLOW);
        characterPyroButton.setFont(normalFont);
        characterPyroButton.setFocusPainted(false);
        //characterPyroButton.addActionListener(choiceHandler);
        characterClassPanel.add(characterPyroButton);

        //Description Text
        characterDescriptionPanel = new JPanel();
        characterDescriptionPanel.setBounds(450, 50, 600, 500);
        characterDescriptionPanel.setBackground(Color.GREEN);

        //Confirm button - formatting
        characterConfirmPanel = new JPanel();
        characterConfirmPanel.setBounds(600, 560, 300, 60);
        characterConfirmPanel.setBackground(Color.BLACK);

        //Confirm button - function
        characterConfirmButton = new JButton("CONFIRM"); //Initialising the start button with the START text
        characterConfirmButton.setBackground(Color.BLACK);
        characterConfirmButton.setForeground(Color.YELLOW);
        characterConfirmButton.setFont(normalFont);
        characterConfirmButton.addActionListener(titleScreenHandler); //Button recognises the click and performs the TitleScreenHandler function
        characterConfirmButton.setFocusPainted(false);
        characterConfirmPanel.add(characterConfirmButton);


        //Adding all panels to the container
        container.add(characterClassPanel);
        container.add(characterDescriptionPanel);
        container.add(characterConfirmPanel);


    }


    //Class for a panel for intro text to introduce the story
    public void IntroText() {

        //Removing previous panels
        characterClassPanel.setVisible(false);
        characterDescriptionPanel.setVisible(false);
        characterConfirmPanel.setVisible(false);

        //Setting up the major text panel
        introTextPanel = new JPanel();
        introTextPanel.setBounds(100, 100, 980, 475);
        introTextPanel.setBackground(Color.BLACK);

        introTextLabel = new JLabel("Intro text goes here");
        introTextLabel.setForeground(Color.YELLOW);
        introTextLabel.setFont(normalFont);
        introTextPanel.add(introTextLabel);

        //Setting up a button to begin the story
        introTextConfirmPanel = new JPanel();
        introTextConfirmPanel.setBounds(900, 600, 300, 100);
        introTextConfirmPanel.setBackground(Color.BLACK);

        introTextConfirmButton = new JButton("BEGIN ADVENTURE");
        introTextConfirmButton.setBackground(Color.BLACK);
        introTextConfirmButton.setForeground(Color.YELLOW);
        introTextConfirmButton.setFont(normalFont);
        introTextConfirmButton.addActionListener(gameScreenHandler); //Button recognises the click and performs the TitleScreenHandler function
        introTextConfirmButton.setFocusPainted(false);
        introTextConfirmPanel.add(introTextConfirmButton);

        //Adding all panels to the container
        container.add(introTextPanel);
        container.add(introTextConfirmPanel);


    }



    public void CreateGameScreen() {

        //Removing the previous panels
        introTextPanel.setVisible(false);
        introTextConfirmPanel.setVisible(false);


        //Setting up the main text panel, where the player reads the story
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 980, 450);
        mainTextPanel.setBackground(Color.BLACK);

        container.add(mainTextPanel);
        //Formatting the main text panel
        mainTextArea = new JTextArea("This is the main text area. This game is going to be great I'm sure of it. Help me make a better game with good character creation");
        mainTextArea.setBounds(100, 100, 980, 450);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE); //sets the text colour
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true); //Text will automatically be wrapped

        //Adding the text to the main panel
        mainTextPanel.add(mainTextArea);

        //Setting up a choice button where different options will be available to the player
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(150, 450, 980, 150);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        container.add(choiceButtonPanel);
        
        choiceOption = new String[]{"Choice 1", "Choice 2", "Choice 3", "Choice 4"};
        //choiceButtonList[] = ChoiceButton(choiceOption.length);
        choiceButtonPanel.setLayout(new GridLayout(choiceOption.length, 1));
        //choiceButtonPanel.add(choiceButton);

        //Currently am writing all the code out explicitly until I can find a way to use the for loop method
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.YELLOW);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);


        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.BLACK);
        choice2.setForeground(Color.YELLOW);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);


        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.BLACK);
        choice3.setForeground(Color.YELLOW);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);


        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.BLACK);
        choice4.setForeground(Color.YELLOW);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);



        ShowPlayerStats();


    }

    //Creating a Class to show the player Stats
    public void ShowPlayerStats () {

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 980, 50);
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setLayout(new GridLayout(1, 6));
        container.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.YELLOW);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.RED);
        playerPanel.add(hpLabelNumber);

        staminaLabel = new JLabel("Stamina:");
        staminaLabel.setFont(normalFont);
        staminaLabel.setForeground(Color.YELLOW);
        playerPanel.add(staminaLabel);

        staminaLabelNumber = new JLabel();
        staminaLabelNumber.setFont(normalFont);
        staminaLabelNumber.setForeground(Color.GREEN);
        playerPanel.add(staminaLabelNumber);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.YELLOW);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.YELLOW);
        playerPanel.add(weaponLabelName);

        playerSetup();

    }

    //Giving the player variables such as health and the weapon equipped
    public void playerSetup() {

        playerHP = 15; //Default player HP
        playerStamina = 20; //Default player Stamina

        playerWeapon = "Broken Sword"; //Default starting weapon

        //Default values for Monster:
        monsterHP = 20;

        weaponLabelName.setText(playerWeapon);
        hpLabelNumber.setText(String.valueOf(playerHP));
        staminaLabelNumber.setText(String.valueOf(playerStamina));

        townGate();
    }

    //Classes to add functionality to the buttons, and progress the story

    //First choice that the character makes
    public void townGate () {
        position = "townGate";
        mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?"); // \n means linebreak

        choice1.setText("Talk to the Guard");
        choice2.setText("Attack the Guard");
        choice3.setText("Leave");
        choice4.setText("Do Nothing");

    }

    //Outcome of talking to the Guard
    public void talkGuard() {
        position = "talkGuard";

        mainTextArea.setText("Guard: Hello stranger. I have never seen your face before, \nI'm sorry but we cannot let a stranger enter our settlement.");

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("Return");

    }

    public void attackGuard() {
        position = "attackGuard";

        mainTextArea.setText("Guard: Don't be stupid wanderer \n\n The Guard fights back and hits you hard \n (You receive 3 damage)");

        //Changing the HP
        playerHP -= 3;
        hpLabelNumber.setText(String.valueOf(playerHP));

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("Return");

    }

    public void crossroad() {
        position = "crossroad";

        mainTextArea.setText("You are at a crossroad. \nIf you go south you will go back to the settlement.");

        choice1.setText("Go north");
        choice2.setText("Go east");
        choice3.setText("Go west");
        choice4.setText("Go south");
    }

    public void crossroadNorth() {
        position = "crossroadNorth";

        mainTextArea.setText("There is a river. You drink the water and rest at the riverside. \n\n (Your HP is recovered by 2)");
        playerHP += 2;
        hpLabelNumber.setText(String.valueOf(playerHP));

        choice1.setText("Return to the crossroad");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");


    }

    public void crossroadEast() {
        position = "crossroadEast";

        mainTextArea.setText("A forest looms in front of you. At the entrance to the great forest lies a corpse. \n The corpse clutches a Long Sword in its hands. " +
                "\n\n Do you pick up the Long Sword?");

        choice1.setText("Yes (You obtain the Long Sword)");
        choice2.setText("No (Continue into the forest)");
        choice3.setText("No (Move north along the edge of the forest)");
        choice4.setText("Return to the crossroad");

    }

    public void crossroadWest() {
        position = "crossroadWest";

        mainTextArea.setText("You encounter a monster");

        choice1.setText("Fight the monster");
        choice2.setText("Flee");
        choice3.setText("");
        choice4.setText("");

    }

    public void monsterFight() {
        position = "monsterFight";

        mainTextArea.setText("Monster HP: " + monsterHP + "\n\n What do you do?");

        choice1.setText("Attack");
        choice2.setText("Flee");
        choice3.setText("");
        choice4.setText("");
    }

    //Setting the player attack options for multiple weapons
    public void playerAttack() {
        position = "playerAttack";

        if (playerWeapon.equals("Broken Sword")) {
            //Using a random number generator to create randomised damage
            playerDamage = new java.util.Random().nextInt(2); //0-1 damage potential
            playerStaminaLoss = 4;
        }

        else if (playerWeapon.equals("Long Sword")) {
            playerDamage = new java.util.Random().nextInt(11); //0-7 damage potential
            playerStaminaLoss = 6;
        }


        monsterHP -= playerDamage;
        playerStamina -= playerStaminaLoss;
        staminaLabelNumber.setText("" + playerStamina);

        mainTextArea.setText("You attacked the monster and did " + playerDamage + " points of damage \n\n\n Monster HP: " + monsterHP);


        choice1.setText("Attack");
        choice2.setText("Flee");


    }

    //Setting the monster attack calculations
    public void monsterAttack() {
        position = "monsterAttack";

        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(1);

        mainTextArea.setText("The monster attacked you and did " + monsterDamage + " points of damage");
        playerHP -= monsterDamage;
        hpLabelNumber.setText("" + playerHP);
        playerStamina += 4;
        staminaLabelNumber.setText("" + playerStamina);

        choice1.setText(">");
        choice2.setText("Flee");


    }

    public void win() {
        position = "win";

        mainTextArea.setText("You defeated the monster. \n The monster dropped a ring. \n\n (You obtained a silver ring)");

        //Effectively saying you have the ring
        silverRing = 1;

        choice1.setText("Return to the crossroad");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void playerDeath() {
        position = "playerDeath";

        mainTextArea.setText("You died. \n\n <GAME OVER>");

        choice1.setText("Begin anew");
        choice2.setText("Flee");


    }

    public void ending() {
        position = "ending";

        mainTextArea.setText("Guard: Oh, you killed that monster? \n The settlement will forever be in your debt, welcome welcome! \n\n THE END");

        choice1.setText("Return to the crossroad (Stamina is restored)");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }



    //Title screen to character select screen
    public class CharacterScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            CreateCharacterScreen();
        }
    }

    //Character select screen to Intro Text screen
    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            IntroText();
        }
    }

    //Intro text screen to Game screen
    public class GameScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            CreateGameScreen();
        }
    }

    //Method to handle the choices taken in the main story
    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            //switch is similar to an if statement, but is better to handle lots of branches
            //First find the position (the point of the story)
            switch (position){
                case "townGate":
                    //Then choose the action for each choice
                    switch (yourChoice){
                        case "c1":
                            if (silverRing == 1) { ending(); }
                            else { talkGuard(); } break;
                        case "c2": attackGuard(); break;
                        case "c3": crossroad(); break;
                        case "c4": break;
                    }
                    break;
                case "talkGuard":
                    switch (yourChoice) {
                        case "c4": townGate(); break;
                    }
                    break;

                case "attackGuard":
                    switch (yourChoice) {

                        case "c4": townGate(); break;
                    }
                    break;

                case "crossroad":
                    switch (yourChoice) {
                        case "c1": crossroadNorth(); break;
                        case "c2": crossroadEast(); break;
                        case "c3": crossroadWest(); break;
                        case "c4": townGate(); break;
                    }
                    break;

                case "crossroadNorth":
                    switch (yourChoice) {
                        case "c1": crossroad(); break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": townGate(); break;
                    }
                    break;

                case "crossroadEast":
                    switch (yourChoice) {
                        case "c1": {
                            playerWeapon = "Long Sword";
                            weaponLabelName.setText(playerWeapon);
                        }

                        case "c2": break;
                        case "c3": break;
                        case "c4": crossroad(); break;
                    }
                    break;

                case "crossroadWest":
                    switch (yourChoice) {
                        case "c1": monsterFight(); break;
                        case "c2": crossroad(); break;
                    }
                    break;

                case "monsterFight":
                    switch (yourChoice) {
                        case "c1": playerAttack(); break;
                        case "c2": crossroad(); break;
                    }
                    break;

                case "playerAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (monsterHP < 1) {
                                win();
                            }
                            else {monsterAttack();} break;
                        case "c2": crossroad(); break;
                    }
                    break;

                case "monsterAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (playerHP < 1) {
                                playerDeath();
                            }
                            else {monsterFight();} break;
                        case "c2": crossroad(); break;
                    }
                    break;

                case "win":
                    switch (yourChoice) {
                        case "c1": {
                            playerStamina = 20;
                            staminaLabelNumber.setText("" + playerStamina);
                            crossroad();
                        } break;
                    }
                    break;

                case "playerDeath":
                    switch (yourChoice) {
                        case "c1": CreateTitleScreen(); break;
                    }
            }

        }
    }


}






