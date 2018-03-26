package helpers;

import java.util.Random;

public class RandomHelper {

    public String randomIdGenerator(int length){
        String candidateChars = "qwertyuiopasdfghjklzxcvbnm0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }
}
