/**
* CW9
* lab4 t5_1
* Run file t5_1.java to check the result.
* @author Yaroslav Yanhol
*/
package lab4.CW9;

public class t5_1 {
    
    public static class Word {

        private String word;

        Word(String ob){this.word = ob;}
        Word(){this.word = "";}
        

        public void set(String word){this.word = word;}
        public String get(){return this.word;}

        public boolean equals(Word ob){
            if (word == null) return ob.word == null;
            return this.word.equals(ob.word);
        }

        @Override
        public int hashCode(){

            int hash = 0;
            int p = 31;
            int m = 10000009;

            for (int i = 0; i < this.word.length(); i++) {
                hash = (int)(((long)hash * p + this.word.charAt(i)) % m);
            }

            return hash;

        }

        @Override
        public String toString(){
            return this.word;
        }

    }

    public static class Sentence {

        final private Word sentence[] = new Word[256];

        Sentence(){}
        Sentence(Sentence ob){for(int i = 0; i < ob.sentence.length; i++) this.sentence[i] = ob.sentence[i];}
        Sentence(Word ob[]){for(int i = 0; i < ob.length; i++) this.sentence[i] = ob[i];}
        Sentence(String ob[]){for(int i = 0; i < ob.length; i++) this.sentence[i] = new Word(ob[i]);} 


        public void setByWords(Word ob[]){for(int i = 0; i < ob.length; i++) this.sentence[i] = ob[i];}
        public void setByStrArr(String ob[]){for(int i = 0; i < ob.length; i++) this.sentence[i] = new Word(ob[i]);}
        public Word[] getWordsArr(){return this.sentence;}
        public String[] getStrArr(){
            String ob[] = new String[256];
            for(int i = 0; i < this.sentence.length; i++){
                if (this.sentence[i] == null) break;
                ob[i] = this.sentence[i].toString();
            }
            return ob;
        }

        public boolean equals(Sentence ob){
            if (sentence == null) return ob.sentence == null;
            for (int i = 0; i < this.sentence.length; i++){
                if (this.sentence[i] == null) break;
                if (!this.sentence[i].equals(ob.sentence[i])) return false;
            }
            return true;
        }

        @Override
        public int hashCode(){

            int hash = 0;
            int p = 31;
            int m = 10000009;

            for (int i = 0; i < this.sentence.length; i++) {
                hash = (int)(((long)hash * p + this.sentence[i].hashCode()) % m);
            }

            return hash;

        }

        @Override
        public String toString(){

            StringBuilder str = new StringBuilder();
            for (Word word: sentence){
                if (word == null) break;
                str.append(word.toString()).append(' ');
            }
            return str.toString();
        }

    }

    public static class Text {

        final private Sentence text[] = new Sentence[256];
        private String heading;

        Text(){this.heading = "";}
        Text(Text ob){this.heading = ""; for(int i = 0; i < ob.text.length; i++) this.text[i] = ob.text[i];}

        public boolean equals(Text ob){
            if (text == null) return ob.text == null;
            return this.text.equals(ob.text);
        }

        @Override
        public int hashCode(){

            int hash = 0;
            int p = 31;
            int m = 10000009;

            for (int i = 0; i < this.text.length; i++) {
                hash = (int)(((long)hash * p + this.text[i].hashCode()) % m);
            }

            return hash;

        }

        @Override
        public String toString(){

            StringBuilder str = new StringBuilder();
            for (Sentence sentence: text){
                if (sentence == null) break;
                str.append(sentence.toString()).append(' ');
            }
            return str.toString();
        }

        public void consoleOut(){

            System.out.print(this.toString());

        }

        public void insertSentence(int pos, Sentence ob){

            Sentence s = this.text[pos];
            this.text[pos] = ob;
            for(int i = pos + 1; i < this.text.length - 1; i++){
                Sentence s2 = this.text[i + 1];
                this.text[i + 1] = s;
                s = s2;
            }

        }

        public void setHead(String heading){this.heading = heading;}
        public String getHead(){return this.heading;}

    }

    public static void main(String args[]){
        
        //this is a test section
        Word tWord1 = new Word("Test");
        Word tWord2 = new Word("number");
        Word tWord3 = new Word("1");
        Word tWordsArr[] = {tWord1, tWord2, tWord3};
        Sentence tSentence1 = new Sentence(tWordsArr);
        Sentence tSentence2 = new Sentence(tWordsArr);
        System.out.printf("%b\n", tSentence1.equals(tSentence2));


        Word tWord4 = new Word("2");
        tWordsArr[2] = tWord4;
        tSentence2.setByWords(tWordsArr);
        System.out.printf("%b\n", tSentence1.equals(tSentence2));
        System.out.printf("%s\n", tSentence1.toString());
        System.out.printf("%s\n", tSentence2.toString());

    }
}
