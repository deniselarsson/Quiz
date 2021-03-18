/** serialiserde objektet
 @author  Denisé Larsson
 */

package app;

import java.io.Serializable;

public class Option implements Serializable {

    // The text for the option
    private String text;
    // Set to true if the option is correct
    private boolean isCorrectAnswer;

    //för att organisera options
    //Måste finnas en text och en boolean
    Option (String text, boolean isCorrectAnswer) {
        this.text = text;
        this.isCorrectAnswer = isCorrectAnswer;
    }

    // Gets the text for the option
    public String getText () {
        return text;
    }

    // Sets the text for the option
    public void setText(String text) {
        this.text = text;
    }

    // Gets a boolean indicating if the option is a correct answer
    public boolean getIsCorrectAnswer () {
        return isCorrectAnswer;
    }

    // Sets if the option is a correct answer
    public void setIsCorrectAnswer (boolean isCorrectAnswer) {
        this.isCorrectAnswer = isCorrectAnswer;
    }
}