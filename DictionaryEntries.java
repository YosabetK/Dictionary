package dictionary;

public enum DictionaryEntries {
    ARROWNOUN("Arrow", "noun", "Here is one arrow:  <IMG> -=>> </IMG>"),


    BOOKNOUN1("Book", "noun", " A set of pages."),


    BOOKNOUN2("Book", "noun", " A written work published in printed or electronic form."),


    BOOKVERB1("Book", "verb", " To arrange for someone to have a seat on a plane."),


    BOOKVERB2("Book", "verb", " To arrange something on a particular date."),


    DISTINCTADJECTIVE1("Distinct", "adjective", " Familiar. Worked in Java."),


    DISTINCTADJECTIVE2("Distinct", "adjective", " Unique. No duplicates. Clearly different or of a different kind."),


    DISTINCTADVERB("Distinct", "adverb", " Uniquely. Written \"distinctly\"."),


    DISTINCTNOUN1("Distinct", "noun", "A keyword in this assignment"),


    DISTINCTNOUN2("Distinct", "noun", "A keyword in this assignment"),


    DISTINCTNOUN3("Distinct", "noun", "A keyword in this assignment"),


    DISTINCTNOUN4("Distinct", "noun", "An advanced search option."),


    DISTINCTNOUN5("Distinct", "noun", "Distinct is a parameter in this assignment."),


    PLACEHOLDERADJECTIVE1("Placeholder", "adjective", "To Be Updated..."),


    PLACEHOLDERADJECTIVE2("Placeholder", "adjective", "To Be Updated.."),


    PLACEHOLDERADJECTIVE3("Placeholder", "adverb", "To Be Updated..."),


    PLACEHOLDERCONJUNCTION("Placeholder", "conjunction", "To Be Updated..."),


    PLACEHOLDERINTERJUNCTION("Placeholder", "interjection", "To Be Updated..."),


    PLACEHOLDERNOUN1("Placeholder", "noun", "To Be Updated..."),


    PLACEHOLDERNOUN2("Placeholder", "noun", "To Be Updated..."),


    PLACEHOLDERNOUN3("Placeholder", "noun", "To Be Updated..."),


    PLACEHOLDERPREPOSITION("Placeholder", "preposition", "To Be Updated..."),


    PLACEHOLDERPRONOUN("Placeholder", "pronoun", "To Be Updated..."),


    REVERSEADJECTIVE1("Reverse", "adjective", "On back side."),


    REVERSEADJECTIVE2("Reverse", "adjective", "Opposite to usual or previous arrangement."),


    REVERSENOUN1("Reverse", "noun", " A dictionary program's parameter."),


    REVERSENOUN2("Reverse", "noun", " Change to opposite direction."),


    REVERSENOUN3("Reverse", "noun", "The opposite."),


    REVERSENOUN4("Reverse", "noun", " To be updated..."),


    REVERSENOUN5("Reverse", "noun", "To be updated..."),


    REVERSENOUN6("Reverse", "noun", "To be updated..."),


    REVERSENOUN7("Reverse", "noun", "To be updated..."),


    REVERSEVERB1("Reverse", "verb", "Change something to opposite."),


    REVERSEVERB2("Reverse", "verb", "Go back."),


    REVERSEVERB3("Reverse", "verb", "Revoke ruling."),


    REVERSEVERB4("Reverse", "verb", "To be updated..."),


    REVERSEVERB5("Reverse", "verb", "To be updated..."),


    REVERSEVERB6("Reverse", "verb", "Turn something inside out.");


    private final String generalNote = "Dictionary";


    private String keyword;


    private String partOfSpeech;


    private String definition;


    DictionaryEntries(String keyword, String partOfSpeech, String definition) {


        this.keyword = keyword;


        this.partOfSpeech = partOfSpeech;


        this.definition = definition;


    }


    public String getKeyword() {

        return this.keyword.toUpperCase();


    }


    public String getPartOfSpeech() {


        return this.partOfSpeech;


    }


    public String getDefinition() {

        return definition;

    }


    @Override


    public String toString() {


        return this.keyword + "[" + partOfSpeech + "] : " + this.definition;

    }
}
