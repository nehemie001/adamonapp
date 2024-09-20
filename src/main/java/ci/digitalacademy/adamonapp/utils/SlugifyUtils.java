package ci.digitalacademy.adamonapp.utils;

import com.github.slugify.Slugify;

import java.util.UUID;

public class SlugifyUtils {

    private SlugifyUtils() {

    }

    public static String generate(String input) {
//        return input.toLowerCase().replaceAll("[^a-z0-9]", "-");
        String value = String.format("%s, %s", input, UUID.randomUUID());
        final Slugify slg = Slugify.builder().underscoreSeparator(true).build();
        return slg.slugify(value);
//        return result.substring(0, Math.min(result.length(), 100));
    }
}
