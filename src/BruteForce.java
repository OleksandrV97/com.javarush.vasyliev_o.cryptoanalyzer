public class BruteForce {
    public String decryptByBruteForce(String encryptedText, char[] alphabet) {
        StringBuilder result = new StringBuilder();

        if (encryptedText == null) {
            throw  new IllegalArgumentException("Не может быть null");
        }for (int shift = 1; shift < alphabet.length; shift++) {
            String decryptedText = Cypher.decrypt(encryptedText, shift);
            result.append("Сдвиг ").append(shift).append(": ").append(decryptedText).append("\n");
        }
        return result.toString();
    }
}