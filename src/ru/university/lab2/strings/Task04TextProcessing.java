package ru.university.lab2.strings;

public class Task04TextProcessing {

    public void run() {
        checkPalindromes();
        reverseWordsOrder();
        countCharCategoriesDemo();
        caesarCipherDemo();
        findLongestWordDemo();
    }

    private void checkPalindromes() {
        System.out.println("1. Палиндром");
        String s1 = "А роза упала на лапу Азора";
        String s2 = "Hello";
        System.out.println(isPalindrome(s1) ? "палиндром" : "не палиндром");
        System.out.println(isPalindrome(s2) ? "палиндром" : "не палиндром");
    }

    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while (start < end){
            while (start < end && !Character.isLetterOrDigit(s.charAt(start)))
                start += 1;
            while (end > start && !Character.isLetterOrDigit(s.charAt(end)))
                end -= 1;
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                return false;
            start += 1;
            end -= 1;
        }
        return true;
    }

    private void reverseWordsOrder() {
        System.out.println("2. Разворот порядка слов");
        String s = "кот съел мышь";
        System.out.println(s);

        String[] words = s.split(" ");
        String reversed = "";
        for (int i = words.length - 1; i >= 0; i--){
            reversed += words[i];
            reversed += " ";
        }
        System.out.println(reversed);

    }

    private void countCharCategoriesDemo() {
        System.out.println("3. Подсчёт категорий символов за один проход");
        String s = "Hello world 2026!";
        System.out.println(s);

        String vowels = "aeiouAEIOUаеёиоуыэюяАЕЁИОУЫЭЮЯ";
        int v = 0;
        int c = 0;
        int digits = 0;
        int spaces = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                spaces++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isLetter(ch)) {
                if (vowels.indexOf(ch) != -1) {
                    v++;
                } else {
                    c++;
                }
            }
        }
        System.out.println("Гласных: " + v + ", согласных: " + c
                + ", цифр: " + digits + ", пробелов: " + spaces);
    }

    private void caesarCipherDemo() {
        System.out.println("4. Шифр Цезаря");
        String text = "Hello, World!";
        int k = 3;
        String encrypted = caesarEncrypt(text, k);
        String decrypted = caesarDecrypt(encrypted, k);
        System.out.println("Исходный : " + text);
        System.out.println("Зашифрован (k=3): " + encrypted);
        System.out.println("Расшифрован     : " + decrypted);
    }

    private String caesarEncrypt(String s, int k) {
        if (s.isEmpty()) {
            return "";
        }
        int shift = ((k % 26) + 26) % 26;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'a' && c <= 'z') {
                chars[i] = (char) ('a' + (c - 'a' + shift) % 26);
            } else if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) ('A' + (c - 'A' + shift) % 26);
            }
        }
        return new String(chars);
    }

    private String caesarDecrypt(String s, int k) {
        return caesarEncrypt(s, -k);
    }

    private void findLongestWordDemo() {
        System.out.println("5. Самое длинное слово");
        String s = "a bb ccc dddd eee";
        System.out.println(s);
        System.out.println("Самое длинное слово в строке: " + findLongestWord(s));
    }

    private String findLongestWord(String s) {
        String[] words = s.split(" ");
        String longest = "";
        int longestLen = 0;
        for (String word : words){
            int len = 0;
            for (int i = 0; i < word.length(); i++){
                if (Character.isLetter(word.charAt(i)))
                    len += 1;
            }
            if (len > longestLen) {
                longest = word;
                longestLen = len;
            }
        }
        return longest;
    }
}
