/****************************************************************
*
* File: [Dictionary]
* By: [Yosabet Kassie]
* Date: [9-18-2020]
*
* Description: [This is a interactive dictionary program. you can lookup words and get thier definition and 
* part of speech.]
*             
*
****************************************************************/
package dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

    public class Dictionary {

        //default variables like lengths and sizes
        private final int maxLength = 4;
        private final String[] partOfSpeeches = {"NOUN", "VERB", "ADJECTIVE", "ADVERB", "PRONOUN", "PREPOSITION", "CONJUNCTION", "INTERJECTION"};

        //instance variables
        private HashMap<String, ArrayList<DictionaryEntries>> hMap;
        private String[] userElements;
        private String word, partOfSpeech;
        private boolean distinct, reverse;
        private ArrayList <DictionaryEntries> result, secondResult, thirdResult;

        public Dictionary() {
            this.hMap = new HashMap<String, ArrayList<DictionaryEntries>>();
            this.userElements = new String[maxLength];
        }

        public static void main(String[] args) {
            Dictionary dictionary = new Dictionary();
            dictionary.program();
        }

        /* methods to perform tasks */

        //program will then determine every situation
        public void program() {

            boolean exitStatus = false;
            int count = 1;

            //load the data
            if (this.loadStartingScreen()) //if this is true then program can't load. finished.
                return;

            do {

                //user to input the data
                this.userInput(count++); //finished.
                //analyze the user's input
                if(userElements[0].equalsIgnoreCase("!q")) {
                    exitStatus = true;
                    System.out.println("\t\n-----THANK YOU-----");
                    break;
                }
                System.out.println("\t|");
                this.analyze();
                int mode= this.checkWord();

                if(mode ==2 && this.collectData()){
                    this.printData();
                }if(mode == 3) {
                    System.out.println("\t<Not Found>  To be considered for the next release. Thank you.");
                }

                partOfSpeech= null;
                distinct= false;
                reverse= false;

                System.out.println("\t|");
            } while (!exitStatus);
        }

        //functions to use when it's start of the program
        public boolean loadStartingScreen() {

            System.out.println("! loading data...");

            try {
                for (DictionaryEntries diction : DictionaryEntries.values()) {

                    String keyword = diction.getKeyword();
                    ArrayList<DictionaryEntries> list = (hMap.containsKey(keyword)) ? hMap.get(keyword) : new ArrayList<DictionaryEntries>();
                    list.add(diction);
                    hMap.put(keyword, list);

                }
            } catch (Exception error) {
                return true;
            }

            System.out.println("! Loading complete..");
            System.out.println("\n===== DICTIONARY 340 JAVA =====\n");
            System.out.println("----- Keywords: 19");
            System.out.println("----- Definitions: 61");

            return false;
        }

        //user input should allow user to type the desired input and scanned into the system.
        public void userInput(int time) {

            //prompt the user
            System.out.print("Search\t[" + time + "]\t: ");

            //ask the user for its input
            Scanner userInput = new Scanner(System.in);
            userElements = (userInput.nextLine()).split(" ");

        }

        //analyze the situations that the user inputted.
        public void analyze() {

            for (int i = 1; i < userElements.length; i++) {
                this.checkEachParameter(userElements[i], i + 1);
            }
        }

        private int checkWord() {

            if (this.checkDefaultInputs()) {
                return 1;
            } else if (hMap.containsKey(userElements[0].toUpperCase())) {
                word = userElements[0];
                return 2;
            }

            return 3;
        }

        private boolean checkDefaultInputs() {
            if (userElements[0].equalsIgnoreCase("!help") || userElements[0].length() == 0) {
                System.out.println("\tPARAMETER HOW-TO, please enter:");
                System.out.println("\t1. A search key -then 2. An optional part of speech -then");
                System.out.println("\t3. An optional 'distinct' -then 4. An optional 'reverse'");
                return true;
            }
            return false;
        }

        private void checkEachParameter(String input, int count) {

            String numberTH = "";
            String lastMessage = "";
            boolean printError = false;
            boolean checkDR= true;

            if (input.equalsIgnoreCase("reverse")) {
                reverse = true;
                checkDR = false;
            } else if (input.equalsIgnoreCase("distinct")) {
                distinct = true;
                checkDR = false;
            } else {
                printError = true;
            }

            switch (count) {
                case 2:
                    numberTH += count + "nd";
                    if (Arrays.asList(partOfSpeeches).contains(input.toUpperCase())) {
                        partOfSpeech = input;
                        printError = false;
                    } else if(checkDR) {
                        printError = true;
                        System.out.println("\t<The entered 2nd parameter '" + input + "' is NOT a part of speech.>");
                        lastMessage = "\t<The " + numberTH + " parameter should be a part of speech or 'distinct' or 'reverse'.>";
                    }
                    break;
                case 3:
                    numberTH += count + "rd";
                    lastMessage = "\t<The " + numberTH + " parameter should be 'distinct' or 'reverse'.>";
                    break;
                default:
                    numberTH += count + "th";
                    lastMessage = "\t<The " + numberTH + " parameter should be 'reverse'.>";
            }

            if (printError) {
                System.out.println("\t<The entered " + numberTH + " parameter '" + input + "' is NOT 'distinct'.>");
                System.out.println("\t<The entered " + numberTH + " parameter '" + input + "' is NOT 'reverse'.>");
                System.out.println("\t<The entered " + numberTH + " parameter '" + input + "' was disregarded.>");
                System.out.println(lastMessage);
                System.out.println("\t|");
            }
        }

        public boolean collectData() {
            result = hMap.get(word.toUpperCase());
            //System.out.println(result.toString());
            secondResult = (distinct) ? returnDictionaryWithDistinctPartOfSpeech(result) : result;
            thirdResult = (partOfSpeech != null) ? returnDictionaryWithSamePartOfSpeech(secondResult, partOfSpeech) : secondResult;

            return thirdResult != null && thirdResult.size() > 0;
        }

        public void printData(){

            if (reverse) {

                for (int i = thirdResult.size() - 1; i >= 0; i--) {
                    System.out.println("\t" + thirdResult.get(i));
                }

            } else{

                for (DictionaryEntries key : thirdResult) {
                    System.out.print("    " + key + "\n");
                }

            }
        }

        public ArrayList<DictionaryEntries> returnDictionaryWithDistinctPartOfSpeech(ArrayList<DictionaryEntries> dictionList) {

            HashMap<String, DictionaryEntries> hMap = new HashMap<String, DictionaryEntries>();
            ArrayList<DictionaryEntries> tmp = new ArrayList<DictionaryEntries>();
            String dup = "";

            if (dictionList != null) {
                for (DictionaryEntries diction : dictionList) {
                    if (!dup.contains(diction.getDefinition())) {
                        dup += diction.getDefinition() + "|";
                        tmp.add(diction);
                    }
                }
            }

            return tmp;
        }

        /*returns new array list based on existing array list and part of speech user inputs*/
        public ArrayList<DictionaryEntries> returnDictionaryWithSamePartOfSpeech(ArrayList<DictionaryEntries> dictionList, String partOfSpeech) {

            ArrayList<DictionaryEntries> result = new ArrayList<DictionaryEntries>();

            if (dictionList != null) {
                for (DictionaryEntries diction : dictionList) {
                    if (diction.getPartOfSpeech().equalsIgnoreCase(partOfSpeech)) {
                        result.add(diction);
                    }
                }
            }

            return result;
        }
    }

