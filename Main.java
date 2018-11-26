import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static String command;
    public static String room;

    public static int totalturns;
    public static int turnsremaining;

    public static Boolean lookbenchdone = false;
    public static Boolean openchestdone = false;
    public static Boolean getmatchesdone = false;
    public static Boolean lightcandledone = false;
    public static Boolean openlibrarydoordone = false;

    public static Boolean lookshelvesdone = false;
    public static Boolean getbookdone = false;
    public static Boolean getpendone = false;
    public static Boolean writeonbookdone = false;
    public static Boolean openconservatorydoordone = false;

    public static Boolean playtrumpetdone = false;
    public static Boolean playpianodone = false;
    public static Boolean playdrumdone = false;
    public static Boolean openescapedoordone = false;

    public static Boolean allcompleted = false;

    public static void main(String[] args) {

        totalturns = 30;
        room = "foyer"; //room can only be foyer, library, conservatory (that order)

        System.out.println("\nWelcome to the game! You have a total of " + totalturns + " turns to escape. Each command you type counts as a turn, and I am only capable of understanding two-word commands, so choose your words wisely. Type help for a total list of commands at any time during the game.");
        System.out.println("\nYou find yourself in a large foyer. There is a door to the north. To the west is a bench against the wall. To the east is a chest on the floor. In the center of the room is a large candle. The candle is unlit.");

        for (turnsremaining = totalturns; turnsremaining > 0; turnsremaining--) {
            System.out.println("** You have " + turnsremaining + " turns remaining.\n");
            System.out.print("Enter command: >> ");
            command = sc.nextLine();
//            System.out.println("You said " + command);

            if (command.equals("help") || command.equals("Help") || command.equals("HELP")) {
                help();
                turnsremaining++;
            } else if (room.equals("foyer")) {
                foyer();
            } else if (room.equals("library")) {
                library();
            } else if (room.equals("conservatory")) {
                conservatory();
            }

            if (allcompleted) {
                System.out.println("Congratulations! You have successfully escaped and completed the game in " + (totalturns - turnsremaining + 1) + " moves.");
                break;
            }

        }

        if(!allcompleted) {
            System.out.println("\nSorry, you have run out of turns. You're trapped in here forever. Click play to try again.");
        }
    }

    public static void help() {
        System.out.println("\nHere is a list of commands you can use: ");
        System.out.println("\nWord 1: open | close | light | read | write | play | look | get");
        System.out.println("Word 2: door | room | bench | chest | candle | note | matches | shelves | book | pen | scroll | music | trumpet | piano | drum | lock | north | south | east | west");
        System.out.println("\nThe command \"help\" does not count as a turn. \"Look\" used alone will restate the description of the room you are in.");
    }

    public static void foyer() {

        if (command.equals("look")) {
            System.out.println("You find yourself in a large foyer. There is a door to the north. To the west is a bench against the wall. To the east is a chest on the floor. In the center of the room is a large candle. The candle is unlit.");
        } else if (command.equals("look foyer")) {
            System.out.println("You find yourself in a large foyer. There is a door to the north. To the west is a bench against the wall. To the east is a chest on the floor. In the center of the room is a large candle. The candle is unlit.");
        } else if (command.equals("look bench")) {
            System.out.println("There is a bench on the western wall. There is a small note here.");
            lookbenchdone = true;
        } else if (command.equals("look note")) {
            if (lookbenchdone) {
                System.out.println("There is writing on the note. Read it.");
            } else {
                System.out.println("What note?");
            }
        } else if (command.equals("read note")) {
            if (lookbenchdone) {
                System.out.println("The note is written on a piece of embossed vellum paper. In script writing you can make ou the phrase \"May my light show you the way.\"");
            } else {
                System.out.println("What note?");
            }
        } else if (command.equals("look chest")) {
            System.out.println("You see a chest. It is closed. It doesn't appear to be locked.");
        } else if (command.equals("open chest")) {
            System.out.println("You open the chest. There is a box of matches here.");
            openchestdone = true;
        } else if (command.equals("look matches")) {
            if (openchestdone) {
                System.out.println("Those are cool matches. Get them.");
            } else {
                System.out.println("What matches?");
            }
        } else if (command.equals("get matches")) {
            if (openchestdone) {
                System.out.println("You take the box of matches out of the chest.");
                getmatchesdone = true;
            } else {
                System.out.println("What matches?");
            }
        } else if (command.equals("light matches")) {
            if (getmatchesdone) {
                System.out.println("You take a match out of the box and light the match.");
            } else {
                System.out.println("What matches?");
            }
        } else if (command.equals("light candle")) {
            if (getmatchesdone) {
                System.out.println("You light the candle, and fierce wind blows through the room, extinguishing the match in your hand, but making the candle burn brighter. You hear a loud metal grinding sound from the north.");
                lightcandledone = true;
            } else {
                System.out.println("How are you going to light the candle? You need something to light it with, like matches.");
            }
        } else if (command.equals("look candle")) {
            if (lightcandledone) {
                System.out.println("You have lit the candle, and you heard a loud metal grinding sound from the north.");
            } else {
                System.out.println("The candle in the center of the room is not lit.");
            }
        } else if (command.equals("look north")) {
            if (lightcandledone) {
                System.out.println("You see the north door. It is closed, but unlocked.");
            } else {
                System.out.println("You see the north door. It is closed and locked.");
            }
        } else if (command.equals("look door")) {
            if (lightcandledone) {
                System.out.println("The door to the north is closed, but unlocked.");
            } else {
                System.out.println("The door to the north is closed and locked. You need to figure out how to unlock it.");
            }
        } else if (command.equals("open door")) {
            if (lightcandledone) {
                System.out.println("The north door is open.");
                openlibrarydoordone = true;
            } else {
                System.out.println("The door is locked. You can't open it until you unlock it.");
            }
        } else if (command.equals("go north")) {
            if (openlibrarydoordone) {
                System.out.println("You leave the foyer, the door behind you closes with a loud slam, and you hear the locking mechanism relock the door. You cannot return to the foyer.\n");
                room = "library";
                System.out.println("You now find yourself in a library full of shelves of books. In the center of the room is a desk. On the desk is a pen and a scroll. There is a door to the north.");
            } else {
                System.out.println("You go north and find yourself at the closed door.");
            }
        } else {
            System.out.println("I'm sorry, I do not understand your command.");
        }

    }

    public static void library() {

        if (command.equals("look")) {
            System.out.println("You now find yourself in a library full of shelves of books. In the center of the room is a desk. On the desk is a pen and a scroll. There is a door to the north.");
        } else if (command.equals("look library")) {
            System.out.println("You now find yourself in a library full of shelves of books. In the center of the room is a desk. On the desk is a pen and a scroll. There is a door to the north.");
        } else if (command.equals("look books")) {
            System.out.println("There are a lot of books.");
        } else if (command.equals("look desk")) {
            System.out.println("On the desk you see a pen and a scroll. There is something written on the scroll.");
        } else if (command.equals("look scroll")) {
            System.out.println("There's something written on the scroll. Read it.");
        } else if (command.equals("read scroll")) {
            System.out.println("The scroll says, \"Share your story.\"");
        } else if (command.equals("look shelves")) {
            System.out.println("You look through the shelves and find a book that is open. The book is titled, \"The Autobiography of ___\" with the rest of the title empty. Get that book. You probably have to fill in the blank.");
            lookshelvesdone = true;
        } else if (command.equals("get book")) {
            if (lookshelvesdone) {
                System.out.println("You get that book. Now you need to write the rest of the title.");
                getbookdone = true;
            } else {
                System.out.println("What book?");
            }
        } else if (command.equals("look pen")) {
            System.out.println("You look at the pen. It's a cool pen.");
        } else if (command.equals("get pen")) {
            System.out.println("You get the pen and now need to write on something.");
            getpendone = true;
        } else if (command.equals("write name")) {
            if (getpendone && getbookdone) {
                System.out.println("You write your name on that book and hear a loud metal grinding sound from the north.");
                writeonbookdone = true;
            } else {
                System.out.println("Where and how will you write your name?");
            }
        } else if (command.equals("write book")) {
            if (getpendone && getbookdone) {
                System.out.println("You write your name on that book and hear a loud metal grinding sound from the north.");
                writeonbookdone = true;
            } else {
                System.out.println("Where and how will you write?");
            }
        } else if (command.equals("look north")) {
            System.out.println("You look to the north and see the door.");
        } else if (command.equals("look door")) {
            if (writeonbookdone) {
                System.out.println("You see the door is still closed, but is now unlocked.");
            } else {
                System.out.println("You see the door is closed and locked. You need to figure out how to unlock it.");
            }
        } else if (command.equals("open door")) {
            if (writeonbookdone) {
                System.out.println("You open the north door.");
                openconservatorydoordone = true;
            } else {
                System.out.println("The door is locked. You can't open it until you unlock it.");
            }
        } else if (command.equals("go north")) {
            if (openconservatorydoordone) {
                System.out.println("You leave the library, the door behind you closes with a loud slam, and you hear the locking mechanism relock the door. You cannot return to the library.\n");
                room = "conservatory";
                System.out.println("You find yourself in a conservatory. The conservatory is beautiful, with high ceilings, bright lights illuminating the entire room, and hundreds of empty seats. In the center you see a trumpet, a drum, and a piano, next to a music stand. There is a piece of sheet music on the stand. There is a door to the north.");
            } else {
                System.out.println("You go north and find yourself at the closed door.");
            }
        } else {
            System.out.println("I'm sorry, I do not understand your command.");
        }
    }

    public static void conservatory() {


        if (command.equals("look")) {
            System.out.println("You find yourself in a conservatory. The conservatory is beautiful, with high ceilings, bright lights illuminating the entire room, and hundreds of empty seats. In the center you see a trumpet, a drum, and a piano, next to a music stand. There is a piece of sheet music on the stand. There is a door to the north.");
        } else if (command.equals("look conservatory")) {
            System.out.println("You find yourself in a conservatory. The conservatory is beautiful, with high ceilings, bright lights illuminating the entire room, and hundreds of empty seats. In the center you see a trumpet, a drum, and a piano, next to a music stand. There is a piece of sheet music on the stand. There is a door to the north.");
        } else if (command.equals("look trumpet")) {
            System.out.println("You look at the trumpet. Luckily you know how to play this instrument.");
        } else if (command.equals("look drum")) {
            System.out.println("You look at the drum. Luckily you know how to play this instrument.");
        } else if (command.equals("look piano")) {
            System.out.println("You look at the piano. Luckily you know how to play this instrument.");
        } else if (command.equals("look stand")) {
            System.out.println("You look at the music stand and see the piece of sheet music on it.");
        } else if (command.equals("look music")) {
            System.out.println("You look at the sheet music on the stand and see something written on it. Read it.");
        } else if (command.equals("read music")) {
            System.out.println("You read the sheet music and see that there are no music notes on the page. The only thing on the sheet is the phrase, \"Timbre, Tone, and Time\" is written. Perhaps this relates to the instruments.");
        } else if (command.equals("look sheet")) {
            System.out.println("You look at the sheet music on the stand and see something written on it. Read it.");
        } else if (command.equals("read sheet")) {
            System.out.println("You read the sheet music and see that there are no music notes on the page. The only thing on the sheet is the phrase, \"Timbre, Tone, and Time\" is written. Perhaps this relates to the instruments.");
        } else if (command.equals("play trumpet")) {
            System.out.println("You play the trumpet. What a bright timbre.");
            playtrumpetdone = true;
        } else if (command.equals("play piano")) {
            if (playtrumpetdone) {
                System.out.println("You play the piano. What a beautiful tone.");
                playpianodone = true;
            } else {
                System.out.println("You play the piano. What a beautiful tone. You have to play the trumpet before the piano, though.");
                playtrumpetdone = false;
                playpianodone = false;
            }
        } else if (command.equals("play drum")) {
            if (playtrumpetdone && playpianodone) {
                System.out.println("You play the drum. What a fast time. You hear a loud metal grinding sound from the north.");
                playdrumdone = true;
            } else {
                System.out.println("You play the drum. What a fast time. You have to play the trumpet and piano before the drum, though.");
                playtrumpetdone = false;
                playpianodone = false;
                playdrumdone = false;
            }
        } else if (command.equals("look north")) {
            System.out.println("You look to the north and see the door.");
        } else if (command.equals("look door")) {
            if (playdrumdone) {
                System.out.println("You see the door is still closed, but is now unlocked.");
            } else {
                System.out.println("You see the door is closed and locked. You need to figure out how to unlock it.");
            }
        } else if (command.equals("open door")) {
            if (playdrumdone) {
                System.out.println("You open the north door. Freedom appears to be close!");
                openescapedoordone = true;
            } else {
                System.out.println("The door is locked. You can't open it until you unlock it.");
            }
        } else if (command.equals("go north")) {
            if (openescapedoordone) {
                System.out.println("You leave the conservatory, the door behind you closes with a loud slam, and you hear the locking mechanism relock the door. You cannot return to the conservatory. You find yourself outside!\n");
                allcompleted = true;
            } else {
                System.out.println("You go north and find yourself at the closed door.");
            }
        } else {
            System.out.println("I'm sorry, I do not understand your command.");
            }
        }

}



