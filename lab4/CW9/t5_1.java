/**
 * CW9
 * lab4 t5_1
 * Run file t5_1.java to check the result.
 * @author Yaroslav Yanhol
 */
package lab4.CW9;

import java.util.StringTokenizer;

public class t5_1 {

    public static class Word {

        private String word;

        /**
         * Constructor to initialize a Word object with a given string.
         * @param ob The string to initialize the Word object with.
         */
        Word(String ob) {
            this.word = ob;
        }

        /**
         * Default constructor to create an empty Word object.
         */
        Word() {
            this.word = "";
        }

        /**
         * Set the word to a new string value.
         * @param word The new string value for the Word object.
         */
        public void set(String word) {
            this.word = word;
        }

        /**
         * Get the word as a string.
         * @return The word as a string.
         */
        public String get() {
            return this.word;
        }

        /**
         * Check if two Word objects are equal.
         * @param ob The Word object to compare.
         * @return true if the objects are equal, false otherwise.
         */
        public boolean equals(Word ob) {
            if (word == null) return ob.word == null;
            return this.word.equals(ob.word);
        }

        @Override
        public int hashCode() {
            int hash = 0;
            int p = 31;
            int m = 10000009;

            for (int i = 0; i < this.word.length(); i++) {
                hash = (int) (((long) hash * p + this.word.charAt(i)) % m);
            }

            return hash;
        }

        @Override
        public String toString() {
            return this.word;
        }
    }

    public static class Sentence {

        final private Word sentence[] = new Word[256];

        /**
         * Default constructor to create an empty Sentence object.
         */
        Sentence() {
        }

        /**
         * Copy constructor to create a Sentence object from another Sentence object.
         * @param ob The Sentence object to copy.
         */
        Sentence(Sentence ob) {
            for (int i = 0; i < ob.sentence.length; i++) {
                this.sentence[i] = ob.sentence[i];
            }
        }

        /**
         * Constructor to create a Sentence object from an array of Word objects.
         * @param ob An array of Word objects.
         */
        Sentence(Word ob[]) {
            for (int i = 0; i < ob.length; i++) {
                this.sentence[i] = ob[i];
            }
        }

        /**
         * Constructor to create a Sentence object from an array of strings.
         * @param ob An array of strings to initialize Word objects in the Sentence.
         */
        Sentence(String ob[]) {
            for (int i = 0; i < ob.length; i++) {
                this.sentence[i] = new Word(ob[i]);
            }
        }

        /**
         * Constructor to create a Sentence object from a string, splitting it by spaces.
         * @param sentenceString The input string to create the Sentence.
         */
        Sentence(String ob) {
            StringTokenizer tokenizer = new StringTokenizer(ob, " ");
            int i = 0;
            while (tokenizer.hasMoreTokens() && i < 256) {
                String token = tokenizer.nextToken();
                this.sentence[i] = new Word(token);
                i++;
            }
        }

        /**
         * Set the Sentence object by an array of Word objects.
         * @param ob An array of Word objects to set the Sentence.
         */
        public void setByWords(Word ob[]) {
            for (int i = 0; i < ob.length; i++) {
                this.sentence[i] = ob[i];
            }
        }

        /**
         * Set the Sentence object by an array of strings.
         * @param ob An array of strings to initialize Word objects in the Sentence.
         */
        public void setByStrArr(String ob[]) {
            for (int i = 0; i < ob.length; i++) {
                this.sentence[i] = new Word(ob[i]);
            }
        }

        /**
         * Set the Sentence object from a string, splitting it by spaces.
         * @param sentenceString The input string to set the Sentence.
         */
        public void set(String ob) {
            StringTokenizer tokenizer = new StringTokenizer(ob, " ");
            int i = 0;
            while (tokenizer.hasMoreTokens() && i < 256) {
                String token = tokenizer.nextToken();
                this.sentence[i] = new Word(token);
                i++;
            }
        }

        /**
         * Get the array of Word objects in the Sentence.
         * @return An array of Word objects.
         */
        public Word[] getWordsArr() {
            return this.sentence;
        }

        /**
         * Get the Sentence as an array of strings.
         * @return An array of strings.
         */
        public String[] getStrArr() {
            String ob[] = new String[256];
            for (int i = 0; i < this.sentence.length; i++) {
                if (this.sentence[i] == null) break;
                ob[i] = this.sentence[i].toString();
            }
            return ob;
        }

        /**
         * Check if two Sentence objects are equal.
         * @param ob The Sentence object to compare.
         * @return true if the objects are equal, false otherwise.
         */
        public boolean equals(Sentence ob) {
            if (sentence == null) return ob.sentence == null;
            for (int i = 0; i < this.sentence.length; i++) {
                if (this.sentence[i] == null) break;
                if (!this.sentence[i].equals(ob.sentence[i])) return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            int p = 31;
            int m = 10000009;

            for (int i = 0; i < this.sentence.length; i++) {
                hash = (int) (((long) hash * p + this.sentence[i].hashCode()) % m);
            }
 
            return hash;
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            for (Word word : sentence) {
                if (word == null) break;
                str.append(word.toString()).append(' ');
            }
            return str.toString();
        }
    }

    public static class Text {

        final private Sentence text[] = new Sentence[256];
        private String heading;

        /**
         * Default constructor to create a Text object with an empty heading.
         */
        Text() {
            this.heading = "";
        }

        /**
         * Copy constructor to create a Text object from another Text object.
         * @param ob The Text object to copy.
         */
        Text(Text ob) {
            this.heading = "";
            for (int i = 0; i < ob.text.length; i++) {
                this.text[i] = ob.text[i];
            }
        }

         /**
         * Constructor to create a Text object from an array of Sentence objects.
         * @param ob An array of Sentence objects to initialize the Text.
         */
        Text(Sentence ob[]) {
            for (int i = 0; i < ob.length; i++) {
                this.text[i] = ob[i];
            }
        }

        /**
         * Constructor to create a Text object from an array of strings.
         * @param ob An array of strings to initialize Sentence objects in the Text.
         */
        Text(String ob[]) {
            for (int i = 0; i < ob.length; i++) {
                this.text[i] = new Sentence(ob);
            }
        }

        /**
         * Set the Text object by an array of Sentence objects.
         * @param ob An array of Sentence objects to set the Text.
         */
        public void setBySentences(Sentence ob[]) {
            for (int i = 0; i < ob.length; i++) {
                this.text[i] = ob[i];
            }
        }

        /**
         * Set the Text object by an array of strings.
         * @param ob An array of strings to initialize Sentence objects in the Text.
         */
        public void setByStrArr(String ob[]) {
            for (int i = 0; i < ob.length; i++) {
                this.text[i] = new Sentence(ob);
            }
        }

        /**
         * Get the array of Sentence objects in the Text.
         * @return An array of Sentence objects.
         */
        public Sentence[] getSentencesArr() {
            return this.text;
        }

        /**
         * Get the Text as an array of strings.
         * @return An array of strings representing the Text.
         */
        public String[] getStrArr() {
            String ob[] = new String[256];
            for (int i = 0; i < this.text.length; i++) {
                if (this.text[i] == null) break;
                ob[i] = this.text[i].toString();
            }
            return ob;
        }

        /**
         * Check if two Text objects are equal.
         * @param ob The Text object to compare.
         * @return true if the objects are equal, false otherwise.
         */
        public boolean equals(Text ob) {
            if (text == null) return ob.text == null;
            return this.text.equals(ob.text);
        }

        @Override
        public int hashCode() {
            int hash = 0;
            int p = 31;
            int m = 10000009;

            for (int i = 0; i < this.text.length; i++) {
                hash = (int) (((long) hash * p + this.text[i].hashCode()) % m);
            }

            return hash;
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            for (Sentence sentence : text) {
                if (sentence == null) break;
                str.append(sentence.toString()).append('\n');
            }
            return str.toString();
        }

        /**
         * Print the Text to the console.
         */
        public void consoleOut() {
            System.out.printf("%s", this.toString());
        }

        /**
         * Insert a Sentence at a specific position in the Text.
         * @param pos The position to insert the Sentence.
         * @param ob The Sentence to insert.
         */
        public void insertSentence(int pos, Sentence ob) {
            Sentence s = this.text[pos];
            this.text[pos] = ob;
            for (int i = pos; i < this.text.length - 1; i++) {
                Sentence s2 = this.text[i + 1];
                this.text[i + 1] = s;
                s = s2;
            }
        }

        /**
         * Set the heading of the Text.
         * @param heading The new heading for the Text.
         */
        public void setHead(String heading) {
            this.heading = heading;
        }

        /**
         * Get the heading of the Text.
         * @return The heading of the Text.
         */
        public String getHead() {
            return this.heading;
        }
    }

    public static void main(String args[]) {

        // This is a test section
        Word tWord1 = new Word("Test");
        Word tWord2 = new Word("number");
        Word tWord3 = new Word("1");
        Word tWordsArr[] = {tWord1, tWord2, tWord3};
        Sentence tSentence1 = new Sentence(tWordsArr);
        Sentence tSentence2 = new Sentence(tWordsArr);
        System.out.printf("First sentence: %s\n", tSentence1.toString());
        System.out.printf("Second sentence: %s\n", tSentence2.toString());
        System.out.printf("Equal? %b\n\n", tSentence1.equals(tSentence2));

        Word tWord4 = new Word("2");
        tWordsArr[2] = tWord4;
        tSentence2.setByWords(tWordsArr);
        System.out.printf("First sentence: %s\n", tSentence1.toString());
        System.out.printf("Second sentence: %s\n", tSentence2.toString());
        System.out.printf("Equal? %b\n\n", tSentence1.equals(tSentence2));

        Sentence tSentence3 = new Sentence("Test number 3");
        Sentence tSentencesArr[] = {tSentence1, tSentence2, tSentence3};
        Text tText = new Text(tSentencesArr);
        tText.setHead("Tests list");

        Sentence tSentence4 = new Sentence("There is a list of tests:");
        tText.insertSentence(0, tSentence4);

        System.out.printf("Text output:\n");
        System.out.printf("%s\n", tText.getHead());
        tText.consoleOut();

    }

}
