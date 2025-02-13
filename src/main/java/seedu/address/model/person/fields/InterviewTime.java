package seedu.address.model.person.fields;

import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Person's interview time in the address book.
 */

public class InterviewTime {

    public static final String TYPE = "Interview Time";
    public static final String MESSAGE_CONSTRAINTS =
        "Interview time should be in the format of DD/MM/YYYY HHmm. To cancel the interview, enter "
            + "'cancel' (case sensitive)";

    public static final String VALIDATION_REGEX = "^\\d{2}/\\d{2}/\\d{4} \\d{4}$";

    private final String time;

    /**
     * Constructs a {@code InterviewTime}.
     *
     * @param interviewTime A valid interview time.
     */
    public InterviewTime(String interviewTime) {
        checkArgument(isValidTime(interviewTime), MESSAGE_CONSTRAINTS);
        this.time = interviewTime;
    }

    /**
     * Returns true if a given string is a valid interview time.
     *
     * @param test The string to test.
     * @return True if the string is a valid interview time, false otherwise.
     */
    public static boolean isValidTime(String test) {
        return test.equals("cancel") || test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        //instanceof handles null
        if (!(other instanceof InterviewTime)) {
            return false;
        }

        InterviewTime otherInterviewTime = (InterviewTime) other;

        return time.equals(otherInterviewTime.time);
    }

    @Override
    public String toString() {
        if (time.equals("cancel")) {
            return "Interview time has not been set";
        }
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        LocalDateTime dateTime = LocalDateTime.parse(this.time, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy h:mma");
        String formattedDateTime = dateTime.format(outputFormatter);
        return "Interview scheduled at: " + formattedDateTime;
    }

    @Override
    public int hashCode() {
        return time.hashCode();
    }

    public String getTime() {
        return this.time;
    }
}
