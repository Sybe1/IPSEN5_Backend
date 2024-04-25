package ipsen5.services;

import org.passay.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserInputValidator {
    public boolean isValidPassword(String password) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new WhitespaceRule()));

        RuleResult result = validator.validate(new PasswordData(password));
        return result.isValid();
    }

    public boolean isValidEmail(String email) {
        final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public boolean isValidFirstName(String first_name) {
        final Pattern VALID_FIRST_NAME_REGEX = Pattern.compile("^(?=.*[a-zA-Z])[\\p{L}\\s-_]+$");
        Matcher matcher = VALID_FIRST_NAME_REGEX.matcher(first_name);
        return matcher.find();
    }

    public boolean isValidLastName(String last_name) {
        final Pattern VALID_LAST_NAME_REGEX = Pattern.compile("^(?=.*[a-zA-Z])[\\p{L}\\s-_]+$");
        Matcher matcher = VALID_LAST_NAME_REGEX.matcher(last_name);
        return matcher.find();
    }


    public boolean isValidDonationLink(String donation_link) {
        final Pattern VALID_DONATION_LINK_REGEX = Pattern.compile("^(https?|ftp):\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)$");
        Matcher matcher = VALID_DONATION_LINK_REGEX.matcher(donation_link);
        return matcher.find();
    }
}
